package med.beans;

import med.dto.EventDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class EventController {

    @Inject
    private EventService eventService;

    public List<EventDto> getEvents(){
        return eventService.getEvents();
    }

}