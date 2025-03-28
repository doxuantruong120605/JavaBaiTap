package com.kt_jakataee.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student_score_t")
@Data
public class StudentScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentScoreId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    private double score1;
    private double score2;

    // Method to calculate grade based on the formula: 0.3 * score1 + 0.7 * score2
    @Transient
    public double calculateFinalScore() {
        return 0.3 * score1 + 0.7 * score2;
    }

    @Transient
    public String calculateGrade() {
        double finalScore = calculateFinalScore();
        if (finalScore >= 8.0 && finalScore <= 10.0) {
            return "A";
        } else if (finalScore >= 6.0 && finalScore <= 7.9) {
            return "B";
        } else if (finalScore >= 4.0 && finalScore <= 5.9) {
            return "D";
        } else {
            return "F";
        }
    }
}