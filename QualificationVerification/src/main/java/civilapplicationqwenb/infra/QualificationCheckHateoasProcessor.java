package civilapplicationqwenb.infra;

import civilapplicationqwenb.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class QualificationCheckHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<QualificationCheck>> {

    @Override
    public EntityModel<QualificationCheck> process(
        EntityModel<QualificationCheck> model
    ) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "createqualificationcheck"
                )
                .withRel("reatequalificationcheck")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/updatequalificationstatus"
                )
                .withRel("updatequalificationstatus")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/retrievequalificationhistory"
                )
                .withRel("retrievequalificationhistory")
        );

        return model;
    }
}
