package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.cj.xdevapi.Statement;

public class Test {
    private static Connection conn = null;
	public static Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //�������ݿ���������
            String user = "root";
            String psw = "tianqiong";  //XXXΪ�Լ������ݿ������
            String url = "jdbc:mysql://localhost:3306/project1?useUnicode = true&characterEncoding = utf-8&useSSL = false&serverTimezone = GMT";
            conn = DriverManager.getConnection(url, user, psw);  //��ȡ����
	        //System.out.println("�������ݿ�ɹ�");
        } catch (Exception e) {
            //System.out.println("�������ݿ�ʧ��");
            e.printStackTrace();
        }
        return conn;
    }
}

