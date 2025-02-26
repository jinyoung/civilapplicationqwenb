package civilapplicationqwenb.domain;

import civilapplicationqwenb.DocumentManagementApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DocumentManagement_table")
@Data
//<<< DDD / Aggregate Root
public class DocumentManagement {

    @Id
    private String documentId;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private DocumentType type;

    @Enumerated(EnumType.STRING)
    private ProcessingStatus status;

    @Embedded
    private DocumentTemplate documentTemplate;

    @Embedded
    private DocumentProcessing documentProcessing;

    @Embedded
    private ServiceApplicationId serviceApplicationId;

    public static DocumentManagementRepository repository() {
        DocumentManagementRepository documentManagementRepository = DocumentManagementApplication.applicationContext.getBean(
            DocumentManagementRepository.class
        );
        return documentManagementRepository;
    }

    //<<< Clean Arch / Port Method
    public void createDocument(CreateDocumentCommand createDocumentCommand) {
        //implement business logic here:

        DocumentCreated documentCreated = new DocumentCreated(this);
        documentCreated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void updateDocumentStatus(
        UpdateDocumentStatusCommand updateDocumentStatusCommand
    ) {
        //implement business logic here:

        DocumentStatusUpdated documentStatusUpdated = new DocumentStatusUpdated(
            this
        );
        documentStatusUpdated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void retrieveDocumentHistory(
        RetrieveDocumentHistoryCommand retrieveDocumentHistoryCommand
    ) {
        //implement business logic here:

        DocumentHistoryRetrieved documentHistoryRetrieved = new DocumentHistoryRetrieved(
            this
        );
        documentHistoryRetrieved.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
