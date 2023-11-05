package homework;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Notepad extends Application{
	private TextArea tarea;
	private FlowPane fp;
	private Button btnCopy,btnPaste,btnCut;
	private BorderPane mainPane;
	public void createPane()
	{
		tarea=new TextArea();
		btnCopy=new Button("Copy");
		btnPaste=new Button("Paste");
		btnCut=new Button("Cut");
		fp=new FlowPane();
		fp.getChildren().addAll(btnCopy,btnCut,btnPaste);
		btnCopy.setOnAction(e->{
			tarea.copy();
		});
		btnPaste.setOnAction(e->{
			tarea.paste();
		});
		btnCut.setOnAction(e->{
			tarea.cut();
		});
		mainPane=new BorderPane(tarea);
		mainPane.setTop(fp);
	}
	@Override
	public void start(Stage stage) throws Exception {
		createPane();
		Scene sc=new Scene(mainPane);
		stage.setScene(sc);
		stage.setTitle("NotePad");
		stage.show();
		
	}
	public static void main(String[] args) {
		Application.launch(args);

	}
	

}
