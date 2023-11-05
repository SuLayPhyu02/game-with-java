package uiTest;

import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class WorkForm {

	private Label lstaff,loption0,loption1,loption2,lheader;
	private FlowPane topPane;
	private VBox leftPane;
	private BorderPane mainPane;
	
	private Stage st;
	public WorkForm()
	{
		st=new Stage();
		createTopPane();
		createleftPane();
		createMainPane();
		Scene sc=new Scene(mainPane,900,700);
		URL url=this.getClass().getResource("mystyle.css");
		sc.getStylesheets().add(url.toExternalForm());
		setStyle();
		st.setScene(sc);
		st.setTitle("Work Form");
		st.show();
	}
	public void createTopPane()
	{
		lstaff=new Label(Login.getStaffName());
		topPane=new FlowPane(lstaff);
		topPane.setAlignment(Pos.CENTER_RIGHT);
		topPane.setPadding(new Insets(20));
	}
	public void createleftPane()
	{
		lheader=new Label("Admin Dashboard");
		loption0=new Label("PersonManage");
		loption0.setOnMouseClicked(e->{
			mainPane.setCenter(null);
			mainPane.setCenter(new PersonUI().getMainPane());
		});
		loption1=new Label("Register");
		loption1.setOnMouseClicked(e->{
			mainPane.setCenter(null);
			mainPane.setCenter(new Register().getRegisterPane());
		});
		loption2=new Label("Option 2");
		leftPane=new VBox(20,lheader,loption0,loption1,loption2);
		leftPane.setPadding(new Insets(20));
	}
	public void createMainPane()
	{
		mainPane=new BorderPane();
		mainPane.setTop(topPane);
		mainPane.setLeft(leftPane);
		mainPane.setCenter(new PersonUI().getMainPane());
	}
	public void setGeometry()
	{
		loption0.setPrefWidth(250);
		loption1.setPrefWidth(250);
		loption2.setPrefWidth(250);
		
		mainPane.setMargin(topPane, new Insets(0, 0, 20, 0));
	}
	public void setStyle()
	{
				
		topPane.setId("toppane");
		lheader.setId("dashboard");
		loption0.getStyleClass().add("option");
		loption1.getStyleClass().add("option");
		loption2.getStyleClass().add("option");
	}

}
