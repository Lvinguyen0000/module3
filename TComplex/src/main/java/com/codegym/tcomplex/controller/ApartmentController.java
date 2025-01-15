package com.codegym.tcomplex.controller;


import com.codegym.tcomplex.model.Apartment;
import com.codegym.tcomplex.service.ApartmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@WebServlet (name = "ApartmentController", urlPatterns = {"/", "/add", "/list", "/del"})
public class ApartmentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        switch (action){
            case "/":
                req.getRequestDispatcher("/WEB-INF/view/add.jsp").forward(req, resp);
                break;
            case "/add":
                req.getRequestDispatcher("/WEB-INF/view/add.jsp").forward(req, resp);
                break;
            case "/list":
                List<Apartment> resultList = new ApartmentService().getApt();

                req.setAttribute("apt_list", resultList);
                req.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(req, resp);
                break;
            case "/del":
                new ApartmentService().delete(req.getParameter("id"));
                resp.sendRedirect("/list");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        switch (action){
            case "/add":
                String id = req.getParameter("id");
                Double area = Double.valueOf(req.getParameter("area"));
                String status = req.getParameter("status");
                Integer floor = Integer.valueOf(req.getParameter("floor"));
                String type = req.getParameter("type");
                String description = req.getParameter("description");
                Double price = Double.valueOf(req.getParameter("price"));

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate startDate = LocalDate.parse(req.getParameter("start_date"), formatter);
                LocalDate endDate = LocalDate.parse(req.getParameter("end_date"), formatter);

                Apartment apartment = new Apartment(id, area, status, floor, type, description, price, startDate, endDate);

                String result = new ApartmentService().addApt(apartment);

                if (!Optional.ofNullable(result).isPresent()){
                    resp.sendRedirect("/list");
                }
                else{
                    req.setAttribute("message", result);
                    req.getRequestDispatcher("/WEB-INF/view/add.jsp").forward(req, resp);
                }
                break;

            case "/list":
                String statusP = req.getParameter("status");
                Integer floorP = Integer.valueOf(req.getParameter("floor"));
                String typeP = req.getParameter("type");
                Double priceP = Double.valueOf(req.getParameter("price"));

                List<Apartment> resultListP = new ApartmentService().getAptByPara(statusP, floorP, typeP, priceP);

                req.setAttribute("apt_list", resultListP);
                req.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(req, resp);
                break;
        }
    }
}
