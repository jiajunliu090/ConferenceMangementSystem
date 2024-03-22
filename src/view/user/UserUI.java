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
        setTitle("会议管理系统");
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
                    nameLabel.setText("姓名/Name:");
                    nameLabel.setForeground(Color.lightGray);
                    panel3.add(nameLabel);
                    nameLabel.setBounds(60, 30, 100, 30);

                    //---- meetingNameLabel ----
                    meetingNameLabel.setText("会议姓名/Meeting Name:");
                    meetingNameLabel.setForeground(Color.lightGray);
                    panel3.add(meetingNameLabel);
                    meetingNameLabel.setBounds(60, 75, 170, 30);

                    //---- positionLabel ----
                    positionLabel.setText("职位/position");
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
                    timeLabel.setText("当前时间/Current Time:");
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
                    searchLabel.setText("输入会议ID搜索/input meeting_ID do search");
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
                    conferenceLabel.setText("即将参加的会议/upcoming meeting:");
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
                    startUser_IDLabel.setText("用户ID/user_ID:");
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
            tabbedPane1.addTab("主页", StartPanel);

            //======== CMPanel ========
            {
                CMPanel.setLayout(null);

                //======== panel5 ========
                {
                    panel5.setBackground(new Color(0x666666));
                    panel5.setLayout(null);

                    //---- createMeetingLabel ----
                    createMeetingLabel.setText("创建会议/create meeting:");
                    createMeetingLabel.setForeground(Color.lightGray);
                    panel5.add(createMeetingLabel);
                    createMeetingLabel.setBounds(30, 20, 170, 30);
                    panel5.add(meeting_IDField);
                    meeting_IDField.setBounds(505, 20, 150, 30);

                    //---- meeting_IDLabel ----
                    meeting_IDLabel.setText("会议ID/meeting_ID:");
                    meeting_IDLabel.setForeground(Color.lightGray);
                    panel5.add(meeting_IDLabel);
                    meeting_IDLabel.setBounds(215, 20, 150, 30);

                    //---- participantsLabel ----
                    participantsLabel.setText("参加人员/participants(姓名)");
                    participantsLabel.setForeground(Color.lightGray);
                    panel5.add(participantsLabel);
                    participantsLabel.setBounds(215, 65, 185, 30);

                    //---- meetingTimeLabel ----
                    meetingTimeLabel.setText("时间/Time(需要格式为: MM.dd.HH.mm): ");
                    meetingTimeLabel.setForeground(Color.lightGray);
                    panel5.add(meetingTimeLabel);
                    meetingTimeLabel.setBounds(215, 110, 265, 30);
                    panel5.add(participantsField);
                    participantsField.setBounds(505, 65, 150, 30);
                    panel5.add(meetingTimeField);
                    meetingTimeField.setBounds(505, 110, 150, 30);

                    //---- createMeetingButton ----
                    createMeetingButton.setText("创建/create");
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
                    conferenceLabel2.setText("在表格中选中会议进行操作:");
                    conferenceLabel2.setForeground(new Color(0x333333));
                    panel6.add(conferenceLabel2);
                    conferenceLabel2.setBounds(515, 5, 230, 40);

                    //---- signInButton ----
                    signInButton.setText("签到");
                    signInButton.setBackground(new Color(0x666666));
                    signInButton.setForeground(Color.lightGray);
                    panel6.add(signInButton);
                    signInButton.setBounds(560, 50, 120, 40);

                    //---- removeButton ----
                    removeButton.setText("从列表中移除");
                    removeButton.setBackground(new Color(0x666666));
                    removeButton.setForeground(Color.lightGray);
                    panel6.add(removeButton);
                    removeButton.setBounds(560, 105, 120, 40);

                    //---- updateMeetingButton ----
                    updateMeetingButton.setText("更改会议信息");
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
            tabbedPane1.addTab("会议管理", CMPanel);

            //======== User_infoPanel ========
            {
                User_infoPanel.setLayout(null);

                //======== userInfoPanel ========
                {
                    userInfoPanel.setBackground(Color.gray);
                    userInfoPanel.setLayout(null);

                    //---- titleLabel ----
                    titleLabel.setText("个人信息/profile");
                    userInfoPanel.add(titleLabel);
                    titleLabel.setBounds(325, 10, 100, 50);

                    //---- infoNameLabel ----
                    infoNameLabel.setText("姓名/Name");
                    infoNameLabel.setForeground(Color.darkGray);
                    userInfoPanel.add(infoNameLabel);
                    infoNameLabel.setBounds(130, 70, 150, 25);

                    //---- infoMeeingNameLabel ----
                    infoMeeingNameLabel.setText("参会名/Meeting Name");
                    infoMeeingNameLabel.setForeground(Color.darkGray);
                    userInfoPanel.add(infoMeeingNameLabel);
                    infoMeeingNameLabel.setBounds(130, 140, 155, 25);

                    //---- infoPositionLabel ----
                    infoPositionLabel.setForeground(Color.darkGray);
                    infoPositionLabel.setText("职位/position");
                    userInfoPanel.add(infoPositionLabel);
                    infoPositionLabel.setBounds(130, 210, 155, 25);

                    //---- user_IDLabel ----
                    user_IDLabel.setText("用户ID/user_ID:");
                    user_IDLabel.setForeground(Color.darkGray);
                    userInfoPanel.add(user_IDLabel);
                    user_IDLabel.setBounds(0, 0, 105, 45);

                    //---- infoPasswordLabel ----
                    infoPasswordLabel.setText("密码/password");
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
                    infoGenderLabel.setText("性别/gender");
                    infoGenderLabel.setForeground(Color.darkGray);
                    userInfoPanel.add(infoGenderLabel);
                    infoGenderLabel.setBounds(430, 70, 150, 25);

                    //---- maleRadioButton ----
                    maleRadioButton.setText("男/male");
                    maleRadioButton.setForeground(Color.darkGray);
                    userInfoPanel.add(maleRadioButton);
                    maleRadioButton.setBounds(465, 105, maleRadioButton.getPreferredSize().width, 25);

                    //---- femaleRadioButton ----
                    femaleRadioButton.setText("女/female");
                    femaleRadioButton.setForeground(Color.darkGray);
                    userInfoPanel.add(femaleRadioButton);
                    femaleRadioButton.setBounds(550, 105, femaleRadioButton.getPreferredSize().width, 25);

                    //---- logOutAccount ----
                    logOutAccount.setText("注销账号/log out account");
                    logOutAccount.setForeground(Color.red);
                    userInfoPanel.add(logOutAccount);
                    logOutAccount.setBounds(540, 430, 205, 35);

                    //---- infoUpdateButton ----
                    infoUpdateButton.setText("提交");
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
            tabbedPane1.addTab("我的信息", User_infoPanel);
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