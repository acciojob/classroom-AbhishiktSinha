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

    public String addStudent(Student newStudent)throws Exception {
        String studentName = newStudent.getName();
        if(studentMap.containsKey(studentName)) {
            throw new InvalidNameException();
        }
        else {
            studentMap.put(studentName, newStudent);
            return "SUCCESS";
        }
    }
    public String addTeacher(Teacher newTeacher)throws Exception {
        String teacherName = newTeacher.getName();
        if(teacherMap.containsKey(teacherName)) {
            throw new InvalidNameException();
        }
        else {
            teacherMap.put(teacherName, newTeacher);
            return "SUCCESS";
        }
    }

    public String addStudentTeacherPair(String teacherName, String studentName)throws Exception {

        if(!teacherMap.containsKey(teacherName) || !studentMap.containsKey(studentName)) {
            throw new InvalidNameException();
        }
        else {
            List<String> studentList = pairMap.getOrDefault(teacherName, new ArrayList<>());
            if(studentList.contains(studentName)) {
                throw new AlreadyPairedException();
            }
            else {
                studentList.add(studentName);
                pairMap.put(teacherName, studentList);
                return "SUCCESS";
            }
        }
    }

    public Student getStudentByName(String studentName)throws Exception {
        if(!studentMap.containsKey(studentName)){
            throw new InvalidNameException();
        }
        else{
            return studentMap.get(studentName);
        }
    }
    public Teacher getTeacherByName(String teacherName)throws Exception {
        if(!teacherMap.containsKey(teacherName)){
            throw new InvalidNameException();
        }
        else{
            return teacherMap.get(teacherName);
        }
    }

    public List<String> getStudentsByTeacherName(String teacherName)throws Exception {
        if(!teacherMap.containsKey(teacherName)) {
            throw new InvalidNameException();
        }
        else{
            return pairMap.getOrDefault(teacherName, new ArrayList<String>());
        }
    }
    public List<String> getAllStudents() {
        List<String> allStudents = new ArrayList<>();
        for(String studentName : studentMap.keySet()) {
            allStudents.add(studentName);
        }
        return allStudents;
    }

    public String deleteTeacherByName(String teacherName) throws Exception {
        if(!teacherMap.containsKey(teacherName)) {
            throw new InvalidNameException();
        }
        else{
            teacherMap.remove(teacherName);
            pairMap.remove(teacherName);
            return "SUCCESS";
        }
    }

    public void deleteAllTeachers() {
        teacherMap.clear();
        pairMap.clear();
    }

}
