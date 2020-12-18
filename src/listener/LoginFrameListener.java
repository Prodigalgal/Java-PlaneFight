package listener;

import GameWindos.LoginFrame;
import entity.user.User;
import service.UserService;
import config.Music;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrameListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        LoginFrame login = LoginFrame.getInstance();
        JButton button = (JButton) e.getSource();
        new Music().Button(Music.button1);//ÃÌº”∞¥≈•“Ù–ß

        if (button == login.loginButton) {
            User.user = new User(login.getNameTextField(), login.getPasswordField());
            new UserService().VerifyUser(User.user);
        }
        if (button == login.registerButton) {
            User.user = new User(login.getNameTextField(), login.getPasswordField());
            new UserService().add(User.user);
        }
    }



}

