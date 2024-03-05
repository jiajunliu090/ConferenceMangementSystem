package dao;

import model.ConferenceRoom;

import java.util.List;

public class RoomDAOImpl implements RoomDAO{
    List<ConferenceRoom> conferenceRooms;
    public RoomDAOImpl() {

    }
    @Override
    public List<ConferenceRoom> getAllRooms() {
        return conferenceRooms;
    }

    @Override
    public ConferenceRoom getRoomByMeetingID() {
        return null;
    }

    @Override
    public boolean addRoom(String room_ID) {
        return false;
    }

    @Override
    public boolean deleteRoom(String room_ID) {
        return false;
    }
}
