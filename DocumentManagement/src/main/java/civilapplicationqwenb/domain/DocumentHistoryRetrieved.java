package civilapplicationqwenb.domain;

import civilapplicationqwenb.domain.*;
import civilapplicationqwenb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DocumentHistoryRetrieved extends AbstractEvent {

    private Integer totalPages;
    private Integer currentPage;

    public DocumentHistoryRetrieved(DocumentManagement aggregate) {
        super(aggregate);
    }

    public DocumentHistoryRetrieved() {
        super();
    }
}
//>>> DDD / Domain Event
