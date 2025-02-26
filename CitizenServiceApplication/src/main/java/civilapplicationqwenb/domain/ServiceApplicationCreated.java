package civilapplicationqwenb.domain;

import civilapplicationqwenb.domain.*;
import civilapplicationqwenb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ServiceApplicationCreated extends AbstractEvent {

    private String applicationId;
    private ApplicationType applicationType;
    private ApplicationStatus status;
    private Date submissionDate;
    private CitizenProfile citizenProfile;
    private ContactInformation contactInformation;

    public ServiceApplicationCreated(ServiceApplication aggregate) {
        super(aggregate);
    }

    public ServiceApplicationCreated() {
        super();
    }
}
//>>> DDD / Domain Event
