package uiTest;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UI2 extends Application{
	@Override
	public void start(Stage stage1) throws Exception {
		Scene sc=new Scene(new Group(),500,500);
		stage1.setScene(sc);
		stage1.setTitle("Main Stage");
		stage1.initStyle(StageStyle.UNIFIED);
		stage1.show();
		
//		Stage stage2=new Stage();
//		stage2.setTitle("Stage 2");
//		stage2.show();
//		
//		Stage stage3=new Stage();
//		stage3.setTitle("Stage 3");
//		//stage3.initModality(Modality.APPLICATION_MODAL);
//		stage3.initOwner(stage1);
//		stage3.initModality(Modality.WINDOW_MODAL);
//		stage3.show();
	}
	public static void main(String args[])
	{
		Application.launch(args);
	}

}
