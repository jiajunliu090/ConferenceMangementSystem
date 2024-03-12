package view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class UserUI extends JFrame {
    public UserUI() {
        this.setTitle("用户界面");
        this.setBounds(700, 200, 600, 600);
        JTabbedPane tabbedPane = new JTabbedPane();
        Font font = new Font("楷体", 0, 16);
        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("查看自己需要参加的会议"));
        tabbedPane.addTab("查看自己需要参加的会议", panel1);
        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("创建会议"));
        tabbedPane.addTab("创建会议", panel2);
        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("修改会议"));
        tabbedPane.addTab("修改会议", panel3);
        JPanel panel4 = new JPanel();
        panel4.add(new JLabel("删除会议"));
        tabbedPane.addTab("删除会议", panel4);
        JPanel panel5 = new JPanel();
        panel5.add(new JLabel("会议签到"));
        tabbedPane.addTab("会议签到", panel5);
        JPanel panel6 = new JPanel();
        panel6.add(new JButton("注销"));
        tabbedPane.addTab("修改信息", panel6);
        JPanel panel7 = new JPanel();
        panel7.add(new JLabel("评价会议"));
        panel2.setFont(font);
        panel3.setFont(font);
        panel4.setFont(font);
        panel5.setFont(font);
        panel6.setFont(font);
        panel7.setFont(font);
        tabbedPane.addTab("评价会议", panel7);
        tabbedPane.setFocusable(false);
        this.add(tabbedPane);
    }
}
