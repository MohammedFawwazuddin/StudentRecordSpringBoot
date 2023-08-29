package com.prodapt.learningspring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    private List<StudentController> students = new ArrayList<>();

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute("student") Student student) {
        student.setId(System.currentTimeMillis()); // You might use a better ID generation strategy
        students.add(student);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student studentToEdit = findStudentById(id);
        if (studentToEdit != null) {
            model.addAttribute("student", studentToEdit);
            return "edit-student";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, @ModelAttribute("student") Student updatedStudent) {
        Student studentToEdit = findStudentById(id);
        if (studentToEdit != null) {
            studentToEdit.setRank(updatedStudent.getRank());
            studentToEdit.setName(updatedStudent.getName());
            studentToEdit.setMarks(updatedStudent.getMarks());
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        Student studentToDelete = findStudentById(id);
        if (studentToDelete != null) {
            students.remove(studentToDelete);
        }
        return "redirect:/";
    }

    private StudentController findStudentById(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
