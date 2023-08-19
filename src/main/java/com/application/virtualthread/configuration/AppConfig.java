package com.application.virtualthread.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;

@Slf4j
@Configuration
public class AppConfig {

    //ServletWebServerFactoryConfiguration / TomcatServletWebServerFactory
    //https://medium.com/@egorponomarev/virtual-threads-in-spring-boot-with-java-19-ea98e1725058
    //https://stackoverflow.com/questions/60931718/how-can-i-customize-spring-boot-embedded-tomcat-thread-pool
    @Bean
    @ConditionalOnProperty(name = "virtual-thread.flag", havingValue = "true")
    public TomcatProtocolHandlerCustomizer<?> protocolHandlerVirtualThreadCustomizer() {
        log.info("Using Virtual Threads!!!");
        return protocolHandler -> protocolHandler.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
    }
}
