package civilapplicationqwenb.domain;

import civilapplicationqwenb.domain.*;
import civilapplicationqwenb.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class QualificationStatusUpdated extends AbstractEvent {

    private Object status;
    private Boolean result;
    private Date processedDate;
}
