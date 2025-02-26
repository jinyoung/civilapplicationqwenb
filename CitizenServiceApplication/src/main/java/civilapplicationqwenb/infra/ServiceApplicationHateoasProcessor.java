package civilapplicationqwenb.infra;

import civilapplicationqwenb.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ServiceApplication>> {

    @Override
    public EntityModel<ServiceApplication> process(
        EntityModel<ServiceApplication> model
    ) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/createserviceapplication"
                )
                .withRel("createserviceapplication")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/confirmserviceapplication"
                )
                .withRel("confirmserviceapplication")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/cancelserviceapplication"
                )
                .withRel("cancelserviceapplication")
        );

        return model;
    }
}
