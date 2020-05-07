package med.beans;

import org.apache.log4j.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;


@Named
@ApplicationScoped
public class PushBean implements Serializable {
    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(PushBean.class);

    @Inject
    @Push
    private PushContext pushh;

    public void handleEvent(@Observes String message){
        pushh.send("update");
        LOGGER.info("trying to update event");
    }
}
