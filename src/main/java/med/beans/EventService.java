package med.beans;

import med.dto.EventDto;
import org.apache.log4j.Logger;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.util.Arrays;
import java.util.List;

@Singleton
public class EventService {

    private static final Logger LOGGER = Logger.getLogger(EventController.class);

    private List<EventDto> events = Arrays.asList(new EventDto(2L), new EventDto(3L));

    public void updateEvents(){
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8081/medEjb/");
    }

    public List<EventDto> getEvents(){
        return events;
    }

    public void setEvents(List<EventDto> events){
        this.events = events;
    }

    @PostConstruct
    public void init(){
        updateEvents();
    }
}
