package dao;

import model.Admin;
import model.User;

import java.util.List;

public interface AdminDAO {
    /**
     * 对管理员进行操作
     */
    // 获取所有用户信息
    boolean login(String admin_ID, String a_password);
    List<User> getAllUsers();

    List<String> getAdmin_ID();

}
