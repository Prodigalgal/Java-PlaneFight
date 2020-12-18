package util;

import GameWindos.ReadyFrame;
import GameWindos.StarFrame;
import config.Constant;
import entity.Planes.ProtossPlanes.Mothership;
import entity.user.User;
import flyingObjects.PlayerPlane;
import flyingObjects.SpecialEffects;
import service.UserService;

import javax.swing.*;

public class ReInitial {

    StarFrame star = StarFrame.getInstance();
    ReadyFrame ready = ReadyFrame.getInstance();

    public void reInitial(){
        new Constant().reInitial();
        new BulletsUtil().reInitial();
        new FlyPlaneUtil().reInitial();
        new SpecialItemUtil().reInitial();
        new SpecialEffectsUtil().reInitial();
        PlayerPlane.pp.reInitial();
        star.reInitial();
        Mothership.BossMotherShip.setHp(Constant.BossHP);
        new UserService().submitScore(User.user);//上传分数
        new UserService().submitMoney(User.user,User.user.getUserScore());//上传钱
        star.setVisible(false);
        ready.getContentPane().removeAll();
        ready.getContentPane().add(ready.initialPanel);
        SwingUtilities.updateComponentTreeUI(ready);
        ready.setVisible(true);
    }

}
