package com.example.hw_tuesday.Conroller;


import com.example.hw_tuesday.DTO.ApiResponse;
import com.example.hw_tuesday.Model.Student;
import com.example.hw_tuesday.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    public ResponseEntity<List> getStudent(){
        List<Student> students=studentService.getStudent();
        return ResponseEntity.status(200).body(students);
    }
    @PostMapping
    public ResponseEntity<ApiResponse> setStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(201).body(new ApiResponse("New student added !",201));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> putStudent(@RequestBody @Valid Student student,@PathVariable Integer id){
        studentService.putStudent(id,student);
        return ResponseEntity.status(201).body(new ApiResponse("New student updated !",201));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable @Valid Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(201).body(new ApiResponse("New student deleted !",201));

    }
    // get by Student by id
    @GetMapping("/id/{id}")
    public ResponseEntity getStudentByID(@PathVariable @Valid Integer id){
         Student student=studentService.getStudentById(id);
         return ResponseEntity.status(200).body(student);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity getStudentByName(@PathVariable @Valid String name){
        Student student=studentService.findStudentByName(name);
        return ResponseEntity.status(200).body(student);
    }
    @GetMapping("major/{major}")
    public ResponseEntity getStudentsByMajor(@PathVariable @Valid String major){
        Student student= (Student) studentService.getStudentsByMajor(major);
        return ResponseEntity.status(200).body(student);

    }
    @GetMapping("/age")
    public ResponseEntity<List> getStudentsByAge(@RequestBody Integer age){
        List<Student> students= studentService.getStudentsByAge(age);
        return ResponseEntity.status(200).body(students);
    }


}


