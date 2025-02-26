package civilapplicationqwenb.domain;

import civilapplicationqwenb.domain.*;
import civilapplicationqwenb.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class QualificationCheckCreated extends AbstractEvent {

    private String userId;
    private Object status;
    private String criteria;
    private Date submittedDate;
}
