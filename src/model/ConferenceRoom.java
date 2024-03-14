package model;

public class ConferenceRoom {
    private String room_ID;
    private String isOccupied;
    private String isOpen;

    public ConferenceRoom(String room_ID, String isOpen, String isOccupied) {
        this.room_ID = room_ID;
        this.isOpen = isOpen;
        this.isOccupied = isOccupied;
    }

    public ConferenceRoom(String room_ID) {
        this.room_ID = room_ID;
    }

    public String getRoom_ID() {
        return room_ID;
    }

    public void setRoom_ID(String room_ID) {
        this.room_ID = room_ID;
    }

    public String getIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(String isOccupied) {
        this.isOccupied = isOccupied;
    }

    public String getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen;
    }

    @Override
    public String toString() {
        return "会议室ID--" + this.room_ID;
    }
}
