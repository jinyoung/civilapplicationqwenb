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
// @RequestMapping(value="/qualificationChecks")
@Transactional
public class QualificationCheckController {

    @Autowired
    QualificationCheckRepository qualificationCheckRepository;

    @RequestMapping(
        value = "/qualificationCheckscreatequalificationcheck",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public QualificationCheck createQualificationCheck(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CreateQualificationCheckCommand createQualificationCheckCommand
    ) throws Exception {
        System.out.println(
            "##### /qualificationCheck/createQualificationCheck  called #####"
        );
        QualificationCheck qualificationCheck = new QualificationCheck();
        qualificationCheck.createQualificationCheck(
            createQualificationCheckCommand
        );
        qualificationCheckRepository.save(qualificationCheck);
        return qualificationCheck;
    }

    @RequestMapping(
        value = "/qualificationChecks/{id}/updatequalificationstatus",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public QualificationCheck updateQualificationStatus(
        @PathVariable(value = "id") String id,
        @RequestBody UpdateQualificationStatusCommand updateQualificationStatusCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /qualificationCheck/updateQualificationStatus  called #####"
        );
        Optional<QualificationCheck> optionalQualificationCheck = qualificationCheckRepository.findById(
            id
        );

        optionalQualificationCheck.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        QualificationCheck qualificationCheck = optionalQualificationCheck.get();
        qualificationCheck.updateQualificationStatus(
            updateQualificationStatusCommand
        );

        qualificationCheckRepository.save(qualificationCheck);
        return qualificationCheck;
    }

    @RequestMapping(
        value = "/qualificationChecksretrievequalificationhistory",
        method = RequestMethod.GET,
        produces = "application/json;charset=UTF-8"
    )
    public QualificationCheck retrieveQualificationHistory(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RetrieveQualificationHistoryCommand retrieveQualificationHistoryCommand
    ) throws Exception {
        System.out.println(
            "##### /qualificationCheck/retrieveQualificationHistory  called #####"
        );
        QualificationCheck qualificationCheck = new QualificationCheck();
        qualificationCheck.retrieveQualificationHistory(
            retrieveQualificationHistoryCommand
        );
        qualificationCheckRepository.save(qualificationCheck);
        return qualificationCheck;
    }
}
//>>> Clean Arch / Inbound Adaptor
