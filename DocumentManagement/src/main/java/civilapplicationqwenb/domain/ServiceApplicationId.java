package civilapplicationqwenb.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

//<<< DDD / Value Object
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceApplicationId {

    private String applicationId;

    private Date submissionDate;

    private ApplicationType applicationType;
}
//>>> DDD / Value Object
