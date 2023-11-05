package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Memory_Game_Again2 extends Application{

	private GridPane buttonPane;
	private BorderPane mainPane;
	private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
	private String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16;
	private ImageView v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16;
	private int count=0;
	public void createLayout()
	{
		
		buttonPane=new GridPane();
		buttonPane.add(b1, 0, 0);
		buttonPane.add(b2, 1, 0);
		buttonPane.add(b3, 2, 0);
		buttonPane.add(b4, 3, 0);
		
		buttonPane.add(b5, 0, 1);
		buttonPane.add(b6, 1, 1);
		buttonPane.add(b7, 2, 1);
		buttonPane.add(b8, 3, 1);
		
		buttonPane.add(b9, 0, 2);
		buttonPane.add(b10, 1, 2);
		buttonPane.add(b11, 2, 2);
		buttonPane.add(b12, 3, 2);
		
		buttonPane.add(b13, 0, 3);
		buttonPane.add(b14, 1, 3);
		buttonPane.add(b15, 2, 3);
		buttonPane.add(b16, 3, 3);
		mainPane=new BorderPane();
		mainPane.setCenter(buttonPane);
	}
	private void createPhoto()
	{
		///1 & 13
		FileInputStream fis1;
		try {
			fis1=new FileInputStream("gameImages/chae.jpg");
			File f=new File("D:\\New Java Project 2\\fxTeaching\\fxProject\\gameImages\\chae.jpg");
			s1=f.getName();
			Image img=new Image(fis1);
			v1=new ImageView();
			b1=new Button("",v1);
			b1.setMinSize(150, 150);
			b1.setOnAction(e->{
				count++;
				v1.setImage(img);
			});
		}catch (FileNotFoundException e1) {
			b1=new Button("Copy");
		}
		FileInputStream fis13;
		try {
			fis13=new FileInputStream("gameImages/chae.jpg");
			File f=new File("D:\\New Java Project 2\\fxTeaching\\fxProject\\gameImages\\chae.jpg");
			s13=f.getName();
			Image img=new Image(fis13);
			v13=new ImageView();
			b13=new Button("",v13);
			b13.setMinSize(150, 150);
			b13.setOnAction(e->{
				count++;
				v13.setImage(img);
				Timer t=new Timer();
				TimerTask tt=new TimerTask() {
					
					@Override
					public void run() {
						isSame();
						
					}
				};
				t.schedule(tt,1000);
			});
		} catch (FileNotFoundException e13) {
			b13=new Button("Copy");
		}
		////2 &16
		FileInputStream fis2;
		try {
			fis2=new FileInputStream("gameImages/dino.jpg");
			File f=new File("D:\\New Java Project 2\\fxTeaching\\fxProject\\gameImages\\dino.jpg");
			s2=f.getName();
			Image img=new Image(fis2);
			v2=new ImageView();
			b2=new Button("",v2);
			b2.setMinSize(150, 150);
			b2.setOnAction(e->{
				count++;
				v2.setImage(img);
			});
		}catch (FileNotFoundException e2) {
			b2=new Button("Copy");
		}
		FileInputStream fis16;
		try {
			fis16=new FileInputStream("gameImages/dino.jpg");
			File f=new File("D:\\New Java Project 2\\fxTeaching\\fxProject\\gameImages\\dino.jpg");
			s16=f.getName();
			Image img=new Image(fis16);
			v16=new ImageView();
			b16=new Button("",v16);
			b16.setMinSize(150, 150);
			b16.setOnAction(e->{
				v16.setImage(img);
				Timer t=new Timer();
				TimerTask tt=new TimerTask() {
					
					@Override
					public void run() {
						isSame();
						
					}
				};
				t.schedule(tt,1000);
			});
		} catch (FileNotFoundException e16) {
			b16=new Button("Copy");
		}
		//3 & 7 dk
		FileInputStream fis3;
		try {
			fis3=new FileInputStream("gameImages/dk.jpg");
			File f=new File("D:\\New Java Project 2\\fxTeaching\\fxProject\\gameImages\\dk.jpg");
			s3=f.getName();
			Image img=new Image(fis3);
			v3=new ImageView();
			b3=new Button("",v3);
			b3.setMinSize(150, 150);
			b3.setOnAction(e->{
				count++;
				v1.setImage(img);
			});
		}catch (FileNotFoundException e3) {
			b3=new Button("Copy");
		}
		FileInputStream fis7;
		try {
			fis7=new FileInputStream("gameImages/dk.jpg");
			File f=new File("D:\\New Java Project 2\\fxTeaching\\fxProject\\gameImages\\dk.jpg");
			s7=f.getName();
			Image img=new Image(fis7);
			v7=new ImageView();
			b7=new Button("",v7);
			b7.setMinSize(150, 150);
			b7.setOnAction(e->{
				count++;
				v13.setImage(img);
				Timer t=new Timer();
				TimerTask tt=new TimerTask() {
					
					@Override
					public void run() {
						isSame();
						
					}
				};
				t.schedule(tt,1000);
			});
		} catch (FileNotFoundException e7) {
			b13=new Button("Copy");
			// 4 &10 fourth
			FileInputStream fis4;
			try {
				fis4=new FileInputStream("gameImages/fourth.jpg");
				File f=new File("D:\\New Java Project 2\\fxTeaching\\fxProject\\gameImages\\fourth.jpg");
				s4=f.getName();
				Image img=new Image(fis4);
				v4=new ImageView();
				b4=new Button("",v4);
				b4.setMinSize(150, 150);
				b4.setOnAction(e->{
					count++;
					v1.setImage(img);
				});
			}catch (FileNotFoundException e4) {
				b4=new Button("Copy");
			}
			FileInputStream fis10;
			try {
				fis10=new FileInputStream("gameImages/fourth.jpg");
				File f=new File("D:\\New Java Project 2\\fxTeaching\\fxProject\\gameImages\\fourth.jpg");
				s10=f.getName();
				Image img=new Image(fis10);
				v10=new ImageView();
				b10=new Button("",v13);
				b10.setMinSize(150, 150);
				b10.setOnAction(e->{
					count++;
					v10.setImage(img);
					Timer t=new Timer();
					TimerTask tt=new TimerTask() {
						
						@Override
						public void run() {
							isSame();
							
						}
					};
					t.schedule(tt,1000);
				});
			} catch (FileNotFoundException e10) {
				b10=new Button("Copy");
			}
			// 5 & 8 gemini
			FileInputStream fis5;
			try {
				fis5=new FileInputStream("gameImages/gemini.jpg");
				File f=new File("D:\\New Java Project 2\\fxTeaching\\fxProject\\gameImages\\gemini.jpg");
				s5=f.getName();
				Image img=new Image(fis5);
				v5=new ImageView();
				b5=new Button("",v5);
				b5.setMinSize(150, 150);
				b5.setOnAction(e->{
					count++;
					v5.setImage(img);
				});
			}catch (FileNotFoundException e5) {
				b5=new Button("Copy");
			}
			FileInputStream fis8;
			try {
				fis8=new FileInputStream("gameImages/gemini.jpg");
				File f=new File("D:\\New Java Project 2\\fxTeaching\\fxProject\\gameImages\\gemini.jpg");
				s8=f.getName();
				Image img=new Image(fis8);
				v8=new ImageView();
				b8=new Button("",v8);
				b8.setMinSize(150, 150);
				b8.setOnAction(e->{
					count++;
					v8.setImage(img);
					Timer t=new Timer();
					TimerTask tt=new TimerTask() {
						
						@Override
						public void run() {
							isSame();
							
						}
					};
					t.schedule(tt,1000);
				});
			} catch (FileNotFoundException e8) {
				b8=new Button("Copy");
			}
			// 6 & 12 phuwin
			FileInputStream fis6;
			try {
				fis6=new FileInputStream("gameImages/phuwin.jpg");
				File f=new File("D:\\New Java Project 2\\fxTeaching\\fxProject\\gameImages\\phuwin.jpg");
				s6=f.getName();
				Image img=new Image(fis6);
				v6=new ImageView();
				b6=new Button("",v6);
				b6.setMinSize(150, 150);
				b6.setOnAction(e->{
					count++;
					v6.setImage(img);
				});
			}catch (FileNotFoundException e6) {
				b6=new Button("Copy");
			}
			FileInputStream fis12;
			try {
				fis12=new FileInputStream("gameImages/phuwin.jpg");
				File f=new File("D:\\New Java Project 2\\fxTeaching\\fxProject\\gameImages\\phuwin.jpg");
				s12=f.getName();
				Image img=new Image(fis12);
				v12=new ImageView();
				b12=new Button("",v12);
				b12.setMinSize(150, 150);
				b12.setOnAction(e->{
					count++;
					v12.setImage(img);
					Timer t=new Timer();
					TimerTask tt=new TimerTask() {
						
						@Override
						public void run() {
							isSame();
							
						}
					};
					t.schedule(tt,1000);
				});
			} catch (FileNotFoundException e12) {
				b12=new Button("Copy");
			}
			// 9 & 15 pond
			FileInputStream fis9;
			try {
				fis9=new FileInputStream("gameImages/pond.jpg");
				File f=new File("D:\\New Java Project 2\\fxTeaching\\fxProject\\gameImages\\pond.jpg");
				s9=f.getName();
				Image img=new Image(fis9);
				v9=new ImageView();
				b9=new Button("",v9);
				b9.setMinSize(150, 150);
				b9.setOnAction(e->{
					count++;
					v9.setImage(img);
				});
			}catch (FileNotFoundException e9) {
				b9=new Button("Copy");
			}
			FileInputStream fis15;
			try {
				fis15=new FileInputStream("gameImages/pond.jpg");
				File f=new File("D:\\New Java Project 2\\fxTeaching\\fxProject\\gameImages\\pond.jpg");
				s15=f.getName();
				Image img=new Image(fis15);
				v15=new ImageView();
				b15=new Button("",v15);
				b15.setMinSize(150, 150);
				b15.setOnAction(e->{
					count++;
					v15.setImage(img);
					Timer t=new Timer();
					TimerTask tt=new TimerTask() {
						
						@Override
						public void run() {
							isSame();
							
						}
					};
					t.schedule(tt,1000);
				});
			} catch (FileNotFoundException e15) {
				b15=new Button("Copy");
			}
			// 11 & 14 minnie
			FileInputStream fis11;
			try {
				fis11=new FileInputStream("gameImages/minnie.jpg");
				File f=new File("D:\\New Java Project 2\\fxTeaching\\fxProject\\gameImages\\minnie.jpg");
				s11=f.getName();
				Image img=new Image(fis11);
				v11=new ImageView();
				b11=new Button("",v11);
				b11.setMinSize(150, 150);
				b11.setOnAction(e->{
					count++;
					v11.setImage(img);
				});
			}catch (FileNotFoundException e11) {
				b11=new Button("Copy");
			}
			FileInputStream fis14;
			try {
				fis14=new FileInputStream("gameImages/minnie.jpg");
				File f=new File("D:\\New Java Project 2\\fxTeaching\\fxProject\\gameImages\\minnie.jpg");
				s14=f.getName();
				Image img=new Image(fis14);
				v14=new ImageView();
				b14=new Button("",v14);
				b14.setMinSize(150, 150);
				b14.setOnAction(e->{
					count++;
					v14.setImage(img);
					Timer t=new Timer();
					TimerTask tt=new TimerTask() {
						
						@Override
						public void run() {
							isSame();
							
						}
					};
					t.schedule(tt,1000);
				});
			} catch (FileNotFoundException e14) {
				b14=new Button("Copy");
			}
		}
	}
	public void isSame()
	{
		if(count==2)
		{
			if(s1.equals(s2))
			{
				b1.setVisible(false);
				b2.setVisible(false);
				count=0;
			}
			else
			{
				count=0;
				v1.setVisible(false);
				v2.setVisible(false);
			}
		}
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		createPhoto();
		createLayout();
		Scene sc=new Scene(mainPane,1000,500);
		stage.setScene(sc);
		stage.setTitle("Memory game");
		stage.show();
	}
	public static void main(String[] args) 
	{
		Application.launch(args);
	}

}
