package util;

import GameWindos.GameOver;
import GameWindos.LoginFrame;
import GameWindos.ReadyFrame;
import GameWindos.StarFrame;
import config.Constant;
import entity.user.User;
import flyingObjects.PlayerPlane;
import listener.JComboBoxListener;
import service.UserService;
import userdao.UserDAO;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class SelectUtil {

    StarFrame star = StarFrame.getInstance();
    ReadyFrame ready = ReadyFrame.getInstance();
    LoginFrame login = LoginFrame.getInstance();
    JComboBoxListener comboBoxListener = new JComboBoxListener();

    //选择飞机
    public void intoTPZ(JComboBox<PlayerPlane> nComboBox , JLabel label , BufferedImage image) {

        PlayerPlane.pp = (PlayerPlane) nComboBox.getSelectedItem();//默认选择第一个选项
        nComboBox.addActionListener(comboBoxListener);//注册监听
        ready.getContentPane().removeAll();
        ready.getContentPane().add(ready.panelTPZ);

        ready.panelTPZ.remove(ready.comboBox);
        ready.panelTPZ.remove(ready.labelX);

        ready.panelTPZ.add(nComboBox);
        ready.panelTPZ.add(label);

        SwingUtilities.updateComponentTreeUI(ready);

        ready.comboBox = nComboBox;//标记上次Box，便于移除
        ready.labelX = label;

        ready.label2.setIcon(new ImageIcon(image));
        ready.panelTPZ.add(ready.label2);
    }

    //返回选择
    public void backInto() {
        ready.getContentPane().removeAll();
        ready.getContentPane().add(ready.initialPanel);
        SwingUtilities.updateComponentTreeUI(ready);
        System.out.println("返回");
    }

    //进入商城
    public void storeInto() {
        ready.getContentPane().removeAll();
        ready.getContentPane().add(ready.panelStore);
        SwingUtilities.updateComponentTreeUI(ready);
        System.out.println("进入商城");
    }

    //购买商品
    public void buyValue(int num) {
        int i = JOptionPane.showConfirmDialog(null, "请确认购买！", "操作提示", JOptionPane.OK_CANCEL_OPTION);
        if (JOptionPane.OK_OPTION == i) {
            new UserService().buy(User.user, num);
            User.user.setMoney(new UserDAO().selectMoney(User.user));
            ready.labelMoney.setText("您的金币：" + User.user.getMoney());//刷新金币显示
        }

        else JOptionPane.showMessageDialog(null, "已取消！", "操作提示", JOptionPane.OK_OPTION);
    }

    //确认选择
    public void confirmInto() {
        ready.setVisible(false);
        PlayerPlane.pp.setHp(User.user.getPlaneHP());//初始化玩家生命值
        if(3 == PlayerPlane.pp.getCampId())
            PlayerPlane.pp.setDefenceHp((int) (User.user.getPlaneHP() * 0.5));//若为神族初始化护盾
        Constant.BulletDamage = User.user.getPlaneDamage();//初始化玩家伤害
        PlayerPlane.pp.setSpeed(User.user.getPlaneSpeed() + PlayerPlane.pp.getSpeed());//初始化玩家飞机移速
        System.out.println("飞机初始生命:" + PlayerPlane.pp.getHp() + "\n飞机初始移速：" + PlayerPlane.pp.getSpeed() + "\n飞机伤害：" + Constant.BulletDamage + "\n起飞:" + PlayerPlane.pp.getName() + "\n游戏状态：" + Constant.STATES);
        Constant.STATES = Constant.STAR;
        star.setVisible(true);
        star.setStar();
    }

    //返回登陆界面
    public void backLogin() {
        login.reInitial();
        ready.setVisible(false);
        login.setVisible(true);
    }

    //失败或过关返回选择界面
    public void fallBackReady(boolean tag) {
        GameOver over = new GameOver(tag);
        over.setBounds(0,0,Constant.WindowWidth,Constant.WindowHeight);
        star.getContentPane().removeAll();
        star.add(over);
    }


}
