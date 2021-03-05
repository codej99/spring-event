package com.daddyprogrammer.springevents.entity;

import com.daddyprogrammer.springevents.event.CustomEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@Table(name = "user")
@Entity
public class User extends AbstractAggregateRoot<User> {

    public User() {
    }

    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userNo;
    private String userId;
    private int age;
    private LocalDateTime created;

    // domain operation
    public void addAge() {
        this.age++;
        registerEvent(new CustomEvent(this,"user age is "+this.age));
    }
}

// @DomainEvents
/*
public class User {

    @Transient
    private final Collection<CustomEvent> customEvents;

    public User() {
        customEvents = new ArrayList<>();
    }

    @DomainEvents
    public Collection<CustomEvent> events() {
        return customEvents;
    }

    @AfterDomainEventPublication
    public void clearEvents() {
        customEvents.clear();
    }

    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userNo;
    private String userId;
    private int age;
    private LocalDateTime created;

    // domain operation
    public void addAge() {
        this.age++;
        customEvents.add(new CustomEvent(this,"user age is "+this.age));
    }
}
*/