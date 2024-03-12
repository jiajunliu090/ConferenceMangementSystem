package dao.impl;

import dao.UserDAO;
import model.Conference;
import model.User;
import utilities.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDAOImpl implements UserDAO {
    List<User> users;

    public UserDAOImpl() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM user_info";
        users = new ArrayList<>();
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String user_ID = resultSet.getString("user_ID");
                String u_password = resultSet.getString("u_password");
                String name = resultSet.getString("name");
                String meetingName = resultSet.getString("meetingName");
                String position = resultSet.getString("position");
                String gender = resultSet.getString("gender");
                User cur = new User(user_ID, u_password, name, meetingName, position, gender);
                users.add(cur);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
    }
    @Override
    public User getUserById(String userId) {
        if (isExist(userId)) {
            for (Object o : users) {
                User user = (User)o;
                if (user.getUser_ID().equals(userId)) {
                    System.out.println("获取用户成功;");
                    return user;
                }
            }
            System.out.println("在数据库中存在，但未更新至users中;");
        }
        System.out.println("用户不存在;");
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
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
            System.out.println("添加用户：受影响的行数：" + affectRow);
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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM user_info WHERE user_ID = ?";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user_ID);
            int affectRow = preparedStatement.executeUpdate();
            System.out.println("删除用户：受影响的行数：" + affectRow);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(preparedStatement, connection);
        }
        return false;
    }

    @Override
    public boolean updateUser(String user_id, User newUser) { // 更新用户信息
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE user_info\n" +
                "SET u_password = ?,\n" +
                "    name = ?,\n" +
                "    meetingName = ?,\n" +
                "    position = ?,\n" +
                "    gender = ?\n" +
                "WHERE user_ID = ?;\n";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newUser.getU_password());
            preparedStatement.setString(2, newUser.getName());
            preparedStatement.setString(3, newUser.getMeetingName());
            preparedStatement.setString(4, newUser.getPosition());
            preparedStatement.setString(5, newUser.getGender());
            preparedStatement.setString(6, newUser.getUser_ID());
            int affectRow = preparedStatement.executeUpdate();
            System.out.println("更新用户信息：受影响的行数：" + affectRow);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(preparedStatement, connection);
        }
        return false;
    }

    @Override
    public User newUserByDB_User_ID(String user_ID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM user_info WHERE user_ID = ?";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user_ID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String uPassword = resultSet.getString("u_password");
                String name = resultSet.getString("name");
                String meetingName = resultSet.getString("meetingName");
                String position = resultSet.getString("position");
                String gender = resultSet.getString("gender");
                return new User(user_ID, uPassword, name, meetingName, position, gender);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
        return null;
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

    @Override
    public boolean isCorrect(String user_ID, String password) {
        if (isExist(user_ID)) {
            if (getU_password(user_ID).equals(password)) {
                System.out.println("用户名与密码匹配且正确;");
                return true;
            }
            System.out.println("密码错误;");
            return false;
        }
        System.out.println("用户不存在;");
        return false;
    }

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImpl();
        //System.out.println(userDAO.getAllUsers());
        //User user = new User("test0001", "tpass1", "test1");
        //userDAO.addUser(user);
        //System.out.println(userDAO.getU_password("test0001"));
        System.out.println(userDAO.isCorrect("test0001","tpass2"));

    }
}