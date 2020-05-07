package med.beans;

import med.dto.EventDto;
import org.apache.log4j.Logger;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Singleton
public class EventService {

    private static final Logger LOGGER = Logger.getLogger(EventService.class);

    private List<EventDto> events = new ArrayList<>();

    public void updateEvents(){
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8081/medEjb/");
    }

    public List<EventDto> getEvents(){
        LOGGER.info("get events from service");
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