package dao;


import model.Admin;

import java.util.List;

interface AdminDAO {
    /**
     * 对管理员进行操作
     */
    List<Admin> getAllAdmins();
    List<String> getAdmin_ID();
}
public class AdminDAOImpl implements AdminDAO{

    @Override
    public List<Admin> getAllAdmins() {
        return null;
    }

    @Override
    public List<String> getAdmin_ID() {
        return null;
    }

    public static void main(String[] args) {

    }
}
