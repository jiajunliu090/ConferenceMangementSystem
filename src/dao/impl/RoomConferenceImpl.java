package dao.impl;

import dao.RoomConferenceDAO;
import model.Conference;
import utilities.ConfigHelper;
import utilities.DateTimeUtils;
import utilities.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
            ConfigHelper.getInstance().getRoomDAO().occupyRoom(room_ID);
            int affectRow = preparedStatement.executeUpdate();
            System.out.println("关联会议和会议室：影响行数：" + affectRow);
            return affectRow == 1;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
        return false;
    }



    @Override
    public List<String> getRoom_IDByMeeting_ID(List<String> meeting_IDs) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<String> room_IDs = new ArrayList<>();
        String sql = "SELECT room_ID FROM conference_management.room_conference WHERE meeting_ID = ?";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            for (String meeting_ID : meeting_IDs) {
                // 在每次循环迭代时，设置预处理语句的参数值为当前迭代的meeting_ID
                preparedStatement.setString(1, meeting_ID);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    room_IDs.add(resultSet.getString("room_ID"));
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
        return room_IDs;
    }

    @Override
    public String getRoom_IDByMeeting_ID(String meeting_ID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT room_ID FROM conference_management.room_conference WHERE meeting_ID = ?";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, meeting_ID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getString("room_ID");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
        return null;
    }

    @Override
    public boolean removeMeetingFromRoom(String meeting_ID, String room_ID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM conference_management.room_conference WHERE room_ID = ? AND meeting_ID = ?";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, room_ID);
            preparedStatement.setString(2, meeting_ID);
            int affectRow = preparedStatement.executeUpdate();
            System.out.println("移除会议-会议室记录：影响行数：" + affectRow);
            ConfigHelper.getInstance().getRoomDAO().unoccupiedRoom(room_ID);
            return affectRow == 1;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(preparedStatement, connection);
        }
        return false;
    }


}
