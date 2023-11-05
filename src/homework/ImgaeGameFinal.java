package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

import javafx.animation.*;

import javafx.application.Application;
import javafx.event.*;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;

import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ImgaeGameFinal extends Application{

	private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
	private ImageView v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16;
	private boolean i1=false,i2=false,i3=false,i4=false,i5=false,i6=false,i7=false,i8=false,i9=false,i10=false,i11=false,i12=false,i13=false,i14=false,i15=false,i16=false;
	private Label score,scoreNo,timerLabel,win,gameOver;
	private int seconds=300;
	private int sco=0;
	private static String arr[]={"chae.jpg","dino.jpg","dk.jpg","fourth.jpg","gemini.jpg","minnie.jpg","phuwin.jpg","pond.jpg"};
	private HBox hb;
	private String yourscore;
	private GridPane buttonPane;
	private BorderPane mainPane;
	private Timeline tline;
	public void TimerFun() 
	{
        tline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
        	
            @Override
            public void handle(ActionEvent event) {
                seconds--;
                int ss=Integer.valueOf(yourscore);
                timerLabel.setText(Integer.toString(seconds));
                if(ss==80 && seconds>0)
                {
                	tline.stop();
                	timerLabel.setText("");
                	//timerLabel.setVisible(false);
                	mainPane.setCenter(win);
                }
                else if (seconds <= 0 && ss!=80) 
                {
                    tline.stop();
                    scoreNo.setVisible(false);
                    score.setVisible(false);
                    timerLabel.setText("");
                  //timerLabel.setVisible(false);
                    mainPane.setCenter(gameOver);
                }
                
            }
        }));
        tline.setCycleCount(Timeline.INDEFINITE);
        tline.play();
	}
	public static int ImageRandom()
	{
		int random;
		random=(int)(Math.random()*arr.length);
		System.out.println("Random arr["+random+"] picture is : "+arr[random]);
		//arr[random]="_";
		return random;
	}
	public void createNode()
	{
		int random=ImageRandom();
		//chae 1 & 13
		try {
			
			FileInputStream fis=new FileInputStream("gameImages/"+arr[random]);
			Image img=new Image(fis);
			v1=new ImageView(img);
			v1.setVisible(false);
			b1=new Button("",v1);
			b1.setMinSize(150, 150);
			b1.setOnAction(e->{
				i1=true;
				v1.setVisible(true);
				Timeline timeline=new Timeline(
						new KeyFrame(Duration.seconds(2),event ->{
							isCheck();
						})
						);
				timeline.play();
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileInputStream fis=new FileInputStream("gameImages/"+arr[random]);
			Image img=new Image(fis);
			v13=new ImageView(img);
			v13.setVisible(false);
			b13=new Button("",v13);
			b13.setMinSize(150, 150);
			b13.setOnAction(e->{
				i13=true;
				v13.setVisible(true);
				Timeline timeline=new Timeline(
						new KeyFrame(Duration.seconds(2),event ->{
							isCheck();
						})
						);
				timeline.play();
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// dino 2 &  16
		try {
			FileInputStream fis=new FileInputStream("gameImages/dino.jpg");
			Image img=new Image(fis);
			v2=new ImageView(img);
			v2.setVisible(false);
			b2=new Button("",v2);
			b2.setMinSize(150, 150);
			b2.setOnAction(e->{
				i2=true;
				v2.setVisible(true);
				Timeline timeline=new Timeline(
						new KeyFrame(Duration.seconds(2),event ->{
							isCheck();
						})
						);
				timeline.play();
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileInputStream fis=new FileInputStream("gameImages/dino.jpg");
			Image img=new Image(fis);
			v16=new ImageView(img);
			v16.setVisible(false);
			b16=new Button("",v16);
			b16.setMinSize(150, 150);
			b16.setOnAction(e->{
				i16=true;
				v16.setVisible(true);
				Timeline timeline=new Timeline(
						new KeyFrame(Duration.seconds(2),event ->{
							isCheck();
						})
						);
				timeline.play();
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//dk 3 & 7
		try {
			FileInputStream fis=new FileInputStream("gameImages/dk.jpg");
			Image img=new Image(fis);
			v3=new ImageView(img);
			v3.setVisible(false);
			b3=new Button("",v3);
			b3.setMinSize(150,150);
			b3.setOnAction(e->{
				i3=true;
				v3.setVisible(true);
				System.out.println("After i press button 3  i3 is "+i3);
				Timeline timeline=new Timeline(
						new KeyFrame(Duration.seconds(2),event ->{
							isCheck();
						})
						);
				timeline.play();
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileInputStream fis=new FileInputStream("gameImages/dk.jpg");
			Image img=new Image(fis);
			v7=new ImageView(img);
			v7.setVisible(false);
			b7=new Button("",v7);
			b7.setMinSize(150,150);
			b7.setOnAction(e->{
				i7=true;
				v7.setVisible(true);
				System.out.println("After i press button 7  i7 is "+i7);
				Timeline timeline=new Timeline(
						new KeyFrame(Duration.seconds(2),event ->{
							isCheck();
						})
						);
				timeline.play();
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fourth 4 & 10
		try {
			FileInputStream fis=new FileInputStream("gameImages/fourth.jpg");
			Image img=new Image(fis);
			v4=new ImageView(img);
			v4.setVisible(false);
			b4=new Button("",v4);
			b4.setMinSize(150,150);
			b4.setOnAction(e->{
				i4=true;
				v4.setVisible(true);
				Timeline timeline=new Timeline(
						new KeyFrame(Duration.seconds(2),event ->{
							isCheck();
						})
						);
				timeline.play();
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileInputStream fis=new FileInputStream("gameImages/fourth.jpg");
			Image img=new Image(fis);
			v10=new ImageView(img);
			v10.setVisible(false);
			b10=new Button("",v10);
			b10.setMinSize(150,150);
			b10.setOnAction(e->{
				i10=true;
				v10.setVisible(true);
				Timeline timeline=new Timeline(
						new KeyFrame(Duration.seconds(2),event ->{
							isCheck();
						})
						);
				timeline.play();
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//gemini 5 & 8
		try {
			FileInputStream fis=new FileInputStream("gameImages/gemini.jpg");
			Image img=new Image(fis);
			v5=new ImageView(img);
			v5.setVisible(false);
			b5=new Button("",v5);
			b5.setMinSize(150,150);
			b5.setOnAction(e->{
				i5=true;
				v5.setVisible(true);
				Timeline timeline=new Timeline(
						new KeyFrame(Duration.seconds(2),event ->{
							isCheck();
						})
						);
				timeline.play();
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileInputStream fis=new FileInputStream("gameImages/gemini.jpg");
			Image img=new Image(fis);
			v8=new ImageView(img);
			v8.setVisible(false);
			b8=new Button("",v8);
			b8.setMinSize(150,150);
			b8.setOnAction(e->{
				i8=true;
				v8.setVisible(true);
				Timeline timeline=new Timeline(
						new KeyFrame(Duration.seconds(2),event ->{
							isCheck();
						})
						);
				timeline.play();
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//phuwin 6 & 12
		try {
			FileInputStream fis=new FileInputStream("gameImages/phuwin.jpg");
			Image img=new Image(fis);
			v6=new ImageView(img);
			v6.setVisible(false);
			b6=new Button("",v6);
			b6.setMinSize(150,150);
			b6.setOnAction(e->{
				i6=true;
				v6.setVisible(true);
				Timeline timeline=new Timeline(
						new KeyFrame(Duration.seconds(2),event ->{
							isCheck();
						})
						);
				timeline.play();
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileInputStream fis=new FileInputStream("gameImages/phuwin.jpg");
			Image img=new Image(fis);
			v12=new ImageView(img);
			v12.setVisible(false);
			b12=new Button("",v12);
			b12.setMinSize(150,150);
			b12.setOnAction(e->{
				i12=true;
				v12.setVisible(true);
				Timeline timeline=new Timeline(
						new KeyFrame(Duration.seconds(2),event ->{
							isCheck();
						})
						);
				timeline.play();
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//pond 9 & 15
		try {
			FileInputStream fis=new FileInputStream("gameImages/pond.jpg");
			Image img=new Image(fis);
			v9=new ImageView(img);
			v9.setVisible(false);
			b9=new Button("",v9);
			b9.setMinSize(150,150);
			b9.setOnAction(e->{
				i9=true;
				v9.setVisible(true);
				Timeline timeline=new Timeline(
						new KeyFrame(Duration.seconds(2),event ->{
							isCheck();
						})
						);
				timeline.play();
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileInputStream fis=new FileInputStream("gameImages/pond.jpg");
			Image img=new Image(fis);
			v15=new ImageView(img);
			v15.setVisible(false);
			b15=new Button("",v15);
			b15.setMinSize(150,150);
			b15.setOnAction(e->{
				i15=true;
				v15.setVisible(true);
				Timeline timeline=new Timeline(
						new KeyFrame(Duration.seconds(2),event ->{
							isCheck();
						})
						);
				timeline.play();
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//minnie 11 & 14
		try {
			FileInputStream fis=new FileInputStream("gameImages/minnie.jpg");
			Image img=new Image(fis);
			v11=new ImageView(img);
			v11.setVisible(false);
			b11=new Button("",v11);
			b11.setMinSize(150,150);
			b11.setOnAction(e->{
				i11=true;
				v11.setVisible(true);
				Timeline timeline=new Timeline(
						new KeyFrame(Duration.seconds(2),event ->{
							isCheck();
						})
						);
				timeline.play();
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileInputStream fis=new FileInputStream("gameImages/minnie.jpg");
			Image img=new Image(fis);
			v14=new ImageView(img);
			v14.setVisible(false);
			b14=new Button("",v14);
			b14.setMinSize(150,150);
			b14.setOnAction(e->{
				i14=true;
				v14.setVisible(true);
				Timeline timeline=new Timeline(
						new KeyFrame(Duration.seconds(2),event ->{
							isCheck();
						})
						);
				timeline.play();
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void isCheck()
	{
		TimerFun();
		if(i1==true && i13==true)
		{
			sco+=10;
			//System.out.println("sco is "+sco);
			yourscore=Integer.toString(sco);
			scoreNo.setText(yourscore);
			b1.setVisible(false);
			b13.setVisible(false);
			System.out.println("b1 & b13 off");
		}
		if(i2==true && i16==true)
		{
			sco+=10;
			yourscore=Integer.toString(sco);
			scoreNo.setText(yourscore);
			b2.setVisible(false);
			b16.setVisible(false);
			System.out.println("b2 & b16 off");
		}
		if(i3==true && i7==true)
		{
			sco+=10;
			yourscore=Integer.toString(sco);
			scoreNo.setText(yourscore);
			b3.setVisible(false);
			b7.setVisible(false);
			System.out.println("b3 & b7 off");
		}
		if(i4==true && i10==true)
		{
			sco+=10;
			yourscore=Integer.toString(sco);
			scoreNo.setText(yourscore);
			b4.setVisible(false);
			b10.setVisible(false);
			System.out.println("b4 & b10 off");
		}
		if(i5==true && i8==true)
		{
			sco+=10;
			yourscore=Integer.toString(sco);
			scoreNo.setText(yourscore);
			b5.setVisible(false);
			b8.setVisible(false);
		}
		if(i6==true && i12==true)
		{
			sco+=10;
			yourscore=Integer.toString(sco);
			scoreNo.setText(yourscore);
			b6.setVisible(false);
			b12.setVisible(false);
		}
		if(i9==true && i15==true)
		{
			sco+=10;
			yourscore=Integer.toString(sco);
			scoreNo.setText(yourscore);
			b9.setVisible(false);
			b15.setVisible(false);
		}
		if(i11==true && i14==true)
		{
			sco+=10;
			yourscore=Integer.toString(sco);
			scoreNo.setText(yourscore);
			b11.setVisible(false);
			b14.setVisible(false);
		}
		isNotMatch();
	}

	public void isNotMatch() 
	{
		i1=false;
		i2=false;
		i3=false;
		i4=false;
		i5=false;
		i6=false;
		i7=false;
		i8=false;
		
		i9=false;
		i10=false;
		i11=false;
		i12=false;
		i13=false;
		i14=false;
		i15=false;
		i16=false;
		
		v1.setVisible(false);
		v2.setVisible(false);
		v3.setVisible(false);
		v4.setVisible(false);
		v5.setVisible(false);
		v6.setVisible(false);
		v7.setVisible(false);
		v8.setVisible(false);
		
		v9.setVisible(false);
		v10.setVisible(false);
		v11.setVisible(false);
		v12.setVisible(false);
		v13.setVisible(false);
		v14.setVisible(false);
		v15.setVisible(false);
		v16.setVisible(false);
	}
	public void setStyle() 
	{
		score.getStyleClass().add("Header");
		scoreNo.getStyleClass().add("Header");
		gameOver.getStyleClass().add("timer");
		timerLabel.getStyleClass().add("timer");
		win.getStyleClass().add("Header");
	}
	public void setLayout() 
	{
		score= new Label("Score is ");
		scoreNo=new Label("0");
		timerLabel=new Label();
		String sec=Integer.toString(seconds);
		timerLabel.setText(sec);
		win=new Label("You win the game.");
		gameOver=new Label("You are running out of time.");
		hb=new HBox();
		hb.getChildren().add(score);
		hb.getChildren().add(scoreNo);
		hb.getChildren().add(timerLabel);
		hb.setPadding(new Insets(20));
		
		
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
		mainPane.setTop(hb);
		mainPane.setCenter(buttonPane);
	}
	public static void main(String[] args) {
		//ImageRandom();
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		createNode();
		setLayout();
		Scene sc=new Scene(mainPane,900,800);
		stage.setScene(sc);
		URL url=this.getClass().getResource("imageStyle.css");
		sc.getStylesheets().add(url.toExternalForm());
		setStyle();
		stage.setTitle("Image Game");
		stage.show();
		
	}

}
