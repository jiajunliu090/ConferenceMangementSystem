package dao;

import model.Conference;
import model.User;

import java.util.List;

/**
 * dao层：将数据访问和业务层分离，对数据库进行操作
 */
public interface UserDAO {
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

    // 用户是否存在
    boolean isExist(String user_ID);
}
