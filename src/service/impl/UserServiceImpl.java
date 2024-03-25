package service.impl;

import model.Conference;
import model.User;
import service.UserService;
import utilities.ConfigHelper;
import utilities.DateTimeUtils;
import utilities.Session;

import java.time.LocalDateTime;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl instance;

    private String loginUser_ID;

    // 私有构造函数，防止外部类直接实例化
    private UserServiceImpl() {
    }

    // 获取单例实例的静态方法
    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
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
            User loggedInUser = ConfigHelper.getInstance().getUserDAO().newUserByDB_User_ID(user_ID);
            Session.getInstance().loginUser(user_ID, loggedInUser); // 将登录成功的用户信息保存到会话对象中
            System.out.println("登录成功");
            return true;
        } else return false;
    }

    @Override
    public String getLoginUser_ID() {
        return this.loginUser_ID;
    }

    @Override
    public User getLoginUser() {
        return ConfigHelper.getInstance().getUserDAO().newUserByDB_User_ID(getLoginUser_ID());
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
    public boolean createConference(String meeting_ID, String room_ID, List<String> participators, LocalDateTime meetingTime) {
        List<String> idByName = ConfigHelper.getInstance().getUserDAO().getIDByName(participators);
        idByName.add(loginUser_ID);
        Conference conference = new Conference(
                meeting_ID,
                loginUser_ID,
                ConfigHelper.getInstance().getUserDAO().getUserByUser_ID(idByName),
                meetingTime);
        if (ConfigHelper.getInstance().getConferenceDAO().addConference(conference, room_ID)) {
            if (ConfigHelper.getInstance().getUserConferenceDAO().connectUserAndConference(idByName, meeting_ID)) {
                System.out.println("会议会议室关联成功，用户会议关联成功");
                return true;
            }else return false;
        }else return false;
    }

    @Override // 时间格式：MM.dd.HH.mm
    public boolean updateConference(String meeting_ID, String theme, String meetingTime) { // 修改会议
        return ConfigHelper.getInstance().getConferenceDAO().updateConference(meeting_ID, loginUser_ID, theme, DateTimeUtils.fromUserInput(meetingTime));
    }

    @Override
    public boolean deleteConference(String meeting_ID) {
        if (ConfigHelper.getInstance().getConferenceDAO().isCreator(meeting_ID, loginUser_ID)) {
            ConfigHelper.getInstance().getConferenceDAO().deleteConference(meeting_ID);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeConference(String meeting_ID) {
        return ConfigHelper.getInstance().getUserConferenceDAO().removeRecord(meeting_ID, loginUser_ID);
    }

    @Override
    public boolean signInMeeting(String meeting_ID) {
        return ConfigHelper.getInstance().getUserConferenceDAO().signInMeetingInDB(loginUser_ID, meeting_ID);
    }

    @Override
    public boolean updateUser(String name, String meetingName, String position, String password, String gender) {
        return ConfigHelper.getInstance().getUserDAO().updateUser(loginUser_ID, name, meetingName, position, gender, password);
    }


    @Override
    public boolean evaluateMeeting(String evaluation, String meeting_ID) {
        return ConfigHelper.getInstance().getUserConferenceDAO().writeEvaluation(evaluation, meeting_ID, loginUser_ID);
    }

    @Override
    public String getAvailableRoom_ID() {

        return ConfigHelper.getInstance().getRoomDAO().getAvailableRoom().getFirst();
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
