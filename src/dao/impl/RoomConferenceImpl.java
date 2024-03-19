package dao.impl;

import dao.RoomConferenceDAO;
import model.Conference;
import model.ConferenceRoom;
import utilities.DateTimeUtils;
import utilities.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;

public class RoomConferenceImpl implements RoomConferenceDAO {
    // 根据会议室查会议:得到会议所有信息

    /**
     * 会议所有信息:
     * 会议ID-meeting_ID-String;
     * 创建者ID-creator_ID-String;
     * 参会人员-participators-List<User>;
     * 会议时间-meetingTime-LocalDateTime;
     * 会议主题-theme-String;
     * 会议总结-summary-String;
     * @param room_ID
     * @return
     */
    @Override
    public List<Conference> getConferenceByRoomID(String room_ID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT ci.* \n" + // 查出所有的会议信息
                "FROM conference_info ci\n" +
                "INNER JOIN room_conference rc ON ci.meeting_ID = rc.meeting_ID\n" +
                "WHERE rc.room_ID = ?";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, room_ID);

        }catch (Exception e) {

        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
        return null;
    }

    @Override
    public boolean addMeetingToRoom(String meeting_ID, String room_ID, LocalDateTime meetingTime) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "INSERT INTO conference_management.room_conference(room_ID, meeting_ID, meetingTime) VALUES (?, ?, ?);";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, room_ID);
            preparedStatement.setString(2, meeting_ID);
            preparedStatement.setString(3, DateTimeUtils.toDbDateTime(meetingTime));
            int affectRow = preparedStatement.executeUpdate();
            System.out.println("关联会议和会议室：影响行数：" + affectRow);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
        return false;
    }

    public static void main(String[] args) {
        RoomConferenceDAO roomConferenceDAO = new RoomConferenceImpl();
        roomConferenceDAO.addMeetingToRoom("muggleee", "1111101H", DateTimeUtils.fromDbDateTime("2024-03-21 15:20:00"));
    }


}
