package service.impl;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import model.Conference;
import model.User;
import service.AdminService;
import utilities.ConfigHelper;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    @Override
    public boolean login(String admin_ID, String a_password) {
        return ConfigHelper.getInstance().getAdminDAO().login(admin_ID, a_password);
    }

    @Override
    public List<User> getAllUsers() {
        return ConfigHelper.getInstance().getUserDAO().getAllUsers();
    }

    @Override
    public List<Conference> getConferenceByUser(String user_ID) {
        return ConfigHelper.getInstance().getUserConferenceDAO().getConferencesByUser_ID(user_ID);
    }

    @Override
    public boolean addConferenceRoom(String room_ID) {
        return ConfigHelper.getInstance().getRoomDAO().addRoom(room_ID);
    }

    @Override
    public boolean openRoom(String room_ID) {
        return ConfigHelper.getInstance().getRoomDAO().openRoom(room_ID);
    }

    @Override
    public boolean closeRoom(String room_ID) {
        return ConfigHelper.getInstance().getRoomDAO().closeRoom(room_ID);
    }

    public static void main(String[] args) {
        AdminService adminService = new AdminServiceImpl();
        //adminService.addConferenceRoom("1234567H");
        //adminService.closeRoom("1234567H");
        //adminService.openRoom("1234567H");
        //adminService.getConferenceByUser("1234");
    }
}
