package med.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EventDto implements Serializable {
    private static final long serialVersionUID = 1L;
    public Long id;
    String date;
    String time ;
    private String assignmentName;
    String status;
    String patientName;
    String comments =" ";

    public EventDto(Long id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "EventDto{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", status='" + status + '\'' +
                ", patientName='" + patientName + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
