package utilities;

import dao.*;
import dao.impl.AdminDAOImpl;
import dao.impl.ConferenceDAOImpl;
import dao.impl.RoomDAOImpl;
import dao.impl.UserDAOImpl;

public class DependencyInjectionConfig {
    private AdminDAO adminDAO = new AdminDAOImpl();
    private UserDAO userDAO = new UserDAOImpl();
    private ConferenceDAO conferenceDAO = new ConferenceDAOImpl();
    private RoomDAO roomDAO = new RoomDAOImpl();

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
}
