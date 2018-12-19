package modelJMS;

import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import org.eclipse.jetty.websocket.api.Session;

@WebSocket
public class Websocket {

    @OnWebSocketConnect
    public void add(Session session) {
        Main.sessions.add(session);
    }

    @OnWebSocketClose
    public void remove(Session session, int statusCode, String reason) {
        Main.sessions.remove(session);
    }
}
