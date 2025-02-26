package civilapplicationqwenb.domain;

import civilapplicationqwenb.domain.*;
import civilapplicationqwenb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DocumentCreated extends AbstractEvent {

    private String documentId;
    private String title;
    private DocumentType type;
    private ProcessingStatus status;
    private Date submissionDate;

    public DocumentCreated(DocumentManagement aggregate) {
        super(aggregate);
    }

    public DocumentCreated() {
        super();
    }
}
//>>> DDD / Domain Event
