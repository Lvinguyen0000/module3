package com.codegym.tcomplex.service;

import com.codegym.tcomplex.dao.ApartmentDao;
import com.codegym.tcomplex.model.Apartment;

import java.time.temporal.ChronoUnit;
import java.util.List;

public class ApartmentService {
    public String addApt(Apartment apartment){
        if (apartment.getEndDate().isEqual(apartment.getStartDate().minusMonths(6))){
            return "Invalid date";
        }

        else{
            if (new ApartmentDao().insertApt(apartment)){
                return null;
            }
            else{
                return "Apartment existed";
            }
        }
    }

    public List<Apartment> getApt(){
        return new ApartmentDao().findApt();
    }

    public List<Apartment> getAptByPara(String status, Integer floor, String type, Double price){
        return new ApartmentDao().findAptByPara(status, floor, type, price);
    }

    public void delete(String id){
        new ApartmentDao().delete(id);
    }
}
