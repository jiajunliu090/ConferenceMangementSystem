package dao;


import model.Admin;

import java.util.List;

public class AdminDAOImpl implements AdminDAO{
    private List<Admin> admins;
    public AdminDAOImpl() {

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
