package med.jms;


import com.google.gson.Gson;
import lombok.SneakyThrows;

import med.beans.EventService;
import med.beans.PushBean;
import med.dto.EventDto;
import med.model.ListEvent;
import med.websockets.FakeEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.*;


@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "superqueue") })
public class ActiveListener implements MessageListener {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ActiveListener.class);

    @Inject
    private Event<ListEvent> lightEvent;

    @Inject
    EventService eventService;

    @Inject
    PushBean pushBean;

    @SneakyThrows
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        String list = textMessage.getText();
        LOGGER.info("inbound json='{}'", list);
   //     FakeEndpoint.sendList(list);
        Type listType = new TypeToken<ArrayList<EventDto>>(){}.getType();
        List<EventDto> eventDtoList = new Gson().fromJson(list, listType);
        eventService.setEvents(eventDtoList);
        pushBean.handleEvent(list);
    }
}