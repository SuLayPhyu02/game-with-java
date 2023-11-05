package uiTest;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.DBHandler;
import model.Person;

public class PersonUI {

	private TableView tvPersons;
	private TableColumn<Person, Integer> idCol;
	private TableColumn<Person, String> nameCol;
	private TableColumn<Person, Integer> ageCol;
	
	private ArrayList<Person> al;
	private FilteredList<Person> fl;
	private TableViewSelectionModel<Person>selectionModel;
	
	//searchPane
	private Label lKeyword;
	private TextField tSearch;
	//private Button btnSearch;
	private FlowPane searchPane;
	//updatePane
	private Label lid,lname,lage;
	private TextField tid,tname,tage;
	private Button btnClear,btnUpdate;
	private GridPane updatePane;
	
	private BorderPane mainPane;
	public void createPersonTable() 
	{
		tvPersons=new TableView<>();
		idCol=new TableColumn<Person,Integer>("PID");
		idCol.setCellValueFactory(new PropertyValueFactory<Person,Integer>("pid"));
		
		nameCol=new TableColumn<Person, String>("Name");
		nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
		nameCol.setSortable(true);
		
		
		ageCol=new TableColumn<Person,Integer>("Age");
		ageCol.setCellValueFactory(new PropertyValueFactory<Person,Integer>("age"));
		ageCol.setSortable(true);
		
		
		tvPersons.getColumns().add(idCol);
		tvPersons.getColumns().add(nameCol);
		tvPersons.getColumns().add(ageCol);
		
		
		selectionModel=tvPersons.getSelectionModel();
		selectionModel.setSelectionMode(SelectionMode.SINGLE);
		tvPersons.setOnMouseClicked(e->{
			if(e.getButton()==MouseButton.PRIMARY)
			{
				if(e.getClickCount()==2)
				{
					delete();
				}
				else
				{
					setUpdateInfo();
				}
			}
		});
		setData();
		edit();
	}
	public void delete()
	{
		Alert alt=new Alert(AlertType.CONFIRMATION);
		alt.setHeaderText("Delete Confirmation");
		alt.setContentText("Are you sure about do you want to delete this ?");
		Optional<ButtonType> ans=alt.showAndWait();
		if(ans.isPresent() && ans.get()==ButtonType.OK)
		{
			Person p=selectionModel.getSelectedItem();
			tvPersons.getItems().remove(p);
		}
	}
	public void setUpdateInfo()
	{
		Person p=selectionModel.getSelectedItem();
		tid.setText(""+p.getPid());
		tid.setEditable(false);
		tname.setText(""+p.getName());
		tage.setText(""+p.getAge());
	}
	public void setData()
	{
		al=DBHandler.getAllPerson();
		fl=new FilteredList<Person>(FXCollections.observableArrayList(al));
		tvPersons.getItems().addAll(fl);
	}
	public void edit() 
	{
		tvPersons.setEditable(true);
		nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		nameCol.setOnEditCommit(
				t->t.getTableView().getItems().get(t.getTablePosition().getRow()).setName(t.getNewValue())
				);
		
	}
	public void createSearchBar()
	{
		lKeyword=new Label("Keyword :");
		tSearch=new TextField();
		tSearch.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.ENTER)
			{
				filter();
			}
		});
		//btnSearch=new Button("Search");
//		btnSearch.setOnAction(e->{
//			filter();
//		});
//		btnSearch.setMinSize(100,40);
		searchPane=new FlowPane(20,20,lKeyword,tSearch);
		searchPane.setAlignment(Pos.CENTER_RIGHT);
		searchPane.setPadding(new Insets(15));
	}
	public void createUpdatePane()
	{
		lid=new Label("Id");
		lname=new Label("Name");
		lage=new Label("Age");
		
		tid=new TextField();
		tname=new TextField();
		tage=new TextField();
		
		btnUpdate=new Button("Update");
		btnClear=new Button("Clear");
		
		updatePane=new GridPane();
		
		updatePane.add(lid, 0, 0);
		updatePane.add(tid, 1, 0);
		
		updatePane.add(lname, 0, 1);
		updatePane.add(tname, 1, 1);
		
		updatePane.add(lage, 0, 2);
		updatePane.add(tage, 1, 2);
		
		updatePane.add(btnClear, 0, 3);
		updatePane.add(btnUpdate, 1, 3);
		
		updatePane.setPadding(new Insets(20));
		updatePane.setVgap(10);
		updatePane.setHgap(10);
	}
	public void createMainPane()
	{
		mainPane=new BorderPane();
		mainPane.setTop(searchPane);
		mainPane.setCenter(tvPersons);
		mainPane.setRight(updatePane);
	}
	public void filter()
	{
		fl=new FilteredList<>(FXCollections.observableArrayList(al));
		fl.setPredicate(new Predicate<Person>() {

			@Override
			public boolean test(Person p) {
				String value=tSearch.getText();
				if(value.length()==0)
				{
					return true;
				}
				try {
					int age=Integer.parseInt(value);
					return age==p.getAge();
				}catch(Exception e)
				{
					return value.equals(p.getName());
				}
				
			}
		});
		tvPersons.getItems().clear();
		tvPersons.getItems().addAll(fl);
	}
	public BorderPane getMainPane() {
		createPersonTable();
		createSearchBar();
		createUpdatePane();
		createMainPane();
		Scene sc=new Scene(mainPane);
		return mainPane;
	}
	public void setMainPane(BorderPane mainPane) {
		this.mainPane = mainPane;
	}
	


}
