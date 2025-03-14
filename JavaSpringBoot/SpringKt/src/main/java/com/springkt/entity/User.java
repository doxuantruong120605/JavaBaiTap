package com.springkt.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Value;

@Entity
@Data
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private int age;

    private double salary;
}
