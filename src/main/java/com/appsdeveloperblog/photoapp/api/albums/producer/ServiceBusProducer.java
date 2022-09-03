package com.appsdeveloperblog.photoapp.api.albums.producer;

import com.microsoft.azure.servicebus.ITopicClient;
import com.microsoft.azure.servicebus.Message;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Log4j2
@Component
class ServiceBusProducer implements Ordered {

    private final ITopicClient iTopicClient;

    ServiceBusProducer(ITopicClient iTopicClient) {
        this.iTopicClient = iTopicClient;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void produce() throws Exception {
        int i = 0;
        //for ( i = 0; i < 100; i++) {
            this.iTopicClient.send(new Message(String.format("Hello @%d ", i) + Instant.now().toString()));
       // }
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}