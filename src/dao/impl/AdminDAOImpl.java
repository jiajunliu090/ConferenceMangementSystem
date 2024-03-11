package dao.impl;


import dao.AdminDAO;
import model.Admin;

import java.util.List;
// ✔️
public class AdminDAOImpl implements AdminDAO {
    private List<Admin> admins;
    public AdminDAOImpl() {
        try {

        }catch (Exception e) {

        }
    }
    @Override
    public List<Admin> getAllAdmins() {
        return admins;
    }

    @Override
    public List<String> getAdmin_ID() {

        return null;
    }

    public static void main(String[] args) {

    }
}
