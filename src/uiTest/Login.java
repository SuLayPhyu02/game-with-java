package uiTest;

import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.DBHandler;

public class Login extends Application{
	private Label lname,lpassword,lerr;
	private TextField tname;
	private PasswordField ppassword,prepassword;
	private Button btnClear,btnLogin;
	private BorderPane mainPane;
	private VBox vb;
	private GridPane gp;
	private static int staffId=-1;
	private static String staffName;

	private Stage stage;
	public void createNode()
	{
		lname=new Label("Name");
		lpassword=new Label("Password");
		tname=new TextField();
		lerr=new Label();
		ppassword=new PasswordField();
		prepassword=new PasswordField();
		btnClear=new Button("Clear");
		btnClear.setOnAction(e->{
			callClear();
		});
		btnLogin=new Button("Login");
		btnLogin.setOnAction(e->{
			staffLogin();
		});
	}
	public void staffLogin()
	{
		String n=tname.getText();
		String p=ppassword.getText();
		staffId=DBHandler.login(n, p);
		staffName=n;
		if(staffId!=-1)
		{
			lerr.setText("");
			stage.hide();
			new WorkForm();
			System.out.println("You are login");
		}
		else
		{
			System.out.println("You are not login");
			lerr.setText("Try again");
		}
	}
	public void callClear()
	{
		tname.setText("");
		ppassword.setText("");
		lerr.setText("");
	}
	public void setDesign()
	{
		btnClear.setMinSize(50, 30);
		btnLogin.setMaxSize(50, 30);
		gp.setVgap(20);
		gp.setHgap(20);
	}
	public void setStyle()
	{
		lerr.getStyleClass().add("err");
	}
	private void setLayout()
	{
		mainPane=new BorderPane();
		gp=new GridPane();
		gp.add(lname, 0, 0);
		gp.add(tname, 1, 0);
		gp.add(lpassword, 0, 1);
		gp.add(ppassword, 1, 1);
		gp.add(btnClear, 0, 2);
		gp.add(btnLogin, 1, 2);
		gp.setAlignment(Pos.CENTER);
		mainPane.setCenter(gp);
		mainPane.setBottom(lerr);
	}
	
	public static int getStaffId() {
		return staffId;
	}
	public static void setStaffId(int staffId) {
		Login.staffId = staffId;
	}
	public static String getStaffName() {
		return staffName;
	}
	public static void setStaffName(String staffName) {
		Login.staffName = staffName;
	}
	@Override
	public void start(Stage st) throws Exception {
		createNode();
		setLayout();
		setDesign();
		stage=st;
		Scene sc=new Scene(mainPane,300,300);
		URL url=this.getClass().getResource("mystyle.css");
		sc.getStylesheets().add(url.toExternalForm());
		setStyle();
		st.setScene(sc);
		st.setTitle("Login");
		st.show();
		
	}
	public static void main(String[] args) 
	{
		Application.launch(args);

	}

}
