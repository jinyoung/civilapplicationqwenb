package civilapplicationqwenb.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RetrieveQualificationHistoryCommand {

    private String userId;
    private Integer page;
    private Integer pageSize;
}
