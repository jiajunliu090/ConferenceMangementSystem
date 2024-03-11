package service;

import model.Conference;
import model.User;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户操作接口
 */
public interface UserService {
    // 注册
    boolean registerUser(String user_ID, String u_password, String name);
    // 登录
    boolean loginUser(String user_ID, String u_password);
    String getLoginUser_ID();
    // 注销
    boolean deleteUser(String user_ID, String u_password, String ensure);
    // 查看自己需要参加的会议
    List<Conference> meetingsToAttend();
    // 创建会议
    boolean createConference(String meeting_ID, String room_ID , List<User> participators, LocalDateTime meetingTime, String theme);
    // 修改会议
    boolean updateConference(); // 先进行验证
    // 删除会议
    boolean deleteConference(String meeting_ID);
    // 会议签到
    boolean signInMeeting(String meeting_ID);
    // 修改信息
    boolean updateUser(User userTouUpdate);
    // 评价会议
    String evaluateMeeting(String evaluation);

}
