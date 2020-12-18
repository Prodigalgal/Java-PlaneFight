package service;

import GameWindos.LoginFrame;
import GameWindos.ReadyFrame;
import entity.user.User;
import userdao.UserDAO;
import util.SelectUtil;

import javax.swing.*;
import java.util.Map;
import java.util.Queue;

public class UserService {

    //��װDAO��ʵ����
    private final UserDAO userDAO = new UserDAO();

    //�û�������Ʒ
    public void buy(User u, int num) {
        if (userDAO.selectMoney(u) - 1000 >= 0) {
            userDAO.Money(u, -1000);
            userDAO.setValue(u, num);
            switch (num) {
                case 1 -> {
                    JOptionPane.showMessageDialog(null, "������������1��", "������ʾ", JOptionPane.OK_CANCEL_OPTION);
                    User.user.setPlaneHP(userDAO.getValue(User.user, 1));
                }
                case 2 -> {
                    JOptionPane.showMessageDialog(null, "�˺�����1��", "������ʾ", JOptionPane.OK_CANCEL_OPTION);
                    User.user.setPlaneDamage(userDAO.getValue(User.user, 2));
                }
                case 3 -> {
                    JOptionPane.showMessageDialog(null, "��������1��", "������ʾ", JOptionPane.OK_CANCEL_OPTION);
                    User.user.setPlaneSpeed(userDAO.getValue(User.user, 3));
                }
            }
        } else JOptionPane.showMessageDialog(null, "��Ҳ���", "������ʾ", JOptionPane.OK_OPTION);
    }

    //ɾ���û�
    public void delete(User u) {

        int i = JOptionPane.showConfirmDialog(null, "ע���û�����ɾ����¼��", "������ʾ", JOptionPane.OK_CANCEL_OPTION);
        if (JOptionPane.OK_OPTION == i) {
            userDAO.deleteUser(u);
            JOptionPane.showMessageDialog(null, "ע���ɹ������ص�½����", "������ʾ", JOptionPane.OK_CANCEL_OPTION);
            new SelectUtil().backLogin();
        }

    }

    //��ѯ����
    public void searchScore(User u) {
        int Score = userDAO.SearchUserScore(u);
        JOptionPane.showMessageDialog(null, "������߷�����" + Score, "������ʾ", JOptionPane.OK_CANCEL_OPTION);
    }

    //��ѯǮ
    public void searchMoney(User u) {
        int money = userDAO.selectMoney(u);
        JOptionPane.showMessageDialog(null, "����ǮǮ��" + money, "������ʾ", JOptionPane.OK_CANCEL_OPTION);
    }

    //�޸�����
    public void modifyName(User u) {
        String name = JOptionPane.showInputDialog(null, "�����룺\n", "�޸�����", JOptionPane.PLAIN_MESSAGE);
        if (name == null)
            JOptionPane.showMessageDialog(null, "��ȡ���޸ģ�", "������ʾ", JOptionPane.OK_CANCEL_OPTION);
        else if (userDAO.SearchUser(new User(name, null)) | "".equals(name))
            JOptionPane.showMessageDialog(null, "�˻��������ظ���Ϊ�գ�", "������ʾ", JOptionPane.OK_CANCEL_OPTION);
        else if (10 < name.length())
            JOptionPane.showMessageDialog(null, "�˻�����ʮ���ַ����ڣ�", "������ʾ", JOptionPane.OK_CANCEL_OPTION);
        else {
            new UserDAO().ModifyUserName(u.getLoginName(), name);
            JOptionPane.showMessageDialog(null, "�޸ĳɹ���", "������ʾ", JOptionPane.OK_CANCEL_OPTION);
        }
    }

    //�޸�����
    public void modifyPassword(User u) {

        String password = JOptionPane.showInputDialog(null, "�����룺\n", "�޸�����", JOptionPane.PLAIN_MESSAGE);
        if (password == null)
            JOptionPane.showMessageDialog(null, "��ȡ���޸ģ�", "������ʾ", JOptionPane.OK_CANCEL_OPTION);
        else if ("".equals(password))
            JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�", "������ʾ", JOptionPane.OK_CANCEL_OPTION);
        else if (10 < password.length())
            JOptionPane.showMessageDialog(null, "������ʮ���ַ����ڣ�", "������ʾ", JOptionPane.OK_CANCEL_OPTION);
        else {
            new UserDAO().ModifyUserPassword(u.getLoginName(), password);
            JOptionPane.showMessageDialog(null, "�޸ĳɹ� ", "������ʾ", JOptionPane.OK_CANCEL_OPTION);
        }
    }

    //�û���½
    public void VerifyUser(User u) {

        LoginFrame login = LoginFrame.getInstance();
        ReadyFrame ready = ReadyFrame.getInstance();

        if (userDAO.VerifyUser(u)) {
            int op = JOptionPane.showConfirmDialog(login, "��½�ɹ�", "������ʾ��", JOptionPane.OK_CANCEL_OPTION);
            if (op == JOptionPane.OK_OPTION) {
                User.user.setPlaneHP(userDAO.getValue(User.user, 1));
                User.user.setPlaneDamage(userDAO.getValue(User.user, 2));
                User.user.setPlaneSpeed(userDAO.getValue(User.user, 3));
                User.user.setMoney(userDAO.selectMoney(User.user));
                System.out.println("��ӭ��" + u.getLoginName());
                login.setVisible(false);
                ready.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "��½ȡ����", "������ʾ", JOptionPane.OK_CANCEL_OPTION);
                System.out.println("��½ȡ����");
            }
        } else {
            JOptionPane.showMessageDialog(null, "��½ʧ�ܣ��˺Ż��������", "������ʾ", JOptionPane.OK_CANCEL_OPTION);
            System.out.println("��½ʧ�ܣ�");
        }
    }

    //�����û�
    public void add(User u) {

        if (userDAO.SearchUser(u)) {
            JOptionPane.showMessageDialog(null, "�˺��Ѵ����޷�ע�ᣡ�������¼����", "������ʾ", JOptionPane.OK_CANCEL_OPTION);
            System.out.println("�˺��Ѵ����޷�ע�ᣡ�������¼����");
        } else {
            if (!"".equals(u.getLoginName()) && !"".equals(u.getLoginPassword()) && 10 >= u.getLoginName().length() && 10 >= u.getLoginPassword().length()) {
                userDAO.AddUser(u);
                JOptionPane.showMessageDialog(null, "ע��ɹ�����ӭ��" + u.getLoginName(), "������ʾ", JOptionPane.OK_CANCEL_OPTION);
                System.out.println("ע��ɹ�����ӭ��" + u.getLoginName());
            } else {
                JOptionPane.showMessageDialog(null, "ע���˺Ż����벻��Ϊ�ջ򳤶Ȳ���", "������ʾ", JOptionPane.OK_CANCEL_OPTION);
                System.out.println("ע���˺Ż����벻��Ϊ�ջ򳤶Ȳ���");
            }
        }

    }

    //�����ύ
    public void submitScore(User u) {
        new UserDAO().submitMAXScore(u.getLoginName(), u.getUserScore());
    }

    //�ύǮ
    public void submitMoney(User u, int money) {
        userDAO.Money(u, money);
    }

    //��ȡ����Դ
    public Map<Integer , User> TableSearch(){
        return userDAO.selectData();
    }

}
