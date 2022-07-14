package com.example.andibag;

import com.example.andibag.global.socket.WebSocketMappingSuppoter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class AndibagApplication {
    public static void main(String[] args) {
        SpringApplication.run(AndibagApplication.class, args);
    }

}
