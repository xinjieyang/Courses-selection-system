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

//EmployeeOperation�����ڲ������ݿ⣬����ģʽ��
public class Operation {
    private static Operation instance = new Operation();
    
    public static Operation getInstance() {
    	//System.out.println("�ɹ�����һ����¼");
    	return instance;
    }
    
    private Operation() {
    }
    
    public boolean insertStudent(String a,String b,String c,int d,int e,String f) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
        
        	
	        conn = Test.getCon();  //�������ݿ�����
	        //System.out.println(conn);

	        String sqlInset = "insert into project1.student(sid,sname,gender,age,from_year,class)  values(?,?,?,?,?,?)";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setString(1, a);         //����SQL����һ����������ֵ
	        stmt.setString(2, b);    //����SQL���ڶ�����������ֵ
	        stmt.setString(3, c);        //����SQL����������������ֵ
	        stmt.setInt(4, d);     //����SQL�����ĸ���������ֵ
	        stmt.setInt(5, e);     //����SQL���������������ֵ
	        stmt.setString(6, f);        //����SQL����������������ֵ
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
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
	        stmt.setString(1, a);         //����SQL����һ����������ֵ
	        stmt.setString(2, b);    //����SQL���ڶ�����������ֵ
	        stmt.setString(3, c);        //����SQL����������������ֵ
	        stmt.setInt(4, d);     //����SQL�����ĸ���������ֵ
	        stmt.setString(5, e);     //����SQL���������������ֵ
	        stmt.setInt(6, f);        //����SQL����������������ֵ
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
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
	        stmt.setString(1, a);         //����SQL����һ����������ֵ
	        stmt.setString(2, b);    //����SQL���ڶ�����������ֵ
	        stmt.setInt(3, c);        //����SQL����������������ֵ
	        //stmt.setInt(4, d);     //����SQL�����ĸ���������ֵ
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    	return result;
    }
    
    public boolean deleteStudentBySid(String a) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "delete from project1.student where sid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setString(1, a);         //����SQL����һ����������ֵ
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i !=0 ) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    public boolean deleteStudentBySname(String a) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "delete from project1.student where sname=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setString(1, a);         //����SQL����һ����������ֵ
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i != 0 ) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean deleteStudentByGender(String a) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "delete from project1.student where gender=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setString(1, a);         //����SQL����һ����������ֵ
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean deleteStudentByAge(int a) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "delete from project1.student where age=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setInt(1, a);         //����SQL����һ����������ֵ
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean deleteStudentByFrom_year(int a) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "delete from project1.student where from_year=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setInt(1, a);         //����SQL����һ����������ֵ
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    public boolean deleteStudentByClass(String a) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "delete from project1.student where class=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setString(1, a);         //����SQL����һ����������ֵ
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    
    public boolean deleteCourseByCid(String a) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "delete from project1.course where cid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setString(1, a);         //����SQL����һ����������ֵ
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    } 
    
    public boolean deleteCourseByCname(String a) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "delete from project1.course where cname=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setString(1, a);         //����SQL����һ����������ֵ
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    } 

    public boolean deleteCourseByTeacher_name(String a) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "delete from project1.course where teacher_name=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setString(1, a);         //����SQL����һ����������ֵ
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    } 

    public boolean deleteCourseByCredit(int a) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "delete from project1.course where credit=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setInt(1, a);         //����SQL����һ����������ֵ
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    } 

    public boolean deleteCourseByGrade(String a) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "delete from project1.course where grade=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setString(1, a);         //����SQL����һ����������ֵ
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    } 

    public boolean deleteCourseByDelete_year(int a) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "delete from project1.course where delete_year=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setInt(1, a);         //����SQL����һ����������ֵ
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    } 
    
    
    public boolean deleteCatalogBySid(String a) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "delete from project1.catalog where sid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setString(1, a);         //����SQL����һ����������ֵ
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    } 

    public boolean deleteCatalogByCid(String a) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "delete from project1.catalog where cid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setString(1, a);         //����SQL����һ����������ֵ
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i != 0) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    } 

 
    
    public boolean updateSidStudentBySname(String a,String b) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "update project1.student set sid=? where sname=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setString(1, b);         //����SQL����һ����������ֵ
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
   
    public boolean updateSnameStudentBySid(String a,String b) {   //aΪsid,bΪsname
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "update project1.student set sname=? where sid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setString(1, b);         //����SQL����һ����������ֵ
	        stmt.setString(2, a);
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    public boolean updateGenderStudentBySid(String a,String b) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "update project1.student set gender=? where sid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setString(1, b);         //����SQL����һ����������ֵ
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateAgeStudentBySid(String a,int b) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "update project1.student set age=? where sid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	
	        stmt.setInt(1, b);         //����SQL����һ����������ֵ
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateFrom_yearStudentBySid(String a,int b) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "update project1.student set from_year=? where sid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setInt(1, b);         //����SQL����һ����������ֵ
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateClassStudentBySid(String a,String b) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "update project1.student set class=? where sid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setString(1, b);         //����SQL����һ����������ֵ
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    
    public boolean updateCidCourseByCname(String a,String b) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "update project1.course set cid=? where cname=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setString(1, b);         //����SQL����һ����������ֵ
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateCnameCourseByCid(String a,String b) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "update project1.course set cname=? where cid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setString(1, b);         //����SQL����һ����������ֵ
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    public boolean updateTeacher_nameCourseByCid(String a,String b) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "update project1.course set teacher_name=? where cid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setString(1, b);         //����SQL����һ����������ֵ
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateCreditCourseByCid(String a,int b) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "update project1.course set credit=? where cid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setInt(1, b);         //����SQL����һ����������ֵ
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateGradeCourseByCid(String a,String b) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "update project1.course set grade=? where cid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setString(1, b);         //����SQL����һ����������ֵ
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateDelete_yearCourseByCid(String a,int b) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "update project1.course set delete_year=? where cid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setInt(1, b);         //����SQL����һ����������ֵ
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    
    public boolean updateSidCatalogByCid(String a,String b) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "update project1.catalog set sid=? where cid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setString(1, b);         //����SQL����һ����������ֵ
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateCidCatalogBySid(String a,String b) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "update project1.catalog set cid=? where sid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setString(1, b);         //����SQL����һ����������ֵ
	        stmt.setString(2, a); 
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateChoose_yearCatalogById(String a,String b,int c) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "update project1.catalog set choose_year=? where sid=? and cid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setInt(1, c);         //����SQL����һ����������ֵ
	        stmt.setString(2, a); 
	        stmt.setString(3, b); 
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateScoreCatalogById(String a,String b,int c) {   //�����ݿ��м�������
        boolean result = false;
        Connection conn = null;
        try {            
	        conn = Test.getCon();  //�������ݿ�����

	        String sqlInset = "update project1.catalog set score=? where sid=? and cid=?;";
	        PreparedStatement stmt = conn.prepareStatement(sqlInset);   //���׳��쳣
	        
	        stmt.setInt(1, c);         //����SQL����һ����������ֵ
	        stmt.setString(2, a); 
	        stmt.setString(3, b); 
	        int i = stmt.executeUpdate();            //ִ�в������ݲ���������Ӱ�������
	        if (i == 1) {
	            result = true;
	        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
            try {
                conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public void selectStudentBySid(String a) {       //�����ݿ��в�ѯ��������
       	Stage window = new Stage();
        window.setTitle("��ѯ���");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "ѧ��			����		  �Ա�	  ��ѧ����	    ��ѧ���	�༶" + "\n\n";
    	
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "select * from project1.student where sid='"+a + "'";//ִ��SQL�����ؽ����
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //ִ�в�ѯ�����ؽ����  
            ResultSet rs=stmt.executeQuery(sql);
            //ʹ��next�����������������ʹ��getXXX���������ÿ����¼���ֶ�ֵ 
            while(rs.next()){
            s = s + rs.getString(1)+"   	 "+rs.getString(2)+"	  "+rs.getString(3)+
            "		   "+rs.getString(4)+" 	 	   "+rs.getString(5)+"	  	  "+rs.getString(6)+"\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //�ر�����
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s);
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }
    
    public void selectStudentBySname(String a) {       //�����ݿ��в�ѯ��������
       	Stage window = new Stage();
        window.setTitle("��ѯ���");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "ѧ��			����		  �Ա�	  ��ѧ����	    ��ѧ���	�༶" + "\n\n";
    	
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "select * from project1.student where sname = '" + a + "'";//ִ��SQL�����ؽ����
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //ִ�в�ѯ�����ؽ����  
            ResultSet rs=stmt.executeQuery(sql);
            //ʹ��next�����������������ʹ��getXXX���������ÿ����¼���ֶ�ֵ 
            while(rs.next()){
            s = s + rs.getString(1)+"   	 "+rs.getString(2)+"	  "+rs.getString(3)+
            "		   "+rs.getString(4)+" 	 	   "+rs.getString(5)+"	  	  "+rs.getString(6)+"\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //�ر�����
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s);
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
            

    }

    public void selectCatalogBySid(String a) {       //�����ݿ��в�ѯ��������
       	Stage window = new Stage();
        window.setTitle("��ѯ���");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "ѧ��			�γ̱��		ѡ�����	  		�ɼ�" + "\n\n";
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "select * from project1.catalog where sid='"+a + "'";//ִ��SQL�����ؽ����
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //ִ�в�ѯ�����ؽ����  
            ResultSet rs=stmt.executeQuery(sql);
            //ʹ��next�����������������ʹ��getXXX���������ÿ����¼���ֶ�ֵ 
            while(rs.next()){
            s = s + rs.getString(1)+"   	"+rs.getString(2)+"	 	  "+rs.getString(3)+
            "		         "+rs.getString(4) + "\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //�ر�����
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s);
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }
    
    public void selectCatalogBySname(String a) {       //�����ݿ��в�ѯ��������
       	Stage window = new Stage();
        window.setTitle("��ѯ���");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "ѧ��			�γ̱��		ѡ�����	  		�ɼ�" + "\n\n";
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "SELECT * FROM catalog,student where student.sid=catalog.sid and student.sname='"+ a + "'";//ִ��SQL�����ؽ����
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //ִ�в�ѯ�����ؽ����  
            ResultSet rs=stmt.executeQuery(sql);
            //ʹ��next�����������������ʹ��getXXX���������ÿ����¼���ֶ�ֵ 
            while(rs.next()){
            s = s + rs.getString(1)+"   	"+rs.getString(2)+"	 	  "+rs.getString(3)+
            "		         "+rs.getString(4) + "\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //�ر�����
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s);
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();

    }

    public void selectCourseByCid(String a) {       //�����ݿ��в�ѯ��������
       	Stage window = new Stage();
        window.setTitle("��ѯ���");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "�γ̱��  		�γ�����		��ʦ����		ѧ��	  	�γ��ʺ��꼶	    ȡ�����" + "\n\n";
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "select * from project1.course where cid='" +a + "'";//ִ��SQL�����ؽ����
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //ִ�в�ѯ�����ؽ����  
            ResultSet rs=stmt.executeQuery(sql);
            //ʹ��next�����������������ʹ��getXXX���������ÿ����¼���ֶ�ֵ 
            while(rs.next()){
            s = s + rs.getString(1)+"   	  "+rs.getString(2)+"	 	   "+rs.getString(3)+
            "		         "+rs.getString(4)+" 		    "+rs.getString(5)+"	  	  "+rs.getString(6) + "\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //�ر�����
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s);
        StackPane root = new StackPane();//����
        root.getChildren().add(la);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }

    public void selectCourseByCname(String a) {       //�����ݿ��в�ѯ��������
       	Stage window = new Stage();
        window.setTitle("��ѯ���");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "�γ̱��  		�γ�����		��ʦ����		ѧ��	  	�γ��ʺ��꼶	    ȡ�����" + "\n\n";
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "select * from project1.course where cname='" + a + "'";//ִ��SQL�����ؽ����
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //ִ�в�ѯ�����ؽ����  
            ResultSet rs=stmt.executeQuery(sql);
            //ʹ��next�����������������ʹ��getXXX���������ÿ����¼���ֶ�ֵ 
            while(rs.next()){
            s = s + rs.getString(1)+"   	  "+rs.getString(2)+"	 	   "+rs.getString(3)+
            "		         "+rs.getString(4)+" 		    "+rs.getString(5)+"	  	  "+rs.getString(6) + "\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //�ر�����
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s);
        StackPane root = new StackPane();//����
        root.getChildren().add(la);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }

    public void selectCatalogByCid(String a) {       //�����ݿ��в�ѯ��������
       	Stage window = new Stage();
        window.setTitle("��ѯ���");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "ѧ��			�γ̱��		ѡ�����	  		�ɼ�" + "\n\n";
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "select * from project1.catalog where cid='"+a + "'";//ִ��SQL�����ؽ����
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //ִ�в�ѯ�����ؽ����  
            ResultSet rs=stmt.executeQuery(sql);
            //ʹ��next�����������������ʹ��getXXX���������ÿ����¼���ֶ�ֵ 
            while(rs.next()){
            s = s + rs.getString(2)+"   	"+rs.getString(1)+"        "+rs.getString(3)+
            "		         "+rs.getString(4) + "\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //�ر�����
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s); 
        StackPane root = new StackPane();//����
        root.getChildren().add(la);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }
    
    public void selectCatalogByCname(String a) {       //�����ݿ��в�ѯ��������
       	Stage window = new Stage();
        window.setTitle("��ѯ���");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "ѧ��			�γ̱��		ѡ�����	  		�ɼ�" + "\n\n";
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "select * from project1.catalog,course where course.cid=catalog.cid and course.cname='"+a + "'";//ִ��SQL�����ؽ����
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //ִ�в�ѯ�����ؽ����  
            ResultSet rs=stmt.executeQuery(sql);
            //ʹ��next�����������������ʹ��getXXX���������ÿ����¼���ֶ�ֵ 
            while(rs.next()){
            s = s + rs.getString(2)+"   	"+rs.getString(1)+"        "+rs.getString(3)+
            "		         "+rs.getString(4) + "\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //�ر�����
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s); 
        StackPane root = new StackPane();//����
        root.getChildren().add(la);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
            

    }
    
    public void selectScoreBySid(String a) {       //�����ݿ��в�ѯ��������
       	Stage window = new Stage();
        window.setTitle("��ѯ���");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "ѧ��			    �ɼ�" + "\n\n";
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "select sid,avg(score) from catalog where sid ='"+a + "'";//ִ��SQL�����ؽ����
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //ִ�в�ѯ�����ؽ����  
            ResultSet rs=stmt.executeQuery(sql);
            //ʹ��next�����������������ʹ��getXXX���������ÿ����¼���ֶ�ֵ 
            while(rs.next()){
            s = s + rs.getString(1)+"       "+rs.getString(2) + "\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //�ر�����
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s);
        StackPane root = new StackPane();//����
        root.getChildren().add(la);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }

    public void selectScoreBySname(String a) {       //�����ݿ��в�ѯ��������
       	Stage window = new Stage();
        window.setTitle("��ѯ���");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "ѧ��			    �ɼ�" + "\n\n";
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "select c.sid,avg(c.score) from catalog c,student s where s.sid=c.sid and s.sname ='"+ a + "'";//ִ��SQL�����ؽ����
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //ִ�в�ѯ�����ؽ����  
            ResultSet rs=stmt.executeQuery(sql);
            //ʹ��next�����������������ʹ��getXXX���������ÿ����¼���ֶ�ֵ 
            while(rs.next()){
            s = s + rs.getString(1)+"       "+rs.getString(2) + "\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //�ر�����
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s);
        StackPane root = new StackPane();//����
        root.getChildren().add(la);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
            
    }
 
    public void selectScoreBySidAll() {       //�����ݿ��в�ѯ��������
       	Stage window = new Stage();
        window.setTitle("��ѯ���");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "ѧ��			    �ɼ�" + "\n\n";
        Connection conn = null;
        try {
            conn = Test.getCon();
            String sql = "select sid,avg(score) from catalog group by sid";//ִ��SQL�����ؽ����
            PreparedStatement stmt = conn.prepareStatement(sql);  
            //ִ�в�ѯ�����ؽ����  
            ResultSet rs=stmt.executeQuery(sql);
            //ʹ��next�����������������ʹ��getXXX���������ÿ����¼���ֶ�ֵ 
            while(rs.next()){
            s = s + rs.getString(1)+"       "+rs.getString(2) + "\n";
            }     
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //�ر�����
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        la.setText(s);
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();

	}
	    
	
	public void selectScoreByClass(String a) {       //�����ݿ��в�ѯ��������
       	Stage window = new Stage();
        window.setTitle("��ѯ���");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
        String s = "�༶		    ƽ���ɼ�" + "\n\n";
	    Connection conn = null;
	    try {
	        conn = Test.getCon();
	        String sql = "select s.class,avg(c.score) from student s,catalog c where c.sid=s.sid and s.class='"+a + "'";//ִ��SQL�����ؽ����
	        PreparedStatement stmt = conn.prepareStatement(sql);  
	        //ִ�в�ѯ�����ؽ����  
	        ResultSet rs=stmt.executeQuery(sql);
	        //ʹ��next�����������������ʹ��getXXX���������ÿ����¼���ֶ�ֵ 
	        while(rs.next()){
	        s = s + rs.getString(1)+"    		  "+rs.getString(2) + "\n";
	        }     
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.close();                                         //�ر�����
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
        la.setText(s);
        StackPane root = new StackPane();//����
        root.getChildren().add(la);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
	}
	
	public void selectScoreByClassAll() {       //�����ݿ��в�ѯ��������
       	Stage window = new Stage();
        window.setTitle("��ѯ���");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
        String s = "�༶		    ƽ���ɼ�" + "\n\n";
	    Connection conn = null;
	    try {
	        conn = Test.getCon();
	        String sql = "select s.class,avg(c.score) from student s,catalog c where c.sid=s.sid group by class";//ִ��SQL�����ؽ����
	        PreparedStatement stmt = conn.prepareStatement(sql);  
	        //ִ�в�ѯ�����ؽ����  
	        ResultSet rs=stmt.executeQuery(sql);
	        //ʹ��next�����������������ʹ��getXXX���������ÿ����¼���ֶ�ֵ 
	        while(rs.next()){
	        s = s + rs.getString(1)+"    		  "+rs.getString(2) + "\n";
	        }     
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.close();                                         //�ر�����
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
        la.setText(s);
        StackPane root = new StackPane();//����
        root.getChildren().add(la);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();	   
	        

	}
	
	public void selectScoreByCid(String a) {       //�����ݿ��в�ѯ��������
       	Stage window = new Stage();
        window.setTitle("��ѯ���");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "�γ̱��		ƽ���ɼ�" + "\n\n";
	    Connection conn = null;
	    try {
	        conn = Test.getCon();
	        String sql = "select cid,avg(score) from catalog where cid='"+a + "'";//ִ��SQL�����ؽ����
	        PreparedStatement stmt = conn.prepareStatement(sql);  
	        //ִ�в�ѯ�����ؽ����  
	        ResultSet rs=stmt.executeQuery(sql);
	        //ʹ��next�����������������ʹ��getXXX���������ÿ����¼���ֶ�ֵ 
	        while(rs.next()){
	        s = s + rs.getString(1)+"          "+rs.getString(2) + "\n";
	        }     
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.close();                                         //�ر�����
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
        la.setText(s);
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
	}
	
	public void selectScoreByCname(String a) {       //�����ݿ��в�ѯ��������
       	Stage window = new Stage();
        window.setTitle("��ѯ���");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "�γ̱��		ƽ���ɼ�" + "\n\n";
	    Connection conn = null;
	    try {
	        conn = Test.getCon();
	        String sql = "select co.cid,avg(ca.score) from course co,catalog ca where ca.cid=co.cid and co.cname='"+a + "'";//ִ��SQL�����ؽ����
	        PreparedStatement stmt = conn.prepareStatement(sql);  
	        //ִ�в�ѯ�����ؽ����  
	        ResultSet rs=stmt.executeQuery(sql);
	        //ʹ��next�����������������ʹ��getXXX���������ÿ����¼���ֶ�ֵ 
	        while(rs.next()){
	        s = s + rs.getString(1)+"          "+rs.getString(2) + "\n";
	        }     
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.close();                                         //�ر�����
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
        la.setText(s);
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
	        

	}
	
	public void selectScoreByCidAll() {       //�����ݿ��в�ѯ��������
		Stage window = new Stage();
        window.setTitle("��ѯ���");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "�γ̱��		ƽ���ɼ�" + "\n\n";
	    Connection conn = null;
	    try {
	        conn = Test.getCon();
	        String sql = "select co.cid,avg(ca.score) from course co,catalog ca where ca.cid=co.cid group by cid";//ִ��SQL�����ؽ����
	        PreparedStatement stmt = conn.prepareStatement(sql);  
	        //ִ�в�ѯ�����ؽ����  
	        ResultSet rs=stmt.executeQuery(sql);
	        //ʹ��next�����������������ʹ��getXXX���������ÿ����¼���ֶ�ֵ 
	        while(rs.next()){
	        s = s + rs.getString(1)+"          "+rs.getString(2) + "\n";
	        }     
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.close();                                         //�ر�����
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
        la.setText(s);
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
	}
	
	public void selectDistributionByCid(String a) {       //�����ݿ��в�ѯ��������
       	Stage window = new Stage();
        window.setTitle("��ѯ���");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "�γ̱��      ��������      ��60-69��      ��70-79��      ��80-89��      ��90-99��      ����" + "\n\n";
	    Connection conn = null;
	    try {
	        conn = Test.getCon();
	        String sql = "select cid,sum(case when score<60 then 1 else 0 end),sum(case when score>=60  and "
	        		+ "score<70 then 1 else 0 end),sum(case when score>=70  and score<80 then 1 else 0 end) ,"
	        		+ "sum(case when score>=80  and score<90 then 1 else 0 end) ,sum(case when score>=90 and "
	        		+ "score<100 then 1 else 0 end),sum(case when score=100 then 1 else 0 end) "
	        		+ "from catalog where cid='"+a + "'";//ִ��SQL�����ؽ����
	        PreparedStatement stmt = conn.prepareStatement(sql);  
	        //ִ�в�ѯ�����ؽ����  
	        ResultSet rs=stmt.executeQuery(sql);
	        //ʹ��next�����������������ʹ��getXXX���������ÿ����¼���ֶ�ֵ 
	        while(rs.next()){
	        s = s + rs.getString(1)+" 		  "+rs.getString(2)+" 		       "+rs.getString(3)+"    		     "
	        +rs.getString(4)+"      		   "+rs.getString(5)+"  	 	       "+rs.getString(6)+"	     	   "+rs.getString(7) + "\n";
	        }     	
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.close();                                         //�ر�����
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
        la.setText(s);
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
	}
	
	public void selectDistributionByCname(String a) {       //�����ݿ��в�ѯ��������
       	Stage window = new Stage();
        window.setTitle("��ѯ���");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "�γ̱��      ��������      ��60-69��      ��70-79��      ��80-89��      ��90-99��      ����" + "\n\n";
	    Connection conn = null;
	    try {
	        conn = Test.getCon();
	        String sql = "select ca.cid,sum(case when score<60 then 1 else 0 end),sum(case when score>=60  and "
	        		+ "score<70 then 1 else 0 end),sum(case when score>=70  and score<80 then 1 else 0 end) ,"
	        		+ "sum(case when score>=80  and score<90 then 1 else 0 end) ,sum(case when score>=90 and "
	        		+ "score<100 then 1 else 0 end),sum(case when score=100 then 1 else 0 end) "
	        		+ "from catalog ca,course co where ca.cid=co.cid and co.cname='"+a + "'";//ִ��SQL�����ؽ����
	        PreparedStatement stmt = conn.prepareStatement(sql);  
	        //ִ�в�ѯ�����ؽ����  
	        ResultSet rs=stmt.executeQuery(sql);
	        //ʹ��next�����������������ʹ��getXXX���������ÿ����¼���ֶ�ֵ 
	        while(rs.next()){
	        s = s + rs.getString(1)+" 		  "+rs.getString(2)+" 		       "+rs.getString(3)+"    		     "
	        +rs.getString(4)+"      		   "+rs.getString(5)+"  	 	       "+rs.getString(6)+"	     	   "+rs.getString(7) + "\n";
	        }     	
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.close();                                         //�ر�����
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
        la.setText(s);
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
	}
	
	public void selectDistributionByCidAll() {       //�����ݿ��в�ѯ��������
       	Stage window = new Stage();
        window.setTitle("��ѯ���");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "�γ̱��      ��������      ��60-69��      ��70-79��      ��80-89��      ��90-99��      ����" + "\n\n";
	    Connection conn = null;
	    try {
	        conn = Test.getCon();
	        String sql = "select cid,sum(case when score<60 then 1 else 0 end),sum(case when score>=60  and "
	        		+ "score<70 then 1 else 0 end),sum(case when score>=70  and score<80 then 1 else 0 end) ,"
	        		+ "sum(case when score>=80  and score<90 then 1 else 0 end) ,sum(case when score>=90 and "
	        		+ "score<100 then 1 else 0 end),sum(case when score=100 then 1 else 0 end) "
	        		+ "from catalog group by cid";//ִ��SQL�����ؽ����
	        PreparedStatement stmt = conn.prepareStatement(sql);  
	        //ִ�в�ѯ�����ؽ����  
	        ResultSet rs=stmt.executeQuery(sql);
	        //ʹ��next�����������������ʹ��getXXX���������ÿ����¼���ֶ�ֵ 
	        while(rs.next()){
	        s = s + rs.getString(1)+" 		  "+rs.getString(2)+" 		       "+rs.getString(3)+"    		     "
	        +rs.getString(4)+"      		   "+rs.getString(5)+"  	 	       "+rs.getString(6)+"	     	   "+rs.getString(7) + "\n";
	        }     	
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.close();                                         //�ر�����
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
        la.setText(s);
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
	}
	
	public void selectSingleScore(String a,String b,String c,String d) {       //�����ݿ��в�ѯ��������
       	Stage window = new Stage();
        window.setTitle("��ѯ���");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la = new Label();
        la.setTranslateY(-100);
    	String s = "ѧ��			    ����		 �γ̱��		�γ�����		    ����" + "\n\n";
	    Connection conn = null;
	    try {
	        conn = Test.getCon();
	        String sql = "select s.sid,s.sname,c.cid,c.cname,ca.score from student s,course c,catalog ca "
	        		+ "where (s.sid='"+a+"'"+" or s.sname='"+b+"'"+") and (c.cid='"+c+"'"+" or c.cname='"+d+"'"+") and "
	        				+ "ca.cid=c.cid and ca.sid=s.sid";//ִ��SQL�����ؽ����
	        PreparedStatement stmt = conn.prepareStatement(sql);  
	        //ִ�в�ѯ�����ؽ����  
	        ResultSet rs=stmt.executeQuery(sql);
	        //ʹ��next�����������������ʹ��getXXX���������ÿ����¼���ֶ�ֵ 
	        while(rs.next()){
	        s = s + rs.getString(1)+"       "+rs.getString(2)+"           "+rs.getString(3)+"          "
	        +rs.getString(4)+"        		"+rs.getString(5) + "\n";
	        }     
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.close();                                         //�ر�����
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
        la.setText(s);
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la);

        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
	}
	

}

    
    
    
