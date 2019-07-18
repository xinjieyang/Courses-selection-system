package test;

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
import javafx.scene.paint.Color;
import javafx.stage.Modality;


public class Ui extends Application {private Stage primaryStage;

//�̳�application���Ի��javaFX�����й��ܡ�

	@Override
    public void start(Stage primaryStage) throws Exception {
		Label la1 = new Label("ѧ��ѡ�μ��ɼ�����ϵͳ");
        Button btn1 = new Button("����");//����,���߶�дһ�� btn1.setText("����");
        Button btn2 = new Button("ɾ��");
        Button btn3 = new Button("��ѯ");
        Button btn4 = new Button("����");
        la1.setTranslateY(-100);
        btn3.setTranslateY(70);//���ð���λ�ã�ƫ������
        btn4.setTranslateY(70);
        btn1.setTranslateX(-100);
        btn2.setTranslateX(100);
        btn3.setTranslateX(-100);
        btn4.setTranslateX(100);
        btn1.setPrefSize(150, 50);//���ð�ť��С
        btn2.setPrefSize(150, 50);
        btn3.setPrefSize(150, 50);
        btn4.setPrefSize(150, 50);
        btn1.setOnAction(this::handle1);//���¼�
        btn2.setOnAction(this::handle2);
        btn3.setOnAction(this::handle3);
        btn4.setOnAction(this::handle4);
        la1.setTextFill(Color.RED);
        String value0 = "-fx-font: 20 arial; -fx-base:#ffffff;";
        String value1 = "-fx-font: 25 arial; -fx-base:#ffffff;";
        la1.setStyle(value1);
        btn1.setStyle(value0);
        btn2.setStyle(value0);
        btn3.setStyle(value0);
        btn4.setStyle(value0);
        StackPane root = new StackPane();//����
        root.getChildren().add(btn1);//����ť����벼��
        root.getChildren().add(btn2);//����ť����벼��
        root.getChildren().add(btn3);//����ť����벼��
        root.getChildren().add(btn4);//����ť����벼��
        root.getChildren().add(la1);
        Scene scene = new Scene(root, 600, 400);//���ò��֡���С
        primaryStage.setTitle("ѧ��ѡ�μ��ɼ�����ϵͳ");//�趨����
        primaryStage.setScene(scene);//��������ӵ�stage
        primaryStage.show();//��ʾstage
        
        
    }
	
    public void handle1(ActionEvent event) {
    	Stage window = new Stage();
        window.setTitle("����");
        //modalityҪʹ��Modality.APPLICATION_MODEL
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
    	Button btn1 = new Button("����ѧ����Ϣ");
    	Button btn2 = new Button("����γ���Ϣ");
    	Button btn3 = new Button("����ѡ����Ϣ");
        btn1.setTranslateY(-100);
        btn3.setTranslateY(100);
	    btn1.setPrefSize(150, 40);//���ð�ť��С
        btn2.setPrefSize(150, 40);
        btn3.setPrefSize(150, 40);
        btn1.setOnAction(this::i1);//���¼�
        btn2.setOnAction(this::i2);
        btn3.setOnAction(this::i3);
        String value1 = "-fx-font: 15 arial; -fx-base:#ffffff;";
        btn1.setStyle(value1);
        btn2.setStyle(value1);
        btn3.setStyle(value1);
        StackPane root = new StackPane();//����
        root.getChildren().add(btn1);//����ť����벼��
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }
    
    public void handle2(ActionEvent event) {
    	Stage window = new Stage();
        window.setTitle("ɾ��");
        //modalityҪʹ��Modality.APPLICATION_MODEL
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
    	Button btn1 = new Button("ɾ��ѧ����Ϣ");
    	Button btn2 = new Button("ɾ���γ���Ϣ");
    	Button btn3 = new Button("ɾ��ѡ����Ϣ");
        btn1.setTranslateY(-100);
        btn3.setTranslateY(100);
	    btn1.setPrefSize(150, 40);//���ð�ť��С
        btn2.setPrefSize(150, 40);
        btn3.setPrefSize(150, 40);
        btn1.setOnAction(this::d1);//���¼�
        btn2.setOnAction(this::d2);
        btn3.setOnAction(this::d3);
        String value1 = "-fx-font: 15 arial; -fx-base:#ffffff;";
        btn1.setStyle(value1);
        btn2.setStyle(value1);
        btn3.setStyle(value1);
        StackPane root = new StackPane();//����
        root.getChildren().add(btn1);//����ť����벼��
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }
    
    public void handle3(ActionEvent event) {
    	Stage window = new Stage();
        window.setTitle("��ѯ");
        //modalityҪʹ��Modality.APPLICATION_MODEL
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
    	Button btn1 = new Button("��ѯѧ��������Ϣ");
    	Button btn2 = new Button("��ѯѧ��ѡ�����");
    	Button btn3 = new Button("��ѯ�γ̻�����Ϣ");
    	Button btn4 = new Button("��ѯ�γ�ѡ�����");
    	Button btn5 = new Button("��ѯѧ��ƽ���ɼ�");
    	Button btn6 = new Button("��ѯ�༶ƽ���ɼ�");
    	Button btn7 = new Button("��ѯ�γ�ƽ���ɼ�");
    	Button btn8 = new Button("��ѯ�γ̳ɼ��ֲ�");
    	Button btn9 = new Button("��ѯѧ�����Ƴɼ�");
        btn1.setTranslateY(-90);
        btn2.setTranslateY(-30);
        btn3.setTranslateY(30);
        btn4.setTranslateY(90);
        btn5.setTranslateY(-120);
        btn6.setTranslateY(-60);
        btn8.setTranslateY(60);
        btn9.setTranslateY(120);
        btn1.setTranslateX(-120);
        btn2.setTranslateX(-120);
        btn3.setTranslateX(-120);
        btn4.setTranslateX(-120);
        btn5.setTranslateX(120);
        btn6.setTranslateX(120);
        btn7.setTranslateX(120);
        btn8.setTranslateX(120);
        btn9.setTranslateX(120);
	    btn1.setPrefSize(150, 30);//���ð�ť��С
        btn2.setPrefSize(150, 30);
        btn3.setPrefSize(150, 30);
        btn4.setPrefSize(150, 30);
        btn5.setPrefSize(150, 30);
        btn6.setPrefSize(150, 30);
        btn7.setPrefSize(150, 30);
        btn8.setPrefSize(150, 30);
        btn9.setPrefSize(150, 30);
        btn1.setOnAction(this::s1);//���¼�
        btn2.setOnAction(this::s2);
        btn3.setOnAction(this::s3);
        btn4.setOnAction(this::s4);
        btn5.setOnAction(this::s5);
        btn6.setOnAction(this::s6);
        btn7.setOnAction(this::s7);
        btn8.setOnAction(this::s8);
        btn9.setOnAction(this::s9);
        String value1 = "-fx-font: 15 arial; -fx-base:#ffffff;";
        btn1.setStyle(value1);
        btn2.setStyle(value1);
        btn3.setStyle(value1);
        btn4.setStyle(value1);
        btn5.setStyle(value1);
        btn6.setStyle(value1);
        btn7.setStyle(value1);
        btn8.setStyle(value1);
        btn9.setStyle(value1);
        StackPane root = new StackPane();//����
        root.getChildren().add(btn1);//����ť����벼��
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        root.getChildren().add(btn4);
        root.getChildren().add(btn5);
        root.getChildren().add(btn6);
        root.getChildren().add(btn7);
        root.getChildren().add(btn8);
        root.getChildren().add(btn9);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }
    
    public void handle4(ActionEvent event) {
    	Stage window = new Stage();
        window.setTitle("ɾ��");
        //modalityҪʹ��Modality.APPLICATION_MODEL
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
    	Button btn1 = new Button("����ѧ����Ϣ");
    	Button btn2 = new Button("���¿γ���Ϣ");
    	Button btn3 = new Button("����ѡ����Ϣ");
        btn1.setTranslateY(-100);
        btn3.setTranslateY(100);
	    btn1.setPrefSize(150, 40);//���ð�ť��С
        btn2.setPrefSize(150, 40);
        btn3.setPrefSize(150, 40);
        btn1.setOnAction(this::u1);//���¼�
        btn2.setOnAction(this::u2);
        btn3.setOnAction(this::u3);
        String value1 = "-fx-font: 15 arial; -fx-base:#ffffff;";
        btn1.setStyle(value1);
        btn2.setStyle(value1);
        btn3.setStyle(value1);
        StackPane root = new StackPane();//����
        root.getChildren().add(btn1);//����ť����벼��
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    
    }
    
    public void i1(ActionEvent event) {
    	Stage window = new Stage();
        window.setTitle("����ѧ����Ϣ");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        StackPane root = new StackPane();//����
        Label la1 = new Label("ѧ�� = ");
        Label la2 = new Label("���� = ");
        Label la3 = new Label("�Ա� = ");
        Label la4 = new Label("��ѧ���� = ");
        Label la5 = new Label("��ѧ��� = ");
        Label la6 = new Label("�༶ = ");
        TextField text1 = new TextField ();
        TextField text2 = new TextField ();
        TextField text3 = new TextField();
        TextField text4 = new TextField();
        TextField text5 = new TextField();
        TextField text6 = new TextField();
        Button btn1 = new Button("����");
        Label la = new Label();
        btn1.setOnAction(e -> {
        boolean res = Operation.getInstance().insertStudent(text1.getText(),text2.getText(),text3.getText(),Integer.parseInt(text4.getText()),Integer.parseInt(text5.getText()),text6.getText());
        if (res == true) {
        	la.setText("����ɹ�");
        	root.getChildren().add(la);
            System.out.println("�������ݳɹ�");
          } else {
          	la.setText("����ʧ��");
          	root.getChildren().add(la);
        	System.out.println("��������ʧ��");
          }
         });

        la1.setTranslateY(-150);
        la2.setTranslateY(-100);
        la3.setTranslateY(-50);
        la5.setTranslateY(50);
        la6.setTranslateY(100);
        text1.setTranslateY(-150);
        text2.setTranslateY(-100);
        text3.setTranslateY(-50);
        text5.setTranslateY(50);
        text6.setTranslateY(100);
        text1.setTranslateX(100);
        text2.setTranslateX(100);
        text3.setTranslateX(100);
        text4.setTranslateX(100);
        text5.setTranslateX(100);
        text6.setTranslateX(100);
        la.setTranslateX(-100);
        btn1.setTranslateY(150);
        text1.setMaxWidth(100);
        text2.setMaxWidth(100);
        text3.setMaxWidth(100);
        text4.setMaxWidth(100);
        text5.setMaxWidth(100);
        text6.setMaxWidth(100);
        String value1 = "-fx-font: 25 arial; -fx-base:#ffffff;";
        la.setStyle(value1);
        la.setTextFill(Color.RED);
        root.getChildren().add(la1);//����ť����벼��
        root.getChildren().add(la2);
        root.getChildren().add(la3);
        root.getChildren().add(la4);
        root.getChildren().add(la5);
        root.getChildren().add(la6);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(text3);
        root.getChildren().add(text4);
        root.getChildren().add(text5);
        root.getChildren().add(text6);
        root.getChildren().add(btn1);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }
    
    public void i2(ActionEvent event) {
    	Stage window = new Stage();
        window.setTitle("����γ���Ϣ");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la1 = new Label("�γ̱�� = ");
        Label la2 = new Label("�γ����� = ");
        Label la3 = new Label("�̿ν�ʦ���� = ");
        Label la4 = new Label("ѧ�� = ");
        Label la5 = new Label("�γ��ʺ��꼶 = ");
        Label la6 = new Label("ȡ����� = ");
        TextField text1 = new TextField ();
        TextField text2 = new TextField ();
        TextField text3 = new TextField();
        TextField text4 = new TextField();
        TextField text5 = new TextField();
        TextField text6 = new TextField();
        Button btn1 = new Button("����");
        btn1.setOnAction(e -> {
        boolean res = Operation.getInstance().insertCourse(text1.getText(),text2.getText(),text3.getText(),Integer.parseInt(text4.getText()),text5.getText(),Integer.parseInt(text6.getText()));
          if (res == true) {
              System.out.println("�������ݳɹ�");
          } else {
              System.out.println("��������ʧ��");
          }
         });
        
        //text1.setPreSize(1,1);
        la1.setTranslateY(-150);
        la2.setTranslateY(-100);
        la3.setTranslateY(-50);
        la5.setTranslateY(50);
        la6.setTranslateY(100);
        text1.setTranslateY(-150);
        text2.setTranslateY(-100);
        text3.setTranslateY(-50);
        text5.setTranslateY(50);
        text6.setTranslateY(100);
        text1.setTranslateX(100);
        text2.setTranslateX(100);
        text3.setTranslateX(100);
        text4.setTranslateX(100);
        text5.setTranslateX(100);
        text6.setTranslateX(100);
        btn1.setTranslateY(150);
        text1.setMaxWidth(100);
        text2.setMaxWidth(100);
        text3.setMaxWidth(100);
        text4.setMaxWidth(100);
        text5.setMaxWidth(100);
        text6.setMaxWidth(100);
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la1);//����ť����벼��
        root.getChildren().add(la2);
        root.getChildren().add(la3);
        root.getChildren().add(la4);
        root.getChildren().add(la5);
        root.getChildren().add(la6);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(text3);
        root.getChildren().add(text4);
        root.getChildren().add(text5);
        root.getChildren().add(text6);
        root.getChildren().add(btn1);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }
    
    public void i3(ActionEvent event) {
    	Stage window = new Stage();
        window.setTitle("����ѡ����Ϣ");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la1 = new Label("ѧ�� = ");
        Label la2 = new Label("�γ̱�� = ");
        Label la3 = new Label("ѡ����� = ");
        //Label la4 = new Label("�ɼ� = ");
        TextField text1 = new TextField ();
        TextField text2 = new TextField ();
        TextField text3 = new TextField();
        //TextField text4 = new TextField();
        Button btn1 = new Button("����");
        btn1.setOnAction(e -> {
        boolean res = Operation.getInstance().insertCatalog(text1.getText(),text2.getText(),Integer.parseInt(text3.getText()));
          if (res == true) {
              System.out.println("�������ݳɹ�");
          } else {
              System.out.println("��������ʧ��");
          }
         });
        la1.setTranslateY(-100);
        la2.setTranslateY(-50);
        //la4.setTranslateY(50);
        text1.setTranslateY(-100);
        text2.setTranslateY(-50);
        //text4.setTranslateY(50);
        text1.setTranslateX(100);
        text2.setTranslateX(100);
        text3.setTranslateX(100);
        //text4.setTranslateX(100);
        btn1.setTranslateY(130);
        text1.setMaxWidth(100);
        text2.setMaxWidth(100);
        text3.setMaxWidth(100);
        //text4.setMaxWidth(100);
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la1);//����ť����벼��
        root.getChildren().add(la2);
        root.getChildren().add(la3);
        //root.getChildren().add(la4);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(text3);
        //root.getChildren().add(text4);
        root.getChildren().add(btn1);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }

    public void d1(ActionEvent event) {
    	Stage window = new Stage();
        window.setTitle("ɾ��ѧ����Ϣ");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la1 = new Label("ѧ�� = ");
        Label la2 = new Label("���� = ");
        Label la3 = new Label("�Ա� = ");
        Label la4 = new Label("��ѧ���� = ");
        Label la5 = new Label("��ѧ��� = ");
        Label la6 = new Label("�༶ = ");
        TextField text1 = new TextField ();
        TextField text2 = new TextField ();
        TextField text3 = new TextField();
        TextField text4 = new TextField();
        TextField text5 = new TextField();
        TextField text6 = new TextField();
        Button btn1 = new Button("ɾ��");
        Button btn2 = new Button("ɾ��");
        Button btn3 = new Button("ɾ��");
        Button btn4 = new Button("ɾ��");
        Button btn5 = new Button("ɾ��");
        Button btn6 = new Button("ɾ��");
        btn1.setOnAction(e -> {
        boolean res = Operation.getInstance().deleteStudentBySid(text1.getText());
        	if (res == true) {
              System.out.println("ɾ�����ݳɹ�");
          } else {
              System.out.println("ɾ������ʧ��");
          }
         });
        btn2.setOnAction(e -> {
        boolean res = Operation.getInstance().deleteStudentBySname(text2.getText());
        	if (res == true) {
              System.out.println("ɾ�����ݳɹ�");
          } else {
              System.out.println("ɾ������ʧ��");
          }
         });
        btn3.setOnAction(e -> {
        boolean res = Operation.getInstance().deleteStudentByGender(text3.getText());
        	if (res == true) {
              System.out.println("ɾ�����ݳɹ�");
          } else {
              System.out.println("ɾ������ʧ��");
          }
         });
        btn4.setOnAction(e -> {
        boolean res = Operation.getInstance().deleteStudentByAge(Integer.parseInt(text4.getText()));
        	if (res == true) {
              System.out.println("ɾ�����ݳɹ�");
          } else {
              System.out.println("ɾ������ʧ��");
          }
         });
        btn5.setOnAction(e -> {
        boolean res = Operation.getInstance().deleteStudentByFrom_year(Integer.parseInt(text5.getText()));
        	if (res == true) {
              System.out.println("ɾ�����ݳɹ�");
          } else {
              System.out.println("ɾ������ʧ��");
          }
         });
        btn6.setOnAction(e -> {
        boolean res = Operation.getInstance().deleteStudentByClass(text6.getText());
        	if (res == true) {
              System.out.println("ɾ�����ݳɹ�");
          } else {
              System.out.println("ɾ������ʧ��");
          }
         });

        la1.setTranslateY(-150);
        la2.setTranslateY(-100);
        la3.setTranslateY(-50);
        la5.setTranslateY(50);
        la6.setTranslateY(100);
        text1.setTranslateY(-150);
        text2.setTranslateY(-100);
        text3.setTranslateY(-50);
        text5.setTranslateY(50);
        text6.setTranslateY(100);
        text1.setTranslateX(100);
        text2.setTranslateX(100);
        text3.setTranslateX(100);
        text4.setTranslateX(100);
        text5.setTranslateX(100);
        text6.setTranslateX(100);
        btn1.setTranslateX(150);
        btn2.setTranslateX(150);
        btn3.setTranslateX(150);
        btn4.setTranslateX(150);
        btn5.setTranslateX(150);
        btn6.setTranslateX(150);
        btn1.setTranslateY(-150);
        btn2.setTranslateY(-100);
        btn3.setTranslateY(-50);
        btn5.setTranslateY(50);
        btn6.setTranslateY(100);
        text1.setMaxWidth(100);
        text2.setMaxWidth(100);
        text3.setMaxWidth(100);
        text4.setMaxWidth(100);
        text5.setMaxWidth(100);
        text6.setMaxWidth(100);
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la1);//����ť����벼��
        root.getChildren().add(la2);
        root.getChildren().add(la3);
        root.getChildren().add(la4);
        root.getChildren().add(la5);
        root.getChildren().add(la6);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(text3);
        root.getChildren().add(text4);
        root.getChildren().add(text5);
        root.getChildren().add(text6);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        root.getChildren().add(btn4);
        root.getChildren().add(btn5);
        root.getChildren().add(btn6);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }
    
    public void d2(ActionEvent event) {
    	Stage window = new Stage();
        window.setTitle("ɾ���γ���Ϣ");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la1 = new Label("�γ̱�� = ");
        Label la2 = new Label("�γ����� = ");
        Label la3 = new Label("�̿ν�ʦ���� = ");
        Label la4 = new Label("ѧ�� = ");
        Label la5 = new Label("�γ��ʺ��꼶 = ");
        Label la6 = new Label("ȡ����� = ");
        TextField text1 = new TextField ();
        TextField text2 = new TextField ();
        TextField text3 = new TextField();
        TextField text4 = new TextField();
        TextField text5 = new TextField();
        TextField text6 = new TextField();
        Button btn1 = new Button("ɾ��");
        Button btn2 = new Button("ɾ��");
        Button btn3 = new Button("ɾ��");
        Button btn4 = new Button("ɾ��");
        Button btn5 = new Button("ɾ��");
        Button btn6 = new Button("ɾ��");
        btn1.setOnAction(e -> {
        boolean res = Operation.getInstance().deleteCourseByCid(text1.getText());
        	if (res == true) {
              System.out.println("ɾ�����ݳɹ�");
          } else {
              System.out.println("ɾ������ʧ��");
          }
         });
        btn2.setOnAction(e -> {
        boolean res = Operation.getInstance().deleteCourseByCname(text2.getText());
        	if (res == true) {
              System.out.println("ɾ�����ݳɹ�");
          } else {
              System.out.println("ɾ������ʧ��");
          }
         });
        btn3.setOnAction(e -> {
        boolean res = Operation.getInstance().deleteCourseByTeacher_name(text3.getText());
        	if (res == true) {
              System.out.println("ɾ�����ݳɹ�");
          } else {
              System.out.println("ɾ������ʧ��");
          }
         });
        btn4.setOnAction(e -> {
        boolean res = Operation.getInstance().deleteCourseByCredit(Integer.parseInt(text4.getText()));
        	if (res == true) {
              System.out.println("ɾ�����ݳɹ�");
          } else {
              System.out.println("ɾ������ʧ��");
          }
         });
        btn5.setOnAction(e -> {
        boolean res = Operation.getInstance().deleteCourseByGrade(text5.getText());
        	if (res == true) {
              System.out.println("ɾ�����ݳɹ�");
          } else {
              System.out.println("ɾ������ʧ��");
          }
         });
        btn6.setOnAction(e -> {
        boolean res = Operation.getInstance().deleteCourseByDelete_year(Integer.parseInt(text6.getText()));
        	if (res == true) {
              System.out.println("ɾ�����ݳɹ�");
          } else {
              System.out.println("ɾ������ʧ��");
          }
         });
        
        //text1.setPreSize(1,1);
        la1.setTranslateY(-150);
        la2.setTranslateY(-100);
        la3.setTranslateY(-50);
        la5.setTranslateY(50);
        la6.setTranslateY(100);
        text1.setTranslateY(-150);
        text2.setTranslateY(-100);
        text3.setTranslateY(-50);
        text5.setTranslateY(50);
        text6.setTranslateY(100);
        text1.setTranslateX(100);
        text2.setTranslateX(100);
        text3.setTranslateX(100);
        text4.setTranslateX(100);
        text5.setTranslateX(100);
        text6.setTranslateX(100);
        btn1.setTranslateX(150);
        btn2.setTranslateX(150);
        btn3.setTranslateX(150);
        btn4.setTranslateX(150);
        btn5.setTranslateX(150);
        btn6.setTranslateX(150);
        btn1.setTranslateY(-150);
        btn2.setTranslateY(-100);
        btn3.setTranslateY(-50);
        btn5.setTranslateY(50);
        btn6.setTranslateY(100);
        text1.setMaxWidth(100);
        text2.setMaxWidth(100);
        text3.setMaxWidth(100);
        text4.setMaxWidth(100);
        text5.setMaxWidth(100);
        text6.setMaxWidth(100);
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la1);//����ť����벼��
        root.getChildren().add(la2);
        root.getChildren().add(la3);
        root.getChildren().add(la4);
        root.getChildren().add(la5);
        root.getChildren().add(la6);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(text3);
        root.getChildren().add(text4);
        root.getChildren().add(text5);
        root.getChildren().add(text6);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        root.getChildren().add(btn4);
        root.getChildren().add(btn5);
        root.getChildren().add(btn6);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }

    public void d3(ActionEvent event) {
    	Stage window = new Stage();
        window.setTitle("ɾ��ѡ����Ϣ");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la1 = new Label("ѧ�� = ");
        Label la2 = new Label("�γ̱�� = ");
        TextField text1 = new TextField ();
        TextField text2 = new TextField ();
        Button btn1 = new Button("ɾ��");
        Button btn2 = new Button("ɾ��");
        btn1.setOnAction(e -> {
        boolean res = Operation.getInstance().deleteCatalogBySid(text1.getText());
        	if (res == true) {
              System.out.println("ɾ�����ݳɹ�");
          } else {
              System.out.println("ɾ������ʧ��");
          }
         });
        btn2.setOnAction(e -> {
        boolean res = Operation.getInstance().deleteCatalogByCid(text2.getText());
        	if (res == true) {
              System.out.println("ɾ�����ݳɹ�");
          } else {
              System.out.println("ɾ������ʧ��");
          }
         });


        la1.setTranslateY(-50);
        la2.setTranslateY(50);
        text1.setTranslateY(-50);
        text2.setTranslateY(50);
        text1.setTranslateX(100);
        text2.setTranslateX(100);
        btn1.setTranslateX(150);
        btn2.setTranslateX(150);
        btn1.setTranslateY(-50);
        btn2.setTranslateY(50);
        text1.setMaxWidth(100);
        text2.setMaxWidth(100);
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la1);//����ť����벼��
        root.getChildren().add(la2);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }

    public void s1(ActionEvent event) {
    	Stage window = new Stage();
        window.setTitle("��ѯѧ��������Ϣ");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la1 = new Label("ѧ�� = ");
        Label la2 = new Label("���� = ");
        TextField text1 = new TextField ();
        TextField text2 = new TextField ();
        Button btn1 = new Button("��ѯ");
        Button btn2 = new Button("��ѯ");
        
        la1.setTranslateX(-90);
        la1.setTranslateY(-40);
        la2.setTranslateX(-90);
        la2.setTranslateY(40);
        text1.setTranslateX(20);
        text1.setTranslateY(-40);
        text2.setTranslateX(20);
        text2.setTranslateY(40);
        btn1.setTranslateX(100);
        btn1.setTranslateY(-40);
        btn2.setTranslateX(100);
        btn2.setTranslateY(40);
        
        text1.setMaxWidth(100);
        text2.setMaxWidth(100);
        
        btn1.setOnAction(e -> {
        	Operation.getInstance().selectStudentBySid(text1.getText());
        });
        
        btn2.setOnAction(e -> {
        	Operation.getInstance().selectStudentBySname(text2.getText());
        });
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la1);
        root.getChildren().add(la2);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }
    
	public void s2(ActionEvent event) {
    	Stage window = new Stage();
        window.setTitle("��ѯѧ��ѡ�����");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la1 = new Label("ѧ�� = ");
        Label la2 = new Label("���� = ");
        TextField text1 = new TextField ();
        TextField text2 = new TextField ();
        Button btn1 = new Button("��ѯ");
        Button btn2 = new Button("��ѯ");
        
        la1.setTranslateX(-90);
        la1.setTranslateY(-40);
        la2.setTranslateX(-90);
        la2.setTranslateY(40);
        text1.setTranslateX(20);
        text1.setTranslateY(-40);
        text2.setTranslateX(20);
        text2.setTranslateY(40);
        btn1.setTranslateX(100);
        btn1.setTranslateY(-40);
        btn2.setTranslateX(100);
        btn2.setTranslateY(40);
        
        text1.setMaxWidth(100);
        text2.setMaxWidth(100);
        
        btn1.setOnAction(e -> {
        	Operation.getInstance().selectCatalogBySid(text1.getText());
        });
        
        btn2.setOnAction(e -> {
        	Operation.getInstance().selectCatalogBySname(text2.getText());
        });

        StackPane root = new StackPane();//����
        root.getChildren().add(la1);
        root.getChildren().add(la2);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();	
    }
    
    public void s3(ActionEvent event) {
    	Stage window = new Stage();
        window.setTitle("��ѯ�γ���Ϣ");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la1 = new Label("�γ̱�� = ");
        Label la2 = new Label("�γ����� = ");
        TextField text1 = new TextField ();
        TextField text2 = new TextField ();
        Button btn1 = new Button("��ѯ");
        Button btn2 = new Button("��ѯ");
        
        la1.setTranslateX(-90);
        la1.setTranslateY(-40);
        la2.setTranslateX(-90);
        la2.setTranslateY(40);
        text1.setTranslateX(20);
        text1.setTranslateY(-40);
        text2.setTranslateX(20);
        text2.setTranslateY(40);
        btn1.setTranslateX(100);
        btn1.setTranslateY(-40);
        btn2.setTranslateX(100);
        btn2.setTranslateY(40);
        
        text1.setMaxWidth(100);
        text2.setMaxWidth(100);
        
        btn1.setOnAction(e -> {
        	Operation.getInstance().selectCourseByCid(text1.getText());
        });
        
        btn2.setOnAction(e -> {
        	Operation.getInstance().selectCourseByCname(text2.getText());
        });

        StackPane root = new StackPane();//����
        root.getChildren().add(la1);
        root.getChildren().add(la2);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();	
    }
    
    public void s4(ActionEvent event) {
    	Stage window = new Stage();
        window.setTitle("��ѯ�γ�ѡ�����");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la1 = new Label("�γ̱�� = ");
        Label la2 = new Label("�γ����� = ");
        TextField text1 = new TextField ();
        TextField text2 = new TextField ();
        Button btn1 = new Button("��ѯ");
        Button btn2 = new Button("��ѯ");
        
        la1.setTranslateX(-90);
        la1.setTranslateY(-40);
        la2.setTranslateX(-90);
        la2.setTranslateY(40);
        text1.setTranslateX(20);
        text1.setTranslateY(-40);
        text2.setTranslateX(20);
        text2.setTranslateY(40);
        btn1.setTranslateX(100);
        btn1.setTranslateY(-40);
        btn2.setTranslateX(100);
        btn2.setTranslateY(40);
        
        text1.setMaxWidth(100);
        text2.setMaxWidth(100);
        
        btn1.setOnAction(e -> {
        	Operation.getInstance().selectCatalogByCid(text1.getText());
        });
        
        btn2.setOnAction(e -> {
        	Operation.getInstance().selectCatalogByCname(text2.getText());
        });
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la1);
        root.getChildren().add(la2);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }
    
    public void s5(ActionEvent event) {
    	Stage window = new Stage();
        window.setTitle("��ѯѧ��ƽ���ɼ�");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la1 = new Label("ѧ�� = ");
        Label la2 = new Label("����  = ");
        TextField text1 = new TextField ();
        TextField text2 = new TextField ();
        Button btn1 = new Button("��ѯ");
        Button btn2 = new Button("��ѯ");
        Button btn3 = new Button("��ѯ����");
        la1.setTranslateX(-90);
        la1.setTranslateY(-40);
        la2.setTranslateX(-90);
        la2.setTranslateY(40);
        text1.setTranslateX(20);
        text1.setTranslateY(-40);
        text2.setTranslateX(20);
        text2.setTranslateY(40);
        btn1.setTranslateX(100);
        btn1.setTranslateY(-40);
        btn2.setTranslateX(100);
        btn2.setTranslateY(40);
        btn3.setTranslateY(100);
        text1.setMaxWidth(100);
        text2.setMaxWidth(100);
        
        btn1.setOnAction(e -> {
        	Operation.getInstance().selectScoreBySid(text1.getText());
        });
        
        btn2.setOnAction(e -> {
        	Operation.getInstance().selectScoreBySname(text2.getText());
        });
        btn3.setOnAction(e -> {
        	Operation.getInstance().selectScoreBySidAll();
        });
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la1);
        root.getChildren().add(la2);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }
    
    public void s6(ActionEvent event) {
    	Stage window = new Stage();
        window.setTitle("��ѯ�༶ƽ���ɼ�");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la1 = new Label("�༶ = ");
        TextField text1 = new TextField ();
        Button btn1 = new Button("��ѯ");
        Button btn2 = new Button("��ѯ����");
        la1.setTranslateX(-90);
        text1.setTranslateX(20);
        btn1.setTranslateX(100);    
        text1.setMaxWidth(100);
        btn2.setTranslateY(50); 
        
        btn1.setOnAction(e -> {
        	Operation.getInstance().selectScoreByClass(text1.getText());
        });
        btn2.setOnAction(e -> {
        	Operation.getInstance().selectScoreByClassAll();
        });
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la1);
        root.getChildren().add(text1);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }
    
    public void s7(ActionEvent event) {
    	Stage window = new Stage();
        window.setTitle("��ѯ�γ�ƽ���ɼ�");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la1 = new Label("�γ̱�� = ");
        Label la2 = new Label("�γ����� = ");
        TextField text1 = new TextField ();
        TextField text2 = new TextField ();
        Button btn1 = new Button("��ѯ");
        Button btn2 = new Button("��ѯ");
        Button btn3 = new Button("��ѯ����");
        la1.setTranslateX(-90);
        la1.setTranslateY(-40);
        la2.setTranslateX(-90);
        la2.setTranslateY(40);
        text1.setTranslateX(20);
        text1.setTranslateY(-40);
        text2.setTranslateX(20);
        text2.setTranslateY(40);
        btn1.setTranslateX(100);
        btn1.setTranslateY(-40);
        btn2.setTranslateX(100);
        btn2.setTranslateY(40);
        btn3.setTranslateY(100);
        text1.setMaxWidth(100);
        text2.setMaxWidth(100);
        
        btn1.setOnAction(e -> {
        	Operation.getInstance().selectScoreByCid(text1.getText());
        });
        
        btn2.setOnAction(e -> {
        	Operation.getInstance().selectScoreByCname(text2.getText());
        });
        btn3.setOnAction(e -> {
        	Operation.getInstance().selectScoreByCidAll();
        });
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la1);
        root.getChildren().add(la2);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }
    
    public void s8(ActionEvent event) {
    	Stage window = new Stage();
        window.setTitle("��ѯ�γ̳ɼ��ֲ�");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la1 = new Label("�γ̱�� = ");
        Label la2 = new Label("�γ����� = ");
        TextField text1 = new TextField ();
        TextField text2 = new TextField ();
        Button btn1 = new Button("��ѯ");
        Button btn2 = new Button("��ѯ");
        Button btn3 = new Button("��ѯ����");
        la1.setTranslateX(-90);
        la1.setTranslateY(-40);
        la2.setTranslateX(-90);
        la2.setTranslateY(40);
        text1.setTranslateX(20);
        text1.setTranslateY(-40);
        text2.setTranslateX(20);
        text2.setTranslateY(40);
        btn1.setTranslateX(100);
        btn1.setTranslateY(-40);
        btn2.setTranslateX(100);
        btn2.setTranslateY(40);
        btn3.setTranslateY(100);
        text1.setMaxWidth(100);
        text2.setMaxWidth(100);
        
        btn1.setOnAction(e -> {
        	Operation.getInstance().selectDistributionByCid(text1.getText());
        });
        
        btn2.setOnAction(e -> {
        	Operation.getInstance().selectDistributionByCname(text2.getText());
        });
        btn3.setOnAction(e -> {
        	Operation.getInstance().selectDistributionByCidAll();
        });
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la1);
        root.getChildren().add(la2);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }
    
    public void s9(ActionEvent event) {
       	Stage window = new Stage();
        window.setTitle("��ѯѧ�����Ƴɼ�");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la1 = new Label("ѧ�� = ");
        Label la2 = new Label("���� = ");
        Label la3 = new Label("�γ̱�� = ");
        Label la4 = new Label("�γ����� = ");
        TextField text1 = new TextField ();
        TextField text2 = new TextField ();
        TextField text3 = new TextField ();
        TextField text4 = new TextField ();
        Button btn1 = new Button("��ѯ");

        la1.setTranslateX(-150);
        la2.setTranslateX(50);  
        la3.setTranslateX(-150);   
        la4.setTranslateX(50);   
        text1.setTranslateX(-70); 
        text2.setTranslateX(130);  
        text3.setTranslateX(-70); 
        text4.setTranslateX(130); 

        la1.setTranslateY(-50);
        la2.setTranslateY(-50);
        la3.setTranslateY(40);
        la4.setTranslateY(40);
        text1.setTranslateY(-50);
        text2.setTranslateY(-50);
        text3.setTranslateY(40);
        text4.setTranslateY(40);
        btn1.setTranslateY(100);

        text1.setMaxWidth(100);
        text2.setMaxWidth(100);
        text3.setMaxWidth(100);
        text4.setMaxWidth(100);
        
        btn1.setOnAction(e -> {
            if(text1.getText()==null)
            	text1.setText("-1");
            if(text2.getText()==null)
            	text2.setText("-1");
            if(text3.getText()==null)
            	text3.setText("-1");
            if(text4.getText()==null)
            	text4.setText("-1");
        	
        	Operation.getInstance().selectSingleScore(text1.getText(),text2.getText(),text3.getText(),text4.getText());
        });
        
        
        StackPane root = new StackPane();//����
        root.getChildren().add(la1);
        root.getChildren().add(la2);
        root.getChildren().add(la3);
        root.getChildren().add(la4);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(text3);
        root.getChildren().add(text4);
        root.getChildren().add(btn1);
      
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    }
     
    public void u1(ActionEvent event) {
    	Stage window = new Stage();
        window.setTitle("����ѧ����Ϣ");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la00 = new Label("[����ѧ��]");
        Label la01 = new Label("[����������Ϣ]");
        Label la1 = new Label("���� = ");
        Label la2 = new Label("��ѧ�Ÿ�Ϊ�� ");
        Label la3 = new Label("ѧ�� = ");
        Label la4 = new Label("��������Ϊ�� ");
        Label la5 = new Label("���Ա��Ϊ�� ");
        Label la6 = new Label("����ѧ�����Ϊ�� ");
        Label la7 = new Label("����ѧ��ݸ�Ϊ�� ");
        Label la8 = new Label("���༶��Ϊ�� ");
        TextField text1 = new TextField ();
        TextField text2 = new TextField ();
        TextField text3 = new TextField();
        TextField text4 = new TextField();
        TextField text5 = new TextField();
        TextField text6 = new TextField();
        TextField text7 = new TextField();
        TextField text8 = new TextField();
        Button btn1 = new Button("�޸�");
        Button btn2 = new Button("�޸�");
        Button btn3 = new Button("�޸�");
        Button btn4 = new Button("�޸�");
        Button btn5 = new Button("�޸�");
        Button btn6 = new Button("�޸�");
        btn1.setOnAction(e -> {
        boolean res = Operation.getInstance().updateSidStudentBySname(text1.getText(),text2.getText());
          if (res == true) {
              System.out.println("�޸����ݳɹ�");
          } else {
              System.out.println("�޸�����ʧ��");
          }
         });
        btn2.setOnAction(e -> {
        boolean res = Operation.getInstance().updateSnameStudentBySid(text3.getText(),text4.getText());
          if (res == true) {
              System.out.println("�޸����ݳɹ�");
          } else {
              System.out.println("�޸�����ʧ��");
          }
         });
        btn3.setOnAction(e -> {
        boolean res = Operation.getInstance().updateGenderStudentBySid(text3.getText(),text5.getText());
          if (res == true) {
              System.out.println("�޸����ݳɹ�");
          } else {
              System.out.println("�޸�����ʧ��");
          }
         });
        btn4.setOnAction(e -> {
        boolean res = Operation.getInstance().updateAgeStudentBySid(text3.getText(),Integer.parseInt(text6.getText()));
          if (res == true) {
              System.out.println("�޸����ݳɹ�");
          } else {
              System.out.println("�޸�����ʧ��");
          }
         });
        btn5.setOnAction(e -> {
        boolean res = Operation.getInstance().updateFrom_yearStudentBySid(text3.getText(),Integer.parseInt(text7.getText()));
          if (res == true) {
              System.out.println("�޸����ݳɹ�");
          } else {
              System.out.println("�޸�����ʧ��");
          }
         });
        btn6.setOnAction(e -> {
        boolean res = Operation.getInstance().updateClassStudentBySid(text3.getText(),text8.getText());
          if (res == true) {
              System.out.println("�޸����ݳɹ�");
          } else {
              System.out.println("�޸�����ʧ��");
          }
         });
        
        la00.setTranslateX(-150);
        la00.setTranslateY(-170);
        la1.setTranslateX(-70);
        la1.setTranslateY(-170);
        text1.setTranslateX(10);
        text1.setTranslateY(-170);
        la2.setTranslateX(-70);
        la2.setTranslateY(-140);
        text2.setTranslateX(10);
        text2.setTranslateY(-140);
        btn1.setTranslateX(90);
        btn1.setTranslateY(-140);
        
        la01.setTranslateX(-150);
        la01.setTranslateY(-80);
        la3.setTranslateX(-70);
        la3.setTranslateY(-80);
        text3.setTranslateX(10);
        text3.setTranslateY(-80);
        la4.setTranslateX(-75);
        la4.setTranslateY(-50);
        text4.setTranslateX(10);
        text4.setTranslateY(-50);
        btn2.setTranslateX(90);
        btn2.setTranslateY(-50);
        la5.setTranslateX(-75);
        la5.setTranslateY(-20);
        text5.setTranslateX(10);
        text5.setTranslateY(-20);
        btn3.setTranslateX(90);
        btn3.setTranslateY(-20);
        la6.setTranslateX(-80);
        la6.setTranslateY(10);
        text6.setTranslateX(10);
        text6.setTranslateY(10);
        btn4.setTranslateX(90);
        btn4.setTranslateY(10);
        la7.setTranslateX(-90);
        la7.setTranslateY(40);
        text7.setTranslateX(10);
        text7.setTranslateY(40);
        btn5.setTranslateX(90);
        btn5.setTranslateY(40);
        la8.setTranslateX(-70);
        la8.setTranslateY(70);
        text8.setTranslateX(10);
        text8.setTranslateY(70);
        btn6.setTranslateX(90);
        btn6.setTranslateY(70);

        text1.setMaxWidth(100);
        text2.setMaxWidth(100);
        text3.setMaxWidth(100);
        text4.setMaxWidth(100);
        text5.setMaxWidth(100);
        text6.setMaxWidth(100);
        text7.setMaxWidth(100);
        text8.setMaxWidth(100);
            
        StackPane root = new StackPane();//����
        root.getChildren().add(la00);
        root.getChildren().add(la01);
        root.getChildren().add(la1);//����ť����벼��
        root.getChildren().add(la2);
        root.getChildren().add(la3);
        root.getChildren().add(la4);
        root.getChildren().add(la5);
        root.getChildren().add(la6);
        root.getChildren().add(la7);
        root.getChildren().add(la8);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(text3);
        root.getChildren().add(text4);
        root.getChildren().add(text5);
        root.getChildren().add(text6);
        root.getChildren().add(text7);
        root.getChildren().add(text8);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        root.getChildren().add(btn4);
        root.getChildren().add(btn5);
        root.getChildren().add(btn6);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    	
    }
    
    public void u2(ActionEvent event) {
    	Stage window = new Stage();
        window.setTitle("���Ŀγ���Ϣ");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la00 = new Label("[���Ŀγ̱��]");
        Label la01 = new Label("[����������Ϣ]");
        Label la1 = new Label("�γ����� = ");
        Label la2 = new Label("���γ̱�Ÿ�Ϊ�� ");
        Label la3 = new Label("�γ̱�� = ");
        Label la4 = new Label("���γ����Ƹ�Ϊ�� ");
        Label la5 = new Label("���̿ν�ʦ������Ϊ�� ");
        Label la6 = new Label("��ѧ�ָ�Ϊ�� ");
        Label la7 = new Label("���γ��ʺ��꼶��Ϊ�� ");
        Label la8 = new Label("��ȡ����ݸ�Ϊ�� ");
        TextField text1 = new TextField ();
        TextField text2 = new TextField ();
        TextField text3 = new TextField();
        TextField text4 = new TextField();
        TextField text5 = new TextField();
        TextField text6 = new TextField();
        TextField text7 = new TextField();
        TextField text8 = new TextField();
        Button btn1 = new Button("�޸�");
        Button btn2 = new Button("�޸�");
        Button btn3 = new Button("�޸�");
        Button btn4 = new Button("�޸�");
        Button btn5 = new Button("�޸�");
        Button btn6 = new Button("�޸�");
        btn1.setOnAction(e -> {
        boolean res = Operation.getInstance().updateCidCourseByCname(text1.getText(),text2.getText());
          if (res == true) {
              System.out.println("�޸����ݳɹ�");
          } else {
              System.out.println("�޸�����ʧ��");
          }
         });
        btn2.setOnAction(e -> {
        boolean res = Operation.getInstance().updateCnameCourseByCid(text3.getText(),text4.getText());
          if (res == true) {
              System.out.println("�޸����ݳɹ�");
          } else {
              System.out.println("�޸�����ʧ��");
          }
         });
        btn3.setOnAction(e -> {
        boolean res = Operation.getInstance().updateTeacher_nameCourseByCid(text3.getText(),text5.getText());
          if (res == true) {
              System.out.println("�޸����ݳɹ�");
          } else {
              System.out.println("�޸�����ʧ��");
          }
         });
        btn4.setOnAction(e -> {
        boolean res = Operation.getInstance().updateCreditCourseByCid(text3.getText(),Integer.parseInt(text6.getText()));
          if (res == true) {
              System.out.println("�޸����ݳɹ�");
          } else {
              System.out.println("�޸�����ʧ��");
          }
         });
        btn5.setOnAction(e -> {
        boolean res = Operation.getInstance().updateGradeCourseByCid(text3.getText(),text7.getText());
          if (res == true) {
              System.out.println("�޸����ݳɹ�");
          } else {
              System.out.println("�޸�����ʧ��");
          }
         });
        btn6.setOnAction(e -> {
        boolean res = Operation.getInstance().updateDelete_yearCourseByCid(text3.getText(),Integer.parseInt(text8.getText()));
          if (res == true) {
              System.out.println("�޸����ݳɹ�");
          } else {
              System.out.println("�޸�����ʧ��");
          }
         });
        
        la00.setTranslateX(-150);
        la00.setTranslateY(-170);
        la1.setTranslateX(-70);
        la1.setTranslateY(-170);
        text1.setTranslateX(10);
        text1.setTranslateY(-170);
        la2.setTranslateX(-80);
        la2.setTranslateY(-140);
        text2.setTranslateX(10);
        text2.setTranslateY(-140);
        btn1.setTranslateX(90);
        btn1.setTranslateY(-140);
        
        la01.setTranslateX(-150);
        la01.setTranslateY(-80);
        la3.setTranslateX(-70);
        la3.setTranslateY(-80);
        text3.setTranslateX(10);
        text3.setTranslateY(-80);
        la4.setTranslateX(-75);
        la4.setTranslateY(-50);
        text4.setTranslateX(10);
        text4.setTranslateY(-50);
        btn2.setTranslateX(90);
        btn2.setTranslateY(-50);
        la5.setTranslateX(-95);
        la5.setTranslateY(-20);
        text5.setTranslateX(10);
        text5.setTranslateY(-20);
        btn3.setTranslateX(90);
        btn3.setTranslateY(-20);
        la6.setTranslateX(-70);
        la6.setTranslateY(10);
        text6.setTranslateX(10);
        text6.setTranslateY(10);
        btn4.setTranslateX(90);
        btn4.setTranslateY(10);
        la7.setTranslateX(-90);
        la7.setTranslateY(40);
        text7.setTranslateX(10);
        text7.setTranslateY(40);
        btn5.setTranslateX(90);
        btn5.setTranslateY(40);
        la8.setTranslateX(-90);
        la8.setTranslateY(70);
        text8.setTranslateX(10);
        text8.setTranslateY(70);
        btn6.setTranslateX(90);
        btn6.setTranslateY(70);

        text1.setMaxWidth(100);
        text2.setMaxWidth(100);
        text3.setMaxWidth(100);
        text4.setMaxWidth(100);
        text5.setMaxWidth(100);
        text6.setMaxWidth(100);
        text7.setMaxWidth(100);
        text8.setMaxWidth(100);
            
        StackPane root = new StackPane();//����
        root.getChildren().add(la00);
        root.getChildren().add(la01);
        root.getChildren().add(la1);//����ť����벼��
        root.getChildren().add(la2);
        root.getChildren().add(la3);
        root.getChildren().add(la4);
        root.getChildren().add(la5);
        root.getChildren().add(la6);
        root.getChildren().add(la7);
        root.getChildren().add(la8);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(text3);
        root.getChildren().add(text4);
        root.getChildren().add(text5);
        root.getChildren().add(text6);
        root.getChildren().add(text7);
        root.getChildren().add(text8);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        root.getChildren().add(btn4);
        root.getChildren().add(btn5);
        root.getChildren().add(btn6);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    	
    }
        
    public void u3(ActionEvent event) {
    	Stage window = new Stage();
        window.setTitle("����ѡ����Ϣ");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(600);
        window.setMinHeight(400);
        Label la00 = new Label("[����ѧ��]");
        Label la01 = new Label("[���Ŀγ̱��]");
        Label la02 = new Label("[����������Ϣ]");
        Label la1 = new Label("�γ̱�� = ");
        Label la2 = new Label("��ѧ�Ÿ�Ϊ�� ");
        Label la3 = new Label("ѧ�� = ");
        Label la4 = new Label("���γ̱�Ÿ�Ϊ�� ");
        Label la5 = new Label("ѧ�� =�� ");
        Label la6 = new Label("�γ̱�� =�� ");
        Label la7 = new Label("��ѡ����ݸ�Ϊ�� ");
        Label la8 = new Label("���ɼ���Ϊ�� ");
        TextField text1 = new TextField ();
        TextField text2 = new TextField ();
        TextField text3 = new TextField();
        TextField text4 = new TextField();
        TextField text5 = new TextField();
        TextField text6 = new TextField();
        TextField text7 = new TextField();
        TextField text8 = new TextField();
        Button btn1 = new Button("�޸�");
        Button btn2 = new Button("�޸�");
        Button btn3 = new Button("�޸�");
        Button btn4 = new Button("�޸�");
        btn1.setOnAction(e -> {
        boolean res = Operation.getInstance().updateSidCatalogByCid(text1.getText(),text2.getText());
          if (res == true) {
              System.out.println("�޸����ݳɹ�");
          } else {
              System.out.println("�޸�����ʧ��");
          }
         });
        btn2.setOnAction(e -> {
        boolean res = Operation.getInstance().updateCidCatalogBySid(text3.getText(),text4.getText());
          if (res == true) {
              System.out.println("�޸����ݳɹ�");
          } else {
              System.out.println("�޸�����ʧ��");
          }
         });
        btn3.setOnAction(e -> {
        boolean res = Operation.getInstance().updateChoose_yearCatalogById(text5.getText(),text6.getText(),Integer.parseInt(text7.getText()));
          if (res == true) {
              System.out.println("�޸����ݳɹ�");
          } else {
              System.out.println("�޸�����ʧ��");
          }
         });
        btn4.setOnAction(e -> {
        boolean res = Operation.getInstance().updateScoreCatalogById(text5.getText(),text6.getText(),Integer.parseInt(text8.getText()));
          if (res == true) {
              System.out.println("�޸����ݳɹ�");
          } else {
              System.out.println("�޸�����ʧ��");
          }
         });
        
        la00.setTranslateX(-150);
        la00.setTranslateY(-170);
        la1.setTranslateX(-70);
        la1.setTranslateY(-170);
        text1.setTranslateX(10);
        text1.setTranslateY(-170);
        la2.setTranslateX(-70);
        la2.setTranslateY(-140);
        text2.setTranslateX(10);
        text2.setTranslateY(-140);
        btn1.setTranslateX(90);
        btn1.setTranslateY(-140);
        
        la01.setTranslateX(-150);
        la01.setTranslateY(-80);
        la3.setTranslateX(-70);
        la3.setTranslateY(-80);
        text3.setTranslateX(10);
        text3.setTranslateY(-80);
        la4.setTranslateX(-75);
        la4.setTranslateY(-50);
        text4.setTranslateX(10);
        text4.setTranslateY(-50);
        btn2.setTranslateX(90);
        btn2.setTranslateY(-50);
        
        la02.setTranslateX(-150);
        la02.setTranslateY(0);
        la5.setTranslateX(-70);
        la5.setTranslateY(0);
        text5.setTranslateX(10);
        text5.setTranslateY(0);
        la6.setTranslateX(-75);
        la6.setTranslateY(30);
        text6.setTranslateX(10);
        text6.setTranslateY(30);
        la7.setTranslateX(-90);
        la7.setTranslateY(60);
        text7.setTranslateX(10);
        text7.setTranslateY(60);       
        btn3.setTranslateX(90);
        btn3.setTranslateY(60);
        la8.setTranslateX(-70);
        la8.setTranslateY(90);
        text8.setTranslateX(10);
        text8.setTranslateY(90);       
        btn4.setTranslateX(90);
        btn4.setTranslateY(90);


        text1.setMaxWidth(100);
        text2.setMaxWidth(100);
        text3.setMaxWidth(100);
        text4.setMaxWidth(100);
        text5.setMaxWidth(100);
        text6.setMaxWidth(100);
        text7.setMaxWidth(100);
        text8.setMaxWidth(100);
            
        StackPane root = new StackPane();//����
        root.getChildren().add(la00);
        root.getChildren().add(la01);
        root.getChildren().add(la02);
        root.getChildren().add(la1);//����ť����벼��
        root.getChildren().add(la2);
        root.getChildren().add(la3);
        root.getChildren().add(la4);
        root.getChildren().add(la5);
        root.getChildren().add(la6);
        root.getChildren().add(la7);
        root.getChildren().add(la8);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(text3);
        root.getChildren().add(text4);
        root.getChildren().add(text5);
        root.getChildren().add(text6);
        root.getChildren().add(text7);
        root.getChildren().add(text8);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        root.getChildren().add(btn4);
        Scene scene = new Scene(root, 600, 400);
        window.setScene(scene);
        //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
        window.showAndWait();
    	
    }
    
    
    public static void main(String[] args) {
        launch(args);//��������ʱ����ʼ��javaFX����
    }
}