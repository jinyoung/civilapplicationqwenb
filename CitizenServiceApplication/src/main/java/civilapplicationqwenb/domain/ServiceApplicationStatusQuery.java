package civilapplicationqwenb.domain;

import java.util.Date;
import lombok.Data;

@Data
public class ServiceApplicationStatusQuery {

    private ApplicationStatus status;
    private ApplicationType applicationType;
}
