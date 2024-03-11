package view;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class Login extends JFrame {
    JTextField userNameField = new FocusableBorderTextField(20);
    JPasswordField passWordField = new FocusableBorderPasswordField(20);
    public Login() {
        //设置窗口标题
        this.setTitle("会议管理系统");
        //设置窗口大小
        this.setSize(500,300);
        Font font = new Font("楷体",Font.PLAIN,16);
        //添加一个面板作为容器
        JPanel root = new JPanel();
        this.setContentPane(root);
        //添加一个文本框

        root.add(userNameField);
        root.add(passWordField);
        userNameField.setText("");
        //添加标签
        JLabel jLabel1 = new JLabel("账号:");
        JLabel jLabel2 = new JLabel("密码:");
        JLabel jLabel3 = new JLabel("会议管理系统");
        root.add(jLabel1);
        root.add(jLabel2);
        root.add(jLabel3);
        //
        JButton managerLogin = new JButton("管理员登录");
        JButton userLogin = new JButton("用户登录");
        JButton Sign = new JButton("注册");
        root.add(managerLogin);
        root.add(userLogin);
        root.add(Sign);
        root.setLayout(null);
        //

        //
        managerLogin.setBounds(80,200,100,30);
        userLogin.setBounds(210,200,80,30);
        Sign.setBounds(320,200,60,30);
        userNameField.setBounds(150,50,200,30);
        passWordField.setBounds(150,125,200,30);
        jLabel1.setBounds(100,50,50,30);
        jLabel2.setBounds(100,125,50,30);
        jLabel3.setBounds(200,10,100,30);
        jLabel3.setFont(font);

        //
        managerLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test();
            }
        });
        userLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test();
            }
        });
        Sign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //销毁当前页面
                dispose();
                Sign sign = new Sign();
                sign.setVisible(true);
            }
        });



    }



    public void test(){
        String userName = userNameField.getText().trim();
        String passWord = passWordField.getText().trim();
        System.out.println(userName);
        System.out.println(passWord);
        //判断用户名和密码是否为空
        if("".equals(userName)){
            System.out.println("账号不能为空");
            JOptionPane.showMessageDialog(null,"账号不能为空");
        }
        else if("".equals(passWord)){
            System.out.println("密码不能为空");
            JOptionPane.showMessageDialog(null,"密码不能为空");
        }
        else{
            System.out.println("..");
        }
    }
}


