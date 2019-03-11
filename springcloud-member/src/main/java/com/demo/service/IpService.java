package com.demo.service;

import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class IpService implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {

    private int serverPort;
    @Override
    public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
        this.serverPort = event.getEmbeddedServletContainer().getPort();
    }

    public int getPort() {
        return this.serverPort;
    }
}
