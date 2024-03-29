import model.Captcha;
import service.UserService;
import service.impl.AdminServiceImpl;
import service.impl.UserServiceImpl;
import utilities.*;

import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

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
                    case "registerUser":
                        handleRegisterUser();
                        break;
                    case "getLoginUser_name":
                        handleGetUser_name();
                        break;
                    case "getLoginUser_meetingName":
                        handleGetUser_meetingName();
                        break;
                    case "getLoginUser_position":
                        handleGetUser_position(); // 获取用户职位信息
                        break;
                    case "getComingMeetingTable":
                        handleGetComingMeetingTable(); // 获取会议表格1
                        break;
                    case "getConferInfoTable":
                        handleGetConferInfoTable(); // 获取会议表格2
                        break;
                    case "createConference":
                        handleCreateConference(); // 创建会议
                        break;
                    case "getSignInInfo":
                        handleGetCodeImage(); // 发送图片和验证码
                        break;
                    case "signInMeeting":
                        handleSignInMeeting();
                        // 刷新表格
                        break;
                    case "removeFromMeeting":
                        handleRemoveFromMeeting();
                        // 刷新表格
                        break;
                    case "getAvailableRoom":
                        handleGetAvailableRoom();
                        break;
                    case "changeConferenceInfo":
                        handleChangeConferenceInfo();
                        break;
                    case "submitComment":
                        handleSubmitComment();
                        break;
                    case "logOutUser":
                        logOutUser(); // id, pass, ensure
                        break;
                    default:
                        System.out.println("未知请求 <<< 服务端等待请求 <<<<<");
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
    private void handleRegisterUser() throws IOException {
        String user_ID = in.readLine();
        String password = in.readLine();
        String name = in.readLine();
        if (UserServiceImpl.getInstance().registerUser(user_ID, password, name)) {
            out.println("registerSuccess");
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

    private void handleGetComingMeetingTable() throws IOException {
        System.out.println("正在发送表格数据...");
        String user_ID = in.readLine();
        TableModel tableModel = new DefaultTableModel();
        // 将表格数据发送给客户端
        tableModel = TableGenerator.generateComingMeetingTable(user_ID);
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(tableModel);
        outputStream.flush();
    }

    private void handleGetConferInfoTable() throws IOException { // 表格2
        System.out.println("表格2信息...");
        String user_ID = in.readLine();
        TableModel tableModel = new DefaultTableModel();
        tableModel = TableGenerator.generateMeetingInfoTable(user_ID);

        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream()); // 输出表格信息
        outputStream.writeObject(tableModel);
        outputStream.flush();
    }

    private void handleCreateConference() throws IOException {
        String meeting_ID = in.readLine();
        String participants = in.readLine();
        String meeting_time = in.readLine();
        String user_ID = in.readLine();
        String first_room = ConfigHelper.getInstance().getRoomDAO().getAvailableRoom().getFirst(); // 获取空闲的会议室
        List<String> participants_name = Arrays.stream(participants.split(",")).toList();
        if (UserServiceImpl.getInstance().createConference( // 创建会议
                meeting_ID, first_room, participants_name, DateTimeUtils.fromUserInput(meeting_time)
        )) {
            // 成功传信息
            out.println("CreateConferenceSuccess");
            out.println(first_room);
            out.flush();
            handleResetTable(user_ID);
        }
    }

    private void handleResetTable(String user_ID) throws IOException {
        resetTable1(user_ID);
        resetTable2(user_ID);
    }

    private void resetTable1(String user_ID) throws IOException {
        TableModel tableModel = TableGenerator.generateComingMeetingTable(user_ID);
        System.out.println("刷新表格1...");
        try (ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {
            outputStream.writeObject(tableModel);
            outputStream.flush();
        }
    }

    private void resetTable2(String user_ID) throws IOException {
        TableModel tableModel = TableGenerator.generateMeetingInfoTable(user_ID);
        System.out.println("刷新表格2...");
        try (ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {
            outputStream.writeObject(tableModel);
            outputStream.flush();
        }
    }
    private void handleGetCodeImage() throws IOException {
        Captcha captcha = CaptchaGenerator.generateCaptcha();
        BufferedImage image = captcha.getImage();
        String code = captcha.getCode();
        System.out.println("验证码：" + code);
        // 将图像转换为字节数组
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        baos.flush();
        byte[] imageData = baos.toByteArray();

        // 发送字节数组到客户端
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(imageData); // 发送验证码图片
        out.println(code); // 发送验证码
        outputStream.flush();
    }

    private void handleSignInMeeting() throws IOException {
        String meeting_ID = in.readLine();
        if (UserServiceImpl.getInstance().signInMeeting(meeting_ID)) {
            out.println("signInSuccess");
        }else {
            out.println("signInFail");
        }
        out.flush();
    }
    private void handleRemoveFromMeeting() throws IOException {
        String meeting_ID = in.readLine();
        boolean b = UserServiceImpl.getInstance().removeConference(meeting_ID);
        if (b) {
            out.println("removeSuccess");
        }else out.println("removeFail");
        out.flush();
    }
    private void handleGetAvailableRoom() throws IOException {
        String meeting_ID = in.readLine();
        List<String> availableRoom = ConfigHelper.getInstance().getRoomDAO().getAvailableRoom();
        String roomIdByMeetingId = ConfigHelper.getInstance().getRoomConferenceDAO().getRoom_IDByMeeting_ID(meeting_ID);
        availableRoom.add(roomIdByMeetingId);
        out.println(availableRoom.size());
        for (String s : availableRoom) {
            out.println(s);
        }
        out.flush();
    }

    private void handleChangeConferenceInfo() throws IOException {
        String meeting_id = in.readLine(); // 二次
        String theme = in.readLine(); // 三次
        String time = in.readLine(); // 四次
        String add = in.readLine(); // 五次
        String remove = in.readLine(); // 六次
        String room_ID = in.readLine(); // 七次
        String roomIdByMeetingId = ConfigHelper.getInstance().getRoomConferenceDAO().getRoom_IDByMeeting_ID(meeting_id);
        if (UserServiceImpl.getInstance().updateConference(meeting_id, theme, time)
                && ConfigHelper.getInstance().getRoomConferenceDAO().removeMeetingFromRoom(meeting_id, roomIdByMeetingId)
                && ConfigHelper.getInstance().getRoomConferenceDAO().addMeetingToRoom(meeting_id, room_ID, DateTimeUtils.fromUserInput(time))) {
            out.println("changeConferenceInfoSuccess"); // 一次
            handleRemoveRecord(meeting_id, remove);
            handleAddParticipants(meeting_id, add);
        }

    }

    private void handleRemoveRecord(String meeting_ID, String targets) throws IOException { // 移除参会人
        List<String> target = Arrays.stream(targets.split(",")).toList(); // 目标姓名
        if (target == null || target.size() == 0) {
            return;
        }
        if (UserServiceImpl.getInstance().removeConferenceByIDs(target, meeting_ID)) {
            out.println("removeParticipantsSuccess"); // 两次
        }
    }

    private void handleAddParticipants(String meeting_ID, String targets) throws IOException { // 添加参会人
        List<String> target = Arrays.stream(targets.split(",")).toList(); // 目标姓名
        if (target == null || target.size() == 0) {
            return;
        }
        if (UserServiceImpl.getInstance().addUserToConference(target, meeting_ID)) {
            out.println("addParticipantsSuccess"); // 三次
        }
    }
    private void handleSubmitComment() throws IOException {
        String meeting_ID = in.readLine();
        String comment = in.readLine();
        if (UserServiceImpl.getInstance().evaluateMeeting(comment, meeting_ID)) {
            out.println("submitCommentSuccess");
        }
    }

    private void logOutUser() throws IOException {
        String user_id = in.readLine();
        String ensure = in.readLine();
        if (UserServiceImpl.getInstance().deleteUser(user_id, ensure)) {
            out.println("logOutSuccess");
            out.flush();
        }
    }
}
