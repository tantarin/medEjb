package med.jms;


import com.google.gson.Gson;
import lombok.SneakyThrows;
import med.beans.EventService;
import med.beans.PushBean;
import med.dto.EventDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.reflect.TypeToken;
import med.test.EndPoint;


import javax.inject.Inject;
import javax.jms.*;


@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "superqueue") })
public class ActiveListener implements MessageListener {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ActiveListener.class);

    @Inject
    EventService eventService;

    @Inject
    EndPoint endPoint;

    public String text = "1";

    @Inject
    PushBean pushBean;

    @SneakyThrows
    @Override
    public void onMessage(Message message) {
        text = text+"1";
        TextMessage textMessage = (TextMessage) message;
        String list = textMessage.getText();
        LOGGER.info("inbound json='{}'", list);
        Type listType = new TypeToken<ArrayList<EventDto>>(){}.getType();
        List<EventDto> eventList = new Gson().fromJson(list, listType);
        eventService.setEvents(eventList);
        pushBean.handleEvent(text);
        EndPoint.sendList(list);
    }
}