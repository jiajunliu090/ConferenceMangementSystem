package dao;

import model.Admin;

import java.util.List;

public interface AdminDAO {
    /**
     * 对管理员进行操作
     */
    List<Admin> getAllAdmins();

    List<String> getAdmin_ID();
}
