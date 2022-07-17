package com.example.andibag.global.config;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.example.andibag.global.socket.WebSocketMappingSupporter;
import com.example.andibag.global.socket.exception.SocketExceptionListener;
import com.example.andibag.global.socket.security.WebSocketConnectController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WebSocketConfig {
    private final WebSocketMappingSupporter mappingSuppoter;
    private final WebSocketConnectController connectController;
    private final SocketExceptionListener exceptionListener;

    @Value("${socket.port}")
    private Integer port;

    @Bean
    public SocketIOServer socketIOServer() {
        Configuration config = new Configuration();
        config.setPort(port);
        config.setOrigin("*");
        config.setExceptionListener(exceptionListener);
        SocketIOServer server = new SocketIOServer(config);
        mappingSuppoter.addListeners(server);
        server.addConnectListener(connectController::onConnect);
        return server;
    }
}
