package civilapplicationqwenb.domain;

import civilapplicationqwenb.domain.*;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "documentManagements",
    path = "documentManagements"
)
public interface DocumentManagementRepository
    extends PagingAndSortingRepository<DocumentManagement, String> {
    @Query(
        value = "select documentManagement " +
        "from DocumentManagement documentManagement " +
        "where(:documentId is null or documentManagement.documentId like %:documentId%)"
    )
    DocumentManagement documentStatusView(String documentId);

    @Query(
        value = "select documentManagement " +
        "from DocumentManagement documentManagement " +
        "where(:userId is null or documentManagement.userId like %:userId%) and (:status is null or documentManagement.status = :status) and (:page is null or documentManagement.page = :page) and (:pageSize is null or documentManagement.pageSize = :pageSize)"
    )
    List<DocumentManagement> documentHistoryView(
        String userId,
        ProcessingStatus status,
        Integer page,
        Integer pageSize,
        Pageable pageable
    );
}
