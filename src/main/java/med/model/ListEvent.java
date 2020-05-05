package med.model;


import med.dto.Event;

import java.util.List;

public class ListEvent {

    private List<Event> eventDtoList;

    public List<Event> getEventDtoList() {
        return eventDtoList;
    }

    public void setEventDtoList(List<Event> eventDtoList) {
        System.out.println("set eventdto list");
        this.eventDtoList = eventDtoList;
    }
}