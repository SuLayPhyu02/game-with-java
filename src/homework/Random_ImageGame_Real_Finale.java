package homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Random_ImageGame_Real_Finale extends Application{

	private static String arr[]={"chae.jpg","dino.jpg","dk.jpg","fourth.jpg","gemini.jpg","minnie.jpg","phuwin.jpg","pond.jpg"};
	private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
	private Label lscore,lno,ltimeallow,ltime,win,gameOver;
	private GridPane buttonPane;
	private BorderPane mainPane;
	private FlowPane scorePane,secondPane;
	private HBox overBox;
	private VBox rightBox;
	private ImageView imageView;
	private Button button;
	private String name;
	private int count=0;
	private int score=0;
	private String youeScore,yourSecond;
	private int seconds=900;
	private Timeline tline;
	private static int countArr[]=new int[8];
	public void setLayout()
	{
		lscore=new Label("Your score is ");
		youeScore=Integer.toString(score);
		lno=new Label(youeScore);
		
		ltimeallow=new Label("Time allowed ");
		yourSecond=Integer.toString(seconds);
		ltime=new Label(yourSecond);
		
		scorePane=new FlowPane();
		scorePane.getChildren().add(lscore);
		scorePane.getChildren().add(lno);
		
		
		secondPane=new FlowPane();
		secondPane.getChildren().add(ltimeallow);
		secondPane.getChildren().add(ltime);
		
		
		scorePane.setPadding(new Insets(30));
		secondPane.setPadding(new Insets(30));
		
		win=new Label("You win the game.");
		gameOver=new Label("You are running out of time.");
		
		forButton1();
		forButton2();
		forButton3();
		forButton4();
		forButton5();
		forButton6();
		forButton7();
		forButton8();
		forButton9();
		forButton10();
		forButton11();
		forButton12();
		forButton13();
		forButton14();
		forButton15();
		forButton16();

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
		rightBox=new VBox();
		rightBox.getChildren().add(scorePane);
		rightBox.getChildren().add(secondPane);
		rightBox.setPadding(new Insets(20));
		
		overBox=new HBox();
		overBox.getChildren().add(buttonPane);
		overBox.getChildren().add(rightBox);
		overBox.setPadding(new Insets(40));
		overBox.setAlignment(Pos.CENTER);
		mainPane.setCenter(overBox);
	}
	public void setStyle() 
	{
		lscore.getStyleClass().add("Header");
		lno.getStyleClass().add("Header");
		gameOver.getStyleClass().add("timer");
		ltimeallow.getStyleClass().add("timer");
		ltime.getStyleClass().add("timer");
		win.getStyleClass().add("Header");
	}
	public void TimerFun() 
	{
        tline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
        	
            @Override
            public void handle(ActionEvent event) {
                seconds--;
                int ss=Integer.valueOf(youeScore);
                ltime.setText(Integer.toString(seconds));
                if(ss==80 && seconds>0)
                {
                	tline.stop();
                	ltime.setVisible(false);
                	mainPane.setCenter(win);
                }
                else if (seconds <= 0 && ss!=80) 
                {
                    tline.stop();
                    lscore.setVisible(false);
                    lno.setVisible(false);
                    ltime.setVisible(false);
                    mainPane.setCenter(gameOver);
                }
                
            }
        }));
        tline.setCycleCount(Timeline.INDEFINITE);
        tline.play();
	}
	public void putCount0()
	{
		for(int i=0;i<countArr.length;i++)
		{
			countArr[i]=0;
		}
	}
	private static int imageRandom() 
	{
		int random;
		random=(int)(Math.random()*arr.length);
		countArr[random]++;
		while(countArr[random]>=3)
		{
			random=(int)(Math.random()*arr.length);
			countArr[random]++;
		}
		return random;
	}
	public void display()
	{
		for(int i=0;i<countArr.length;i++)
		{
			System.out.println("arr["+i+"] is "+arr[i]);
			
		}
	}
	
	public void forButton1() 
	{
		int random=imageRandom();
		String randomName=arr[random];
		try {
			FileInputStream fis=new FileInputStream("gameImages/"+arr[random]);
			Image img=new Image(fis);
			ImageView imgV=new ImageView(img);
			imgV.setVisible(false);
			
			b1=new Button("",imgV);
			b1.setMinSize(150, 150);
			b1.setOnAction(e->{
				imgV.setVisible(true);
				count++;
				if(count==1)
				{
					forCount1(randomName, b1, imgV);
					
				}
				else if(count==2)
				{
					System.out.println("RandomName "+randomName);
					System.out.println("Name "+name);
					callDelay(randomName, name, b1, button, imgV, imageView);
					
				}
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void forButton2() 
	{
		int random=imageRandom();
		String randomName=arr[random];
		try {
			FileInputStream fis=new FileInputStream("gameImages/"+arr[random]);
			Image img=new Image(fis);
			ImageView imgV=new ImageView(img);
			imgV.setVisible(false);
			b2=new Button("",imgV);
			b2.setMinSize(150, 150);
			b2.setOnAction(e->{
				imgV.setVisible(true);
				count++;
				if(count==1)
				{
					forCount1(randomName, b2, imgV);
				}
				else if(count==2)
				{
					System.out.println("RandomName "+randomName);
					System.out.println("Name "+name);
					callDelay(randomName, name, b2, button, imgV, imageView);
				}
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void forButton3() 
	{
		int random=imageRandom();
		String randomName=arr[random];
		try {
			FileInputStream fis=new FileInputStream("gameImages/"+arr[random]);
			Image img=new Image(fis);
			ImageView imgV=new ImageView(img);
			imgV.setVisible(false);
			
			b3=new Button("",imgV);
			b3.setMinSize(150, 150);
			b3.setOnAction(e->{
				imgV.setVisible(true);
				count++;
				if(count==1)
				{
					forCount1(randomName, b3, imgV);
				}
				else if(count==2)
				{
					System.out.println("RandomName "+randomName);
					System.out.println("Name "+name);
					callDelay(randomName, name, b3, button, imgV, imageView);
				}
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void forButton4() 
	{
		int random=imageRandom();
		String randomName=arr[random];
		try {
			FileInputStream fis=new FileInputStream("gameImages/"+arr[random]);
			Image img=new Image(fis);
			ImageView imgV=new ImageView(img);
			imgV.setVisible(false);
			b4=new Button("",imgV);
			b4.setMinSize(150, 150);
			b4.setOnAction(e->{
				imgV.setVisible(true);
				count++;
				if(count==1)
				{
					forCount1(randomName, b4, imgV);
				}
				else if(count==2)
				{
					System.out.println("RandomName "+randomName);
					System.out.println("Name "+name);
					callDelay(randomName, name, b4, button, imgV, imageView);
				}
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void forButton5() 
	{
		int random=imageRandom();
		String randomName=arr[random];
		try {
			FileInputStream fis=new FileInputStream("gameImages/"+arr[random]);
			Image img=new Image(fis);
			ImageView imgV=new ImageView(img);
			imgV.setVisible(false);
			
			b5=new Button("",imgV);
			b5.setMinSize(150, 150);
			b5.setOnAction(e->{
				imgV.setVisible(true);
				count++;
				if(count==1)
				{
					forCount1(randomName, b5, imgV);
				}
				else if(count==2)
				{
					System.out.println("RandomName "+randomName);
					System.out.println("Name "+name);
					callDelay(randomName, name, b5, button, imgV, imageView);
				}
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void forButton6() 
	{
		int random=imageRandom();
		String randomName=arr[random];
		try {
			FileInputStream fis=new FileInputStream("gameImages/"+arr[random]);
			Image img=new Image(fis);
			ImageView imgV=new ImageView(img);
			imgV.setVisible(false);
			b6=new Button("",imgV);
			b6.setMinSize(150, 150);
			b6.setOnAction(e->{
				imgV.setVisible(true);
				count++;
				if(count==1)
				{
					forCount1(randomName, b6, imgV);
				}
				else if(count==2)
				{
					System.out.println("RandomName "+randomName);
					System.out.println("Name "+name);
					callDelay(randomName, name, b6, button, imgV, imageView);
				}
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void forButton7() 
	{
		int random=imageRandom();
		String randomName=arr[random];
		try {
			FileInputStream fis=new FileInputStream("gameImages/"+arr[random]);
			Image img=new Image(fis);
			ImageView imgV=new ImageView(img);
			imgV.setVisible(false);
			
			b7=new Button("",imgV);
			b7.setMinSize(150, 150);
			b7.setOnAction(e->{
				imgV.setVisible(true);
				count++;
				if(count==1)
				{
					forCount1(randomName, b7, imgV);
				}
				else if(count==2)
				{
					System.out.println("RandomName "+randomName);
					System.out.println("Name "+name);
					callDelay(randomName, name, b7, button, imgV, imageView);
				}
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void forButton8() 
	{
		int random=imageRandom();
		String randomName=arr[random];
		try {
			FileInputStream fis=new FileInputStream("gameImages/"+arr[random]);
			Image img=new Image(fis);
			ImageView imgV=new ImageView(img);
			imgV.setVisible(false);
			b8=new Button("",imgV);
			b8.setMinSize(150, 150);
			b8.setOnAction(e->{
				imgV.setVisible(true);
				count++;
				if(count==1)
				{
					forCount1(randomName, b8, imgV);
					
				}
				else if(count==2)
				{
					System.out.println("RandomName "+randomName);
					System.out.println("Name "+name);
					callDelay(randomName, name, b8, button, imgV, imageView);
					
				}
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void forButton9() 
	{
		int random=imageRandom();
		String randomName=arr[random];
		try {
			FileInputStream fis=new FileInputStream("gameImages/"+arr[random]);
			Image img=new Image(fis);
			ImageView imgV=new ImageView(img);
			imgV.setVisible(false);
			
			b9=new Button("",imgV);
			b9.setMinSize(150, 150);
			b9.setOnAction(e->{
				imgV.setVisible(true);
				count++;
				if(count==1)
				{
					forCount1(randomName, b9, imgV);
					
				}
				else if(count==2)
				{
					System.out.println("RandomName "+randomName);
					System.out.println("Name "+name);
					callDelay(randomName, name, b9, button, imgV, imageView);
				}
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void forButton10() 
	{
		int random=imageRandom();
		String randomName=arr[random];
		try {
			FileInputStream fis=new FileInputStream("gameImages/"+arr[random]);
			Image img=new Image(fis);
			ImageView imgV=new ImageView(img);
			imgV.setVisible(false);
			b10=new Button("",imgV);
			b10.setMinSize(150, 150);
			b10.setOnAction(e->{
				imgV.setVisible(true);
				count++;
				if(count==1)
				{
					forCount1(randomName, b10, imgV);
				
				}
				else if(count==2)
				{
					System.out.println("RandomName "+randomName);
					System.out.println("Name "+name);
					callDelay(randomName, name, b10, button, imgV, imageView);
					
				}
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void forButton11() 
	{
		int random=imageRandom();
		String randomName=arr[random];
		try {
			FileInputStream fis=new FileInputStream("gameImages/"+arr[random]);
			Image img=new Image(fis);
			ImageView imgV=new ImageView(img);
			imgV.setVisible(false);
			
			b11=new Button("",imgV);
			b11.setMinSize(150, 150);
			b11.setOnAction(e->{
				imgV.setVisible(true);
				count++;
				if(count==1)
				{
					forCount1(randomName, b11, imgV);
				}
				else if(count==2)
				{
					System.out.println("RandomName "+randomName);
					System.out.println("Name "+name);
					callDelay(randomName, name, b11, button, imgV, imageView);
					
				}
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void forButton12() 
	{
		int random=imageRandom();
		String randomName=arr[random];
		try {
			FileInputStream fis=new FileInputStream("gameImages/"+arr[random]);
			Image img=new Image(fis);
			ImageView imgV=new ImageView(img);
			imgV.setVisible(false);
			b12=new Button("",imgV);
			b12.setMinSize(150, 150);
			b12.setOnAction(e->{
				imgV.setVisible(true);
				count++;
				if(count==1)
				{
					forCount1(randomName, b12, imgV);
					
				}
				else if(count==2)
				{
					System.out.println("RandomName "+randomName);
					System.out.println("Name "+name);
					callDelay(randomName, name, b12, button, imgV, imageView);
					
				}
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void forButton13() 
	{
		int random=imageRandom();
		String randomName=arr[random];
		try {
			FileInputStream fis=new FileInputStream("gameImages/"+arr[random]);
			Image img=new Image(fis);
			ImageView imgV=new ImageView(img);
			imgV.setVisible(false);
			
			b13=new Button("",imgV);
			b13.setMinSize(150, 150);
			b13.setOnAction(e->{
				imgV.setVisible(true);
				count++;
				if(count==1)
				{
					forCount1(randomName, b13, imgV);
					
				}
				else if(count==2)
				{
					System.out.println("RandomName "+randomName);
					System.out.println("Name "+name);
					callDelay(randomName, name, b13, button, imgV, imageView);

				}
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void forButton14() 
	{
		int random=imageRandom();
		String randomName=arr[random];
		try {
			FileInputStream fis=new FileInputStream("gameImages/"+arr[random]);
			Image img=new Image(fis);
			ImageView imgV=new ImageView(img);
			imgV.setVisible(false);
			b14=new Button("",imgV);
			b14.setMinSize(150, 150);
			b14.setOnAction(e->{
				imgV.setVisible(true);
				count++;
				if(count==1)
				{
					forCount1(randomName, b14, imgV);
					
				}
				else if(count==2)
				{
					System.out.println("RandomName "+randomName);
					System.out.println("Name "+name);
					callDelay(randomName, name, b14, button, imgV, imageView);
					
				}
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void forButton15() 
	{
		int random=imageRandom();
		String randomName=arr[random];
		try {
			FileInputStream fis=new FileInputStream("gameImages/"+arr[random]);
			Image img=new Image(fis);
			ImageView imgV=new ImageView(img);
			imgV.setVisible(false);
			
			b15=new Button("",imgV);
			b15.setMinSize(150, 150);
			b15.setOnAction(e->{
				imgV.setVisible(true);
				count++;
				if(count==1)
				{
					forCount1(randomName, b15, imgV);
					
				}
				else if(count==2)
				{
					System.out.println("RandomName "+randomName);
					System.out.println("Name "+name);
					callDelay(randomName, name, b15, button, imgV, imageView);
					
				}
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void forButton16() 
	{
		int random=imageRandom();
		String randomName=arr[random];
		try {
			FileInputStream fis=new FileInputStream("gameImages/"+arr[random]);
			Image img=new Image(fis);
			ImageView imgV=new ImageView(img);
			imgV.setVisible(false);
			b16=new Button("",imgV);
			b16.setMinSize(150, 150);
			b16.setOnAction(e->{
				imgV.setVisible(true);
				count++;
				if(count==1)
				{
					forCount1(randomName, b16, imgV);
					
				}
				else if(count==2)
				{
					System.out.println("RandomName "+randomName);
					System.out.println("Name "+name);
					callDelay(randomName, name, b16, button, imgV, imageView);
					
				}
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void callDelay(String s1,String s2,Button button1,Button button2,ImageView v1,ImageView v2) 
	{
		Timeline timeline=new Timeline(
				new KeyFrame(Duration.seconds(1),event ->{
					forCount2(s1,s2,button1,button2,v1,v2);
				})
				);
		timeline.play();
	}
	public void forCount1(String n,Button b,ImageView img)
	{
		name=n;
		button =b;
		imageView=img;
		System.out.println("In count 1, ......name is "+name);
	}
	public void forCount2(String s1,String s2,Button button1,Button button2,ImageView v1,ImageView v2)
	{
		TimerFun();
		if(s1.equals(s2))
		{
			score+=10;
			youeScore=Integer.toString(score);
			lno.setText(youeScore);
			System.out.println("I am going to Button visible off");
			button1.setVisible(false);
			button2.setVisible(false);
		}
		else
		{
			System.out.println("I am going to imageView visible off");
			v1.setVisible(false);
			v2.setVisible(false);
		}
		count=0;
	}
	public void start(Stage stage) throws Exception {
		putCount0();
		setLayout();
		Scene sc=new Scene(mainPane,1000,700);
		stage.setScene(sc);
		URL url=this.getClass().getResource("imageStyle.css");
		sc.getStylesheets().add(url.toExternalForm());
		setStyle();
		stage.setTitle("Image Game");
		stage.show();
		
	}
	public static void main(String[] args) 
	{
		Application.launch(args);
	}

}
