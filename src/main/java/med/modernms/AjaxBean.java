package med.modernms;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;

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
import java.util.List;

@ViewScoped
@Named("ajaxBean")
public class AjaxBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(AjaxBean.class.getName());

    @Inject
    @Push
    PushContext ajaxChannel;

    @Inject
    @Push
    PushContext ajaxListenerChannel;

    @Inject
    @Push
    PushContext commandScriptChannel;

    private List<String> messages = new ArrayList<>();

    public void ajaxPushed(AjaxBehaviorEvent e) throws AbortProcessingException {
        LOG.log(Level.INFO, "ajax pushed: " + e.toString());
        messages.add("ajaxListenerEvent is sent at: " + LocalDateTime.now());
    }

    public void commandScriptExecuted() {
        LOG.log(Level.INFO, "commandScriptExecuted pushed.");
        messages.add("commandScriptExecuted message is sent at: " + LocalDateTime.now());
    }

    public void pushToAjaxChannel() {
        messages.add("ajaxEvent is sent at: " + LocalDateTime.now());
        ajaxChannel.send("ajaxEvent");
    }

    public void pushToAjaxListenerChannel(){
        ajaxListenerChannel.send("ajaxListenerEvent");
    }

    public void pushToCommandScriptChannel() {
        commandScriptChannel.send("onCommandScript");
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

}
