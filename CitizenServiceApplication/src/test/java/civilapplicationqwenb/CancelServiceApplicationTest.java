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
public class CancelServiceApplicationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        CancelServiceApplicationTest.class
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
    public ServiceApplicationRepository repository;

    @Test
    @SuppressWarnings("unchecked")
    public void test0() {
        //given:
        ServiceApplication entity = new ServiceApplication();

        entity.setApplicationId("신청서-001");
        entity.setApplicationType("N/A");
        entity.setStatus("처리중");
        entity.setSubmissionDate("2024-03-20T00:00:00Z");
        entity.setCompletionDate("N/A");
        entity.setCitizenProfile("N/A");
        entity.setContactInformation("N/A");
        entity.setServiceApplicationId("N/A");

        repository.save(entity);

        //when:
        try {
            CancelServiceApplicationCommand command = new CancelServiceApplicationCommand();

            command.setApplicationId("신청서-001");
            command.setCancellationReason("더 이상 필요하지 않습니다");

            entity.cancelServiceApplication(command);

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

            ServiceApplicationCancelled outputEvent = objectMapper.readValue(
                receivedPayload,
                ServiceApplicationCancelled.class
            );

            LOGGER.info("Response received: {}", outputEvent);

            assertEquals(outputEvent.getApplicationId(), "신청서-001");
            assertEquals(
                outputEvent.getCancellationReason(),
                "더 이상 필요하지 않습니다"
            );
            assertEquals(
                outputEvent.getCancelledDate(),
                "2024-03-20T00:00:00Z"
            );
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            assertTrue(e.getMessage(), false);
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    public void test1() {
        //given:
        ServiceApplication entity = new ServiceApplication();

        entity.setApplicationId("신청서-002");
        entity.setApplicationType("N/A");
        entity.setStatus("완료");
        entity.setSubmissionDate("2024-03-20T00:00:00Z");
        entity.setCompletionDate("N/A");
        entity.setCitizenProfile("N/A");
        entity.setContactInformation("N/A");
        entity.setServiceApplicationId("N/A");

        repository.save(entity);

        //when:
        try {
            CancelServiceApplicationCommand command = new CancelServiceApplicationCommand();

            command.setApplicationId("신청서-002");
            command.setCancellationReason("더 이상 필요하지 않습니다");

            entity.cancelServiceApplication(command);

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

            ServiceApplicationCancelled outputEvent = objectMapper.readValue(
                receivedPayload,
                ServiceApplicationCancelled.class
            );

            LOGGER.info("Response received: {}", outputEvent);

            assertEquals(outputEvent.getApplicationId(), "신청서-002");
            assertEquals(outputEvent.getCancellationReason(), "N/A");
            assertEquals(outputEvent.getCancelledDate(), "N/A");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            assertTrue(e.getMessage(), false);
        }
    }
}
