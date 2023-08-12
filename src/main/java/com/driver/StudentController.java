package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    StudentService servObj = new StudentService();
    @PostMapping("/add-student")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        String resp = servObj.addStudent(student);
        if(resp.equals("SUCCESS")) {
            return new ResponseEntity<>("New student added successfully", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Student already exists", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/add-teacher")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher){

        String resp = servObj.addTeacher(teacher);
        if(resp.equals("SUCCESS")) {
            return new ResponseEntity<>("New teacher added successfully", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Teacher already exists", HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @PutMapping("/add-student-teacher-pair")
    public ResponseEntity<String> addStudentTeacherPair(@RequestParam String student, @RequestParam String teacher){

        String resp = servObj.addStudentTeacherPair(student, teacher);
        if(resp.equals("SUCCESS")) {
            return new ResponseEntity<>("New student-teacher pair added successfully", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Invalid name", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/get-student-by-name/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable String name){
        Student student = null; // Assign student by calling service layer method
        student = servObj.getStudentByName(name);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping("/get-teacher-by-name/{name}")
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable String name){
        Teacher teacher = null; // Assign student by calling service layer method
        teacher = servObj.getTeacherByTeacherName(name);
        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    @GetMapping("/get-students-by-teacher-name/{teacher}")
    public ResponseEntity<List<String>> getStudentsByTeacherName(@PathVariable String teacher){
        List<String> students = null; // Assign list of student by calling service layer method
        students = servObj.getStudentsByTeacherName(teacher);
        return new ResponseEntity<>(students, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-students")
    public ResponseEntity<List<String>> getAllStudents(){
        List<String> students = null; // Assign list of student by calling service layer method
        students = servObj.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-teacher-by-name")
    public ResponseEntity<String> deleteTeacherByName(@RequestParam String teacher){
        String resp = servObj.deleteTeacherByName(teacher);
        if(resp.equals("SUCCESS")) {
            return new ResponseEntity<>(teacher + " removed successfully", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Teacher not found", HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @DeleteMapping("/delete-all-teachers")
    public ResponseEntity<String> deleteAllTeachers(){
        servObj.deleteAllTeachers();
        return new ResponseEntity<>("All teachers deleted successfully", HttpStatus.CREATED);
    }
}
