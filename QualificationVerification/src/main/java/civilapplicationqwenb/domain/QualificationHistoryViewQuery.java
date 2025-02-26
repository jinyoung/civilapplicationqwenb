package civilapplicationqwenb.domain;

import java.util.Date;
import lombok.Data;

@Data
public class QualificationHistoryViewQuery {

    private String userId;
    private EligibilityStatus status;
    private Integer page;
    private Integer pageSize;
}
