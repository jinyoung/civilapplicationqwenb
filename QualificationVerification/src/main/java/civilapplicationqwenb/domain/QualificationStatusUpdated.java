package civilapplicationqwenb.domain;

import civilapplicationqwenb.domain.*;
import civilapplicationqwenb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class QualificationStatusUpdated extends AbstractEvent {

    private EligibilityStatus status;
    private Boolean result;
    private Date processedDate;

    public QualificationStatusUpdated(QualificationCheck aggregate) {
        super(aggregate);
    }

    public QualificationStatusUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
