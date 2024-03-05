package model;

import java.time.LocalDateTime;
import java.util.List;

public class Conference {
    /**
     * meeting_ID, creator_ID, participators, meetingTime, theme, summary
     */
    private String meeting_ID;
    private String creator_ID;
    private List<User> participators;
    private LocalDateTime meetingTime;
    private String theme;
    private String summary;

    public Conference(String meeting_ID, String creator_ID, List<User> participators, LocalDateTime meetingTime, String theme) {
        this.meeting_ID = meeting_ID;
        this.creator_ID = creator_ID;
        this.participators = participators;
        this.meetingTime = meetingTime;
        this.theme = theme;
    }

    public Conference(String meeting_ID, String creator_ID, List<User> participators, LocalDateTime meetingTime) {
        this.meeting_ID = meeting_ID;
        this.creator_ID = creator_ID;
        this.participators = participators;
        this.meetingTime = meetingTime;
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

}
