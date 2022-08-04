package com.example.andibag.global.socket;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@RequiredArgsConstructor
@@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private final ChatHandler chatHandler;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        registry.addEndpoint("/example").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {

        config.setApplicationDestinationPrefixes("/test");
        config.enableSimpleBroker("/topic", "/queue");
    }
    }
}