package civilapplicationqwenb.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateServiceApplicationCommand {

    private ApplicationType applicationType;
    private CitizenProfile citizenProfile;
    private ContactInformation contactInformation;
}
