package dao.impl;

import dao.UserDAO;
import model.Conference;
import model.User;
import utilities.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    List<User> users;

    @Override
    public User getUserById(int userId) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public List<User> getUsersByConference(Conference conference) {
        return null;
    }

    @Override
    public boolean addUser(User curToAdd) {
        // 判断是否存在
        if (isExist(curToAdd.getUser_ID())) {
            return false;
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO user_info(user_ID, u_password, name) VALUES (?, ?, ?)";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, curToAdd.getUser_ID());
            preparedStatement.setString(2, curToAdd.getU_password());
            preparedStatement.setString(3, curToAdd.getName());
            int affectRow = preparedStatement.executeUpdate();
            System.out.println("受影响的行数：" + affectRow);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(preparedStatement, connection);
        }
        return false;
    }

    @Override
    public boolean deleteUser(String user_ID) {
        return false;
    }

    @Override
    public boolean updateUser(String user_id, User newUser) {
        return false;
    }

    @Override
    public boolean isExist(String user_ID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM user_info";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String cur = resultSet.getString("user_ID");
                if (cur.equals(user_ID)) {
                    return true;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
        return false;
    }
    public String getU_password(String user_ID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM user_info WHERE user_ID = ?";
        String res = null;
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user_ID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("user_ID").equals(user_ID)) {
                    res = resultSet.getString("u_password");
                }
            }
            return res;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
        return res;
    }

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImpl();
        System.out.println(userDAO.isExist("10000000"));
        //User user = new User("test0001", "tpass1", "test1");
        //userDAO.addUser(user);
        System.out.println(userDAO.getU_password("test0001"));

    }
}
