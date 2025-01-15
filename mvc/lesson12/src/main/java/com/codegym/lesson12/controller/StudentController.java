package com.codegym.lesson12.controller;

import com.codegym.lesson12.model.Student;
import com.codegym.lesson12.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "studentController", urlPatterns = {"/students" , "/students/detail", "/students/add", "/students/edit", "/students/remove"})
public class StudentController extends HttpServlet {
    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        studentService = new StudentService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        switch (action){
            case "/students":
                req.setAttribute("students", studentService.getStudents());
                req.getRequestDispatcher("/WEB-INF/view/student/list.jsp").forward(req, resp);
                break;
            case "/students/detail":
                req.setAttribute("student", studentService.getStudent(Integer.parseInt(req.getParameter("id"))));
                req.getRequestDispatcher("/WEB-INF/view/student/detail.jsp").forward(req, resp);
                break;
            case "/students/add":
                req.getRequestDispatcher("/WEB-INF/view/student/add.jsp").forward(req, resp);
                break;
            case "/students/edit":
                req.setAttribute("student", studentService.getStudentInfo(Integer.parseInt(req.getParameter("id"))));
                req.getRequestDispatcher("/WEB-INF/view/student/edit.jsp").forward(req, resp);
                break;
            case "/students/remove":
                studentService.removeStudent(Integer.parseInt(req.getParameter("id")));
                req.setAttribute("message", "Student was removed successfully");
                req.setAttribute("students", studentService.getStudents());
                req.getRequestDispatcher("/WEB-INF/view/student/list.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        switch (action){
            case "/students/add":
                String fullName = req.getParameter("fullName");
                String userName = req.getParameter("userName");
                String password = req.getParameter("password");
                int age = Integer.parseInt(req.getParameter("age"));
                String email = req.getParameter("email");
                String phone = req.getParameter("phone");
                String address = req.getParameter("address");
                int clazzId = Integer.parseInt(req.getParameter("clazzId"));
                Student student = new Student(fullName, userName, password, age, email, phone, address, clazzId);

                studentService.addStudent(student);
                req.setAttribute("message", "Added student successfully");
                req.getRequestDispatcher("/WEB-INF/view/student/add.jsp").forward(req, resp);
                break;

            case "/students/edit":
                Integer id = Integer.parseInt(req.getParameter("id"));
                String fullName1 = req.getParameter("fullName");
                String userName1 = req.getParameter("userName");
                String password1 = req.getParameter("password");
                int age1 = Integer.parseInt(req.getParameter("age"));
                String email1 = req.getParameter("email");
                String phone1 = req.getParameter("phone");
                String address1 = req.getParameter("address");
                int clazzId1 = Integer.parseInt(req.getParameter("clazzId"));
                Student editStudent = new Student(id, fullName1, userName1, password1, age1, email1, phone1, address1, clazzId1);

                studentService.editStudent(editStudent);
                req.setAttribute("message", "Updated student successfully");
                req.getRequestDispatcher("/WEB-INF/view/student/edit.jsp").forward(req, resp);
                break;
        }
    }
}
