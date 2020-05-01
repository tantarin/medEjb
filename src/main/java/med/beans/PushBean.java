package med.beans;


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

    @Inject
    @Push(channel = "push")
    private PushContext push;

    public void handleEvent(@Observes String message){
        System.out.println("trying to update event");
        push.send("updateTable");
    }

    public void action(){
        push.send("updateTable");
    }
}
