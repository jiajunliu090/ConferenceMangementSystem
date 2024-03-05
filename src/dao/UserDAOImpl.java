package dao;

import model.Conference;
import model.User;

import java.util.List;

/**
 * dao层：将数据访问和业务层分离，对数据库进行操作
 */
interface UserDAO {
    /**
     * 对用户操作
     */
    // 查用户
    User getUserById(int userId);
    List<User> getAllUsers();
    // 根据会议查用户
    List<User> getUsersByConference(Conference conference);
    // 添加用户
    boolean addUser(User curToAdd);
    // 删除用户
    boolean deleteUser(String user_ID);
    // 更新用户信息
    boolean updateUser(String user_id, User newUser);
}
public class UserDAOImpl implements UserDAO {

    @Override
    public User getUserById(int userId) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<User> getUsersByConference(Conference conference) {
        return null;
    }

    @Override
    public boolean addUser(User curToAdd) {
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

    public static void main(String[] args) {

    }
}
