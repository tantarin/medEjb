package med.common;

import lombok.Data;
import med.dto.EventDto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@SessionScoped
@Data
public class Events implements Serializable {

    private static final long serialVersionUID = 1L;

     List<EventDto> eventList = Arrays.asList(new EventDto(12l), new EventDto(13L));
     String string = eventList.toString();

}