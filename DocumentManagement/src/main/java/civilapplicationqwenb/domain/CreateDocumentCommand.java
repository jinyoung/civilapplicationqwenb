package civilapplicationqwenb.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateDocumentCommand {

    private String title;
    private String content;
    private DocumentType type;
    private DocumentTemplate documentTemplate;
}
