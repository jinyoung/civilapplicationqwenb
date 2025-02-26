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
// @RequestMapping(value="/serviceApplications")
@Transactional
public class ServiceApplicationController {

    @Autowired
    ServiceApplicationRepository serviceApplicationRepository;

    @RequestMapping(
        value = "/serviceApplications/createserviceapplication",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public ServiceApplication createServiceApplication(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CreateServiceApplicationCommand createServiceApplicationCommand
    ) throws Exception {
        System.out.println(
            "##### /serviceApplication/createServiceApplication  called #####"
        );
        ServiceApplication serviceApplication = new ServiceApplication();
        serviceApplication.createServiceApplication(
            createServiceApplicationCommand
        );
        serviceApplicationRepository.save(serviceApplication);
        return serviceApplication;
    }

    @RequestMapping(
        value = "/serviceApplications/{id}/confirmserviceapplication",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public ServiceApplication confirmServiceApplication(
        @PathVariable(value = "id") String id,
        @RequestBody ConfirmServiceApplicationCommand confirmServiceApplicationCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /serviceApplication/confirmServiceApplication  called #####"
        );
        Optional<ServiceApplication> optionalServiceApplication = serviceApplicationRepository.findById(
            id
        );

        optionalServiceApplication.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        ServiceApplication serviceApplication = optionalServiceApplication.get();
        serviceApplication.confirmServiceApplication(
            confirmServiceApplicationCommand
        );

        serviceApplicationRepository.save(serviceApplication);
        return serviceApplication;
    }

    @RequestMapping(
        value = "/serviceApplications/{id}/cancelserviceapplication",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public ServiceApplication cancelServiceApplication(
        @PathVariable(value = "id") String id,
        @RequestBody CancelServiceApplicationCommand cancelServiceApplicationCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /serviceApplication/cancelServiceApplication  called #####"
        );
        Optional<ServiceApplication> optionalServiceApplication = serviceApplicationRepository.findById(
            id
        );

        optionalServiceApplication.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        ServiceApplication serviceApplication = optionalServiceApplication.get();
        serviceApplication.cancelServiceApplication(
            cancelServiceApplicationCommand
        );

        serviceApplicationRepository.save(serviceApplication);
        return serviceApplication;
    }
}
//>>> Clean Arch / Inbound Adaptor
