package com.daddyprogrammer.springevents.service;

import com.daddyprogrammer.springevents.event.CustomEventPublisher;
import com.daddyprogrammer.springevents.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class DomainService {

    private final UserRepository userRepository;
    private final CustomEventPublisher customEventPublisher;

    @Transactional
    public void addAge(String userId) {
        userRepository.findByUserId(userId)
                .ifPresent(entity -> {
                    entity.addAge();
                    userRepository.save(entity);
//                    customEventPublisher.publish("user age is "+entity.getAge());
                });
    }
}
