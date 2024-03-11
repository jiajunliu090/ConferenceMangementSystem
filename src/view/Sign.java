package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sign extends JFrame {
    JTextField userNameField = new FocusableBorderTextField(20);
    JPasswordField passWordField = new FocusableBorderPasswordField(20);
    JPasswordField affirmField = new FocusableBorderPasswordField(20);
    JTextField nameField = new FocusableBorderTextField(20);
    //将复选框加入容器
    JCheckBox agreeField = new JCheckBox("同意用户协议");
    JButton nextButton = new JButton("下一步");

    public Sign(){
        //设置窗口标题
        this.setTitle("注册");
        //设置窗口大小
        this.setBounds(700,200,600,600);
        //添加一个面板作为容器
        JPanel root = new JPanel();
        this.setContentPane(root);
        //添加一个文本框
        root.add(userNameField);
        root.add(passWordField);
        root.add(affirmField);
        root.add(nameField);
        userNameField.setText("");
        //添加标签
        JLabel jLabel1 = new JLabel("账号:");
        JLabel jLabel2 = new JLabel("密码:");
        JLabel jLabel3 = new JLabel("确认密码:");
        JLabel jLabel4 = new JLabel("姓名:");
        root.add(jLabel1);
        root.add(jLabel2);
        root.add(jLabel3);
        root.add(jLabel4);
        root.add(agreeField);
        //将按钮添加到容器中
        root.add(nextButton);
        //
        root.setLayout(null);
        //界面初始化
         agreeField.setSelected(false);
         nextButton.setEnabled(false);
        //
        nextButton.setBounds(350,400,100,30);
        userNameField.setBounds(200,50,200,30);
        passWordField.setBounds(200,125,200,30);
        affirmField.setBounds(200,200,200,30);
        agreeField.setBounds(100,400,150,30);
        nameField.setBounds(200,275,200,30);
        jLabel1.setBounds(100,50,50,30);
        jLabel2.setBounds(100,125,50,30);
        jLabel3.setBounds(75,200,60,30);
        jLabel4.setBounds(100,275,60,30);

        agreeField.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(agreeField.isSelected()){
                    nextButton.setEnabled(true);
                }
                else {
                    nextButton.setEnabled(false);
                }
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test();
            }
        });
    }
    public void test(){
        String userName = userNameField.getText().trim();
        String passWord = passWordField.getText().trim();
        String affirm = affirmField.getText().trim();
        System.out.println(userName);
        System.out.println(passWord);
        System.out.println(affirm);
        //判断用户名和密码是否为空
        if("".equals(userName)){
            System.out.println("账号不能为空");
            JOptionPane.showMessageDialog(null,"账号不能为空");
        }
        else if("".equals(passWord)){
            System.out.println("密码不能为空");
            JOptionPane.showMessageDialog(null,"密码不能为空");
        }
        else if("".equals(affirm)){
            System.out.println("确认密码不能为空");
            JOptionPane.showMessageDialog(null,"确认密码不能为空");
        }
    }


}

