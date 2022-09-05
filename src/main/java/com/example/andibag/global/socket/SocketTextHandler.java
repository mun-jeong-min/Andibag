package com.example.andibag.global.socket;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SocketTextHandler extends TextWebSocketHandler {
    private final Set<WebSocketSession> socketSessions = ConcurrentHashMap.newKeySet();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        socketSessions.add(session);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();

        JSONObject jsonObject = new JSONObject(payload);
        for(WebSocketSession s : socketSessions) {
            s.sendMessage(new TextMessage("Hi " + jsonObject.getString("user") + "!"));
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        socketSessions.remove(session);
    }

}
