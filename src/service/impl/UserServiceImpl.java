package service.impl;

import dao.*;
import model.Conference;
import model.User;
import service.UserService;
import utilities.ConfigHelper;

import java.time.LocalDateTime;
import java.util.List;

public class UserServiceImpl implements UserService {

    private String loginUser_ID;

    public UserServiceImpl() {
    }
    @Override
    public boolean registerUser(String user_ID, String u_password, String name) {
        // 先检查ID是否重复
        if (ConfigHelper.getInstance().getUserDAO().isExist(user_ID)) {
            return false;
        }else {
            ConfigHelper.getInstance().getUserDAO().addUser(new User(user_ID, u_password, name));
            return true;
        }
    }

    @Override
    public boolean loginUser(String user_ID, String u_password) {
        if (ConfigHelper.getInstance().getUserDAO().isCorrect(user_ID, u_password)) {
            this.loginUser_ID = user_ID;
            return true;
        }
        return false;
    }

    @Override
    public String getLoginUser_ID() {
        return loginUser_ID;
    }


    @Override
    public boolean deleteUser(String user_ID, String u_password, String ensure) {
        String contrast = "我同意注销" + user_ID; // 写保证
        if (ConfigHelper.getInstance().getUserDAO().isCorrect(user_ID, u_password) && contrast.equals(ensure)) { // 如果存在并且用户名和密码对的上的话
            return ConfigHelper.getInstance().getUserDAO().deleteUser(user_ID); // 删除
        }
        return false;
    }

    @Override
    public List<Conference> meetingsToAttend() { // 查找需要参加的会议
        return ConfigHelper.getInstance().getUserConferenceDAO().getConferencesByUser_ID(loginUser_ID);
    }

    @Override
    public boolean createConference(String meeting_ID, String room_ID, List<User> participators, LocalDateTime meetingTime, String theme) {
        Conference conference = new Conference(meeting_ID, loginUser_ID, participators, meetingTime, theme);
        // 创建会议
        return ConfigHelper.getInstance().getConferenceDAO().addConference(conference, room_ID);
    }

    @Override
    public boolean updateConference() { // 修改会议

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

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.registerUser("test0001", "tpass1", "test1");
        userService.loginUser("test0001", "tpass1");
        String loginUser_ID = userService.getLoginUser_ID();
        System.out.println("Login user ID: " + loginUser_ID);
        //System.out.println(userService.deleteUser("test0001", "tpass1", "我同意注销test0001"));
    }
}
