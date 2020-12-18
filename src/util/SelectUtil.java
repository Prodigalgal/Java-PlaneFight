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

    //ѡ��ɻ�
    public void intoTPZ(JComboBox<PlayerPlane> nComboBox , JLabel label , BufferedImage image) {

        PlayerPlane.pp = (PlayerPlane) nComboBox.getSelectedItem();//Ĭ��ѡ���һ��ѡ��
        nComboBox.addActionListener(comboBoxListener);//ע�����
        ready.getContentPane().removeAll();
        ready.getContentPane().add(ready.panelTPZ);

        ready.panelTPZ.remove(ready.comboBox);
        ready.panelTPZ.remove(ready.labelX);

        ready.panelTPZ.add(nComboBox);
        ready.panelTPZ.add(label);

        SwingUtilities.updateComponentTreeUI(ready);

        ready.comboBox = nComboBox;//����ϴ�Box�������Ƴ�
        ready.labelX = label;

        ready.label2.setIcon(new ImageIcon(image));
        ready.panelTPZ.add(ready.label2);
    }

    //����ѡ��
    public void backInto() {
        ready.getContentPane().removeAll();
        ready.getContentPane().add(ready.initialPanel);
        SwingUtilities.updateComponentTreeUI(ready);
        System.out.println("����");
    }

    //�����̳�
    public void storeInto() {
        ready.getContentPane().removeAll();
        ready.getContentPane().add(ready.panelStore);
        SwingUtilities.updateComponentTreeUI(ready);
        System.out.println("�����̳�");
    }

    //������Ʒ
    public void buyValue(int num) {
        int i = JOptionPane.showConfirmDialog(null, "��ȷ�Ϲ���", "������ʾ", JOptionPane.OK_CANCEL_OPTION);
        if (JOptionPane.OK_OPTION == i) {
            new UserService().buy(User.user, num);
            User.user.setMoney(new UserDAO().selectMoney(User.user));
            ready.labelMoney.setText("���Ľ�ң�" + User.user.getMoney());//ˢ�½����ʾ
        }

        else JOptionPane.showMessageDialog(null, "��ȡ����", "������ʾ", JOptionPane.OK_OPTION);
    }

    //ȷ��ѡ��
    public void confirmInto() {
        ready.setVisible(false);
        PlayerPlane.pp.setHp(User.user.getPlaneHP());//��ʼ���������ֵ
        if(3 == PlayerPlane.pp.getCampId())
            PlayerPlane.pp.setDefenceHp((int) (User.user.getPlaneHP() * 0.5));//��Ϊ�����ʼ������
        Constant.BulletDamage = User.user.getPlaneDamage();//��ʼ������˺�
        PlayerPlane.pp.setSpeed(User.user.getPlaneSpeed() + PlayerPlane.pp.getSpeed());//��ʼ����ҷɻ�����
        System.out.println("�ɻ���ʼ����:" + PlayerPlane.pp.getHp() + "\n�ɻ���ʼ���٣�" + PlayerPlane.pp.getSpeed() + "\n�ɻ��˺���" + Constant.BulletDamage + "\n���:" + PlayerPlane.pp.getName() + "\n��Ϸ״̬��" + Constant.STATES);
        Constant.STATES = Constant.STAR;
        star.setVisible(true);
        star.setStar();
    }

    //���ص�½����
    public void backLogin() {
        login.reInitial();
        ready.setVisible(false);
        login.setVisible(true);
    }

    //ʧ�ܻ���ط���ѡ�����
    public void fallBackReady(boolean tag) {
        GameOver over = new GameOver(tag);
        over.setBounds(0,0,Constant.WindowWidth,Constant.WindowHeight);
        star.getContentPane().removeAll();
        star.add(over);
    }


}
