package civilapplicationqwenb.domain;

import civilapplicationqwenb.CitizenServiceApplicationApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ServiceApplication_table")
@Data
//<<< DDD / Aggregate Root
public class ServiceApplication {

    @Id
    private String applicationId;

    @Enumerated(EnumType.STRING)
    private ApplicationType applicationType;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    private Date submissionDate;

    private Date completionDate;

    @Embedded
    private CitizenProfile citizenProfile;

    @Embedded
    private ContactInformation contactInformation;

    @Embedded
    private ServiceApplicationId serviceApplicationId;

    public static ServiceApplicationRepository repository() {
        ServiceApplicationRepository serviceApplicationRepository = CitizenServiceApplicationApplication.applicationContext.getBean(
            ServiceApplicationRepository.class
        );
        return serviceApplicationRepository;
    }

    //<<< Clean Arch / Port Method
    public void createServiceApplication(
        CreateServiceApplicationCommand createServiceApplicationCommand
    ) {
        //implement business logic here:

        ServiceApplicationCreated serviceApplicationCreated = new ServiceApplicationCreated(
            this
        );
        serviceApplicationCreated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void confirmServiceApplication(
        ConfirmServiceApplicationCommand confirmServiceApplicationCommand
    ) {
        //implement business logic here:

        ServiceApplicationConfirmed serviceApplicationConfirmed = new ServiceApplicationConfirmed(
            this
        );
        serviceApplicationConfirmed.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void cancelServiceApplication(
        CancelServiceApplicationCommand cancelServiceApplicationCommand
    ) {
        //implement business logic here:

        ServiceApplicationCancelled serviceApplicationCancelled = new ServiceApplicationCancelled(
            this
        );
        serviceApplicationCancelled.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
