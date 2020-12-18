package userdao;

import entity.user.User;
import util.SQLConnectUtil;

import java.sql.*;
import java.util.*;

public class UserDAO {
    //ʵ�ֶ����ݵ���ɾ�Ĳ�

    public Map<Integer, User> selectData() {

        Map<Integer, User> map = new HashMap<Integer, User>();
        Integer integer = 0;
        String slqData = "SELECT * FROM user order by UserScore DESC";

        try (Connection c1 = SQLConnectUtil.getConnection(); PreparedStatement ps = c1.prepareStatement(slqData)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setLoginName(rs.getString(1));
                u.setUserScore(rs.getInt(3));
                map.put(integer,u);
                integer++;
                //System.out.println(rs.getString(1)+" "+rs.getString(3));
                //rs.getString(1);rs.getString(3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    //�û�������Ʒ
    public void setValue(User user, int num) {
        String sqlAdd = null;
        switch (num) {
            case 1 -> sqlAdd = "update user set PlaneHP = ? where loginName= '" + user.getLoginName() + "'";
            case 2 -> sqlAdd = "update user set PlaneDamage = ? where loginName= '" + user.getLoginName() + "'";
            case 3 -> sqlAdd = "update user set PlaneSpeed = ? where loginName= '" + user.getLoginName() + "'";
        }
        try (Connection c1 = SQLConnectUtil.getConnection(); PreparedStatement ps = c1.prepareStatement(sqlAdd)) {
            ps.setInt(1, getValue(user, num) + 1);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //��ȡ�û��������Ʒbuff
    public int getValue(User user, int num) {
        String sqlSelect = null;
        switch (num) {
            case 1 -> sqlSelect = "SELECT PlaneHP FROM user WHERE loginName= ? ";
            case 2 -> sqlSelect = "SELECT PlaneDamage FROM user WHERE loginName= ? ";
            case 3 -> sqlSelect = "SELECT PlaneSpeed FROM user WHERE loginName= ? ";
        }
        int value = 0;
        try (Connection c1 = SQLConnectUtil.getConnection(); PreparedStatement ps = c1.prepareStatement(sqlSelect)) {
            ps.setString(1, user.getLoginName());
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                value = rs.getInt(1);
            return value;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;

    }

    //ɾ���û�
    public void deleteUser(User user) {
        String sqlDelete = "DELETE FROM user WHERE loginName ='" + user.getLoginName() + "'";
        try (Connection c = SQLConnectUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sqlDelete)) {
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Ǯ����
    public void Money(User user, int money) {
        String sqlReduceOrAdd = "update user set Money = ? where loginName= ? ";
        try (Connection c1 = SQLConnectUtil.getConnection(); PreparedStatement ps = c1.prepareStatement(sqlReduceOrAdd)) {
            ps.setInt(1, selectMoney(user) + money);
            ps.setString(2, user.getLoginName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //��Ǯ
    public int selectMoney(User user) {
        String sqlSelect = "SELECT Money FROM user WHERE loginName= ? ";
        int money = 0;
        try (Connection c1 = SQLConnectUtil.getConnection(); PreparedStatement ps = c1.prepareStatement(sqlSelect)) {
            ps.setString(1, user.getLoginName());
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                money = rs.getInt("Money");
            return money;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return money;
    }

    //������߷���
    public void submitMAXScore(String name, int score) {
        String sqlSelect = "SELECT UserScore from user WHERE loginName = '" + name + "'";
        try (Connection c = SQLConnectUtil.getConnection(); Statement s = c.createStatement()) {
            ResultSet rs = s.executeQuery(sqlSelect);
            while (rs.next()) {
                int oldScore = rs.getInt("UserScore");
                if (oldScore < score) {
                    String sqlSubmit = "update user set UserScore=? where loginName=?";
                    try (Connection c1 = SQLConnectUtil.getConnection(); PreparedStatement ps = c1.prepareStatement(sqlSubmit)) {
                        ps.setInt(1, score);
                        ps.setString(2, name);
                        ps.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //�޸�����
    public void ModifyUserName(String oldName, String newName) {
        String sql = "UPDATE user SET loginName = '" + newName + "' WHERE loginName = '" + oldName + "'";

        try (Connection c = SQLConnectUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        User.user.setLoginName(newName);

    }

    //�޸�����
    public void ModifyUserPassword(String name, String newPassword) {
        String sql = "UPDATE user SET loginPassword = '" + newPassword + "' WHERE loginName = '" + name + "'";

        try (Connection c = SQLConnectUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        User.user.setLoginPassword(newPassword);
    }

    //��ѯ�û�
    public boolean SearchUser(User u) {
        String sql = "select * from user where loginName = '" + u.getLoginName() + "'";
        try (Connection c = SQLConnectUtil.getConnection(); Statement s = c.createStatement()) {
            ResultSet rs = s.executeQuery(sql);
            return rs.next();//����true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //��ѯ����
    public int SearchUserScore(User u) {
        String sql = "select UserScore from user where loginName = '" + u.getLoginName() + "'";
        int Score = 0;
        try (Connection c = SQLConnectUtil.getConnection(); Statement s = c.createStatement()) {
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Score = rs.getInt("UserScore");
            }
            return Score;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    //����
    public void AddUser(User u) {
        String sql = "insert into user (loginName,loginPassword) values(?,?)";
        try (Connection c = SQLConnectUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, u.getLoginName());
            ps.setString(2, u.getLoginPassword());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //��½��֤
    public boolean VerifyUser(User u) {
        String sql = "select * from user where loginName = '" + u.getLoginName() + "' and loginPassword = '" + u.getLoginPassword() + "'";
        try (Connection c = SQLConnectUtil.getConnection(); Statement s = c.createStatement()) {
            ResultSet rs = s.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        //����
        UserDAO us = new UserDAO();



    }
}
