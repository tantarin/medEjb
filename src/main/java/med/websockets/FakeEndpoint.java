package med.websockets;

import javax.faces.bean.ManagedBean;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/push")
@ManagedBean
public class FakeEndpoint{
    private static final Set<Session> SESSIONS = ConcurrentHashMap.newKeySet();

    public FakeEndpoint(){
        System.out.println("class loaded");
    }

  @OnMessage
   public static void sendList(String listJson) {
        synchronized (SESSIONS) {
            for (Session session : SESSIONS) {
                if (session.isOpen()) {
                    session.getAsyncRemote().sendText(listJson);
                }
            }
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        SESSIONS.add(session);
        try {
            System.out.println("onopen");
            session.getBasicRemote().sendText("Hi there, we are successfully connected.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session) {
        SESSIONS.remove(session);
    }
}