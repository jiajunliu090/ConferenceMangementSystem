package utilities;

import dao.*;
import dao.impl.*;
import model.User;

public class ConfigHelper {  // 单例模式
    private static ConfigHelper instance;
    private AdminDAO adminDAO = new AdminDAOImpl();
    private UserDAO userDAO = new UserDAOImpl();
    private ConferenceDAO conferenceDAO = new ConferenceDAOImpl();
    private RoomDAO roomDAO = new RoomDAOImpl();
    private UserConferenceDAO userConferenceDAO = new UserConferenceDAOImpl();
    private RoomConferenceDAO roomConferenceDAO = new RoomConferenceImpl();

    private ConfigHelper() {}

    public static ConfigHelper getInstance() {
        if (instance == null) {
            instance = new ConfigHelper();
        }
        return instance;
    }

    public AdminDAO getAdminDAO() {
        return adminDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public ConferenceDAO getConferenceDAO(){
        return conferenceDAO;
    }

    public RoomDAO getRoomDAO() {
        return roomDAO;
    }
    public RoomConferenceDAO getRoomConferenceDAO() {
        return roomConferenceDAO;
    }
    public UserConferenceDAO getUserConferenceDAO() {
        return userConferenceDAO;
    }
    public static void main(String[] args) {
        ConfigHelper.getInstance().getUserDAO().addUser(new User("user_ID", "n", "name"));
        ConfigHelper.getInstance().getUserDAO().isExist("user_ID");
        ConfigHelper.getInstance().getUserDAO().deleteUser("user_ID");

    }
}

