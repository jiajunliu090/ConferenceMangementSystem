package view.user;

import service.UserService;
import service.impl.UserServiceImpl;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class UserUI extends JFrame {
    UserService userService;
    private JTabbedPane tabbedPane1;
    private JPanel StartPanel;
    private JPanel panel3;
    private JLabel nameLabel;
    private JLabel meetingNameLabel;
    private JLabel positionLabel;
    private JLabel nameLabel2;
    private JLabel meetingNameLabel2;
    private JLabel positionLabel2;
    private JLabel timeLabel;
    private JLabel TimeLabel2;
    private JTextField searchField;
    private JLabel searchIcon;
    private JLabel searchLabel;
    private JPanel panel4;
    private JLabel conferenceLabel;
    private JScrollPane scrollPane1;
    private JTable conferenceTable;
    private JLabel startUser_IDLabel;
    private JLabel startUser_IDLabel2;
    private JPanel CMPanel;
    private JPanel panel5;
    private JLabel createMeetingLabel;
    private JTextField meeting_IDField;
    private JLabel meeting_IDLabel;
    private JLabel participantsLabel;
    private JLabel meetingTimeLabel;
    private JTextField participantsField;
    private JTextField meetingTimeField;
    private JButton createMeetingButton;
    private JPanel panel6;
    private JScrollPane scrollPane2;
    private JTable conferenceTable2;
    private JLabel conferenceLabel2;
    private JButton signInButton;
    private JButton removeButton;
    private JButton updateMeetingButton;
    private JPanel User_infoPanel;
    private JPanel userInfoPanel;
    private JLabel titleLabel;
    private JLabel infoNameLabel;
    private JLabel infoMeeingNameLabel;
    private JLabel infoPositionLabel;
    private JLabel user_IDLabel;
    private JLabel infoPasswordLabel;
    private JTextField infoNameField;
    private JTextField infoMeetingNameField;
    private JTextField infoPositionField;
    private JTextField infoPasswordField;
    private JLabel user_IDLabel2;
    private JLabel infoGenderLabel;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JButton logOutAccount;
    private JButton infoUpdateButton;

    public UserUI(UserService userService) {
        this.userService = userService;
        tabbedPane1 = new JTabbedPane();
        StartPanel = new JPanel();
        panel3 = new JPanel();
        nameLabel = new JLabel();
        meetingNameLabel = new JLabel();
        positionLabel = new JLabel();
        nameLabel2 = new JLabel();
        meetingNameLabel2 = new JLabel();
        positionLabel2 = new JLabel();
        timeLabel = new JLabel();
        TimeLabel2 = new JLabel();
        searchField = new JTextField();
        searchIcon = new JLabel();
        searchLabel = new JLabel();
        panel4 = new JPanel();
        conferenceLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        conferenceTable = new JTable();
        startUser_IDLabel = new JLabel();
        startUser_IDLabel2 = new JLabel();
        CMPanel = new JPanel();
        panel5 = new JPanel();
        createMeetingLabel = new JLabel();
        meeting_IDField = new JTextField();
        meeting_IDLabel = new JLabel();
        participantsLabel = new JLabel();
        meetingTimeLabel = new JLabel();
        participantsField = new JTextField();
        meetingTimeField = new JTextField();
        createMeetingButton = new JButton();
        panel6 = new JPanel();
        scrollPane2 = new JScrollPane();
        conferenceTable2 = new JTable();
        conferenceLabel2 = new JLabel();
        signInButton = new JButton();
        removeButton = new JButton();
        updateMeetingButton = new JButton();
        User_infoPanel = new JPanel();
        userInfoPanel = new JPanel();
        titleLabel = new JLabel();
        infoNameLabel = new JLabel();
        infoMeeingNameLabel = new JLabel();
        infoPositionLabel = new JLabel();
        user_IDLabel = new JLabel();
        infoPasswordLabel = new JLabel();
        infoNameField = new JTextField();
        infoMeetingNameField = new JTextField();
        infoPositionField = new JTextField();
        infoPasswordField = new JTextField();
        user_IDLabel2 = new JLabel();
        infoGenderLabel = new JLabel();
        maleRadioButton = new JRadioButton();
        femaleRadioButton = new JRadioButton();
        logOutAccount = new JButton();
        infoUpdateButton = new JButton();

        //======== this ========
        setTitle("\u4f1a\u8bae\u7ba1\u7406\u7cfb\u7edf");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {
            //======== StartPanel ========
            {
                StartPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
                        EmptyBorder(0, 0, 0, 0), " ", javax.swing.border.TitledBorder.CENTER, javax.swing
                        .border.TitledBorder.BOTTOM, new java.awt.Font("Dia\u006cog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), StartPanel.getBorder()));
                StartPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                    @Override
                    public void propertyChange(java.beans.PropertyChangeEvent e) {
                        if ("\u0062ord\u0065r".equals(e.getPropertyName()))
                            throw new RuntimeException();
                    }
                });
                StartPanel.setLayout(null);

                //======== panel3 ========
                {
                    panel3.setBackground(new Color(0x666666));
                    panel3.setLayout(null);

                    //---- nameLabel ----
                    nameLabel.setText("\u59d3\u540d/Name\uff1a");
                    nameLabel.setForeground(Color.lightGray);
                    panel3.add(nameLabel);
                    nameLabel.setBounds(60, 30, 100, 30);

                    //---- meetingNameLabel ----
                    meetingNameLabel.setText("\u4f1a\u8bae\u59d3\u540d/Meeting Name\uff1a");
                    meetingNameLabel.setForeground(Color.lightGray);
                    panel3.add(meetingNameLabel);
                    meetingNameLabel.setBounds(60, 75, 170, 30);

                    //---- positionLabel ----
                    positionLabel.setText("\u804c\u4f4d/position\uff1a");
                    positionLabel.setForeground(Color.lightGray);
                    panel3.add(positionLabel);
                    positionLabel.setBounds(60, 120, 170, 30);

                    //---- nameLabel2 ----
                    nameLabel2.setText(userService.getLoginUser().getName());
                    nameLabel2.setForeground(Color.lightGray);
                    panel3.add(nameLabel2);
                    nameLabel2.setBounds(255, 30, 75, 30);

                    //---- meetingNameLabel2 ----
                    meetingNameLabel2.setText(userService.getLoginUser().getMeetingName());
                    meetingNameLabel2.setForeground(Color.lightGray);
                    panel3.add(meetingNameLabel2);
                    meetingNameLabel2.setBounds(255, 75, 75, 30);

                    //---- positionLabel2 ----
                    positionLabel2.setText(userService.getLoginUser().getPosition());
                    positionLabel2.setForeground(Color.lightGray);
                    panel3.add(positionLabel2);
                    positionLabel2.setBounds(255, 120, 75, 30);

                    //---- timeLabel ----
                    timeLabel.setText("\u5f53\u524d\u65f6\u95f4/Current Time\uff1a");
                    timeLabel.setForeground(Color.lightGray);
                    panel3.add(timeLabel);
                    timeLabel.setBounds(375, 15, 165, 30);

                    //---- TimeLabel2 ----
                    TimeLabel2.setText("text");
                    TimeLabel2.setForeground(Color.lightGray);
                    panel3.add(TimeLabel2);
                    TimeLabel2.setBounds(590, 15, 75, 30);
                    panel3.add(searchField);
                    searchField.setBounds(375, 105, 225, 50);

                    //---- searchIcon ----
                    searchIcon.setIcon(new ImageIcon(String.valueOf(UserUI.class.getResourceAsStream("/resources/image/icons8-search-36(1).png"))));
                    panel3.add(searchIcon);
                    searchIcon.setBounds(605, 110, 40, 40);

                    //---- searchLabel ----
                    searchLabel.setText("\u8f93\u5165\u4f1a\u8baeID\u641c\u7d22/input meeting_ID do search\uff1a");
                    searchLabel.setForeground(Color.lightGray);
                    panel3.add(searchLabel);
                    searchLabel.setBounds(375, 55, 315, 45);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for (int i = 0; i < panel3.getComponentCount(); i++) {
                            Rectangle bounds = panel3.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel3.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel3.setMinimumSize(preferredSize);
                        panel3.setPreferredSize(preferredSize);
                    }
                }
                StartPanel.add(panel3);
                panel3.setBounds(0, 0, 750, 190);

                //======== panel4 ========
                {
                    panel4.setBackground(Color.lightGray);
                    panel4.setLayout(null);

                    //---- conferenceLabel ----
                    conferenceLabel.setText("\u5373\u5c06\u53c2\u52a0\u7684\u4f1a\u8bae/upcoming meeting\uff1a");
                    conferenceLabel.setForeground(new Color(0x333333));
                    panel4.add(conferenceLabel);
                    conferenceLabel.setBounds(60, 10, 240, 40);

                    //======== scrollPane1 ========
                    {

                        //---- conferenceTable ----
                        conferenceTable.setForeground(Color.lightGray);
                        conferenceTable.setBackground(Color.darkGray);
                        conferenceTable.setBorder(new LineBorder(Color.gray, 2, true));
                        scrollPane1.setViewportView(conferenceTable);
                    }
                    panel4.add(scrollPane1);
                    scrollPane1.setBounds(375, 0, 375, 280);

                    //---- startUser_IDLabel ----
                    startUser_IDLabel.setText("\u7528\u6237ID/user_ID\uff1a");
                    startUser_IDLabel.setForeground(new Color(0x333333));
                    panel4.add(startUser_IDLabel);
                    startUser_IDLabel.setBounds(0, 240, 105, 40);

                    //---- startUser_IDLabel2 ----
                    startUser_IDLabel2.setText("text");
                    startUser_IDLabel2.setForeground(new Color(0x333333));
                    panel4.add(startUser_IDLabel2);
                    startUser_IDLabel2.setBounds(125, 240, 90, 40);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for (int i = 0; i < panel4.getComponentCount(); i++) {
                            Rectangle bounds = panel4.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel4.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel4.setMinimumSize(preferredSize);
                        panel4.setPreferredSize(preferredSize);
                    }
                }
                StartPanel.add(panel4);
                panel4.setBounds(0, 190, 750, 280);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for (int i = 0; i < StartPanel.getComponentCount(); i++) {
                        Rectangle bounds = StartPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = StartPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    StartPanel.setMinimumSize(preferredSize);
                    StartPanel.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u4e3b\u9875", StartPanel);

            //======== CMPanel ========
            {
                CMPanel.setLayout(null);

                //======== panel5 ========
                {
                    panel5.setBackground(new Color(0x666666));
                    panel5.setLayout(null);

                    //---- createMeetingLabel ----
                    createMeetingLabel.setText("\u521b\u5efa\u4f1a\u8bae/create meeting\uff1a");
                    createMeetingLabel.setForeground(Color.lightGray);
                    panel5.add(createMeetingLabel);
                    createMeetingLabel.setBounds(30, 20, 170, 30);
                    panel5.add(meeting_IDField);
                    meeting_IDField.setBounds(505, 20, 150, 30);

                    //---- meeting_IDLabel ----
                    meeting_IDLabel.setText("\u4f1a\u8baeID/meeting_ID\uff1a");
                    meeting_IDLabel.setForeground(Color.lightGray);
                    panel5.add(meeting_IDLabel);
                    meeting_IDLabel.setBounds(215, 20, 150, 30);

                    //---- participantsLabel ----
                    participantsLabel.setText("\u53c2\u52a0\u4eba\u5458/participants(\u59d3\u540d)\uff1a");
                    participantsLabel.setForeground(Color.lightGray);
                    panel5.add(participantsLabel);
                    participantsLabel.setBounds(215, 65, 185, 30);

                    //---- meetingTimeLabel ----
                    meetingTimeLabel.setText("\u65f6\u95f4/Time(\u9700\u8981\u683c\u5f0f\u4e3a: MM.dd.HH.mm) \uff1a");
                    meetingTimeLabel.setForeground(Color.lightGray);
                    panel5.add(meetingTimeLabel);
                    meetingTimeLabel.setBounds(215, 110, 265, 30);
                    panel5.add(participantsField);
                    participantsField.setBounds(505, 65, 150, 30);
                    panel5.add(meetingTimeField);
                    meetingTimeField.setBounds(505, 110, 150, 30);

                    //---- createMeetingButton ----
                    createMeetingButton.setText("\u521b\u5efa/create");
                    createMeetingButton.setBackground(Color.lightGray);
                    createMeetingButton.setForeground(new Color(0x333333));
                    panel5.add(createMeetingButton);
                    createMeetingButton.setBounds(300, 155, 121, createMeetingButton.getPreferredSize().height);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for (int i = 0; i < panel5.getComponentCount(); i++) {
                            Rectangle bounds = panel5.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel5.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel5.setMinimumSize(preferredSize);
                        panel5.setPreferredSize(preferredSize);
                    }
                }
                CMPanel.add(panel5);
                panel5.setBounds(0, 0, 750, 190);

                //======== panel6 ========
                {
                    panel6.setBackground(Color.lightGray);
                    panel6.setLayout(null);

                    //======== scrollPane2 ========
                    {

                        //---- conferenceTable2 ----
                        conferenceTable2.setForeground(Color.lightGray);
                        conferenceTable2.setBackground(Color.darkGray);
                        conferenceTable2.setBorder(new LineBorder(Color.gray, 2, true));
                        scrollPane2.setViewportView(conferenceTable2);
                    }
                    panel6.add(scrollPane2);
                    scrollPane2.setBounds(0, 0, 515, 280);

                    //---- conferenceLabel2 ----
                    conferenceLabel2.setText("\u5728\u8868\u683c\u4e2d\u9009\u4e2d\u4f1a\u8bae\u8fdb\u884c\u64cd\u4f5c\uff1a");
                    conferenceLabel2.setForeground(new Color(0x333333));
                    panel6.add(conferenceLabel2);
                    conferenceLabel2.setBounds(515, 5, 230, 40);

                    //---- signInButton ----
                    signInButton.setText("\u7b7e\u5230");
                    signInButton.setBackground(new Color(0x666666));
                    signInButton.setForeground(Color.lightGray);
                    panel6.add(signInButton);
                    signInButton.setBounds(560, 50, 120, 40);

                    //---- removeButton ----
                    removeButton.setText("\u4ece\u5217\u8868\u4e2d\u79fb\u9664");
                    removeButton.setBackground(new Color(0x666666));
                    removeButton.setForeground(Color.lightGray);
                    panel6.add(removeButton);
                    removeButton.setBounds(560, 105, 120, 40);

                    //---- updateMeetingButton ----
                    updateMeetingButton.setText("\u66f4\u6539\u4f1a\u8bae\u4fe1\u606f");
                    updateMeetingButton.setBackground(new Color(0x666666));
                    updateMeetingButton.setForeground(Color.lightGray);
                    panel6.add(updateMeetingButton);
                    updateMeetingButton.setBounds(560, 160, 120, 40);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for (int i = 0; i < panel6.getComponentCount(); i++) {
                            Rectangle bounds = panel6.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel6.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel6.setMinimumSize(preferredSize);
                        panel6.setPreferredSize(preferredSize);
                    }
                }
                CMPanel.add(panel6);
                panel6.setBounds(0, 190, 750, 280);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for (int i = 0; i < CMPanel.getComponentCount(); i++) {
                        Rectangle bounds = CMPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = CMPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    CMPanel.setMinimumSize(preferredSize);
                    CMPanel.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u4f1a\u8bae\u7ba1\u7406", CMPanel);

            //======== User_infoPanel ========
            {
                User_infoPanel.setLayout(null);

                //======== userInfoPanel ========
                {
                    userInfoPanel.setBackground(Color.gray);
                    userInfoPanel.setLayout(null);

                    //---- titleLabel ----
                    titleLabel.setText("\u4e2a\u4eba\u4fe1\u606f/profile");
                    userInfoPanel.add(titleLabel);
                    titleLabel.setBounds(325, 10, 100, 50);

                    //---- infoNameLabel ----
                    infoNameLabel.setText("\u59d3\u540d/Name");
                    infoNameLabel.setForeground(Color.darkGray);
                    userInfoPanel.add(infoNameLabel);
                    infoNameLabel.setBounds(130, 70, 150, 25);

                    //---- infoMeeingNameLabel ----
                    infoMeeingNameLabel.setText("\u53c2\u4f1a\u540d/Meeting Name");
                    infoMeeingNameLabel.setForeground(Color.darkGray);
                    userInfoPanel.add(infoMeeingNameLabel);
                    infoMeeingNameLabel.setBounds(130, 140, 155, 25);

                    //---- infoPositionLabel ----
                    infoPositionLabel.setForeground(Color.darkGray);
                    infoPositionLabel.setText("\u804c\u4f4d/position");
                    userInfoPanel.add(infoPositionLabel);
                    infoPositionLabel.setBounds(130, 210, 155, 25);

                    //---- user_IDLabel ----
                    user_IDLabel.setText("\u7528\u6237ID/user_ID\uff1a");
                    user_IDLabel.setForeground(Color.darkGray);
                    userInfoPanel.add(user_IDLabel);
                    user_IDLabel.setBounds(0, 0, 105, 45);

                    //---- infoPasswordLabel ----
                    infoPasswordLabel.setText("\u5bc6\u7801/password");
                    infoPasswordLabel.setForeground(Color.darkGray);
                    userInfoPanel.add(infoPasswordLabel);
                    infoPasswordLabel.setBounds(130, 285, 155, 25);
                    userInfoPanel.add(infoNameField);
                    infoNameField.setBounds(180, 105, 180, infoNameField.getPreferredSize().height);
                    userInfoPanel.add(infoMeetingNameField);
                    infoMeetingNameField.setBounds(180, 175, 180, infoMeetingNameField.getPreferredSize().height);
                    userInfoPanel.add(infoPositionField);
                    infoPositionField.setBounds(180, 245, 180, infoPositionField.getPreferredSize().height);
                    userInfoPanel.add(infoPasswordField);
                    infoPasswordField.setBounds(180, 320, 180, infoPasswordField.getPreferredSize().height);

                    //---- user_IDLabel2 ----
                    user_IDLabel2.setForeground(Color.darkGray);
                    user_IDLabel2.setText("text");
                    userInfoPanel.add(user_IDLabel2);
                    user_IDLabel2.setBounds(130, 10, 150, 25);

                    //---- infoGenderLabel ----
                    infoGenderLabel.setText("\u6027\u522b/gender");
                    infoGenderLabel.setForeground(Color.darkGray);
                    userInfoPanel.add(infoGenderLabel);
                    infoGenderLabel.setBounds(430, 70, 150, 25);

                    //---- maleRadioButton ----
                    maleRadioButton.setText("\u7537/male");
                    maleRadioButton.setForeground(Color.darkGray);
                    userInfoPanel.add(maleRadioButton);
                    maleRadioButton.setBounds(465, 105, maleRadioButton.getPreferredSize().width, 25);

                    //---- femaleRadioButton ----
                    femaleRadioButton.setText("\u5973/female");
                    femaleRadioButton.setForeground(Color.darkGray);
                    userInfoPanel.add(femaleRadioButton);
                    femaleRadioButton.setBounds(550, 105, femaleRadioButton.getPreferredSize().width, 25);

                    //---- logOutAccount ----
                    logOutAccount.setText("\u6ce8\u9500\u8d26\u53f7/log out account");
                    logOutAccount.setForeground(Color.red);
                    userInfoPanel.add(logOutAccount);
                    logOutAccount.setBounds(540, 430, 205, 35);

                    //---- infoUpdateButton ----
                    infoUpdateButton.setText("\u63d0\u4ea4");
                    infoUpdateButton.setForeground(Color.darkGray);
                    userInfoPanel.add(infoUpdateButton);
                    infoUpdateButton.setBounds(335, 380, infoUpdateButton.getPreferredSize().width, 35);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for (int i = 0; i < userInfoPanel.getComponentCount(); i++) {
                            Rectangle bounds = userInfoPanel.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = userInfoPanel.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        userInfoPanel.setMinimumSize(preferredSize);
                        userInfoPanel.setPreferredSize(preferredSize);
                    }
                }
                User_infoPanel.add(userInfoPanel);
                userInfoPanel.setBounds(0, 0, 750, 470);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for (int i = 0; i < User_infoPanel.getComponentCount(); i++) {
                        Rectangle bounds = User_infoPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = User_infoPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    User_infoPanel.setMinimumSize(preferredSize);
                    User_infoPanel.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u6211\u7684\u4fe1\u606f", User_infoPanel);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 0, 750, 500);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
    }
}