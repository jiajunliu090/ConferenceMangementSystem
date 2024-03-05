package service.impl;

import dao.*;
import model.Conference;
import model.User;
import service.UserService;
import utilities.DependencyInjectionConfig;

import java.time.LocalDateTime;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    private AdminDAO adminDAO;
    private ConferenceDAO conferenceDAO;
    private RoomDAO roomDAO;

    public UserServiceImpl(DependencyInjectionConfig dic) {
        userDAO = dic.getUserDAO();
        adminDAO = dic.getAdminDAO();
        conferenceDAO = dic.getConferenceDAO();
        roomDAO = dic.getRoomDAO();
    }
    @Override
    public boolean registerUser(String user_ID, String u_password, String name) {
        // 先检查ID是否重复
        if (userDAO.isExist(user_ID)) {
            return false;
        }else {
            userDAO.addUser(new User(user_ID, u_password, name));
            return true;
        }
    }


    @Override
    public boolean deleteUser(String user_ID, String u_password) {
        return false;
    }

    @Override
    public List<Conference> meetingsToAttend() {
        return null;
    }

    @Override
    public boolean createConference(String meeting_ID, String room_ID, List<User> participators, LocalDateTime meetingTime) {
        return false;
    }

    @Override
    public boolean updateConference() {
        return false;
    }

    @Override
    public boolean deleteConference(String meeting_ID) {
        return false;
    }

    @Override
    public boolean signInMeeting(String meeting_ID) {
        return false;
    }

    @Override
    public boolean updateUser(User userTouUpdate) {
        return false;
    }

    @Override
    public String evaluateMeeting(String evaluation) {
        return null;
    }
}
