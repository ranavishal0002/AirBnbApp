package com.example.projects.AirBnbApp.Project.entity;


import com.example.projects.AirBnbApp.Project.entity.enums.PayementStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Payement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String transactionId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PayementStatus payementStatus;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

}
