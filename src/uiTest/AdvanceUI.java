package uiTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.controlsfx.control.textfield.TextFields;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.*;

public class AdvanceUI extends Application{
	private Label lname,ldob,lerr;
	private TextField tname;
	private DatePicker dpdob;
	private GridPane gp;
	private BorderPane bp;
	private FlowPane fp;
	private Button btnRegister;
	public void createNode()
	{
		lname=new Label("Name");
		ldob=new Label("DOB");
		lerr=new Label();
		
		lerr.setStyle("-fx-text-fill:red");
		
		tname=new TextField();
		tname.setOnKeyReleased(e->{
			//System.out.println(tname.getText());
			String name=tname.getText();
			if(Checker.isValidName(name))
			{
				lerr.setText("");
				//insert into database.
				//System.out.println(name);
			}
			else
			{
				lerr.setText("Wrong name format!! eg Su Lay Phyu");
			}
		});
		
		dpdob=new DatePicker();
		btnRegister=new Button("Register");
		btnRegister.setOnAction(e->{
			register();
			
		});
		
	}
	public void limitDate()
	{
		dpdob.setDayCellFactory(picker->new DateCell() {
			public void updateItem(LocalDate date,boolean empty) {
				super.updateItem(date, empty);
				LocalDate today=LocalDate.now();
				//setDisable(empty || date.compareTo(today)<0);//reservation for flight,bus
				setDisable(empty || date.getYear() > today.getYear()-15);//for student age
			}
		});
	}
	public void autoCompleteName()
	{
		
		String arr[]={"Aye Aye","Su Su","Aung Aung","Ma Ma"};
		ArrayList<String>al=new ArrayList<>();
		al.addAll(Arrays.asList(arr));
		TextFields.bindAutoCompletion(tname,al);
	}
	public void register()
	{
		String name=tname.getText();
		LocalDate dob=dpdob.getValue();
	}
	public void setLayout()
	{
		gp=new GridPane();
		gp.add(lname,0,0);
		gp.add(tname, 1, 0);
		gp.add(ldob, 0, 1);
		gp.add(dpdob, 1, 1);
		gp.setHgap(20);
		gp.setVgap(20);
		gp.setAlignment(Pos.CENTER);
		
		fp=new FlowPane(btnRegister);
		fp.setAlignment(Pos.CENTER);
		fp.setPadding(new Insets(20));
		
		bp=new BorderPane();
		bp.setTop(lerr);
		bp.setCenter(gp);
		bp.setBottom(fp);
	}
	
	@Override
	public void start(Stage stage) throws Exception 
	{
		createNode();
		setLayout();
		limitDate();
		//autoCompleteName();
		Scene sc=new Scene(bp);
		stage.setScene(sc);
		stage.setTitle("Date Picker");
		stage.show();
		
	}
	public static void main(String[] args) {
		Application.launch(args);

	}


}
