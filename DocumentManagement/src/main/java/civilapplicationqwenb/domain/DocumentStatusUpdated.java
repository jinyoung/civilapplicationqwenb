package civilapplicationqwenb.domain;

import civilapplicationqwenb.domain.*;
import civilapplicationqwenb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DocumentStatusUpdated extends AbstractEvent {

    private String documentId;
    private ProcessingStatus status;
    private Date processedDate;

    public DocumentStatusUpdated(DocumentManagement aggregate) {
        super(aggregate);
    }

    public DocumentStatusUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
