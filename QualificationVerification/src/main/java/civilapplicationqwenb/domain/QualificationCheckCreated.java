package civilapplicationqwenb.domain;

import civilapplicationqwenb.domain.*;
import civilapplicationqwenb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class QualificationCheckCreated extends AbstractEvent {

    private String userId;
    private EligibilityStatus status;
    private String criteria;
    private Date submittedDate;

    public QualificationCheckCreated(QualificationCheck aggregate) {
        super(aggregate);
    }

    public QualificationCheckCreated() {
        super();
    }
}
//>>> DDD / Domain Event
