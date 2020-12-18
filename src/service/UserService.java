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

    //封装DAO与实体类
    private final UserDAO userDAO = new UserDAO();

    //用户购买商品
    public void buy(User u, int num) {
        if (userDAO.selectMoney(u) - 1000 >= 0) {
            userDAO.Money(u, -1000);
            userDAO.setValue(u, num);
            switch (num) {
                case 1 -> {
                    JOptionPane.showMessageDialog(null, "生命上限提升1点", "操作提示", JOptionPane.OK_CANCEL_OPTION);
                    User.user.setPlaneHP(userDAO.getValue(User.user, 1));
                }
                case 2 -> {
                    JOptionPane.showMessageDialog(null, "伤害提升1点", "操作提示", JOptionPane.OK_CANCEL_OPTION);
                    User.user.setPlaneDamage(userDAO.getValue(User.user, 2));
                }
                case 3 -> {
                    JOptionPane.showMessageDialog(null, "移速提升1点", "操作提示", JOptionPane.OK_CANCEL_OPTION);
                    User.user.setPlaneSpeed(userDAO.getValue(User.user, 3));
                }
            }
        } else JOptionPane.showMessageDialog(null, "金币不足", "操作提示", JOptionPane.OK_OPTION);
    }

    //删除用户
    public void delete(User u) {

        int i = JOptionPane.showConfirmDialog(null, "注销用户将会删除记录！", "操作提示", JOptionPane.OK_CANCEL_OPTION);
        if (JOptionPane.OK_OPTION == i) {
            userDAO.deleteUser(u);
            JOptionPane.showMessageDialog(null, "注销成功！返回登陆界面", "操作提示", JOptionPane.OK_CANCEL_OPTION);
            new SelectUtil().backLogin();
        }

    }

    //查询分数
    public void searchScore(User u) {
        int Score = userDAO.SearchUserScore(u);
        JOptionPane.showMessageDialog(null, "您的最高分数：" + Score, "操作提示", JOptionPane.OK_CANCEL_OPTION);
    }

    //查询钱
    public void searchMoney(User u) {
        int money = userDAO.selectMoney(u);
        JOptionPane.showMessageDialog(null, "您的钱钱：" + money, "操作提示", JOptionPane.OK_CANCEL_OPTION);
    }

    //修改名字
    public void modifyName(User u) {
        String name = JOptionPane.showInputDialog(null, "请输入：\n", "修改名字", JOptionPane.PLAIN_MESSAGE);
        if (name == null)
            JOptionPane.showMessageDialog(null, "已取消修改！", "操作提示", JOptionPane.OK_CANCEL_OPTION);
        else if (userDAO.SearchUser(new User(name, null)) | "".equals(name))
            JOptionPane.showMessageDialog(null, "账户名不能重复或为空！", "操作提示", JOptionPane.OK_CANCEL_OPTION);
        else if (10 < name.length())
            JOptionPane.showMessageDialog(null, "账户名限十个字符以内！", "操作提示", JOptionPane.OK_CANCEL_OPTION);
        else {
            new UserDAO().ModifyUserName(u.getLoginName(), name);
            JOptionPane.showMessageDialog(null, "修改成功！", "操作提示", JOptionPane.OK_CANCEL_OPTION);
        }
    }

    //修改密码
    public void modifyPassword(User u) {

        String password = JOptionPane.showInputDialog(null, "请输入：\n", "修改名字", JOptionPane.PLAIN_MESSAGE);
        if (password == null)
            JOptionPane.showMessageDialog(null, "已取消修改！", "操作提示", JOptionPane.OK_CANCEL_OPTION);
        else if ("".equals(password))
            JOptionPane.showMessageDialog(null, "密码不能为空！", "操作提示", JOptionPane.OK_CANCEL_OPTION);
        else if (10 < password.length())
            JOptionPane.showMessageDialog(null, "密码限十个字符以内！", "操作提示", JOptionPane.OK_CANCEL_OPTION);
        else {
            new UserDAO().ModifyUserPassword(u.getLoginName(), password);
            JOptionPane.showMessageDialog(null, "修改成功 ", "操作提示", JOptionPane.OK_CANCEL_OPTION);
        }
    }

    //用户登陆
    public void VerifyUser(User u) {

        LoginFrame login = LoginFrame.getInstance();
        ReadyFrame ready = ReadyFrame.getInstance();

        if (userDAO.VerifyUser(u)) {
            int op = JOptionPane.showConfirmDialog(login, "登陆成功", "操作提示：", JOptionPane.OK_CANCEL_OPTION);
            if (op == JOptionPane.OK_OPTION) {
                User.user.setPlaneHP(userDAO.getValue(User.user, 1));
                User.user.setPlaneDamage(userDAO.getValue(User.user, 2));
                User.user.setPlaneSpeed(userDAO.getValue(User.user, 3));
                User.user.setMoney(userDAO.selectMoney(User.user));
                System.out.println("欢迎：" + u.getLoginName());
                login.setVisible(false);
                ready.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "登陆取消！", "操作提示", JOptionPane.OK_CANCEL_OPTION);
                System.out.println("登陆取消！");
            }
        } else {
            JOptionPane.showMessageDialog(null, "登陆失败，账号或密码错误！", "操作提示", JOptionPane.OK_CANCEL_OPTION);
            System.out.println("登陆失败！");
        }
    }

    //增加用户
    public void add(User u) {

        if (userDAO.SearchUser(u)) {
            JOptionPane.showMessageDialog(null, "账号已存在无法注册！请更换登录名！", "操作提示", JOptionPane.OK_CANCEL_OPTION);
            System.out.println("账号已存在无法注册！请更换登录名！");
        } else {
            if (!"".equals(u.getLoginName()) && !"".equals(u.getLoginPassword()) && 10 >= u.getLoginName().length() && 10 >= u.getLoginPassword().length()) {
                userDAO.AddUser(u);
                JOptionPane.showMessageDialog(null, "注册成功！欢迎：" + u.getLoginName(), "操作提示", JOptionPane.OK_CANCEL_OPTION);
                System.out.println("注册成功！欢迎：" + u.getLoginName());
            } else {
                JOptionPane.showMessageDialog(null, "注册账号或密码不能为空或长度不符", "操作提示", JOptionPane.OK_CANCEL_OPTION);
                System.out.println("注册账号或密码不能为空或长度不符");
            }
        }

    }

    //分数提交
    public void submitScore(User u) {
        new UserDAO().submitMAXScore(u.getLoginName(), u.getUserScore());
    }

    //提交钱
    public void submitMoney(User u, int money) {
        userDAO.Money(u, money);
    }

    //获取数据源
    public Map<Integer , User> TableSearch(){
        return userDAO.selectData();
    }

}
