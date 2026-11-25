package edu.dypatil.ajt.exp06.websocket;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatEndpoint {
    private static final Set<Session> CLIENTS = ConcurrentHashMap.newKeySet();

    @OnOpen
    public void onOpen(Session session) {
        CLIENTS.add(session);
        broadcast("[System] A user joined the chat. Connected users: " + CLIENTS.size());
    }

    @OnMessage
    public void onMessage(String message) {
        String cleanMessage = message == null ? "" : message.trim();
        if (!cleanMessage.isEmpty() && cleanMessage.length() <= 500) {
            broadcast(cleanMessage);
        }
    }

    @OnClose
    public void onClose(Session session) {
        CLIENTS.remove(session);
        broadcast("[System] A user left the chat. Connected users: " + CLIENTS.size());
    }

    @OnError
    public void onError(Session session, Throwable error) {
        if (session != null) {
            CLIENTS.remove(session);
        }
    }

    private void broadcast(String message) {
        for (Session client : CLIENTS) {
            if (client.isOpen()) {
                client.getAsyncRemote().sendText(message);
            }
        }
    }
}

