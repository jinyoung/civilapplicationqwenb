package civilapplicationqwenb.infra;

import civilapplicationqwenb.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/documentManagements")
@Transactional
public class DocumentManagementController {

    @Autowired
    DocumentManagementRepository documentManagementRepository;

    @RequestMapping(
        value = "/documentManagements/createdocument",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public DocumentManagement createDocument(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CreateDocumentCommand createDocumentCommand
    ) throws Exception {
        System.out.println(
            "##### /documentManagement/createDocument  called #####"
        );
        DocumentManagement documentManagement = new DocumentManagement();
        documentManagement.createDocument(createDocumentCommand);
        documentManagementRepository.save(documentManagement);
        return documentManagement;
    }

    @RequestMapping(
        value = "/documentManagements/{id}/updatedocumentstatus",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public DocumentManagement updateDocumentStatus(
        @PathVariable(value = "id") String id,
        @RequestBody UpdateDocumentStatusCommand updateDocumentStatusCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /documentManagement/updateDocumentStatus  called #####"
        );
        Optional<DocumentManagement> optionalDocumentManagement = documentManagementRepository.findById(
            id
        );

        optionalDocumentManagement.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        DocumentManagement documentManagement = optionalDocumentManagement.get();
        documentManagement.updateDocumentStatus(updateDocumentStatusCommand);

        documentManagementRepository.save(documentManagement);
        return documentManagement;
    }

    @RequestMapping(
        value = "/documentManagementsretrievedocumenthistory",
        method = RequestMethod.GET,
        produces = "application/json;charset=UTF-8"
    )
    public DocumentManagement retrieveDocumentHistory(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RetrieveDocumentHistoryCommand retrieveDocumentHistoryCommand
    ) throws Exception {
        System.out.println(
            "##### /documentManagement/retrieveDocumentHistory  called #####"
        );
        DocumentManagement documentManagement = new DocumentManagement();
        documentManagement.retrieveDocumentHistory(
            retrieveDocumentHistoryCommand
        );
        documentManagementRepository.save(documentManagement);
        return documentManagement;
    }
}
//>>> Clean Arch / Inbound Adaptor
