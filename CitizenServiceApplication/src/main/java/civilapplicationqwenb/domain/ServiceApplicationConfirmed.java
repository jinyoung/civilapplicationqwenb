package civilapplicationqwenb.domain;

import civilapplicationqwenb.domain.*;
import civilapplicationqwenb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ServiceApplicationConfirmed extends AbstractEvent {

    private String applicationId;
    private ApplicationStatus status;
    private Date processedDate;

    public ServiceApplicationConfirmed(ServiceApplication aggregate) {
        super(aggregate);
    }

    public ServiceApplicationConfirmed() {
        super();
    }
}
//>>> DDD / Domain Event
