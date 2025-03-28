package com.kt_jakataee.repository;

import com.kt_jakataee.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
