package homework;
 
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.text.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Notepad_upgraded_version extends Application{
	private MenuBar Bar;
	private Menu fileMenu,editMenu,formatMenu,viewMenu,helpMenu,Zoom;
	private MenuItem New,NewWindow,Open,Save,SaveAs,PageSetup,Print,Exit,Undo,Cut,Copy,Paste,Delete,SelectAll,TimeDate,Font,ZoomIn,ZoomOut,ViewHelp,SendFeedback,AboutNotepad;
	private TextArea tarea;
	private VBox mainBox;
	private File currentFile;
	private Stage stage,newStage;
	private int fontSize=12;
	
	public void createMenuBar()
	{
		tarea=new TextArea();
		fileMenu=new Menu("File");
		editMenu=new Menu("Edit");
		formatMenu=new Menu("Format");
		viewMenu=new Menu("View");
		helpMenu=new Menu("Help");
		
		createFileMenuItem();
		
		Bar=new MenuBar(fileMenu,editMenu,formatMenu,viewMenu,helpMenu);
	}
	public void createFileMenuItem()
	{
		//=new MenuItem("");
		New=new MenuItem("New");
		New.setOnAction(e->{
			newFile();
		});
		NewWindow=new MenuItem("New Window");
		NewWindow.setOnAction(e->{
			newWindowFile();
		});
		Open=new MenuItem("Open");
		Open.setOnAction(e->{
			openFile();
		});
		Save=new MenuItem("Save");
		Save.setOnAction(e->{
			saveAsFile();
		});
		SaveAs=new MenuItem("Save As");
		PageSetup=new MenuItem("Page Setup");
		Print=new MenuItem("Print");
		Exit=new MenuItem("Exit");
		Exit.setOnAction(e->{
			exitFile();
		});
		fileMenu.getItems().add(New);
		fileMenu.getItems().add(NewWindow);
		fileMenu.getItems().add(Open);
		fileMenu.getItems().add(Save);
		fileMenu.getItems().add(SaveAs);
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(PageSetup);
		fileMenu.getItems().add(Print);
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(Exit);
		
		//for Edit
		String sel=getSelectedText();
		Undo=new MenuItem("Undo");
		Undo.setOnAction(e->{
			undoText();
		});
		Cut=new MenuItem("Cut");
		Cut.setOnAction(e->{
			cutText();
		});
		Copy=new MenuItem("Copy");
		Copy.setOnAction(e->{
			copyText();
		});
		Paste=new MenuItem("Paste");
		Paste.setOnAction(e->{
			pasteText();
		});
		Delete=new MenuItem("Delete");
		Delete.setOnAction(e->{
			deleteText();
		});
		SelectAll=new MenuItem("Select All");
		SelectAll.setOnAction(e->{
			selectAllText();
		});
		TimeDate=new MenuItem("Time/Date");
		TimeDate.setOnAction(e->{
			String time=getCurrentTime();
			int position=getCaretPosition();
			tarea.insertText(position, time);
		});
		editMenu.getItems().add(Undo);
		editMenu.getItems().add(new SeparatorMenuItem());
		editMenu.getItems().add(Cut);
		editMenu.getItems().add(Copy);
		editMenu.getItems().add(Paste);
		editMenu.getItems().add(Delete);
		editMenu.getItems().add(new SeparatorMenuItem());
		editMenu.getItems().add(SelectAll);
		editMenu.getItems().add(TimeDate);
		
		//for format
		Font=new MenuItem("Font");
		
		formatMenu.getItems().add(Font);
		//for view
		Zoom=new Menu("Zoom");
		ZoomIn=new MenuItem("Zoom In");
		ZoomIn.setOnAction(e->{
			zoomInFunction();
		});
		ZoomOut=new MenuItem("Zoom Out");
		ZoomOut.setOnAction(e->{
			zoomOutFunction();
		});
		viewMenu.getItems().add(Zoom);
		Zoom.getItems().add(ZoomIn);
		Zoom.getItems().add(ZoomOut);
		//for Help
		ViewHelp=new MenuItem("View Help");
		ViewHelp.setOnAction(e->{
			goForHelp();
		});
		SendFeedback=new MenuItem("Send Feedback");
		AboutNotepad=new MenuItem("About Notepad");
		AboutNotepad.setOnAction(e->{
			showAboutNotepad();
		});
		helpMenu.getItems().add(ViewHelp);
		helpMenu.getItems().add(SendFeedback);
		helpMenu.getItems().add(new SeparatorMenuItem());
		helpMenu.getItems().add(AboutNotepad);
	}
	public String getSelectedText()
	{
		String selected=tarea.getSelectedText();
		return selected;
	}
	public void newFile()
	{
		tarea.setText("");
	}
	public void newWindowFile()
	{
		newStage=new Stage();
		createMenuBar();
		setLayout();
		Scene sc=new Scene(mainBox,700,700);
		newStage.setScene(sc);
		newStage.setTitle("Notepad");
		newStage.show();
	}
	public void openFile()
	{
		FileChooser chooser=new FileChooser();
		chooser.setTitle("Open Dialog Box");;
		File f=chooser.showOpenDialog(stage);
		try {
			BufferedReader br=new BufferedReader(new FileReader(f));
			String line;
			while((line=br.readLine())!=null )
			{
				tarea.appendText(line+"\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void saveAsFile()
	{
		FileChooser chooser=new FileChooser();
		chooser.setTitle("Save Dialog Box");
		File f=chooser.showSaveDialog(stage);
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter(f));
			String line=tarea.getText();
			writer.write(line);
			writer.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void pageSetupFile()
	{
		
	}
	public void printFile()
	{
		
	}
	public void exitFile()
	{
		stage.close();
	}
	public void undoText()
	{
		tarea.undo();
	}
	public void cutText()
	{
		tarea.cut();
	}
	public void pasteText()
	{
		tarea.paste();
	}
	public void copyText()
	{
		tarea.copy();
	}
	public void deleteText()
	{
		tarea.deleteText(tarea.getSelection());
	}
	public void selectAllText()
	{
		tarea.selectAll();
	}
	public String getCurrentTime()
	{
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
		LocalDateTime now=LocalDateTime.now();
		return dtf.format(now);
	}
	public int getCaretPosition()
	{
		return tarea.getCaretPosition();
	}
	public void zoomInFunction()
	{
		fontSize+=2;
		tarea.setFont(javafx.scene.text.Font.font(fontSize));
	}
	public void zoomOutFunction()
	{
		if(fontSize>2)
		{
			fontSize-=2;
			tarea.setFont(javafx.scene.text.Font.font(fontSize));
		}
		
	}
	public void goForHelp()
	{
		try {
			URI helpUri=new URI("https://www.bing.com/search?q=get+help+with+notepad+in+windows&filters=guid:%224466414-en-dia%22%20lang:%22en%22&form=T00032&ocid=HelpPane-BingIA");
			Desktop.getDesktop().browse(helpUri);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void showAboutNotepad()
	{
		Alert aboutDialog=new Alert(Alert.AlertType.INFORMATION);
		aboutDialog.setTitle("About Notepad");
		aboutDialog.setHeaderText("JavaFX Notepad");
		aboutDialog.setContentText("Version 1.0\n Developed by Su Lay Phyu");
		aboutDialog.showAndWait();
	}
	public void setLayout()
	{
		mainBox=new VBox();
		mainBox.getChildren().add(Bar);
		mainBox.getChildren().add(tarea);
		tarea.setPrefHeight(700);
		//"monospaced"
		tarea.setFont(javafx.scene.text.Font.font(fontSize));
	}
	@Override
	public void start(Stage st) throws Exception {
		createMenuBar();
		setLayout();
		Scene sc=new Scene(mainBox,700,700);
		stage=st;
		stage.setScene(sc);
		stage.setTitle("Notepad");
		stage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);

	}

}
