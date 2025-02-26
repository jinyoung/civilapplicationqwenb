package civilapplicationqwenb.infra;

import civilapplicationqwenb.config.kafka.KafkaProcessor;
import civilapplicationqwenb.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    QualificationCheckRepository qualificationCheckRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ServiceApplicationCreated'"
    )
    public void wheneverServiceApplicationCreated_QualificationCheckCreationPolicy(
        @Payload ServiceApplicationCreated serviceApplicationCreated
    ) {
        ServiceApplicationCreated event = serviceApplicationCreated;
        System.out.println(
            "\n\n##### listener QualificationCheckCreationPolicy : " +
            serviceApplicationCreated +
            "\n\n"
        );
        // Comments //
        //민원 신청이 생성될 때 해당 신청에 대한 자격 증명 검사를 자동으로 생성합니다.

        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
