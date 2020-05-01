package med.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class InitialDataDto {

    private List<EventDto> eventDtoList;
}
