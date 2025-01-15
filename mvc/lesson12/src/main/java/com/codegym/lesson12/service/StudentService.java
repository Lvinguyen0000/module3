package com.codegym.lesson12.service;

import com.codegym.lesson12.dao.StudentDao;
import com.codegym.lesson12.model.Student;

import java.util.List;
import java.util.Optional;

public class StudentService {
    private StudentDao studentDao;

    public StudentService(){
        studentDao = new StudentDao();
    }

    public List<Student> getStudents(){
        List<Student> students = studentDao.findStudents();
        if (Optional.ofNullable(students).isPresent()){
            return students;
        }
        return null;
    }

    public Student getStudent(Integer id){
        Student student = studentDao.findStudent(id);
        if (Optional.ofNullable(student).isPresent()){
            return student;
        }
        return null;
    }

    public Student getStudentInfo(Integer id){
        Student student = studentDao.findStudentInfo(id);
        if (Optional.ofNullable(student).isPresent()){
            return student;
        }
        return null;
    }

    public void addStudent(Student student){
        studentDao.saveStudent(student);
    }

    public void editStudent(Student student){
        studentDao.updateStudent(student);
    }

    public void removeStudent(Integer id) {
        studentDao.deleteStudent(id);
    }
}
