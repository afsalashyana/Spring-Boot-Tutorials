package com.genuinecoder.LearnSpringBoot;

import com.genuinecoder.LearnSpringBoot.model.Student;
import com.genuinecoder.LearnSpringBoot.model.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/student/save")
    public Student createStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    @GetMapping("/student/findByEmail")
    public Student findStudent(@RequestParam("email") String email) {
        return repository.findByEmail(email);
    }

    @PatchMapping("/student/update")
    public Student findStudent(@RequestParam("student_id") Long id, @RequestParam("new_email") String email) {
        Optional<Student> student = repository.findById(id);
        if (student.isPresent()) {
            Student studentObj = student.get();
            studentObj.setEmail(email);
            return repository.save(studentObj);
        }
        return null;
    }

    @GetMapping("/student/findByEmailDomain")
    public List<Student> findStudentByDomain(@RequestParam("domain") String domain) {
        return repository.findByDomain(domain);
    }

}
