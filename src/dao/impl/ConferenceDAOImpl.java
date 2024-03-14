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

    public ConferenceDAOImpl() { // 拿到所有会议信息

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
            int affectRow = preparedStatement.executeUpdate();
            System.out.println("创建会议：影响行数：" + affectRow);
            // 调用RoomConferenceDAO
            // 将会议加入到会议室中
            ConfigHelper.getInstance().getRoomConferenceDAO().addMeetingToRoom(conferenceToAdd.getMeeting_ID(), room_ID,
                    conferenceToAdd.getMeetingTime());
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

    //@Override
    //public Map<LocalDateTime, List<User>> getMeetingInfo(String meeting_ID) {
    //    return null;
    //}

    @Override
    public List<String> getMeeting_ID(String user_ID) { // 根据参会人查找会议
        List<String> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT meeting_ID FROM conference_management.user_conference WHERE user_ID = ?";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user_ID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                res.add(resultSet.getString("meeting_ID"));
            }
            return res;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
        return res;
    }

    @Override
    public Conference newConferenceByMeeting_ID(String meeting_ID) {
        return ConfigHelper.getInstance().getUserConferenceDAO().getConferenceByMeeting_ID(meeting_ID);
    }

    @Override
    public boolean updateConference(String meeting_ID, String user_ID, String theme, LocalDateTime meetingTime) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM conference_management.conference_info WHERE creator_ID = ? AND meeting_ID = ?";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user_ID);
            preparedStatement.setString(2, meeting_ID);
            resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    updateHelper(meeting_ID, theme, meetingTime);
                    return true;
                }
            }else return false;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isCreator(String meeting_ID, String user_ID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT meeting_ID FROM conference_management.conference_info";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("creator_ID").equals(user_ID)) {
                    return true;
                }
            }
            return false;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
        return false;
    }

    private void updateHelper(String meeting_ID, String theme, LocalDateTime meetingTime) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE conference_management.conference_info SET theme = ? AND meetingTime = ? WHERE meeting_ID = ?";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, theme);
            preparedStatement.setString(2, DateTimeUtils.toDbDateTime(meetingTime));
            preparedStatement.setString(3, meeting_ID);
            int affectRow = preparedStatement.executeUpdate();
            System.out.println("更新会议：影响的行数：" + affectRow);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(preparedStatement, connection);
        }
    }

    public static void main(String[] args) {
        //ConfigHelper.getInstance().getConferenceDAO().deleteConference("jj_12345"); ✔️

    }

}
