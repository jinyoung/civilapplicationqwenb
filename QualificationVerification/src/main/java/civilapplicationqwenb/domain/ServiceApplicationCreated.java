package civilapplicationqwenb.domain;

import civilapplicationqwenb.domain.*;
import civilapplicationqwenb.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ServiceApplicationCreated extends AbstractEvent {

    private String applicationId;
    private Object applicationType;
    private Object status;
    private Date submissionDate;
    private Object citizenProfile;
    private Object contactInformation;
}
