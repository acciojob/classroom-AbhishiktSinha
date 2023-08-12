package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

class InvalidNameException extends Exception {
    InvalidNameException() {
        super("Invalid name");
    }
}
class AlreadyPairedException extends Exception{
    AlreadyPairedException() {
        super("Pairing already exists");
    }
}

@Repository
public class StudentRepository {
    private Map<String, Student> studentMap = new HashMap<>();
    private Map<String, Teacher> teacherMap = new HashMap<>();
    private Map<String, List<String>> pairMap = new HashMap<>();

    public void addStudent(Student newStudent){
        String studentName = newStudent.getName();
        studentMap.put(studentName, newStudent);
    }
    public void addTeacher(Teacher newTeacher) {
        String teacherName = newTeacher.getName();
        teacherMap.put(teacherName, newTeacher);
    }

    public void addStudentTeacherPair(String teacherName, String studentName) {

        if(!teacherMap.containsKey(teacherName) || !studentMap.containsKey(studentName)) {
            return;
        }
        else {
            List<String> studentList = pairMap.getOrDefault(teacherName, new ArrayList<>());

            studentList.add(studentName);
            pairMap.put(teacherName, studentList);
            Teacher teacher = teacherMap.get(teacherName);
            teacher.setNumberOfStudents(studentList.size());
        }
    }

    public Student getStudentByName(String studentName) {
        return studentMap.getOrDefault(studentName, null);
    }
    public Teacher getTeacherByName(String teacherName) {
        return teacherMap.getOrDefault(teacherName, null);
    }

    public List<String> getStudentsByTeacherName(String teacherName) {
        return pairMap.getOrDefault(teacherName, new ArrayList<String>());
    }
    public List<String> getAllStudents() {
        List<String> allStudents = new ArrayList<>();
        for(String studentName : studentMap.keySet()) {
            allStudents.add(studentName);
        }
        return allStudents;
    }

    public void deleteTeacherByName(String teacherName) {
        teacherMap.remove(teacherName);
        pairMap.remove(teacherName);
    }

    public void deleteAllTeachers() {
        teacherMap.clear();
        pairMap.clear();
    }

}
