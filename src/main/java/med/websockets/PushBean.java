package med.websockets;

//
//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
////import org.slf4j.Logger;
//
//import javax.ejb.Stateful;
//import javax.ejb.Stateless;
//import javax.faces.bean.ApplicationScoped;
//import javax.faces.push.Push;
//import javax.faces.push.PushContext;
//import javax.inject.Inject;
//import javax.inject.Named;
//import java.io.Serializable;
//import java.util.Calendar;
////import java.util.logging.Logger;
////import java.util.logging.Logger;
//
//@Named("pushBean")
//@ApplicationScoped
//@Stateful
//public class PushBean implements Serializable {
//
//    private static final Logger LOG = Logger.getLogger(PushBean.class.getName());
//
//    @Inject
//    @Push(channel = "clock")
//    private PushContext push;
//
//    public void clockAction(){
//        Calendar now = Calendar.getInstance();
//
//        String time = now.get(Calendar.HOUR_OF_DAY) + ":" +
//                now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND);
//        LOG.log(Level.INFO, "Time: {0}"+ time);
//
//        push.send(time);
//    }
//}