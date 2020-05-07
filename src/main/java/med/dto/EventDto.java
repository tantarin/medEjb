package med.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class EventDto implements Serializable {
    private static final long serialVersionUID = 1L;
    public Long id;
    String date;
    String time ;
    private String assignmentName;
    String status;
    String patientName;
    String comments =" ";
    String doze;

    public EventDto(Long id){
        this.id = id;
    }

}
