package view;

import javax.swing.*;
import java.awt.*;

public class AlertMetting extends JFrame{
    public AlertMetting(){
        //设置窗口标题
        this.setTitle("修改会议");
        //设置窗口大小
        this.setSize(500,300);
        Font font = new Font("楷体",Font.PLAIN,16);
        Font font1 = new Font("楷体",Font.PLAIN,8);
        //添加一个面板作为容器
        JPanel root = new JPanel();
        this.setContentPane(root);
    }
}
