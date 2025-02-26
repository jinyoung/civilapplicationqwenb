package civilapplicationqwenb.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CancelServiceApplicationCommand {

    private String applicationId;
    private String cancellationReason;
}
