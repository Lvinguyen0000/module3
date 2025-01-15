package com.codegym.lesson12.dao;

import com.codegym.lesson12.connection.JdbcConnection;
import com.codegym.lesson12.model.Student;
import com.sun.tools.classfile.ConstantPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDao {
    private List<Student> students;

    public List<Student> findStudents(){
        students = new ArrayList<>();
        try{
            Connection connection = JdbcConnection.getConnection();
            String query = "select * from students limit 100;";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFullName(resultSet.getString("fullName"));
                student.setUsername(resultSet.getString("userName"));
                student.setPassword(resultSet.getString("password"));
                student.setAge(resultSet.getInt("age"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone(resultSet.getString("phone"));
                student.setAddress(resultSet.getString("address"));
                student.setClazzId(resultSet.getInt("clazz_id"));
                students.add(student);
            }
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }

    public Student findStudent(Integer id){
        Student student = new Student();
        try{
            Connection connection = JdbcConnection.getConnection();
            String query = "select id, fullName, age, email, phone, address, clazz_id from students where id = ?;";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                student.setId(resultSet.getInt("id"));
                student.setFullName(resultSet.getString("fullName"));
                student.setAge(resultSet.getInt("age"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone(resultSet.getString("phone"));
                student.setAddress(resultSet.getString("address"));
                student.setClazzId(resultSet.getInt("clazz_id"));
            }
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }

    public Student findStudentInfo(Integer id){
        Student student = new Student();
        try{
            Connection connection = JdbcConnection.getConnection();
            String query = "select id, fullName, userName, password, age, email, phone, address, clazz_id from students where id = ?;";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                student.setId(resultSet.getInt("id"));
                student.setFullName(resultSet.getString("fullName"));
                student.setUsername(resultSet.getString("userName"));
                student.setPassword(resultSet.getString("password"));
                student.setAge(resultSet.getInt("age"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone(resultSet.getString("phone"));
                student.setAddress(resultSet.getString("address"));
                student.setClazzId(resultSet.getInt("clazz_id"));
            }
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }

    public void saveStudent(Student student) {
        try {
            if(student.getId() != null) {
                System.out.println("Student is existed.");
                return;
            }

            Connection connection = JdbcConnection.getConnection();
            String query = "INSERT INTO students(fullName, username, password, age, " +
                    "email, phone, address, clazz_id) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setString(2, student.getUsername());
            preparedStatement.setString(3, student.getPassword());
            preparedStatement.setInt(4, student.getAge());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setString(6, student.getPhone());
            preparedStatement.setString(7, student.getAddress());
            preparedStatement.setInt(8, student.getClazzId());

            if(preparedStatement.executeUpdate() > 0) {
                System.out.println("Added student successfully.");
            } else {
                System.out.println("Failed to insert student.");
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student){
        try{
            Connection connection = JdbcConnection.getConnection();
            String query = "UPDATE students SET fullName=?, userName=?, password=?, age=?, email=?, phone=?, address=?, clazz_id=? where id=?;";

            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setString(2, student.getUsername());
            preparedStatement.setString(3, student.getPassword());
            preparedStatement.setInt(4, student.getAge());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setString(6, student.getPhone());
            preparedStatement.setString(7, student.getAddress());
            preparedStatement.setInt(8, student.getClazzId());
            preparedStatement.setInt(9, student.getId());

            if(preparedStatement.executeUpdate() > 0) {
                System.out.println("Updated student successfully.");
            } else {
                System.out.println("Failed to update student.");
            }
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteStudent(Integer id){
        try{
            Connection connection = JdbcConnection.getConnection();
            String query = "DELETE FROM students WHERE id = ?;";

            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            if(preparedStatement.executeUpdate() > 0) {
                System.out.println("Deleted student successfully.");
            } else {
                System.out.println("Failed to delete student.");
            }
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
