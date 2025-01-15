package com.codegym.tcomplex.model;

import java.time.LocalDate;

public class Apartment {
    private String id;
    private Double area;
    private String status;
    private Integer floor;
    private String type;
    private String description;
    private Double price;
    private LocalDate startDate;
    private LocalDate endDate;

    public Apartment() {
    }

    public Apartment(String id, Double area, String status, Integer floor, String type, String description, Double price, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.area = area;
        this.status = status;
        this.floor = floor;
        this.type = type;
        this.description = description;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id='" + id + '\'' +
                ", area=" + area +
                ", status='" + status + '\'' +
                ", floor=" + floor +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
