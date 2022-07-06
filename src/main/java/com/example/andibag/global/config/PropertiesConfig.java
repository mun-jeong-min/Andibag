package com.example.andibag.global.config;

import com.example.andibag.infrastructure.s3.S3Properties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(value = S3Properties.class)
@Configuration
public class PropertiesConfig {
}
