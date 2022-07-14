package com.example.andibag.global.socket.security;

import com.corundumstudio.socketio.SocketIOClient;
import com.example.andibag.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WebSocketConnectController {
    private final JwtTokenProvider jwtTokenProvider;

    public void onConnect(SocketIOClient socketIOClient) {
        String token = socketIOClient.getHandshakeData().getSingleUrlParam("Authorization");
        Authentication authentication = jwtTokenProvider.authentication(token);
        socketIOClient.set(AuthenticationProperty.USER_KEY, authentication.getName());
    }
}
