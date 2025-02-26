package civilapplicationqwenb.domain;

import civilapplicationqwenb.domain.*;
import civilapplicationqwenb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class QualificationHistoryRetrieved extends AbstractEvent {

    private List<QualificationCheck> qualificationChecks;
    private Integer totalPages;
    private Integer currentPage;

    public QualificationHistoryRetrieved(QualificationCheck aggregate) {
        super(aggregate);
    }

    public QualificationHistoryRetrieved() {
        super();
    }
}
//>>> DDD / Domain Event
