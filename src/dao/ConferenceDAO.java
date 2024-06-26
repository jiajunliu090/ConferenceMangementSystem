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
    // 根据时间和参会人查会议
    List<String> getMeeting_ID(String user_ID);
    // 根据会议ID查会议
    Conference newConferenceByMeeting_ID(String meeting_ID);
    // 更新会议信息
    boolean updateConference(String meeting_ID, String user_ID, String theme, LocalDateTime meetingTime); // 在这里改主题和会议时间
    // 验证是否是创建者
    boolean isCreator(String meeting_ID, String user_ID);
}
