package civilapplicationqwenb.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ConfirmServiceApplicationCommand {

    private String applicationId;
    private ApplicationStatus status;
}
