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
    User getUserById(String userId);
    List<User> getAllUsers();
    // 添加用户
    boolean addUser(User curToAdd);
    // 删除用户
    boolean deleteUser(String user_ID);
    // 更新用户信息
    boolean updateUser(String user_id, String name, String meetingName, String position, String gender, String u_password);
    // 根据用户ID查询数据库创建一个用户实例
    User newUserByDB_User_ID(String user_ID);
    // 用户是否存在
    boolean isExist(String user_ID);
    String getU_password(String user_ID);
    // 用户名与密码符合
    boolean isCorrect(String user_ID, String password);
}
