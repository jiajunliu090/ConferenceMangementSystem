package dao.impl;


import dao.AdminDAO;
import model.Admin;
import model.User;
import utilities.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
// ✔️
public class AdminDAOImpl implements AdminDAO {
    private List<Admin> admins;
    public AdminDAOImpl() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
    }


    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<String> getAdmin_ID() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "";

        return null;
    }

    public static void main(String[] args) {

    }
}
