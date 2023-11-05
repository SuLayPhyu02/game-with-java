 package uiTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MenuAndCharts extends Application{

	private Menu fileMenu,chartMenu;
	private MenuItem openMI,exitMI,newMI,saveMI,pieChart,lineChart,barChart;
	private MenuBar bar;
	private VBox vb;
	private TextArea tarea;
	private Stage stage;
	private PieChart pc;
	private BarChart bc;
	private LineChart lc;
	public void createMenuBar()
	{
		fileMenu=new Menu("File");
		openMI=new MenuItem("Open");
		openMI.setOnAction(e->{
			open();
		});
		exitMI=new MenuItem("Exit");
		newMI=new MenuItem("New");
		newMI.setOnAction(e->{
			tarea.setText("");
		});
		saveMI=new MenuItem("Save");
		saveMI.setOnAction(e->{
			save();
		});
		fileMenu.getItems().add(newMI);
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(openMI);
		fileMenu.getItems().add(saveMI);
		fileMenu.getItems().add(new SeparatorMenuItem()); 
		fileMenu.getItems().add(exitMI);
		
		chartMenu=new Menu("Chart");
		pieChart=new MenuItem("PieChart");
		pieChart.setOnAction(e->{
			createPieChart();
		});
		lineChart=new MenuItem("LineChart");
		lineChart.setOnAction(e->{
			createLineChart();
		});
		barChart=new MenuItem("BarChart");
		barChart.setOnAction(e->{
			createBarChart();
		});
		chartMenu.getItems().add(pieChart);
		chartMenu.getItems().add(barChart);
		chartMenu.getItems().add(lineChart);
		
		bar=new MenuBar(fileMenu,chartMenu);
		tarea=new TextArea();
	}
	public void open()
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
	public void save()
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
	
	public void createPieChart()
	{
		vb.getChildren().remove(tarea);
		vb.getChildren().remove(bc);
		vb.getChildren().remove(lc);
		pc=new PieChart();
		PieChart.Data d1=new Data("Window",700);
		PieChart.Data d2=new Data("MacOs",300);
		PieChart.Data d3=new Data("Linux",200);
		
		pc.getData().addAll(d1,d2,d3);
		vb.getChildren().add(pc);
	}
	public void createBarChart()
	{
		vb.getChildren().remove(tarea);
		vb.getChildren().remove(pc);
		vb.getChildren().remove(lc);
		
		CategoryAxis xa=new CategoryAxis();
		xa.setLabel("Month");
		
		NumberAxis ya=new NumberAxis();
		ya.setLabel("Income");
		
		bc=new BarChart(xa,ya);
		
		XYChart.Series<String, Integer> s2000=new Series<>();
		s2000.setName("2000");
		s2000.getData().add(new XYChart.Data("Jan",20000000));
		s2000.getData().add(new XYChart.Data("Feb",18000000));
		s2000.getData().add(new XYChart.Data("March",20500000));
		
		XYChart.Series<String, Integer> s2001=new Series<>();
		s2001.setName("2001");
		s2001.getData().add(new XYChart.Data("Jan",30000000));
		s2001.getData().add(new XYChart.Data("Feb",28000000));
		s2001.getData().add(new XYChart.Data("March",35000000));
		
		
		bc.getData().addAll(s2000,s2001);
		vb.getChildren().add(bc);
	}
	public void createLineChart()
	{
		vb.getChildren().remove(tarea);
		vb.getChildren().remove(bc);
		vb.getChildren().remove(pc);
		
		CategoryAxis xa=new CategoryAxis();
		xa.setLabel("Month");
		
		NumberAxis ya=new NumberAxis();
		ya.setLabel("Income");
		
		lc=new LineChart<>(xa, ya);
		
		XYChart.Series<String, Integer> s2000=new Series<>();
		s2000.setName("2000");
		s2000.getData().add(new XYChart.Data("Jan",20000000));
		s2000.getData().add(new XYChart.Data("Feb",18000000));
		s2000.getData().add(new XYChart.Data("March",20500000));
		
		XYChart.Series<String, Integer> s2001=new Series<>();
		s2001.setName("2001");
		s2001.getData().add(new XYChart.Data("Jan",30000000));
		s2001.getData().add(new XYChart.Data("Feb",28000000));
		s2001.getData().add(new XYChart.Data("March",35000000));
		
		lc.getData().addAll(s2000,s2001);
		vb.getChildren().add(lc);
	}
	public void setLayout()
	{
		vb=new VBox();
		vb.getChildren().add(bar);
		vb.getChildren().add(tarea);
	}
	private void setGeometry()
	{
//		tarea.setPrefHeight(500);
		tarea.setPrefColumnCount(100);
	}
	@Override
	public void start(Stage st) throws Exception {
		stage=st;
		createMenuBar();
		setGeometry();
		setLayout();
		
		Scene sc=new Scene(vb,900,700);
		st.setScene(sc);
		st.setTitle("Report");
		st.show();
		
	}
	public static void main(String[] args) {
		Application.launch(args);

	}

	

}
