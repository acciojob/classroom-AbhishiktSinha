package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repoObj = new StudentRepository();

    public String addStudent(Student student)  {
        try{
            repoObj.addStudent(student);
            return "SUCCESS";
        }
        catch(InvalidNameException e) {
            return "FALIURE";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String addTeacher(Teacher teacher) {
        try{
            repoObj.addTeacher(teacher);
            return "SUCCESS";
        }
        catch(InvalidNameException e) {
            return "FAILURE";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String addStudentTeacherPair(String teacherName, String studentName) {
        try{
            repoObj.addStudentTeacherPair(teacherName, studentName);
            return "SUCCESS";
        }
        catch(InvalidNameException e) {
            return "FAILURE";
        }catch(AlreadyPairedException e) {
            return "FAILURE";
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Student getStudentByName(String name) {
        try {
            return repoObj.getStudentByName(name);
        } catch (InvalidNameException e) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Teacher getTeacherByTeacherName(String name) {
        try {
            return repoObj.getTeacherByName(name);
        } catch(InvalidNameException e) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getStudentsByTeacherName(String name) {
        try {
            return repoObj.getStudentsByTeacherName(name);
        } catch (InvalidNameException e) {
            return new ArrayList<>();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<String> getAllStudents() {
        return repoObj.getAllStudents();
    }

    public String deleteTeacherByName(String name) {
        try {
            return repoObj.deleteTeacherByName(name);
        } catch (InvalidNameException e) {
            return "FAILURE";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteAllTeachers() {
        repoObj.deleteAllTeachers();
    }
}
