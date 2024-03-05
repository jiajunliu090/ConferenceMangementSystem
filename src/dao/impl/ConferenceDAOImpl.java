package dao.impl;

import dao.ConferenceDAO;
import model.Conference;
import model.ConferenceRoom;

import java.util.List;

public class ConferenceDAOImpl implements ConferenceDAO {
    private List<Conference> conferences;
    public ConferenceDAOImpl() {

    }

    @Override
    public boolean addConference(Conference conferenceToAdd) {
        return false;
    }

    @Override
    public boolean deleteConference(String meeting_ID) {
        return false;
    }

    @Override
    public List<Conference> getAllConferences() {
        return conferences;
    }

    @Override
    public List<Conference> getConferenceByRoomID(ConferenceRoom conferenceRoom) {
        return null;
    }
}
