package dao;

import model.ConferenceRoom;

import java.util.List;

public interface RoomDAO {

    // 根据会议获得会议室
    ConferenceRoom getRoomByMeetingID(String meeting_ID);
    // 添加会议室
    boolean addRoom(String room_ID);
    // 删除会议室
    boolean deleteRoom(String room_ID);
    // 搜索空闲的房间
    List<String> getAvailableRoom();

    // 查看会议室是否被占用
    boolean isAvailable(String room_ID);
    //
    boolean openRoom(String room_ID);
    boolean closeRoom(String room_ID);

}
