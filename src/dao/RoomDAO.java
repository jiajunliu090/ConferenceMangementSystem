package dao;

import model.ConferenceRoom;

import java.util.List;

public interface RoomDAO {
    // 获得所有会议室
    List<ConferenceRoom> getAllRooms();
    // 根据会议获得会议室
    ConferenceRoom getRoomByMeetingID();
    // 添加会议室
    boolean addRoom(String room_ID);
    // 删除会议室
    boolean deleteRoom(String room_ID);
    // 搜索空闲的房间
    List<String> getOpenRoom();

}
