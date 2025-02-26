package civilapplicationqwenb.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

public enum ApplicationStatus {
    미처리,
    처리중,
    완료,
    취소,
}
