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
}
