package uiTest;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HboxVboxFlowPane extends Application{

	
	public static void main(String[] args) 
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage mainStage) throws Exception {
		Button b1=new Button("Button1");
		Button b2=new Button("Button2 Button2 Button2");
		Button b3=new Button("Button3");
		Button b4=new Button("Button4");
		Button b5=new Button("Button5");
		Button b6=new Button("Button6 Button6");
		Button b7=new Button("Button7");
		Button b8=new Button("Button8");
		
//		HBox hb= new HBox(20,b1,b2,b3,b4);
//		hb.setSpacing(20);
//		VBox vb=new VBox(20,b1,b2,b3,b4);
//		FlowPane fp=new FlowPane(Orientation.VERTICAL,20,20,b1,b2,b3,b4,b5,b6,b7,b8);
//		FlowPane fp=new FlowPane(b1,b2,b3,b4,b5,b6,b7);
//		fp.getChildren().add(b8);
//		fp.getChildren().remove(b7);
//		fp.setOrientation(Orientation.VERTICAL);
//		fp.setHgap(50);
//		fp.setVgap(20);
//		TilePane tp=new TilePane(Orientation.HORIZONTAL,20,20,b1,b2,b3,b4,b5,b6,b7,b8);
		GridPane gp=new GridPane();
		Scene sc=new Scene(gp,500,500);
		
		mainStage.setScene(sc);
		mainStage.setTitle("Hbox Vbox FlowPane testing");
		mainStage.show();
	}

}
