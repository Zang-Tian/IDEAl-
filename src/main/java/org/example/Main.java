package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=orcl";
        String userName = "zang";
        String userPwd = "123";

        try {
            // 显式加载 JDBC 驱动程序
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // 建立数据库连接
            con = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("数据库连接成功！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC 驱动程序未找到！");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败！！！");
        } finally {
            // 关闭连接
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}