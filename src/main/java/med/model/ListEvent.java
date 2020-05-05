package med.model;


import med.dto.EventDto;

import java.util.List;

public class ListEvent {

    private List<EventDto> eventDtoList;

    public List<EventDto> getEventDtoList() {
        return eventDtoList;
    }

    public void setEventDtoList(List<EventDto> eventDtoList) {
        System.out.println("set eventdto list");
        this.eventDtoList = eventDtoList;
    }
}