package view;

import javax.swing.*;
import java.awt.*;

public class SignMeeting extends JFrame {
    public SignMeeting(){
        //设置窗口标题
        this.setTitle("创建会议");
        //设置窗口大小
        this.setSize(500,300);
        Font font = new Font("楷体",Font.PLAIN,16);
        Font font1 = new Font("楷体",Font.PLAIN,8);
        //添加一个面板作为容器
        JPanel root = new JPanel();
        this.setContentPane(root);
    }
}
