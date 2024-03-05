package model;

import java.util.List;

public class ConferenceRoom {
    private String room_ID;
    private List<Conference> conferenceList;
    private boolean isOccupied;
    private boolean isOpen;

    public ConferenceRoom(String room_ID) {
        this.room_ID = room_ID;
    }

    public ConferenceRoom(String room_ID, boolean isOpen) {
        this.room_ID = room_ID;
        this.isOpen = isOpen;
    }

    public String getRoom_ID() {
        return room_ID;
    }

    public void setRoom_ID(String room_ID) {
        this.room_ID = room_ID;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public List<Conference> getConferenceList() {
        return conferenceList;
    }

    public void setConferenceList(List<Conference> conferenceList) {
        this.conferenceList = conferenceList;
    }
}
