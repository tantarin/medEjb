package med.beans;


import med.dto.Event;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class EventController {

    @Inject
    private EventService eventService;

    public List<Event> getEvents(){
        return eventService.getEvents();
    }

}