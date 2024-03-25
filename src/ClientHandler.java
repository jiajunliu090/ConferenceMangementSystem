import service.impl.AdminServiceImpl;
import service.impl.UserServiceImpl;
import utilities.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                // 读取客户端发送的请求类型
                String requestType = in.readLine();
                System.out.println("客户端请求：>>>>> " + requestType);
                if (requestType == null) {
                    // 客户端断开连接
                    break;
                }
                // 根据请求类型处理请求
                switch (requestType) {
                    case "AdminLogin":
                        handleAdminLogin();
                        break;
                    case "UserLogin":
                        handleUserLogin();
                        break;
                    case "getLoginUser_name":
                        handleGetUser_name();
                        break;
                    case "getLoginUser_meetingName":
                        handleGetUser_meetingName();
                        break;
                    case "getLoginUser_position":
                        handleGetUser_position();
                        break;
                    default:
                        System.out.println("服务端等待请求 <<<<<");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleAdminLogin() throws IOException {
        // 读取客户端发送的登录信息
        String userID = in.readLine();
        String password = in.readLine();

        // 管理员验证
        boolean loginResult = AdminServiceImpl.getInstance().login(userID, password);
        // 发送登录结果给客户端
        if (loginResult) {
            out.println("LoginSuccess"); // 登录成功
        } else {
            out.println("LoginFailed"); // 登录失败
        }
    }

    private void handleUserLogin() throws IOException {
        // 读取客户端发送的登录信息
        String userID = in.readLine();
        String password = in.readLine();

        // 用户验证
        boolean loginResult = UserServiceImpl.getInstance().loginUser(userID, password);
        // 发送登录结果给客户端
        if (loginResult) {
            out.println("LoginSuccess"); // 登录成功
        } else {
            out.println("LoginFailed"); // 登录失败
        }
    }
    private void handleGetUser_name() throws IOException {
        String user_ID = in.readLine();
        String name = Session.getInstance().getLoggedInUser(user_ID).getName();

        out.println("ReturnUserName");
        out.println(name);
        out.flush();
        System.out.println("发送用户姓名：" + name);
    }
    private void handleGetUser_meetingName() throws IOException {
        // 读取返回的用户id然后给信息
        String user_ID = in.readLine();
        String meeting_name = Session.getInstance().getLoggedInUser(user_ID).getMeetingName();
        out.println("ReturnUserMeetingName");
        out.println(meeting_name);
        out.flush();
        System.out.println("发送会议呢称：" + meeting_name);
    }
    private void handleGetUser_position() throws IOException {
        String user_ID = in.readLine();
        String position = Session.getInstance().getLoggedInUser(user_ID).getPosition();
        out.println("ReturnUser_position");
        out.println(position);
        out.flush();
        System.out.println("发送职位：" + position);
    }

}
