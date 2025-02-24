package com.example.projects.AirBnbApp.Project.entity;


import com.example.projects.AirBnbApp.Project.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Setter
@Getter
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private  Integer age;

    @ManyToMany(mappedBy = "guests")
    private Set<Booking> bookings;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
