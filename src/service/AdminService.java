package service;

import model.Conference;
import model.User;

import java.util.List;

public interface AdminService {
    /**
     * 管理用户：添加；删除；
     * @return
     */
    List<User> getAllUsers();

    /**
     * 管理会议：查看；添加；删除；
     * @return
     */
    List<Conference> getConferenceByUser(String user_ID);

    /**
     * 管理会议室
     */
    // 添加会议室
    boolean addConferenceRoom(String room_ID);
    // 开启会议室
    boolean openRoom(String room_ID);
    // 关闭会议室
    boolean closeRoom(String room_ID);

    /**
     * 反馈和数据统计
     * 数据统计：会议数量；参加人员数量；会议时间；签到时间
     */
    // 反馈给数据库





}
