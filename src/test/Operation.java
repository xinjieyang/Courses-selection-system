package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;

//EmployeeOperation类用于操作数据库，单例模式。
public class Operation {
    private static Operation instance = new Operation();
    
    public static Operation getInstance() {
    	//System.out.println("成功申请一条记录");
    	return instance;
    }
    
    private Operation() {
    }
    
    public boolean insertStudent(String a,String b,String c,int d,int e,String f) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
        
        	
	        conn = Test.getCon();  //建立数据库连接
	        //System.out.println(conn);

	        String sqlInset = "insert into project1.student(sid,sname,gender,age,from_year,class)  values(?,?,?,?,?,?)";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setString(1, a);         //设置SQL语句第一个“？”的值
	        stmt.setString(2, b);    //设置SQL语句第二个“？”的值
	        stmt.setString(3, c);        //设置SQL语句第三个“？”的值
	        stmt.setInt(4, d);     //设置SQL语句第四个“？”的值
	        stmt.setInt(5, e);     //设置SQL语句第五个“？”的值
	        stmt.setString(6, f);        //设置SQL语句第六个“？”的值
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    public boolean insertCourse(String a,String b,String c,int d,String e,int f) {
    	boolean result = false;
    	Connection conn = null;
    	try {
    		conn = Test.getCon();
    		String sqlInsert = "insert into project1.course(cid,cname,teacher_name,credit,grade,delete_year) values(?,?,?,?,?,?);";
    		PreparedStatement stmt = conn.prepareStatement(sqlInsert) ;
	        stmt.setString(1, a);         //设置SQL语句第一个“？”的值
	        stmt.setString(2, b);    //设置SQL语句第二个“？”的值
	        stmt.setString(3, c);        //设置SQL语句第三个“？”的值
	        stmt.setInt(4, d);     //设置SQL语句第四个“？”的值
	        stmt.setString(5, e);     //设置SQL语句第五个“？”的值
	        stmt.setInt(6, f);        //设置SQL语句第六个“？”的值
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    	return result;
    }
    
    public boolean insertCatalog(String a,String b,int c) {
    	boolean result = false;
    	Connection conn = null;
    	try {
    		conn = Test.getCon();
    		String sqlInsert = "insert into project1.catalog(sid,cid,choose_year,score) values(?,?,?,0);";
    		PreparedStatement stmt = conn.prepareStatement(sqlInsert) ;
	        stmt.setString(1, a);         //设置SQL语句第一个“？”的值
	        stmt.setString(2, b);    //设置SQL语句第二个“？”的值
	        stmt.setInt(3, c);        //设置SQL语句第三个“？”的值
	        //stmt.setInt(4, d);     //设置SQL语句第四个“？”的值
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    	return result;
    }
    
    public boolean deleteStudentBySid(String a) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "delete from project1.student where sid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setString(1, a);         //设置SQL语句第一个“？”的值
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i !=0 ) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    public boolean deleteStudentBySname(String a) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "delete from project1.student where sname=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setString(1, a);         //设置SQL语句第一个“？”的值
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i != 0 ) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean deleteStudentByGender(String a) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "delete from project1.student where gender=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setString(1, a);         //设置SQL语句第一个“？”的值
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean deleteStudentByAge(int a) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "delete from project1.student where age=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setInt(1, a);         //设置SQL语句第一个“？”的值
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean deleteStudentByFrom_year(int a) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "delete from project1.student where from_year=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setInt(1, a);         //设置SQL语句第一个“？”的值
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    public boolean deleteStudentByClass(String a) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "delete from project1.student where class=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setString(1, a);         //设置SQL语句第一个“？”的值
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    
    public boolean deleteCourseByCid(String a) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "delete from project1.course where cid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setString(1, a);         //设置SQL语句第一个“？”的值
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    } 
    
    public boolean deleteCourseByCname(String a) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "delete from project1.course where cname=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setString(1, a);         //设置SQL语句第一个“？”的值
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    } 

    public boolean deleteCourseByTeacher_name(String a) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "delete from project1.course where teacher_name=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setString(1, a);         //设置SQL语句第一个“？”的值
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    } 

    public boolean deleteCourseByCredit(int a) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "delete from project1.course where credit=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setInt(1, a);         //设置SQL语句第一个“？”的值
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    } 

    public boolean deleteCourseByGrade(String a) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "delete from project1.course where grade=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setString(1, a);         //设置SQL语句第一个“？”的值
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    } 

    public boolean deleteCourseByDelete_year(int a) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "delete from project1.course where delete_year=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setInt(1, a);         //设置SQL语句第一个“？”的值
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    } 
    
    
    public boolean deleteCatalogBySid(String a) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "delete from project1.catalog where sid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setString(1, a);         //设置SQL语句第一个“？”的值
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    } 

    public boolean deleteCatalogByCid(String a) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "delete from project1.catalog where cid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setString(1, a);         //设置SQL语句第一个“？”的值
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    } 

 
    
    public boolean updateSidStudentBySname(String a,String b) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "update project1.student set sid=? where sname=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setString(1, b);         //设置SQL语句第一个“？”的值
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
   
    public boolean updateSnameStudentBySid(String a,String b) {   //a为sid,b为sname
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "update project1.student set sname=? where sid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setString(1, b);         //设置SQL语句第一个“？”的值
	        stmt.setString(2, a);
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    public boolean updateGenderStudentBySid(String a,String b) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "update project1.student set gender=? where sid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setString(1, b);         //设置SQL语句第一个“？”的值
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateAgeStudentBySid(String a,int b) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "update project1.student set age=? where sid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	
	        stmt.setInt(1, b);         //设置SQL语句第一个“？”的值
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateFrom_yearStudentBySid(String a,int b) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "update project1.student set from_year=? where sid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setInt(1, b);         //设置SQL语句第一个“？”的值
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateClassStudentBySid(String a,String b) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "update project1.student set class=? where sid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setString(1, b);         //设置SQL语句第一个“？”的值
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    
    public boolean updateCidCourseByCname(String a,String b) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "update project1.course set cid=? where cname=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setString(1, b);         //设置SQL语句第一个“？”的值
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateCnameCourseByCid(String a,String b) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "update project1.course set cname=? where cid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setString(1, b);         //设置SQL语句第一个“？”的值
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    public boolean updateTeacher_nameCourseByCid(String a,String b) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "update project1.course set teacher_name=? where cid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setString(1, b);         //设置SQL语句第一个“？”的值
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateCreditCourseByCid(String a,int b) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "update project1.course set credit=? where cid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setInt(1, b);         //设置SQL语句第一个“？”的值
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateGradeCourseByCid(String a,String b) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "update project1.course set grade=? where cid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setString(1, b);         //设置SQL语句第一个“？”的值
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateDelete_yearCourseByCid(String a,int b) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "update project1.course set delete_year=? where cid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setInt(1, b);         //设置SQL语句第一个“？”的值
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    
    public boolean updateSidCatalogByCid(String a,String b) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "update project1.catalog set sid=? where cid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setString(1, b);         //设置SQL语句第一个“？”的值
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateCidCatalogBySid(String a,String b) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "update project1.catalog set cid=? where sid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setString(1, b);         //设置SQL语句第一个“？”的值
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateChoose_yearCatalogById(String a,String b,int c) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "update project1.catalog set choose_year=? where sid=? and cid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setInt(1, c);         //设置SQL语句第一个“？”的值
	        stmt.setString(2, a); 
	        stmt.setString(3, b); 
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateScoreCatalogById(String a,String b,int c) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //建立数据库连接

	        String sqlInset = "update project1.catalog set score=? where sid=? and cid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
	        
	        stmt.setInt(1, c);         //设置SQL语句第一个“？”的值
	        stmt.setString(2, a); 
	        stmt.setString(3, b); 
	        int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public void selectStudentBySid(String a) {       //从数据库中查询所需数据
       	Stage window = new Stage();
        window.setTitle("查询结果");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "学号			姓名		  性别	  入学年龄	    入学年份	班级" + "\n\n";
    	
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "select * from project1.student where sid='"+a + "'";//执行SQL并返回结果集
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //执行查询，返回结果集  
            ResultSet rs=stmt.executeQuery(sql);
            //使用next方法，迭代结果集，使用getXXX方法，获得每条记录的字段值 
            while(rs.next()){
            s = s + rs.getString(1)+"   	 "+rs.getString(2)+"	  "+rs.getString(3)+
            "		   "+rs.getString(4)+" 	 	   "+rs.getString(5)+"	  	  "+rs.getString(6)+"\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s);
        
        StackPane root = new StackPane();//布局
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();
    }
    
    public void selectStudentBySname(String a) {       //从数据库中查询所需数据
       	Stage window = new Stage();
        window.setTitle("查询结果");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "学号			姓名		  性别	  入学年龄	    入学年份	班级" + "\n\n";
    	
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "select * from project1.student where sname = '" + a + "'";//执行SQL并返回结果集
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //执行查询，返回结果集  
            ResultSet rs=stmt.executeQuery(sql);
            //使用next方法，迭代结果集，使用getXXX方法，获得每条记录的字段值 
            while(rs.next()){
            s = s + rs.getString(1)+"   	 "+rs.getString(2)+"	  "+rs.getString(3)+
            "		   "+rs.getString(4)+" 	 	   "+rs.getString(5)+"	  	  "+rs.getString(6)+"\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s);
        
        StackPane root = new StackPane();//布局
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();
            

    }

    public void selectCatalogBySid(String a) {       //从数据库中查询所需数据
       	Stage window = new Stage();
        window.setTitle("查询结果");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "学号			课程编号		选课年份	  		成绩" + "\n\n";
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "select * from project1.catalog where sid='"+a + "'";//执行SQL并返回结果集
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //执行查询，返回结果集  
            ResultSet rs=stmt.executeQuery(sql);
            //使用next方法，迭代结果集，使用getXXX方法，获得每条记录的字段值 
            while(rs.next()){
            s = s + rs.getString(1)+"   	"+rs.getString(2)+"	 	  "+rs.getString(3)+
            "		         "+rs.getString(4) + "\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s);
        
        StackPane root = new StackPane();//布局
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();
    }
    
    public void selectCatalogBySname(String a) {       //从数据库中查询所需数据
       	Stage window = new Stage();
        window.setTitle("查询结果");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "学号			课程编号		选课年份	  		成绩" + "\n\n";
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "SELECT * FROM catalog,student where student.sid=catalog.sid and student.sname='"+ a + "'";//执行SQL并返回结果集
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //执行查询，返回结果集  
            ResultSet rs=stmt.executeQuery(sql);
            //使用next方法，迭代结果集，使用getXXX方法，获得每条记录的字段值 
            while(rs.next()){
            s = s + rs.getString(1)+"   	"+rs.getString(2)+"	 	  "+rs.getString(3)+
            "		         "+rs.getString(4) + "\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s);
        
        StackPane root = new StackPane();//布局
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();

    }

    public void selectCourseByCid(String a) {       //从数据库中查询所需数据
       	Stage window = new Stage();
        window.setTitle("查询结果");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "课程编号  		课程名称		教师名字		学分	  	课程适合年级	    取消年份" + "\n\n";
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "select * from project1.course where cid='" +a + "'";//执行SQL并返回结果集
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //执行查询，返回结果集  
            ResultSet rs=stmt.executeQuery(sql);
            //使用next方法，迭代结果集，使用getXXX方法，获得每条记录的字段值 
            while(rs.next()){
            s = s + rs.getString(1)+"   	  "+rs.getString(2)+"	 	   "+rs.getString(3)+
            "		         "+rs.getString(4)+" 		    "+rs.getString(5)+"	  	  "+rs.getString(6) + "\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s);
        StackPane root = new StackPane();//布局
        root.getChildren().add(la);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();
    }

    public void selectCourseByCname(String a) {       //从数据库中查询所需数据
       	Stage window = new Stage();
        window.setTitle("查询结果");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "课程编号  		课程名称		教师名字		学分	  	课程适合年级	    取消年份" + "\n\n";
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "select * from project1.course where cname='" + a + "'";//执行SQL并返回结果集
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //执行查询，返回结果集  
            ResultSet rs=stmt.executeQuery(sql);
            //使用next方法，迭代结果集，使用getXXX方法，获得每条记录的字段值 
            while(rs.next()){
            s = s + rs.getString(1)+"   	  "+rs.getString(2)+"	 	   "+rs.getString(3)+
            "		         "+rs.getString(4)+" 		    "+rs.getString(5)+"	  	  "+rs.getString(6) + "\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s);
        StackPane root = new StackPane();//布局
        root.getChildren().add(la);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();
    }

    public void selectCatalogByCid(String a) {       //从数据库中查询所需数据
       	Stage window = new Stage();
        window.setTitle("查询结果");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "学号			课程编号		选课年份	  		成绩" + "\n\n";
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "select * from project1.catalog where cid='"+a + "'";//执行SQL并返回结果集
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //执行查询，返回结果集  
            ResultSet rs=stmt.executeQuery(sql);
            //使用next方法，迭代结果集，使用getXXX方法，获得每条记录的字段值 
            while(rs.next()){
            s = s + rs.getString(2)+"   	"+rs.getString(1)+"        "+rs.getString(3)+
            "		         "+rs.getString(4) + "\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s); 
        StackPane root = new StackPane();//布局
        root.getChildren().add(la);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();
    }
    
    public void selectCatalogByCname(String a) {       //从数据库中查询所需数据
       	Stage window = new Stage();
        window.setTitle("查询结果");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "学号			课程编号		选课年份	  		成绩" + "\n\n";
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "select * from project1.catalog,course where course.cid=catalog.cid and course.cname='"+a + "'";//执行SQL并返回结果集
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //执行查询，返回结果集  
            ResultSet rs=stmt.executeQuery(sql);
            //使用next方法，迭代结果集，使用getXXX方法，获得每条记录的字段值 
            while(rs.next()){
            s = s + rs.getString(2)+"   	"+rs.getString(1)+"        "+rs.getString(3)+
            "		         "+rs.getString(4) + "\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s); 
        StackPane root = new StackPane();//布局
        root.getChildren().add(la);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();
            

    }
    
    public void selectScoreBySid(String a) {       //从数据库中查询所需数据
       	Stage window = new Stage();
        window.setTitle("查询结果");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "学号			    成绩" + "\n\n";
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "select sid,avg(score) from catalog where sid ='"+a + "'";//执行SQL并返回结果集
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //执行查询，返回结果集  
            ResultSet rs=stmt.executeQuery(sql);
            //使用next方法，迭代结果集，使用getXXX方法，获得每条记录的字段值 
            while(rs.next()){
            s = s + rs.getString(1)+"       "+rs.getString(2) + "\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s);
        StackPane root = new StackPane();//布局
        root.getChildren().add(la);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();
    }

    public void selectScoreBySname(String a) {       //从数据库中查询所需数据
       	Stage window = new Stage();
        window.setTitle("查询结果");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "学号			    成绩" + "\n\n";
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "select c.sid,avg(c.score) from catalog c,student s where s.sid=c.sid and s.sname ='"+ a + "'";//执行SQL并返回结果集
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //执行查询，返回结果集  
            ResultSet rs=stmt.executeQuery(sql);
            //使用next方法，迭代结果集，使用getXXX方法，获得每条记录的字段值 
            while(rs.next()){
            s = s + rs.getString(1)+"       "+rs.getString(2) + "\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s);
        StackPane root = new StackPane();//布局
        root.getChildren().add(la);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();
            
    }
 
    public void selectScoreBySidAll() {       //从数据库中查询所需数据
       	Stage window = new Stage();
        window.setTitle("查询结果");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "学号			    成绩" + "\n\n";
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "select sid,avg(score) from catalog group by sid";//执行SQL并返回结果集
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //执行查询，返回结果集  
            ResultSet rs=stmt.executeQuery(sql);
            //使用next方法，迭代结果集，使用getXXX方法，获得每条记录的字段值 
            while(rs.next()){
            s = s + rs.getString(1)+"       "+rs.getString(2) + "\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s);
        
        StackPane root = new StackPane();//布局
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();

	}
	    
	
	public void selectScoreByClass(String a) {       //从数据库中查询所需数据
       	Stage window = new Stage();
        window.setTitle("查询结果");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
        String s = "班级		    平均成绩" + "\n\n";
	    Connection conn = null;
	    try {
	        conn = Test.getCon();
	        String sql = "select s.class,avg(c.score) from student s,catalog c where c.sid=s.sid and s.class='"+a + "'";//执行SQL并返回结果集
	        PreparedStatement stmt = conn.prepareStatement(sql);  
	        //执行查询，返回结果集  
	        ResultSet rs=stmt.executeQuery(sql);
	        //使用next方法，迭代结果集，使用getXXX方法，获得每条记录的字段值 
	        while(rs.next()){
	        s = s + rs.getString(1)+"    		  "+rs.getString(2) + "\n";
	        }     
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.close();                                         //关闭连接
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
        la.setText(s);
        StackPane root = new StackPane();//布局
        root.getChildren().add(la);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();
	}
	
	public void selectScoreByClassAll() {       //从数据库中查询所需数据
       	Stage window = new Stage();
        window.setTitle("查询结果");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
        String s = "班级		    平均成绩" + "\n\n";
	    Connection conn = null;
	    try {
	        conn = Test.getCon();
	        String sql = "select s.class,avg(c.score) from student s,catalog c where c.sid=s.sid group by class";//执行SQL并返回结果集
	        PreparedStatement stmt = conn.prepareStatement(sql);  
	        //执行查询，返回结果集  
	        ResultSet rs=stmt.executeQuery(sql);
	        //使用next方法，迭代结果集，使用getXXX方法，获得每条记录的字段值 
	        while(rs.next()){
	        s = s + rs.getString(1)+"    		  "+rs.getString(2) + "\n";
	        }     
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.close();                                         //关闭连接
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
        la.setText(s);
        StackPane root = new StackPane();//布局
        root.getChildren().add(la);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();	   
	        

	}
	
	public void selectScoreByCid(String a) {       //从数据库中查询所需数据
       	Stage window = new Stage();
        window.setTitle("查询结果");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "课程编号		平均成绩" + "\n\n";
	    Connection conn = null;
	    try {
	        conn = Test.getCon();
	        String sql = "select cid,avg(score) from catalog where cid='"+a + "'";//执行SQL并返回结果集
	        PreparedStatement stmt = conn.prepareStatement(sql);  
	        //执行查询，返回结果集  
	        ResultSet rs=stmt.executeQuery(sql);
	        //使用next方法，迭代结果集，使用getXXX方法，获得每条记录的字段值 
	        while(rs.next()){
	        s = s + rs.getString(1)+"          "+rs.getString(2) + "\n";
	        }     
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.close();                                         //关闭连接
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
        la.setText(s);
        
        StackPane root = new StackPane();//布局
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();
	}
	
	public void selectScoreByCname(String a) {       //从数据库中查询所需数据
       	Stage window = new Stage();
        window.setTitle("查询结果");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "课程编号		平均成绩" + "\n\n";
	    Connection conn = null;
	    try {
	        conn = Test.getCon();
	        String sql = "select co.cid,avg(ca.score) from course co,catalog ca where ca.cid=co.cid and co.cname='"+a + "'";//执行SQL并返回结果集
	        PreparedStatement stmt = conn.prepareStatement(sql);  
	        //执行查询，返回结果集  
	        ResultSet rs=stmt.executeQuery(sql);
	        //使用next方法，迭代结果集，使用getXXX方法，获得每条记录的字段值 
	        while(rs.next()){
	        s = s + rs.getString(1)+"          "+rs.getString(2) + "\n";
	        }     
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.close();                                         //关闭连接
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
        la.setText(s);
        
        StackPane root = new StackPane();//布局
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();
	        

	}
	
	public void selectScoreByCidAll() {       //从数据库中查询所需数据
		Stage window = new Stage();
        window.setTitle("查询结果");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "课程编号		平均成绩" + "\n\n";
	    Connection conn = null;
	    try {
	        conn = Test.getCon();
	        String sql = "select co.cid,avg(ca.score) from course co,catalog ca where ca.cid=co.cid group by cid";//执行SQL并返回结果集
	        PreparedStatement stmt = conn.prepareStatement(sql);  
	        //执行查询，返回结果集  
	        ResultSet rs=stmt.executeQuery(sql);
	        //使用next方法，迭代结果集，使用getXXX方法，获得每条记录的字段值 
	        while(rs.next()){
	        s = s + rs.getString(1)+"          "+rs.getString(2) + "\n";
	        }     
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.close();                                         //关闭连接
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
        la.setText(s);
        
        StackPane root = new StackPane();//布局
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();
	}
	
	public void selectDistributionByCid(String a) {       //从数据库中查询所需数据
       	Stage window = new Stage();
        window.setTitle("查询结果");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "课程编号      【不及格】      【60-69】      【70-79】      【80-89】      【90-99】      满分" + "\n\n";
	    Connection conn = null;
	    try {
	        conn = Test.getCon();
	        String sql = "select cid,sum(case when score<60 then 1 else 0 end),sum(case when score>=60  and "
	        		+ "score<70 then 1 else 0 end),sum(case when score>=70  and score<80 then 1 else 0 end) ,"
	        		+ "sum(case when score>=80  and score<90 then 1 else 0 end) ,sum(case when score>=90 and "
	        		+ "score<100 then 1 else 0 end),sum(case when score=100 then 1 else 0 end) "
	        		+ "from catalog where cid='"+a + "'";//执行SQL并返回结果集
	        PreparedStatement stmt = conn.prepareStatement(sql);  
	        //执行查询，返回结果集  
	        ResultSet rs=stmt.executeQuery(sql);
	        //使用next方法，迭代结果集，使用getXXX方法，获得每条记录的字段值 
	        while(rs.next()){
	        s = s + rs.getString(1)+" 		  "+rs.getString(2)+" 		       "+rs.getString(3)+"    		     "
	        +rs.getString(4)+"      		   "+rs.getString(5)+"  	 	       "+rs.getString(6)+"	     	   "+rs.getString(7) + "\n";
	        }     	
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.close();                                         //关闭连接
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
        la.setText(s);
        
        StackPane root = new StackPane();//布局
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();
	}
	
	public void selectDistributionByCname(String a) {       //从数据库中查询所需数据
       	Stage window = new Stage();
        window.setTitle("查询结果");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "课程编号      【不及格】      【60-69】      【70-79】      【80-89】      【90-99】      满分" + "\n\n";
	    Connection conn = null;
	    try {
	        conn = Test.getCon();
	        String sql = "select ca.cid,sum(case when score<60 then 1 else 0 end),sum(case when score>=60  and "
	        		+ "score<70 then 1 else 0 end),sum(case when score>=70  and score<80 then 1 else 0 end) ,"
	        		+ "sum(case when score>=80  and score<90 then 1 else 0 end) ,sum(case when score>=90 and "
	        		+ "score<100 then 1 else 0 end),sum(case when score=100 then 1 else 0 end) "
	        		+ "from catalog ca,course co where ca.cid=co.cid and co.cname='"+a + "'";//执行SQL并返回结果集
	        PreparedStatement stmt = conn.prepareStatement(sql);  
	        //执行查询，返回结果集  
	        ResultSet rs=stmt.executeQuery(sql);
	        //使用next方法，迭代结果集，使用getXXX方法，获得每条记录的字段值 
	        while(rs.next()){
	        s = s + rs.getString(1)+" 		  "+rs.getString(2)+" 		       "+rs.getString(3)+"    		     "
	        +rs.getString(4)+"      		   "+rs.getString(5)+"  	 	       "+rs.getString(6)+"	     	   "+rs.getString(7) + "\n";
	        }     	
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.close();                                         //关闭连接
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
        la.setText(s);
        
        StackPane root = new StackPane();//布局
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();
	}
	
	public void selectDistributionByCidAll() {       //从数据库中查询所需数据
       	Stage window = new Stage();
        window.setTitle("查询结果");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "课程编号      【不及格】      【60-69】      【70-79】      【80-89】      【90-99】      满分" + "\n\n";
	    Connection conn = null;
	    try {
	        conn = Test.getCon();
	        String sql = "select cid,sum(case when score<60 then 1 else 0 end),sum(case when score>=60  and "
	        		+ "score<70 then 1 else 0 end),sum(case when score>=70  and score<80 then 1 else 0 end) ,"
	        		+ "sum(case when score>=80  and score<90 then 1 else 0 end) ,sum(case when score>=90 and "
	        		+ "score<100 then 1 else 0 end),sum(case when score=100 then 1 else 0 end) "
	        		+ "from catalog group by cid";//执行SQL并返回结果集
	        PreparedStatement stmt = conn.prepareStatement(sql);  
	        //执行查询，返回结果集  
	        ResultSet rs=stmt.executeQuery(sql);
	        //使用next方法，迭代结果集，使用getXXX方法，获得每条记录的字段值 
	        while(rs.next()){
	        s = s + rs.getString(1)+" 		  "+rs.getString(2)+" 		       "+rs.getString(3)+"    		     "
	        +rs.getString(4)+"      		   "+rs.getString(5)+"  	 	       "+rs.getString(6)+"	     	   "+rs.getString(7) + "\n";
	        }     	
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.close();                                         //关闭连接
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
        la.setText(s);
        
        StackPane root = new StackPane();//布局
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();
	}
	
	public void selectSingleScore(String a,String b,String c,String d) {       //从数据库中查询所需数据
       	Stage window = new Stage();
        window.setTitle("查询结果");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "学号			    姓名		 课程编号		课程名称		    分数" + "\n\n";
	    Connection conn = null;
	    try {
	        conn = Test.getCon();
	        String sql = "select s.sid,s.sname,c.cid,c.cname,ca.score from student s,course c,catalog ca "
	        		+ "where (s.sid='"+a+"'"+" or s.sname='"+b+"'"+") and (c.cid='"+c+"'"+" or c.cname='"+d+"'"+") and "
	        				+ "ca.cid=c.cid and ca.sid=s.sid";//执行SQL并返回结果集
	        PreparedStatement stmt = conn.prepareStatement(sql);  
	        //执行查询，返回结果集  
	        ResultSet rs=stmt.executeQuery(sql);
	        //使用next方法，迭代结果集，使用getXXX方法，获得每条记录的字段值 
	        while(rs.next()){
	        s = s + rs.getString(1)+"       "+rs.getString(2)+"           "+rs.getString(3)+"          "
	        +rs.getString(4)+"        		"+rs.getString(5) + "\n";
	        }     
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.close();                                         //关闭连接
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
        la.setText(s);
        
        StackPane root = new StackPane();//布局
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();
	}
	

}

    
    
    
