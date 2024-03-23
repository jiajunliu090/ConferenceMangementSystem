package dao;

import model.Conference;
import model.ConferenceRoom;

import java.time.LocalDateTime;
import java.util.List;

public interface RoomConferenceDAO {
    // 根据会议室查会议:得到会议所有信息
    List<Conference> getConferenceByRoomID(String room_ID);
    // 将会议加入到会议室中
    boolean addMeetingToRoom(String meeting_ID, String room_ID, LocalDateTime meetingTime);
    // 通过会议ID查会议室
    List<String> getRoom_IDByMeeting_ID(List<String> meeting_IDs);
}
