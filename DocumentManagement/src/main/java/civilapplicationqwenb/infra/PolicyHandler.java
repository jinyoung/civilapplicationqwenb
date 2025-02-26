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
    DocumentManagementRepository documentManagementRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='QualificationStatusUpdated'"
    )
    public void wheneverQualificationStatusUpdated_DocumentStatusUpdatePolicy(
        @Payload QualificationStatusUpdated qualificationStatusUpdated
    ) {
        QualificationStatusUpdated event = qualificationStatusUpdated;
        System.out.println(
            "\n\n##### listener DocumentStatusUpdatePolicy : " +
            qualificationStatusUpdated +
            "\n\n"
        );
        // Comments //
        //자격 증명 상태가 변경될 때 해당 문서의 상태를 업데이트합니다.

        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='QualificationCheckCreated'"
    )
    public void wheneverQualificationCheckCreated_DocumentCreationPolicy(
        @Payload QualificationCheckCreated qualificationCheckCreated
    ) {
        QualificationCheckCreated event = qualificationCheckCreated;
        System.out.println(
            "\n\n##### listener DocumentCreationPolicy : " +
            qualificationCheckCreated +
            "\n\n"
        );
        // Comments //
        //자격 증명 검사가 생성될 때 해당 검사에 대한 문서를 생성합니다.

        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
