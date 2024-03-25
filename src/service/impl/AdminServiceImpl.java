package service.impl;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import model.Conference;
import model.User;
import service.AdminService;
import utilities.ConfigHelper;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private static AdminServiceImpl instance;

    private AdminServiceImpl() {
        // 私有构造函数防止外部实例化
    }

    public static AdminServiceImpl getInstance() {
        if (instance == null) {
            synchronized (AdminServiceImpl.class) {
                if (instance == null) {
                    instance = new AdminServiceImpl();
                }
            }
        }
        return instance;
    }

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
        AdminService adminService = AdminServiceImpl.getInstance();
        // adminService.addConferenceRoom("1234567H");
        // adminService.closeRoom("1234567H");
        // adminService.openRoom("1234567H");
        // adminService.getConferenceByUser("1234");
    }
}
