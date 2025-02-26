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
    collectionResourceRel = "qualificationChecks",
    path = "qualificationChecks"
)
public interface QualificationCheckRepository
    extends PagingAndSortingRepository<QualificationCheck, String> {
    @Query(
        value = "select qualificationCheck " +
        "from QualificationCheck qualificationCheck " +
        "where(:userId is null or qualificationCheck.userId like %:userId%) and (:status is null or qualificationCheck.status = :status) and (:page is null or qualificationCheck.page = :page) and (:pageSize is null or qualificationCheck.pageSize = :pageSize)"
    )
    List<QualificationCheck> qualificationHistoryView(
        String userId,
        EligibilityStatus status,
        Integer page,
        Integer pageSize,
        Pageable pageable
    );
}
