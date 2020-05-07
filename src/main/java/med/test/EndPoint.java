package med.test;

import javax.annotation.ManagedBean;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/test")
@ManagedBean
public class EndPoint {
    private static final Set<Session> SESSIONS = ConcurrentHashMap.newKeySet();

    public EndPoint(){
        System.out.println("class loaded");
    }

    @OnMessage
    public static void sendList(String listJson) throws IOException {
        synchronized (SESSIONS) {
            for (Session session : SESSIONS) {
                if (session.isOpen()) {
                    session.getAsyncRemote().sendText(listJson);
                    //session.close();
                }
            }
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        SESSIONS.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        SESSIONS.remove(session);
    }
}