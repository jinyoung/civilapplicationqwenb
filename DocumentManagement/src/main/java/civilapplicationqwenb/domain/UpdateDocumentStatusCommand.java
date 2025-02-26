package civilapplicationqwenb.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateDocumentStatusCommand {

    private String documentId;
    private ProcessingStatus status;
}
