package dao.impl;

import dao.ConferenceDAO;
import model.Conference;
import model.ConferenceRoom;
import model.User;
import utilities.ConfigHelper;
import utilities.DateTimeUtils;
import utilities.JDBCUtil;

import javax.print.attribute.standard.MediaSize;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//✔️

public class ConferenceDAOImpl implements ConferenceDAO {
    private List<Conference> conferences;

    public ConferenceDAOImpl() {

    }

    @Override
    public boolean addConference(Conference conferenceToAdd, String room_ID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "INSERT INTO conference_management.conference_info(meeting_ID, summary, theme, meetingTime, creator_ID) VALUES(?, ?, ?, ?, ?)";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, conferenceToAdd.getMeeting_ID());
            preparedStatement.setString(2, conferenceToAdd.getSummary());
            preparedStatement.setString(3, conferenceToAdd.getTheme());
            preparedStatement.setString(4, DateTimeUtils.toDbDateTime(conferenceToAdd.getMeetingTime()));
            preparedStatement.setString(5, conferenceToAdd.getCreator_ID());
            preparedStatement.executeUpdate();
            // 调用RoomConferenceDAO
            //// 将会议加入到会议室中
            //ConfigHelper.getInstance().getRoomConferenceDAO().addMeetingToRoom();
            System.out.println("会议创建完成");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
        return false;
    }

    @Override
    public boolean deleteConference(String meeting_ID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM conference_management.conference_info WHERE meeting_ID = ?";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, meeting_ID);
            int affectRow = preparedStatement.executeUpdate();
            System.out.println("删除会议：影响的行数：" + affectRow);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(preparedStatement, connection);
        }
        return false;
    }

    @Override
    public Map<LocalDateTime, List<User>> getMeetingInfo(String meeting_ID) {
        return null;
    }

    @Override
    public List<Conference> getAllConferences() {
        return conferences;
    }

    @Override
    public List<String> getMeeting_ID(String time, String user_ID) {
        return null;
    }

    @Override
    public List<Conference> getConferenceByMeeting_ID(String meeting_ID) {

        return null;
    }

    public static void main(String[] args) {
        //ConfigHelper.getInstance().getConferenceDAO().deleteConference("jj_12345"); ✔️

    }

}
