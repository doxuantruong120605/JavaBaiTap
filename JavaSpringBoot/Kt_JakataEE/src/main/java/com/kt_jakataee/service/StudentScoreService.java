package com.kt_jakataee.service;

import com.kt_jakataee.entity.StudentScore;
import com.kt_jakataee.repository.StudentScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentScoreService {
    @Autowired
    private StudentScoreRepository studentScoreRepository;

    public List<StudentScore> getAllStudentScores() {
        return studentScoreRepository.findAll();
    }

    public StudentScore saveStudentScore(StudentScore studentScore) {
        return studentScoreRepository.save(studentScore);
    }

    public StudentScore getStudentScoreById(Long id) {
        return studentScoreRepository.findById(id).orElse(null);
    }
}