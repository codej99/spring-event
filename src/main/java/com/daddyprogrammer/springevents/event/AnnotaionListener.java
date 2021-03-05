package com.daddyprogrammer.springevents.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AnnotaionListener {
    @Async
    @EventListener
    public void handleEvent(CustomEvent event) {
        try {
            Thread.sleep(3000);
            System.out.println("Received spring custom event by annotation listener - " + event.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}