package model;

public class User {
    /**
     * user_ID, u_password, name, meetingName, position, gender
     */
    private String user_ID;
    private String u_password;
    private String name;
    private String meetingName;
    private String position;
    private String gender;

    public User(String user_ID, String u_password, String name, String meetingName, String position, String gender) {
        this.user_ID = user_ID;
        this.u_password = u_password;
        this.name = name;
        this.meetingName = meetingName;
        this.position = position;
        this.gender = gender;
    }

    public User(String user_ID, String u_password, String name) {
        this.user_ID = user_ID;
        this.u_password = u_password;
        this.name = name;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public String getU_password() {
        return u_password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("用户ID: ").append(this.user_ID).append(", 姓名: ").append(this.name)
                .append(", 职位: ").append(this.position).append("\n");
        return sb.toString();
    }
}
