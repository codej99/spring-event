package com.daddyprogrammer.springevents.service;

import com.daddyprogrammer.springevents.entity.User;
import com.daddyprogrammer.springevents.event.CustomEvent;
import com.daddyprogrammer.springevents.event.CustomEventListener;
import com.daddyprogrammer.springevents.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@SpringBootTest
class DomainServiceTest {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private DomainService domainService;

    @MockBean
    private CustomEventListener customEventListener;

    @Test
    void serviceEventTest() {
        User user = User.builder().userNo(1).userId("happydaddy").age(30).created(LocalDateTime.now()).build();
        userRepo.save(user);

        // when
        domainService.addAge(user.getUserId());

        // then
        Mockito.verify(customEventListener, times(1)).onApplicationEvent(any(CustomEvent.class));
    }
}