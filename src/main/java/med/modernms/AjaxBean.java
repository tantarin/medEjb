package med.modernms;


import med.dto.EventDto;
import med.model.ListEvent;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.checkerframework.checker.units.qual.A;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Named("ajaxBean")
@ApplicationScoped
public class AjaxBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(AjaxBean.class.getName());

    @Inject
    @Push
    PushContext ajaxChannel;

    @Inject
    @Push
    PushContext ajaxListenerChannel;

    private List<EventDto> messages = new ArrayList<>();


    public void ajaxPushed(AjaxBehaviorEvent e) throws AbortProcessingException {
        LOG.log(Level.INFO, "ajax pushed: " + e.toString());
    }

    public void pushToAjaxChannel(@Observes ListEvent listEvent) {
        LOG.log(Level.INFO, "data updated");
        this.messages = listEvent.getEventDtoList();
        System.out.println("messages "+messages.toString());
        messages.add(new EventDto(2L));
        ajaxChannel.send("ajaxEvent");
    }

    public void pushToAjaxListenerChannel(){
        messages.add(new EventDto(12L));
        ajaxListenerChannel.send("ajaxListenerEvent");
    }

    public List<EventDto> getMessages() {
        return messages;
    }

    public void setMessages(List<EventDto> messages) {
        this.messages = messages;
    }

}
