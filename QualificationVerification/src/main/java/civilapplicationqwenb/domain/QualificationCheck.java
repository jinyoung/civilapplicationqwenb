package civilapplicationqwenb.domain;

import civilapplicationqwenb.QualificationVerificationApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "QualificationCheck_table")
@Data
//<<< DDD / Aggregate Root
public class QualificationCheck {

    @Id
    private String qualificationCheckId;

    private String userId;

    @Enumerated(EnumType.STRING)
    private EligibilityStatus status;

    private String criteria;

    private Date submittedDate;

    private Date processedDate;

    private Boolean result;

    @Embedded
    private ServiceApplicationId serviceApplicationId;

    public static QualificationCheckRepository repository() {
        QualificationCheckRepository qualificationCheckRepository = QualificationVerificationApplication.applicationContext.getBean(
            QualificationCheckRepository.class
        );
        return qualificationCheckRepository;
    }

    //<<< Clean Arch / Port Method
    public void createQualificationCheck(
        CreateQualificationCheckCommand createQualificationCheckCommand
    ) {
        //implement business logic here:

        QualificationCheckCreated qualificationCheckCreated = new QualificationCheckCreated(
            this
        );
        qualificationCheckCreated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void updateQualificationStatus(
        UpdateQualificationStatusCommand updateQualificationStatusCommand
    ) {
        //implement business logic here:

        QualificationStatusUpdated qualificationStatusUpdated = new QualificationStatusUpdated(
            this
        );
        qualificationStatusUpdated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void retrieveQualificationHistory(
        RetrieveQualificationHistoryCommand retrieveQualificationHistoryCommand
    ) {
        //implement business logic here:

        QualificationHistoryRetrieved qualificationHistoryRetrieved = new QualificationHistoryRetrieved(
            this
        );
        qualificationHistoryRetrieved.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
