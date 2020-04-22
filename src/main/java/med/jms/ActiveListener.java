package med.jms;


import com.google.gson.Gson;
import lombok.SneakyThrows;

import med.dto.EventDto;
import med.dto.EventDtoList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.jms.*;


@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "superqueue") })
@ManagedBean
public class ActiveListener implements MessageListener {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ActiveListener.class);

//    private Events events = new Events();

    @SneakyThrows
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        String payload = textMessage.getText();
        LOGGER.info("inbound json='{}'", payload);
        Type listType = new TypeToken<ArrayList<EventDto>>(){}.getType();
        List<EventDto> eventDtoList = new Gson().fromJson(payload, listType);
     //   events.setEventList(eventDtoList);
    }
}