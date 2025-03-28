package com.kt_jakataee.service;

import com.kt_jakataee.entity.Subject;
import com.kt_jakataee.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }
}