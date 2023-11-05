package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MemoryGame extends Application{
	private BorderPane mainPane;
	private GridPane buttonPane;
	private VBox scorebox;
	private HBox middlepane;
	private Label score,sno,lose,win;
	private int count=0;
	//private int count[]=new int[16];
	private Button btn[][];
	
	private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
	private Button be1,be2,be3,be4,be5,be6,be7,be8,be9,be10,be11,be12,be13,be14,be15,be16;
	private String s1,s2,s3,s13;
	private ImageView v1,v13;
	
	
	public void createNode()
	{
		score=new Label();
		lose=new Label();
		win=new Label();
		
//		be1=new Button();
//		be1.setOnAction(e->{
//			be1.setDisable(true);
//			forButton1();
//			
//		});
		be2=new Button();
		be2.setOnAction(e->{
			be2.setDisable(true);
			forButton2();
		});
		be3=new Button();
		be3.setOnAction(e->{
			be3.setDisable(true);
			forButton3();
		});
		be4=new Button();
		be4.setOnAction(e->{
			be4.setDisable(true);
			forButton4();
		});
		be5=new Button();
		be5.setOnAction(e->{
			be5.setDisable(true);
			forButton5();
		});
		be6=new Button();
		be6.setOnAction(e->{
			be6.setDisable(true);
			forButton6();
		});
		be7=new Button();
		be7.setOnAction(e->{
			be7.setDisable(true);
			forButton7();
		});
		be8=new Button();
		be8.setOnAction(e->{
			be8.setDisable(true);
			forButton8();
		});
		be9=new Button();
		be9.setOnAction(e->{
			be9.setDisable(true);
			forButton9();
		});
		be10=new Button();
		be10.setOnAction(e->{
			be10.setDisable(true);
			forButton10();
		});
		be11=new Button();
		be11.setOnAction(e->{
			be11.setDisable(true);
			forButton11();
		});
		be12=new Button();
		be12.setOnAction(e->{
			be12.setDisable(true);
			forButton12();
		});
//		be13=new Button();
//		be13.setOnAction(e->{
//			be13.setDisable(true);
//			forButton13();
//		});
		be14=new Button();
		be14.setOnAction(e->{
			be14.setDisable(true);
			forButton14();
		});
		be15=new Button();
		be15.setOnAction(e->{
			be15.setDisable(true);
			forButton15();
		});
		be16=new Button();
		be16.setOnAction(e->{
			be16.setDisable(true);
			forButton16();
		});
		
		
		sno=new Label();		
		scorebox=new VBox();
		middlepane=new HBox();
		buttonPane=new GridPane();
		mainPane=new BorderPane();
	}
	public void isSame(Button b)
	{
		if(s1.equals(s2))
		{
			b.setVisible(false);
		}
		
	}
	public void forButton1()
	{
		FileInputStream fis1;
		try {
			fis1=new FileInputStream("gameImages/chae.jpg");
			File f=new File("D:\\New Java Project 2\\fxTeaching\\fxProject\\gameImages\\chae.jpg");
			s1=f.getName();
			Image img=new Image(fis1);
			v1=new ImageView();
			be1=new Button("",v1);
			be1.setOnAction(e->{
				count++;
				v1.setImage(img);
				if(count==2)
				{
					if(s1.equals(s13))
					{
						be1.setVisible(false);
						be13.setVisible(false);
					}
				}
			});
			
			
		} catch (FileNotFoundException e1) {
			be1=new Button("Copy");
		}
		buttonPane.add(be1, 0, 0);
	}
	public void forButton13()
	{
		String filepath="gameImages/chae.jpg";
		FileInputStream fis13;
		try {
			fis13=new FileInputStream("gameImages/chae.jpg");
			File f=new File("D:\\New Java Project 2\\fxTeaching\\fxProject\\gameImages\\chae.jpg");
			s13=f.getName();
			Image img=new Image(fis13);
			v13=new ImageView();
			be13=new Button("",v13);
			be13.setOnAction(e->{
				count++;
				v13.setImage(img);
			});
			
		} catch (FileNotFoundException e1) {
			b13=new Button("Copy");
		}
		buttonPane.add(be13, 0, 3);
		
		
	}
	public void forButton2()
	{
		s1="gameImages/dino.jpg";
		count++;
		FileInputStream fis2;
		try {
			fis2=new FileInputStream("gameImages/dino.jpg");
			Image img=new Image(fis2);
			ImageView imgv=new ImageView(img);
			b2=new Button("",imgv);
			
			
		} catch (FileNotFoundException e1) {
			b2=new Button("Copy");
		}
		buttonPane.add(b2, 1, 0);
	}
	public void forButton3()
	{
		count++;
		FileInputStream fis3;
		try {
			fis3=new FileInputStream("gameImages/dk.jpg");
			Image img=new Image(fis3);
			ImageView imgv=new ImageView(img);
			b3=new Button("",imgv);
			
			
		} catch (FileNotFoundException e1) {
			b3=new Button("Copy");
		}
		buttonPane.add(b3, 2, 0);
		
	}
	public void forButton4()
	{
		FileInputStream fis4;
		try {
			fis4=new FileInputStream("gameImages/fourth.jpg");
			Image img=new Image(fis4);
			ImageView imgv=new ImageView(img);
			b4=new Button("",imgv);
			
			
		} catch (FileNotFoundException e1) {
			b4=new Button("Copy");
		}
		buttonPane.add(b4, 3, 0);
	}
	public void forButton5()
	{
		FileInputStream fis5;
		try {
			fis5=new FileInputStream("gameImages/gemini.jpg");
			Image img=new Image(fis5);
			ImageView imgv=new ImageView(img);
			b5=new Button("",imgv);
			
			
		} catch (FileNotFoundException e1) {
			b5=new Button("Copy");
		}
		buttonPane.add(b5, 0, 1);
	}
	public void forButton6()
	{
		FileInputStream fis6;
		try {
			fis6=new FileInputStream("gameImages/phuwin.jpg");
			Image img=new Image(fis6);
			ImageView imgv=new ImageView(img);
			b6=new Button("",imgv);
			
			
		} catch (FileNotFoundException e1) {
			b6=new Button("Copy");
		}
		buttonPane.add(b6, 1, 1);
	}
	public void forButton7()
	{
		FileInputStream fis7;
		try {
			fis7=new FileInputStream("gameImages/dk.jpg");
			Image img=new Image(fis7);
			ImageView imgv=new ImageView(img);
			b7=new Button("",imgv);
			
			
		} catch (FileNotFoundException e1) {
			b7=new Button("Copy");
		}
		buttonPane.add(b7, 2, 1);
	}
	public void forButton8()
	{
		FileInputStream fis8;
		try {
			fis8=new FileInputStream("gameImages/gemini.jpg");
			Image img=new Image(fis8);
			ImageView imgv=new ImageView(img);
			b8=new Button("",imgv);
			
			
		} catch (FileNotFoundException e1) {
			b8=new Button("Copy");
		}
		buttonPane.add(b8, 3, 1);
	}
	public void forButton9()
	{
		FileInputStream fis9;
		try {
			fis9=new FileInputStream("gameImages/pond.jpg");
			Image img=new Image(fis9);
			ImageView imgv=new ImageView(img);
			b9=new Button("",imgv);
			
			
		} catch (FileNotFoundException e1) {
			b9=new Button("Copy");
		}
		buttonPane.add(b9, 0, 2);
	}
	public void forButton10()
	{
		FileInputStream fis10;
		try {
			fis10=new FileInputStream("gameImages/fourth.jpg");
			Image img=new Image(fis10);
			ImageView imgv=new ImageView(img);
			b10=new Button("",imgv);
			
			
		} catch (FileNotFoundException e1) {
			b10=new Button("Copy");
		}
		buttonPane.add(b10, 1, 2);
	}
	public void forButton11()
	{
		FileInputStream fis11;
		try {
			fis11=new FileInputStream("gameImages/minnie.jpg");
			Image img=new Image(fis11);
			ImageView imgv=new ImageView(img);
			b11=new Button("",imgv);
			
			
		} catch (FileNotFoundException e1) {
			b11=new Button("Copy");
		}
		buttonPane.add(b11, 2, 2);
	}
	public void forButton12()
	{
		FileInputStream fis12;
		try {
			fis12=new FileInputStream("gameImages/phuwin.jpg");
			Image img=new Image(fis12);
			ImageView imgv=new ImageView(img);
			b12=new Button("",imgv);
			
			
		} catch (FileNotFoundException e1) {
			b12=new Button("Copy");
		}
		buttonPane.add(b12, 3, 2);
	}

	public void forButton14()
	{
		FileInputStream fis14;
		try {
			fis14=new FileInputStream("gameImages/minnie.jpg");
			Image img=new Image(fis14);
			ImageView imgv=new ImageView(img);
			b14=new Button("",imgv);
			
			
		} catch (FileNotFoundException e1) {
			b14=new Button("Copy");
		}
		buttonPane.add(b14, 1, 3);
	}
	public void forButton15()
	{
		FileInputStream fis15;
		try {
			fis15=new FileInputStream("gameImages/pond.jpg");
			Image img=new Image(fis15);
			ImageView imgv=new ImageView(img);
			b15=new Button("",imgv);
			
			
		} catch (FileNotFoundException e1) {
			b15=new Button("Copy");
		}
		buttonPane.add(b15, 2, 3);	
	}
	public void forButton16()
	{
		FileInputStream fis16;
		try {
			fis16=new FileInputStream("gameImages/dino.jpg");
			Image img=new Image(fis16);
			ImageView imgv=new ImageView(img);
			b16=new Button("",imgv);
			
			
		} catch (FileNotFoundException e1) {
			b16=new Button("Copy");
		}
		buttonPane.add(b16, 3, 3);
	}
	public void setLayout()
	{
		scorebox.getChildren().addAll(score,sno);
		scorebox.setPadding(new Insets(20));
		
		buttonPane.add(be1, 0, 0);
		buttonPane.add(be2, 1, 0);
		buttonPane.add(be3, 2, 0);
		buttonPane.add(be4, 3, 0);
		
		buttonPane.add(be5, 0, 1);
		buttonPane.add(be6, 1, 1);
		buttonPane.add(be7, 2, 1);
		buttonPane.add(be8, 3, 1);
		
		buttonPane.add(be9, 0, 2);
		buttonPane.add(be10, 1, 2);
		buttonPane.add(be11, 2, 2);
		buttonPane.add(be12, 3, 2);
		
		buttonPane.add(be13, 0, 3);
		buttonPane.add(be14, 1, 3);
		buttonPane.add(be15, 2, 3);
		buttonPane.add(be16, 3, 3);
		
		
		middlepane.getChildren().addAll(buttonPane,scorebox);
		middlepane.setPadding(new Insets(40));
		mainPane.setCenter(middlepane);
	}
	public void setStyle()
	{
		be1.setMinSize(150,150);
		be2.setMinSize(150,150);
		be3.setMinSize(150,150);
		be4.setMinSize(150,150);
		be5.setMinSize(150,150);
		be6.setMinSize(150,150);
		be7.setMinSize(150,150);
		be8.setMinSize(150,150);
		be9.setMinSize(150,150);
		be10.setMinSize(150,150);
		be11.setMinSize(150,150);
		be12.setMinSize(150,150);
		be13.setMinSize(150,150);
		be14.setMinSize(150,150);
		be15.setMinSize(150,150);
		be16.setMinSize(150,150);
		
//		b1.getStyleClass().add("Button");
//		b2.getStyleClass().add("Button");
//		b3.getStyleClass().add("Button");
//		b4.getStyleClass().add("Button");
//		b5.getStyleClass().add("Button");
//		b6.getStyleClass().add("Button");
//		b7.getStyleClass().add("Button");
//		b8.getStyleClass().add("Button");
//		b9.getStyleClass().add("Button");
//		b10.getStyleClass().add("Button");
//		b11.getStyleClass().add("Button");
//		b12.getStyleClass().add("Button");
//		b13.getStyleClass().add("Button");
//		b14.getStyleClass().add("Button");
//		b15.getStyleClass().add("Button");
//		b16.getStyleClass().add("Button");
	}
	@Override
	public void start(Stage stage) throws Exception {
		createNode();
		setLayout();
		setStyle();
		Scene sc=new Scene(mainPane,1000,700);
		stage.setScene(sc);
		stage.setTitle("Memory game");
		URL url=this.getClass().getResource("imageStyle.css");
		sc.getStylesheets().add(url.toExternalForm());
		setStyle();
		stage.show();
		
	}
	public static void main(String[] args) 
	{
		Application.launch(args);
	}

}
