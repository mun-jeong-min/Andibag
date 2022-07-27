package com.example.andibag.global.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.example.andibag.global.security.jwt.JwtTokenProvider;
import com.example.andibag.global.socket.property.AuthenticationProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
@RequiredArgsConstructor
public class WebSocketConnectController {
    private final JwtTokenProvider jwtTokenProvider;

    public static final ConcurrentMap<String, SocketIOClient> socketIOClientMap = new ConcurrentHashMap<>();

    @OnConnect
    public void onConnect(SocketIOClient client) {
        String token = client.getHandshakeData().getHttpHeaders().get("Authorization");
        Authentication authentication = jwtTokenProvider.authentication(token);
        socketIOClientMap.put(authentication.getName(), client);
        client.set(AuthenticationProperty.USER_KEY, authentication.getName());
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        socketIOClientMap.remove(client.get(AuthenticationProperty.USER_KEY).toString());
    }
}
