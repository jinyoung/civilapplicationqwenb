package civilapplicationqwenb.infra;

import civilapplicationqwenb.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DocumentManagementHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<DocumentManagement>> {

    @Override
    public EntityModel<DocumentManagement> process(
        EntityModel<DocumentManagement> model
    ) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/createdocument")
                .withRel("createdocument")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/updatedocumentstatus"
                )
                .withRel("updatedocumentstatus")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/retrievedocumenthistory"
                )
                .withRel("retrievedocumenthistory")
        );

        return model;
    }
}
