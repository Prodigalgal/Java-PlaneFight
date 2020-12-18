package util;

import java.sql.*;

public class SQLConnectUtil {
    //实现对数据库的连接
    static String database = "users";
    static String encoding  = "UTF-8";
    static String loginName = "root";
    static String passWord = "admin";
    static int port = 3306;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //连接数据库users
    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql://localhost:%d/%s?useUnicode=true&characterEncoding=%s&useSSL=false&serverTimezone = GMT",port,database,encoding);
        return DriverManager.getConnection(url,loginName,passWord);
    }



    public static void main(String[] args) {
        //测试
        try( Connection c = getConnection()) {
            Statement s = c.createStatement();
            String sql = "select * from user";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()) {
                String UserId = rs.getString("UserId");
                String loginName = rs.getString("loginName");
                String loginPassword  = rs.getString("loginPassword");
                int Score = rs.getInt("UserScore");
                System.out.println(UserId+"\n"+loginName+"\n"+loginPassword+"\n"+Score+"\n");
            }
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
