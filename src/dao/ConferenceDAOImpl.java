package dao;

import model.Conference;
import model.ConferenceRoom;

import java.util.List;

/**
 * 对会议数据操作
 */
interface ConferenceDAO {
    // 添加会议
    boolean addConference(Conference conferenceToAdd);
    // 删除会议
    boolean deleteConference(String meeting_ID);
    List<Conference> getAllConferences();
    // 根据会议室查会议
    List<Conference> getConferenceByRoomID(ConferenceRoom conferenceRoom);


}
public class ConferenceDAOImpl implements ConferenceDAO{
    private List<Conference> conferences;

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
