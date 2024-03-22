package view;

import com.formdev.flatlaf.FlatLightLaf;
import view.start.Login;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        Login login = new Login();
        login.setVisible(true);

        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //userUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
