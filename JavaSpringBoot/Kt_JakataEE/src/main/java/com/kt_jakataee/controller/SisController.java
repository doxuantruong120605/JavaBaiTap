package com.kt_jakataee.controller;

import com.kt_jakataee.entity.Student;
import com.kt_jakataee.entity.StudentScore;
import com.kt_jakataee.repository.StudentRepository;
import com.kt_jakataee.repository.StudentScoreRepository;
import com.kt_jakataee.repository.SubjectRepository;
import com.kt_jakataee.service.StudentScoreService;
import com.kt_jakataee.service.StudentService;
import com.kt_jakataee.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SisController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private StudentScoreService studentScoreService;

    // Display the student information page (as shown in the image)
    @GetMapping("/")
    public String showStudentInformation(Model model) {
        model.addAttribute("studentScores", studentScoreService.getAllStudentScores());
        return "student-information";
    }

    // Show form to add a new student
    @GetMapping("/add-student")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    // Handle adding a new student
    @PostMapping("/add-student")
    public String addStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/";
    }

    // Show form to add a new score
    @GetMapping("/add-score")
    public String showAddScoreForm(Model model) {
        model.addAttribute("studentScore", new StudentScore());
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("subjects", subjectService.getAllSubjects());
        return "add-score";
    }

    // Handle adding a new score
    @PostMapping("/add-score")
    public String addScore(@ModelAttribute StudentScore studentScore,
                           @RequestParam Long studentId,
                           @RequestParam Long subjectId) {
        studentScore.setStudent(studentService.getStudentById(studentId));
        studentScore.setSubject(subjectService.getSubjectById(subjectId));
        studentScoreService.saveStudentScore(studentScore);
        return "redirect:/";
    }

    // Show form to edit a score
    @GetMapping("/edit-score/{id}")
    public String showEditScoreForm(@PathVariable Long id, Model model) {
        StudentScore studentScore = studentScoreService.getStudentScoreById(id);
        model.addAttribute("studentScore", studentScore);
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("subjects", subjectService.getAllSubjects());
        return "edit-score";
    }

    // Handle editing a score
    @PostMapping("/edit-score/{id}")
    public String editScore(@PathVariable Long id,
                            @ModelAttribute StudentScore studentScore,
                            @RequestParam Long studentId,
                            @RequestParam Long subjectId) {
        studentScore.setStudentScoreId(id);
        studentScore.setStudent(studentService.getStudentById(studentId));
        studentScore.setSubject(subjectService.getSubjectById(subjectId));
        studentScoreService.saveStudentScore(studentScore);
        return "redirect:/";
    }

    @GetMapping("/view-students")
    public String viewAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "view-students";
    }

    // Show form to edit a student
    @GetMapping("/edit-student/{id}")
    public String showEditStudentForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "edit-student";
    }

    // Handle editing a student
    @PostMapping("/edit-student/{id}")
    public String editStudent(@PathVariable Long id, @ModelAttribute Student student) {
        student.setStudentId(id); // Ensure the ID is set to update the correct student
        studentService.saveStudent(student);
        return "redirect:/view-students";
    }
}
