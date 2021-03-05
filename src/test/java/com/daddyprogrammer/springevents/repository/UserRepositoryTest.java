package com.daddyprogrammer.springevents.repository;

import com.daddyprogrammer.springevents.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepo;

    @Test
    public void whenFindByUserId_thenReturnUser() {
        String userId = "happydaddy";
        int age = 39;
        // given
        userRepo.save(User.builder()
                .userId(userId)
                .age(age)
                .created(LocalDateTime.now())
                .build());
        // when
        Optional<User> user = userRepo.findByUserId(userId);
        // then
        assertNotNull(user);
        assertTrue(user.isPresent());
        assertEquals(user.get().getUserId(), userId);
        assertEquals(user.get().getAge(),age);
    }
}