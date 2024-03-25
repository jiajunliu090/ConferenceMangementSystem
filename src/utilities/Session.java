package utilities;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class Session {
    private static Session instance;
    private Map<String, User> loggedInUsers; // 保存已登录用户的信息

    private Session() {
        loggedInUsers = new HashMap<>();
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public void loginUser(String userID, User user) {
        loggedInUsers.put(userID, user); // 记录已登录用户的信息
    }

    public User getLoggedInUser(String userID) {
        return loggedInUsers.get(userID); // 获取已登录用户的信息
    }

}

