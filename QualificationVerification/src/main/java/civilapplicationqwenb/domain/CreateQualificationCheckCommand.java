package civilapplicationqwenb.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateQualificationCheckCommand {

    private String userId;
    private String criteria;
}
