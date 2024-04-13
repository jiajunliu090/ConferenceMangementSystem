package dao.impl;

import dao.AdminDAO;
import model.Admin;
import model.User;
import utilities.ConfigHelper;
import utilities.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
// ✔️
public class AdminDAOImpl implements AdminDAO {
    private List<Admin> admins;
    public AdminDAOImpl() {

    }


    @Override
    public boolean login(String admin_ID, String a_password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM conference_management.admin_info WHERE admin_ID = ?;";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, admin_ID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("a_password").equals(a_password)) {
                    System.out.println("登录成功");
                    return true;
                }else return false;
            }
            return false;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {  //✔️
        return ConfigHelper.getInstance().getUserDAO().getAllUsers();
    }

    @Override
    public List<String> getAdmin_ID() { // ✔️
        List<String> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT admin_ID FROM conference_management.admin_info";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getString("admin_ID"));
            }
            return list;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
        return list;
    }

}
