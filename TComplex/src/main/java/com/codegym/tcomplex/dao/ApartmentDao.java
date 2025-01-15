package com.codegym.tcomplex.dao;

import com.codegym.tcomplex.connection.JdbcConnection;
import com.codegym.tcomplex.model.Apartment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ApartmentDao {
    public boolean insertApt(Apartment apartment){
        try{
            Connection connection = JdbcConnection.getConnection();
            String findQuery = "select id from apartments where id=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(findQuery);
            preparedStatement.setString(1, apartment.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!Optional.ofNullable(resultSet).isPresent()) {
                connection.close();
                return false;
            }

            String addQuery = "insert into apartments values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(addQuery);
            preparedStatement.setString(1, apartment.getId());
            preparedStatement.setDouble(2, apartment.getArea());
            preparedStatement.setString(3, apartment.getStatus());
            preparedStatement.setInt(4, apartment.getFloor());
            preparedStatement.setString(5, apartment.getType());
            preparedStatement.setString(6, apartment.getDescription());
            preparedStatement.setDouble(7, apartment.getPrice());
            preparedStatement.setDate(8, Date.valueOf(apartment.getStartDate()));
            preparedStatement.setDate(9, Date.valueOf(apartment.getEndDate()));

            if(preparedStatement.executeUpdate() > 0) {
                connection.close();
                return true;
            } else {
                connection.close();
                return false;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public List<Apartment> findApt(){
        List<Apartment> resultList = new ArrayList<>();
        Apartment apartment;
        try{
            Connection connection = JdbcConnection.getConnection();
            String query = "select id, area, status, floor, type, description, price, start_date, end_date from apartments order by area;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                apartment = new Apartment();
                apartment.setId(resultSet.getString("id"));
                apartment.setArea(resultSet.getDouble("area"));
                apartment.setStatus(resultSet.getString("status"));
                apartment.setFloor(resultSet.getInt("floor"));
                apartment.setType(resultSet.getString("type"));
                apartment.setDescription(resultSet.getString("description"));
                apartment.setPrice(resultSet.getDouble("price"));
                apartment.setStartDate(resultSet.getDate("start_date").toLocalDate());
                apartment.setEndDate(resultSet.getDate("end_date").toLocalDate());

                resultList.add(apartment);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public List<Apartment> findAptByPara(String status, Integer floor, String type, Double price){
        List<Apartment> resultList = new ArrayList<>();
        Apartment apartment;
        try{
            Connection connection = JdbcConnection.getConnection();
            String query = "select id, area, status, floor, type, description, price, start_date, end_date from apartments where status = ? and floor = ? and type = ? and price < ? order by area;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, floor);
            preparedStatement.setString(3, type);
            preparedStatement.setDouble(4, price);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                apartment = new Apartment();
                apartment.setId(resultSet.getString("id"));
                apartment.setArea(resultSet.getDouble("area"));
                apartment.setStatus(resultSet.getString("status"));
                apartment.setFloor(resultSet.getInt("floor"));
                apartment.setType(resultSet.getString("type"));
                apartment.setDescription(resultSet.getString("description"));
                apartment.setPrice(resultSet.getDouble("price"));
                apartment.setStartDate(resultSet.getDate("start_date").toLocalDate());
                apartment.setEndDate(resultSet.getDate("end_date").toLocalDate());

                resultList.add(apartment);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public void delete(String id){
        try{
            Connection connection = JdbcConnection.getConnection();
            String query = "delete from apartments where id =?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
