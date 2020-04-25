package med.poll;

import med.dto.EventDto;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@Stateless
public class CounterView implements Serializable {

    private int number = 1;

    public static List<EventDto> eventDtoList = Arrays.asList(new EventDto(1L));

    public List<EventDto> getEventDtoList() {
        return eventDtoList;
    }


    public int getNumber(){
        return this.number;
    }


}