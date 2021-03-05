package com.daddyprogrammer.springevents.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//@Component
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        try {
            Thread.sleep(3000);
            System.out.println("Received spring custom event - " + event.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
