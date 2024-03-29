package dao.impl;

import dao.UserConferenceDAO;
import model.Conference;
import model.User;
import utilities.ConfigHelper;
import utilities.DateTimeUtils;
import utilities.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserConferenceDAOImpl implements UserConferenceDAO {
    // 根据用户ID查所有该用户需要参加的会议
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

    @Override
    public List<Conference> getConferencesByUser_ID(String user_ID) {
        // first step: 根据用户ID拿到所有的会议ID
        List<String> meeting_IDs = getMeeting_IDByUser_ID(user_ID);
        // second step: 根据会议ID创建一个会议实体
        List<Conference> conferences = new ArrayList<>();
        for (String meeting_ID : meeting_IDs) {
            Conference conferenceByMeetingId = getConferenceByMeeting_ID(meeting_ID);
            conferences.add(conferenceByMeetingId);
        }
        return conferences;
    }
    private List<String> getMeeting_IDByUser_ID(String user_ID) {
        List<String> res = new ArrayList<>();
        // 拿下实例搜索会议数据
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT meeting_ID FROM conference_management.user_conference WHERE user_ID = ?;";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user_ID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                res.add(resultSet.getString("meeting_ID"));
            }
            if (res == null || res.size() == 0) {
                System.out.println("无需参加会议");
            }
            System.out.println("用户：" + user_ID +  ", 需参加会议：" + res);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
        return res;
    }
    // 根据会议ID拿到所有参会人ID
    @Override
    public List<String> getParticipatorsByMeeting_ID(String meeting_ID) {
        List<String> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT user_ID FROM conference_management.user_conference WHERE meeting_ID = ?;";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, meeting_ID);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                System.out.println("无参会人员");
                return null;
            }
            while (resultSet.next()) {
                res.add(resultSet.getString("user_ID"));
            }
            System.out.println("会议ID：" + meeting_ID + ", 参会人员有：" + res);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
        return res;
    }

    @Override
    public Conference getConferenceByMeeting_ID(String meeting_ID) { // 通过会议ID创建一个会议实例
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM conference_management.conference_info WHERE meeting_ID = ?;";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, meeting_ID);
            resultSet = preparedStatement.executeQuery();
            String creatorId = null;
            LocalDateTime meetingTime = null;
            String summary = null;
            String theme = null;
            while (resultSet.next()) {
                // 得到会议除参会人员的信息
                creatorId = resultSet.getString("creator_ID");
                String DB_meetingTime = resultSet.getString("meetingTime");
                meetingTime = DateTimeUtils.fromDbDateTime(DB_meetingTime);
                summary = resultSet.getString("summary");
                theme = resultSet.getString("theme");
            }
            // 从用户数据操作类new出用户
            List<String> participators_ID = getParticipatorsByMeeting_ID(meeting_ID);
            List<User> participators = new ArrayList<>();
            for (String user_ID : participators_ID) {
                User user = ConfigHelper.getInstance().getUserDAO().newUserByDB_User_ID(user_ID);
                participators.add(user);
            }
            // 根据获得的数据new一个会议
            return new Conference(meeting_ID, creatorId, participators, meetingTime, theme, summary);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
        return null;
    }

    @Override
    public boolean signInMeetingInDB(String user_ID, String meeting_ID) {  //✔️
        LocalDateTime signInTime = LocalDateTime.now();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "UPDATE conference_management.user_conference " +
                "SET isSignIn = ?, signInTime = ? WHERE user_ID = ? AND meeting_ID = ?;";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "已签到");
            preparedStatement.setString(2, DateTimeUtils.toDbDateTime(signInTime));
            preparedStatement.setString(3, user_ID);
            preparedStatement.setString(4, meeting_ID);
            int affectRow = preparedStatement.executeUpdate();
            System.out.println("用户ID：" + user_ID + "，签到会议：" + meeting_ID + "，签到时间：" + DateTimeUtils.toUserInput(signInTime));
            return affectRow == 1;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
        return false;
    }

    @Override
    public boolean removeRecord(String meeting_ID, String user_ID) {  //✔️
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM conference_management.user_conference WHERE user_ID = ? AND meeting_ID = ?";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user_ID);
            preparedStatement.setString(2, meeting_ID);
            int affectRow = preparedStatement.executeUpdate();
            System.out.println("删除会议参加者：影响行数：" + affectRow);
            return affectRow == 1;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(preparedStatement, connection);
        }
        return false;
    }

    @Override
    public boolean removeRecord(String meeting_ID, List<String> user_IDs) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM conference_management.user_conference WHERE user_ID = ? AND meeting_ID = ?";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            // 开始批处理
            for (String user_ID : user_IDs) {
                preparedStatement.setString(1, user_ID);
                preparedStatement.setString(2, meeting_ID);
                preparedStatement.addBatch();
            }

            // 执行批处理
            int[] affectedRows = preparedStatement.executeBatch();

            // 打印受影响的行数
            for (int rows : affectedRows) {
                System.out.println("删除会议参加者：影响行数：" + rows);
            }

            // 判断是否删除成功
            for (int rows : affectedRows) {
                if (rows != 1) {
                    return false; // 如果有任何一条记录删除失败，则返回false
                }
            }
            return true; // 所有记录都成功删除
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(preparedStatement, connection);
        }
        return false;
    }


    @Override
    public List<User> getUsersByMeeting_ID(String meeting_ID) {
        List<String> participatorsByMeetingId = getParticipatorsByMeeting_ID(meeting_ID);
        List<User> users = new ArrayList<>();
        for (String s : participatorsByMeetingId) {
            users.add(ConfigHelper.getInstance().getUserDAO().newUserByDB_User_ID(s));
        }
        return users;
    }

    @Override
    public boolean writeEvaluation(String evaluation, String meeting_ID, String user_ID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE conference_management.user_conference SET evaluation = ? WHERE meeting_ID = ? AND user_ID = ?";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, evaluation);
            preparedStatement.setString(2, meeting_ID);
            preparedStatement.setString(3, user_ID);
            int affectRow = preparedStatement.executeUpdate();
            System.out.println("纂写评论：影响行数：" + affectRow);
            return affectRow == 1;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(preparedStatement, connection);
        }
        return false;
    }

    @Override
    public boolean connectUserAndConference(List<String> user_IDs, String meeting_ID) {
        System.out.println("关联用户和会议");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO conference_management.user_conference (user_ID, meeting_ID) VALUES (?, ?);";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            // 开始批处理
            for (String user_ID : user_IDs) {
                preparedStatement.setString(1, user_ID);
                preparedStatement.setString(2, meeting_ID);
                preparedStatement.addBatch();
            }

            // 执行批处理
            int[] affectedRows = preparedStatement.executeBatch();

            // 输出影响行数
            for (int i = 0; i < affectedRows.length; i++) {
                System.out.println("用户: " + user_IDs.get(i) + ", 参加会议: " + meeting_ID + "\n"
                        + "影响行数：" + affectedRows[i]);
            }

            // 检查是否所有行都受影响
            for (int affectedRow : affectedRows) {
                if (affectedRow != 1) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(preparedStatement, connection);
        }
        return false;
    }


    public static void main(String[] args) {
        //System.out.println(ConfigHelper.getInstance().getUserConferenceDAO().getConferencesByUser_ID("test0001"));
        System.out.println(ConfigHelper.getInstance().getUserConferenceDAO().signInMeetingInDB("test0002", "muggleee"));
        //System.out.println(ConfigHelper.getInstance().getUserConferenceDAO().removeRecord("muggleee", "test0001"));
    }
}
