package med.observer;

public class HelloEvent {

    private String message;

    public HelloEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}