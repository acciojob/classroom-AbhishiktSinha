package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repoObj = new StudentRepository();

    public void addStudent(Student student)  {
        repoObj.addStudent(student);
    }
    public void addTeacher(Teacher teacher) {
        repoObj.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String teacherName, String studentName) {
        repoObj.addStudentTeacherPair(teacherName, studentName);
    }

    public Student getStudentByName(String name) {
        return repoObj.getStudentByName(name);
    }
    public Teacher getTeacherByTeacherName(String name) {
        return repoObj.getTeacherByName(name);
    }

    public List<String> getStudentsByTeacherName(String name) {
        return repoObj.getStudentsByTeacherName(name);
    }
    public List<String> getAllStudents() {
        return repoObj.getAllStudents();
    }

    public void deleteTeacherByName(String name) {
        repoObj.deleteTeacherByName(name);
    }
    public void deleteAllTeachers() {
        repoObj.deleteAllTeachers();
    }
}
