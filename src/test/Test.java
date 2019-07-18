package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.cj.xdevapi.Statement;

public class Test {
    private static Connection conn = null;
	public static Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //加载数据库连接驱动
            String user = "root";
            String psw = "tianqiong";  //XXX为自己的数据库的密码
            String url = "jdbc:mysql://localhost:3306/project1?useUnicode = true&characterEncoding = utf-8&useSSL = false&serverTimezone = GMT";
            conn = DriverManager.getConnection(url, user, psw);  //获取连接
	        //System.out.println("连接数据库成功");
        } catch (Exception e) {
            //System.out.println("连接数据库失败");
            e.printStackTrace();
        }
        return conn;
    }
}

