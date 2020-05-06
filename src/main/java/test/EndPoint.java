package test;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/test")
public class EndPoint {
    private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    public EndPoint() {
        System.out.println("class loaded " + this.getClass());
    }

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        for (Session clientSession : sessions) {
            clientSession.getAsyncRemote().sendText("event");
        }
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("get new text");
        for (Session clientSession : sessions) {
            clientSession.getAsyncRemote().sendText("event");
        }
    }

    @OnError
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @OnClose
    public void onClose(Session session) {
        System.out.printf("Session closed with id: %s%n", session.getId());
    }
}