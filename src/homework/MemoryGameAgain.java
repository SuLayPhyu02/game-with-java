package homework;

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

public class MemoryGameAgain extends Application{
	private Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
	private GridPane labelPane;
	private BorderPane mainPane;
	public void createNode()
	{
//		l1=new Label("photo1");
//		l2=new Label("photo2");
//		l3=new Label("photo3");
//		l4=new Label("photo4");
//		l5=new Label("photo5");
//		l6=new Label("photo6");
//		l7=new Label("photo7");
//		l8=new Label("photo8");
//		l9=new Label("photo9");
//		l10=new Label("photo10");
//		l11=new Label("photo11");
//		l12=new Label("photo12");
//		l13=new Label("photo13");
//		l14=new Label("photo14");
//		l15=new Label("photo15");
//		l16=new Label("photo16");
		
		l1=new Label();
		l2=new Label();
		l3=new Label();
		l4=new Label();
		l5=new Label();
		l6=new Label();
		l7=new Label();
		l8=new Label();
		l9=new Label();
		l10=new Label();
		l11=new Label();
		l12=new Label();
		l13=new Label();
		l14=new Label();
		l15=new Label();
		l16=new Label();
		
		
		labelPane=new GridPane();
		mainPane=new BorderPane();
		
	}
	public void putImage()
	{
		
		l1.setOnMouseClicked(e->{
			FileInputStream fis;
			try {
				fis = new FileInputStream("gameImages/chae.jpg");
				Image img= new Image(fis);
				ImageView imgV=new ImageView(img);
				l1.setText("");
				l1.setGraphic(imgV);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				l1.setText("Error");
			}
			
		});
		l2.setOnMouseClicked(e->{
			FileInputStream fis;
			try {
				fis = new FileInputStream("gameImages/dino.jpg");
				Image img= new Image(fis);
				ImageView imgV=new ImageView(img);
				l2.setText("");
				l2.setGraphic(imgV);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				l2.setText("Error");
			}
			
		});
		l3.setOnMouseClicked(e->{
			FileInputStream fis;
			try {
				fis = new FileInputStream("gameImages/dk.jpg");
				Image img=new Image(fis);
				ImageView imgV=new ImageView(img);
				l3.setText("");
				l3.setGraphic(imgV);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				l3.setText("Error");
			}
		});
		l4.setOnMouseClicked(e->{
			FileInputStream fis;
			try {
				fis = new FileInputStream("gameImages/fourth.jpg");
				Image img=new Image(fis);
				ImageView imgv=new ImageView(img);
				l4.setText("");
				l4.setGraphic(imgv);
				
				
			} catch (FileNotFoundException e1) {
				l4.setText("Error");
			}
		});
		l5.setOnMouseClicked(e->{
			FileInputStream fis;
			try {
				fis = new FileInputStream("gameImages/gemini.jpg");
				Image img=new Image(fis);
				ImageView imgv=new ImageView(img);
				l5.setText("");
				l5.setGraphic(imgv);
				
				
			} catch (FileNotFoundException e1) {
				l5.setText("Error");
			}
		});
		l6.setOnMouseClicked(e->{
			FileInputStream fis;
			try {
				fis = new FileInputStream("gameImages/phuwin.jpg");
				Image img= new Image(fis);
				ImageView imgV=new ImageView(img);
				l6.setText("");
				l6.setGraphic(imgV);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				l6.setText("Error");
			}
			
		});
		l7.setOnMouseClicked(e->{
			FileInputStream fis;
			try {
				fis = new FileInputStream("gameImages/dk.jpg");
				Image img= new Image(fis);
				ImageView imgV=new ImageView(img);
				l7.setText("");
				l7.setGraphic(imgV);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				l7.setText("Error");
			}
			
		});
		l8.setOnMouseClicked(e->{
			FileInputStream fis;
			try {
				fis = new FileInputStream("gameImages/gemini.jpg");
				Image img=new Image(fis);
				ImageView imgV=new ImageView(img);
				l8.setText("");
				l8.setGraphic(imgV);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				l8.setText("Error");
			}
		});
		l9.setOnMouseClicked(e->{
			FileInputStream fis;
			try {
				fis = new FileInputStream("gameImages/pond.jpg");
				Image img=new Image(fis);
				ImageView imgv=new ImageView(img);
				l9.setText("");
				l9.setGraphic(imgv);
				
				
			} catch (FileNotFoundException e1) {
				l9.setText("Error");
			}
		});
		l10.setOnMouseClicked(e->{
			FileInputStream fis;
			try {
				fis = new FileInputStream("gameImages/fourth.jpg");
				Image img=new Image(fis);
				ImageView imgv=new ImageView(img);
				l10.setText("");
				l10.setGraphic(imgv);
				
				
			} catch (FileNotFoundException e1) {
				l10.setText("Error");
			}
		});
		l11.setOnMouseClicked(e->{
			FileInputStream fis;
			try {
				fis = new FileInputStream("gameImages/minnie.jpg");
				Image img= new Image(fis);
				ImageView imgV=new ImageView(img);
				l11.setText("");
				l11.setGraphic(imgV);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				l11.setText("Error");
			}
			
		});
		l12.setOnMouseClicked(e->{
			FileInputStream fis;
			try {
				fis = new FileInputStream("gameImages/phuwin.jpg");
				Image img= new Image(fis);
				ImageView imgV=new ImageView(img);
				l12.setText("");
				l12.setGraphic(imgV);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				l12.setText("Error");
			}
			
		});
		l13.setOnMouseClicked(e->{
			FileInputStream fis;
			try {
				fis = new FileInputStream("gameImages/chae.jpg");
				Image img=new Image(fis);
				ImageView imgV=new ImageView(img);
				l13.setText("");
				l13.setGraphic(imgV);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				l13.setText("Error");
			}
		});
		l14.setOnMouseClicked(e->{
			FileInputStream fis;
			try {
				fis = new FileInputStream("gameImages/minnie.jpg");
				Image img=new Image(fis);
				ImageView imgv=new ImageView(img);
				l14.setText("");
				l14.setGraphic(imgv);
				
				
			} catch (FileNotFoundException e1) {
				l4.setText("Error");
			}
		});
		l15.setOnMouseClicked(e->{
			FileInputStream fis;
			try {
				fis = new FileInputStream("gameImages/pond.jpg");
				Image img=new Image(fis);
				ImageView imgv=new ImageView(img);
				l15.setText("");
				l15.setGraphic(imgv);
				
				
			} catch (FileNotFoundException e1) {
				l15.setText("Error");
			}
		});
		l16.setOnMouseClicked(e->{
			FileInputStream fis;
			try {
				fis = new FileInputStream("gameImages/dino.jpg");
				Image img= new Image(fis);
				ImageView imgV=new ImageView(img);
				l16.setText("");
				l16.setGraphic(imgV);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				l16.setText("Error");
			}
			
		});
		
	}
	public void setStyle()
	{
		l1.getStyleClass().add("Label");
		l2.getStyleClass().add("Label");
		l3.getStyleClass().add("Label");
		l4.getStyleClass().add("Label");
		
		l5.getStyleClass().add("Label");
		l6.getStyleClass().add("Label");
		l7.getStyleClass().add("Label");
		l8.getStyleClass().add("Label");
		
		l9.getStyleClass().add("Label");
		l10.getStyleClass().add("Label");
		l11.getStyleClass().add("Label");
		l12.getStyleClass().add("Label");
		
		l13.getStyleClass().add("Label");
		l14.getStyleClass().add("Label");
		l15.getStyleClass().add("Label");
		l16.getStyleClass().add("Label");
	}
	public void setLayout()
	{
		labelPane.add(l1, 0, 0);
		labelPane.add(l2, 1, 0);
		labelPane.add(l3, 2, 0);
		labelPane.add(l4, 3, 0);
		
		labelPane.add(l5, 0, 1);
		labelPane.add(l6, 1, 1);
		labelPane.add(l7, 2, 1);
		labelPane.add(l8, 3, 1);
		
		labelPane.add(l9, 0, 2);
		labelPane.add(l10, 1, 2);
		labelPane.add(l11, 2, 2);
		labelPane.add(l12, 3, 2);
		
		labelPane.add(l13, 0, 3);
		labelPane.add(l14, 1, 3);
		labelPane.add(l15, 2, 3);
		labelPane.add(l16, 3, 3);
		labelPane.setPadding(new Insets(150));
		mainPane.setCenter(labelPane);
	}
	@Override
	public void start(Stage stage) throws Exception {
		createNode();
		putImage();
		setLayout();
		Scene sc=new Scene(mainPane,1000,700);
		URL url=this.getClass().getResource("imageStyle.css");
		sc.getStylesheets().add(url.toExternalForm());
		setStyle();
		stage.setScene(sc);
		stage.setTitle("Memory Game");
		stage.show();
	}
	public static void main(String[] args) 
	{
		Application.launch(args);
	}


}
