package dao.impl;

import dao.RoomDAO;
import model.ConferenceRoom;
import utilities.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    public RoomDAOImpl() {

    }
    

    @Override
    public ConferenceRoom getRoomByMeetingID(String meeting_ID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT ri.*\n" +
                "FROM room_info ri\n" +
                "INNER JOIN room_conference rc ON ri.room_ID = rc.room_ID\n" +
                "WHERE rc.meeting_ID = ?;";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, meeting_ID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new ConferenceRoom(resultSet.getString("room_ID")
                , resultSet.getString("isOpen"), resultSet.getString("isOccupied"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
        return null;
    }

    @Override
    public boolean addRoom(String room_ID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO conference_management.room_info(room_ID) VALUES (?);";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, room_ID);
            int affectRow = preparedStatement.executeUpdate();
            System.out.println("添加会议室：影响行数：" + affectRow);
            return affectRow == 1;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(preparedStatement, connection);
        }
        return false;
    }

    @Override
    public boolean deleteRoom(String room_ID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
        return false;
    }

    @Override
    public List<String> getAvailableRoom() {
        List<String> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT room_ID FROM conference_management.room_info WHERE isOpen = 'Yes' AND isOccupied = 'No';";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                res.add(resultSet.getString("room_ID"));
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
    public boolean isAvailable(String room_ID) { // 查看该房间是否可用
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT isOccupied, isOpen FROM conference_management.room_info WHERE room_ID = ?";

        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, room_ID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("isOccupied").equals("Yes") ||
                        resultSet.getString("isOpen").equals("No")) {
                    return false;
                }
            }
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(resultSet, preparedStatement, connection);
        }
        return false;
    }

    public static void main(String[] args) {
        RoomDAO roomDAO = new RoomDAOImpl();
        System.out.println(roomDAO.isAvailable("1111101H"));
        System.out.println(roomDAO.getAvailableRoom());

    }
}
