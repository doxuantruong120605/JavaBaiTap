package com.kt_jakataee.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student_t")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name = "student_code", nullable = false)
    private String studentCode;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    private String address;
}