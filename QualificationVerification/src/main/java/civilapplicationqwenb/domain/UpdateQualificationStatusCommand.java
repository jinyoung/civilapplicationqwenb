package civilapplicationqwenb.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateQualificationStatusCommand {

    private EligibilityStatus status;
    private Boolean result;
}
