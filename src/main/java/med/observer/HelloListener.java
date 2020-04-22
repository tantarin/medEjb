package med.observer;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

@Stateless
public class HelloListener {

    public void listenToHello(@Observes HelloEvent helloEvent){

        System.out.println("observer.HelloEvent: " + helloEvent);

    }

}
