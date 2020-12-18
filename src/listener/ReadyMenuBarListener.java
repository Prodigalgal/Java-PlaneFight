package listener;

import GameWindos.ReadyFrame;
import config.Constant;
import entity.user.User;
import service.UserService;
import util.MusicAndSpecialUtil;
import util.SelectUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadyMenuBarListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //²Ëµ¥À¸¼àÌý
        ReadyFrame ready = ReadyFrame.getInstance();
        SelectUtil su = new SelectUtil();
        JMenuItem menuItem = (JMenuItem) e.getSource();
        if (menuItem == ready.backMI) {
            su.backLogin();
            Constant.once = 0;
        }


        if (menuItem == ready.modifyLoginNameMI)
            new UserService().modifyName(User.user);

        if (menuItem == ready.modifyPasswordMI)
            new UserService().modifyPassword(User.user);

        if (menuItem == ready.selectScoreMI)
            new UserService().searchScore(User.user);

        if (menuItem == ready.deleteUser)
            new UserService().delete(User.user);

        if (menuItem == ready.selectMoneyMI)
            new UserService().searchMoney(User.user);

        if (menuItem == ready.helpMI) {
            ready.helpDialog();
            ready.dialog.setVisible(true);
        }

        if (menuItem == ready.starMusicMI)
            new MusicAndSpecialUtil().starMusic();

        if (menuItem == ready.stopMusicMI)
            new MusicAndSpecialUtil().stopMusic();

        if (menuItem == ready.nextMusicBGMMI)
            new MusicAndSpecialUtil().nextMusic();

        if (menuItem == ready.addBGMMI)
            new MusicAndSpecialUtil().addBGM();

        if (menuItem == ready.deleteBGMMI)
            new MusicAndSpecialUtil().deleteBGM();

        if (menuItem == ready.tableMI) {
            ready.tableDialog();
            ready.tableDialog.setVisible(true);
        }
    }
}
