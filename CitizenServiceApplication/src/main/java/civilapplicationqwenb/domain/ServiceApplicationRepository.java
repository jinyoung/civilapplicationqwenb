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
    collectionResourceRel = "serviceApplications",
    path = "serviceApplications"
)
public interface ServiceApplicationRepository
    extends PagingAndSortingRepository<ServiceApplication, String> {
    @Query(
        value = "select serviceApplication " +
        "from ServiceApplication serviceApplication " +
        "where(:status is null or serviceApplication.status = :status) and (:applicationType is null or serviceApplication.applicationType = :applicationType)"
    )
    List<ServiceApplication> serviceApplicationStatus(
        ApplicationStatus status,
        ApplicationType applicationType,
        Pageable pageable
    );

    @Query(
        value = "select serviceApplication " +
        "from ServiceApplication serviceApplication " +
        "where(:applicationId is null or serviceApplication.applicationId like %:applicationId%)"
    )
    ServiceApplication serviceApplicationDetails(String applicationId);
}
