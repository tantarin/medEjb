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
@Named("helloBean")
public class HelloBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(HelloBean.class.getName());

    @Inject
    @Push
    PushContext helloChannel;

    String message;

    public void sendMessage() {
        LOG.log(Level.INFO, "send push message");
        this.sendPushMessage("hello");
    }

    private void sendPushMessage(Object message) {
        helloChannel.send("" + message + " at " + LocalDateTime.now());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void sendMessage2() {
        // log.log(Level.INFO, "send push message from input box::" + this.message);
        this.sendPushMessage(this.message);
    }

}