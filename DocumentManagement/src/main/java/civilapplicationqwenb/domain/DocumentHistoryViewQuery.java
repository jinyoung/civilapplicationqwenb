package civilapplicationqwenb.domain;

import java.util.Date;
import lombok.Data;

@Data
public class DocumentHistoryViewQuery {

    private String userId;
    private ProcessingStatus status;
    private Integer page;
    private Integer pageSize;
}
