package dao;

import model.Conference;
import model.ConferenceRoom;
import model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 对会议数据操作
 */
public interface ConferenceDAO {

    // 添加会议
    boolean addConference(Conference conferenceToAdd, String room_ID);
    // 删除会议
    boolean deleteConference(String meeting_ID);
    // 拿出一个会议的开始时间和参会人
    Map<LocalDateTime, List<User>> getMeetingInfo(String meeting_ID);
    List<Conference> getAllConferences();
    // 根据时间和参会人查会议
    List<String> getMeeting_ID(String time, String user_ID);
    // 根据会议ID查会议
    List<Conference> getConferenceByMeeting_ID(String meeting_ID);



}
