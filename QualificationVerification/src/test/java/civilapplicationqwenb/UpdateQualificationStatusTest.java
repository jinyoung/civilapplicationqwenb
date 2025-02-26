package civilapplicationqwenb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import civilapplicationqwenb.domain.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.MessageVerifier;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.cloud.contract.verifier.messaging.internal.ContractVerifierMessage;
import org.springframework.cloud.contract.verifier.messaging.internal.ContractVerifierMessaging;
import org.springframework.cloud.contract.verifier.messaging.internal.ContractVerifierObjectMapper;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MimeTypeUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMessageVerifier
public class UpdateQualificationStatusTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        UpdateQualificationStatusTest.class
    );

    @Autowired
    private MessageCollector messageCollector;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MessageVerifier<Message<?>> messageVerifier;

    @Autowired
    public QualificationCheckRepository repository;

    @Test
    @SuppressWarnings("unchecked")
    public void test0() {
        //given:
        QualificationCheck entity = new QualificationCheck();

        entity.setQualificationCheckId("QC-001");
        entity.setUserId("user123");
        entity.setStatus("PENDING");
        entity.setCriteria("Basic Qualification");
        entity.setSubmittedDate("2024-03-20T00:00:00Z");
        entity.setProcessedDate("N/A");
        entity.setResult(null);
        entity.setServiceApplicationId("N/A");

        repository.save(entity);

        //when:
        try {
            UpdateQualificationStatusCommand command = new UpdateQualificationStatusCommand();

            command.setStatus("ELIGIBLE");
            command.setResult(true);

            entity.updateQualificationStatus(command);

            //then:
            this.messageVerifier.send(
                    MessageBuilder
                        .withPayload(entity)
                        .setHeader(
                            MessageHeaders.CONTENT_TYPE,
                            MimeTypeUtils.APPLICATION_JSON
                        )
                        .build(),
                    "civilapplicationqwenb"
                );

            Message<?> receivedMessage =
                this.messageVerifier.receive(
                        "civilapplicationqwenb",
                        5000,
                        TimeUnit.MILLISECONDS
                    );
            assertNotNull("Resulted event must be published", receivedMessage);

            String receivedPayload = (String) receivedMessage.getPayload();

            QualificationStatusUpdated outputEvent = objectMapper.readValue(
                receivedPayload,
                QualificationStatusUpdated.class
            );

            LOGGER.info("Response received: {}", outputEvent);

            assertEquals(outputEvent.getStatus(), "ELIGIBLE");
            assertEquals(outputEvent.getResult(), true);
            assertEquals(
                outputEvent.getProcessedDate(),
                "2024-03-20T00:00:00Z"
            );
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            assertTrue(e.getMessage(), false);
        }
    }
}
