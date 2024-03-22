package model;

import utilities.DateTimeUtils;

import java.time.LocalDateTime;
import java.util.List;

public class Conference {
    /**
     * meeting_ID, creator_ID, participators, meetingTime, theme, summary
     */
    private String meeting_ID; // 在数据库中
    private String creator_ID; // 在数据库中
    private List<User> participators; // 不在info里
    private LocalDateTime meetingTime; // 在数据库中
    private String theme; // 在数据库中
    private String summary; // 在数据库中
    // 前两种用于创建者创建
    public Conference(String meeting_ID, String creator_ID, List<User> participators, LocalDateTime meetingTime) {
        this.meeting_ID = meeting_ID;
        this.creator_ID = creator_ID;
        this.participators = participators;
        this.meetingTime = meetingTime;
    }
    public Conference(String meeting_ID, String creator_ID, List<User> participators, LocalDateTime meetingTime, String theme) {
        this.meeting_ID = meeting_ID;
        this.creator_ID = creator_ID;
        this.participators = participators;
        this.meetingTime = meetingTime;
        this.theme = theme;
    }

    // 用于从数据库创建会议实例
    public Conference(String meeting_ID, String creator_ID, List<User> participators, LocalDateTime meetingTime, String theme, String summary) {
        this.meeting_ID = meeting_ID;
        this.creator_ID = creator_ID;
        this.participators = participators;
        this.meetingTime = meetingTime;
        this.theme = theme;
        this.summary = summary;
    }


    public String getMeeting_ID() {
        return meeting_ID;
    }

    public void setMeeting_ID(String meeting_ID) {
        this.meeting_ID = meeting_ID;
    }

    public String getCreator_ID() {
        return creator_ID;
    }

    public void setCreator_ID(String creator_ID) {
        this.creator_ID = creator_ID;
    }

    public List<User> getParticipators() {
        return participators;
    }

    public void setParticipators(List<User> participators) {
        this.participators = participators;
    }

    public LocalDateTime getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(LocalDateTime meetingTime) {
        this.meetingTime = meetingTime;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "会议ID：" + this.meeting_ID + "，会议时间：" + DateTimeUtils.toUserInput(meetingTime) + "，会议主题：" + this.theme + "，会议创建者：" + this.creator_ID;
    }
}
