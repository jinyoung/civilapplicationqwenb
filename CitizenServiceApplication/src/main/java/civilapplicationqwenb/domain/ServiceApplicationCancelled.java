package civilapplicationqwenb.domain;

import civilapplicationqwenb.domain.*;
import civilapplicationqwenb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ServiceApplicationCancelled extends AbstractEvent {

    private String applicationId;
    private String cancellationReason;
    private Date cancelledDate;

    public ServiceApplicationCancelled(ServiceApplication aggregate) {
        super(aggregate);
    }

    public ServiceApplicationCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
