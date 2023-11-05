package uiTest;
import java.io.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;
public class Register{
	private Label lname,laddress,lgender,lhobbies,lpassword,lrepassword,lyear,lheader,lpassworderror;
	private TextField tname;
	private TextArea taddress;
	private RadioButton rmale,rfemale;
	private CheckBox cread,cmusic,ctravel;
	private PasswordField ppasswodrd,prepassword;
	private ComboBox<String> cbyear;
	private Button btnRegister,btnClear;
	private ToggleGroup tgGender;
	
	
	private GridPane registerPane;
	private BorderPane mainPane;
	private TilePane genderPane;
	private VBox hobbiesPane;
	private FlowPane buttonPane;
	public void createNode()
	{
		lname=new Label("Name");
		laddress=new Label("Address");
		lgender=new Label("Gender");
		lhobbies=new Label("Hobbies");
		lpassword=new Label("Password");
		lrepassword=new Label("Re-password");
		lyear=new Label("Year");
		lheader=new Label("Please fill the form");
		lpassworderror=new Label();
		
		tname=new TextField();
		taddress=new TextArea();
		
		tgGender=new ToggleGroup();
		rmale=new RadioButton("Male");
		rfemale=new RadioButton("Female");
		rmale.setSelected(true);
		rmale.setToggleGroup(tgGender);
		rfemale.setToggleGroup(tgGender);
		
		cread=new CheckBox("Reading");
		cmusic=new CheckBox("Music");
		ctravel=new CheckBox("Travelling");
		ppasswodrd=new PasswordField();
		prepassword=new PasswordField();
		
		ArrayList<String>al=new ArrayList<String>();
		al.add("First Year");
		al.add("Second Year");
		al.add("Third Year");
		cbyear=new ComboBox<String>(FXCollections.observableArrayList(al));
		cbyear.getSelectionModel().select(1);
		cbyear.setOnAction(e->{
			System.out.println(cbyear.getValue());
		});
		FileInputStream fis;
		try {
			fis = new FileInputStream("images/linechart.jpg");
			Image img=new Image(fis);
			ImageView imgView=new ImageView(img);
			btnRegister=new Button("Register",imgView);
		} catch (FileNotFoundException e1) {
			
			btnRegister=new Button("Register");
		}
		
		
		
		//btnRegister=new Button("Register");
		btnRegister.setOnAction(e->{
			register();
			//System.out.println(name+":"+add+":"+pass+":"+repass+":"+sgender+":"+shobbies+":"+syear);
		});
		btnClear=new Button("Clear");
		btnClear.setOnAction(e->{
			clear();
		});
		
	}
	public void register()
	{
		String name,add,pass,repass,sgender,shobbies="",syear;
		name=tname.getText();
		add=taddress.getText();
		pass=ppasswodrd.getText();
		repass=prepassword.getText();
		if(rmale.isSelected())
			sgender="male";
		else
			sgender="female";
		if(cread.isSelected())
			shobbies+="reading,";
		if(cmusic.isSelected())
			shobbies+="music,";
		if(ctravel.isSelected())
			shobbies+="travelling,";
		syear=cbyear.getValue();
		if(!pass.equals(repass))
		{
			lpassworderror.setText("password and repassword unmatch!");
		}
	}
	public void clear()
	{
		tname.setText("");
		taddress.setText("");
		rmale.setSelected(true);
		cread.setSelected(false);
		cmusic.setSelected(false);
		ctravel.setSelected(false);
		ppasswodrd.setText("");
		prepassword.setText("");
		lpassworderror.setText("");
		tname.requestFocus();
		cbyear.setValue("");
	}
	public void defineLayout()
	{
		registerPane=new GridPane();
		registerPane.add(lname, 0, 0);
		registerPane.add(tname, 1, 0);
		
		registerPane.add(laddress, 0, 1);
		registerPane.add(taddress, 1, 1);
		
		registerPane.add(lgender, 0, 2);
		genderPane=new TilePane(20,20,rmale,rfemale);
		registerPane.add(genderPane, 1, 2);
		
		registerPane.add(lhobbies, 0, 3);
		hobbiesPane=new VBox(15,cread,cmusic,ctravel);
		registerPane.add(hobbiesPane, 1, 3);
		
		registerPane.add(lpassword, 0, 4);
		registerPane.add(ppasswodrd, 1, 4);
		
		registerPane.add(lrepassword, 0, 5);
		VBox vb=new VBox(prepassword,lpassworderror);
		registerPane.add(vb,1,5);
		
		registerPane.add(lyear, 0, 6);
		registerPane.add(cbyear,1,6);
		
//		registerPane.add(btnRegister,0,7);
//		registerPane.add(btnClear,1,7);
		
		registerPane.setVgap(20);
		registerPane.setHgap(20);
		registerPane.setAlignment(Pos.CENTER);
		
		buttonPane=new FlowPane(btnRegister,btnClear);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setPadding(new Insets(20));
		buttonPane.setHgap(20);
		
		mainPane=new BorderPane();
		mainPane.setTop(lheader);
		mainPane.setBottom(buttonPane);
		mainPane.setCenter(registerPane);
	}
	public void setStyle()	
	{
		lheader.setId("header");
		btnRegister.getStyleClass().add("btn");
		btnClear.getStyleClass().add("btn");
		btnRegister.getStyleClass().add("btnregister");
		btnClear.getStyleClass().add("btnclear");
		mainPane.setId("mainpane");
		tname.getStyleClass().add("focusstyle");
		taddress.getStyleClass().add("focusstyle");
		ppasswodrd.getStyleClass().add("focusstyle");
		lpassworderror.getStyleClass().add("err");
	}
//	public void start(Stage stage) throws Exception {
//		
//		
//		Scene sc=new Scene(mainPane,700,700);
//		URL url=this.getClass().getResource("mystyle.css");
//		sc.getStylesheets().add(url.toExternalForm());
//		setStyle();
//		
//		stage.setScene(sc);
//		stage.setTitle("Register");
//		stage.show();
//	}
//	public static void main(String[] args) 
//	{
//		Application.launch(args);
//
//	}
	public BorderPane getRegisterPane()
	{
		createNode(); 
		defineLayout();
		return mainPane;
	}

}
