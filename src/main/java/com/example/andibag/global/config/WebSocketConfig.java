package com.example.andibag.global.config;

import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import com.example.andibag.global.socket.WebSocketConnectController;
import com.example.andibag.global.socket.exception.SocketExceptionListener;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WebSocketConfig {
    private final WebSocketConnectController connectController;
    private final SocketExceptionListener exceptionListener;

    @Value("${socket.port}")
    private Integer port;

    @Bean
    public SocketIOServer socketIOServer() {
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        SocketConfig socketConfig = new SocketConfig();
        socketConfig.setReuseAddress(true);
        config.setPort(port);
        config.setOrigin("*");
        config.setSocketConfig(socketConfig);
        config.setExceptionListener(new SocketExceptionListener());
        return new SocketIOServer(config);
    }
}
