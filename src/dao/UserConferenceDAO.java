package dao;

import model.Conference;
import model.User;

import java.util.List;

public interface UserConferenceDAO {
    /**
     * 会议所有信息:
     * 会议ID-meeting_ID-String;
     * 创建者ID-creator_ID-String;
     * 参会人员-participators-List<User>;
     * 会议时间-meetingTime-LocalDateTime;
     * 会议主题-theme-String;
     * 会议总结-summary-String;
     * @param user_ID
     * @return
     */
    // 根据用户ID查所有该用户需要参加的会议
    List<Conference> getConferencesByUser_ID(String user_ID);
    // 根据会议ID查到会议的参加人员ID
    List<String> getParticipatorsByMeeting_ID(String meeting_ID);
    // 一个会议ID创建一个会议实体
    Conference getConferenceByMeeting_ID(String meeting_ID);
    // 签到
    boolean signInMeetingInDB(String user_ID, String meeting_ID);
    // 删除会议中参会人员
    boolean removeRecord(String meeting_ID, String user_ID);
    List<User> getUsersByMeeting_ID(String meeting_ID);
}
