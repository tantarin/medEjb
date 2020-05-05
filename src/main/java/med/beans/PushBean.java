package med.beans;


import med.jms.ActiveListener;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;


@Named
@ApplicationScoped
public class PushBean implements Serializable {
    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(PushBean.class);

    @Inject
    @Push
    private PushContext push;

    public void handleEvent(@Observes String message){
        LOGGER.info("trying to update event");
        push.send("updateTable");
    }

    public void action(){
        push.send("updateTable");
    }
}
