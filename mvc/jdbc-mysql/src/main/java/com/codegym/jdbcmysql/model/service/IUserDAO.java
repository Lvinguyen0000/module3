package com.codegym.jdbcmysql.model.service;

import com.codegym.jdbcmysql.model.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;

    User getUserById(int id);

    void insertUserStore(User user) throws SQLException;

    void addUserTransaction(User user, List<Integer> permission);

    public void insertUpdateWithoutTransaction();

    public void insertUpdateUseTransaction();
}
