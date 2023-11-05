package homework;

import java.util.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TicTacToeModel extends Application{
	private GridPane gp;
	private FlowPane fp;
	private BorderPane mainPane;
	private Label title;
	private TextField no;
	private Button clickbtn;
	private Button [][]btn;
	
	public void createbtnArray(int d)
	{
		btn=new Button[d][d];
		for(int i=0;i<d;i++)
		{
			for(int j=0;j<d;j++)
			{
				Button b=new Button("e"+i+" "+j);
				btn[i][j]=b;
				System.out.println("i "+i);
				System.out.println("j "+j);
			}
		}
	}
	public void CreateNode()
	{
		title=new Label("Enter no of dimension **(greater than or equal 3)**:");
		no=new TextField();
		no.setMaxSize(100, 50);
		clickbtn=new Button("Click");
		clickbtn.setMaxSize(100, 20);
		fp=new FlowPane(no,clickbtn);
		mainPane=new BorderPane();
		
		clickbtn.setOnAction(e->{
			Integer arrno=getButton();
			System.out.println("button text no "+arrno);
			gp=new GridPane();
			btn=new Button[arrno][arrno];
			//createbtnArray(arrno);
			for(int i=0;i<arrno;i++)
			{
				for(int j=0;j<arrno;j++)
				{
					
					Button b=new Button();
					btn[i][j]=b;
					gp.add(btn[i][j], i, j);
					Setting(btn,i,j);
					System.out.println("button i "+i);
					System.out.println("button j "+j);
					btn[i][j].setMinSize(50,50);
				}
			}
			
			mainPane.setCenter(gp);
		});
		mainPane.setTop(title);
		mainPane.setBottom(fp);
		mainPane.setAlignment(fp, Pos.CENTER);
		
	}
	public void Setting(Button[][] btn,int i,int j)
	{
		System.out.println(btn);

		btn[i][j].setOnAction(e->{
			test(i,j,btn.length);
		});
		
	}
	public void test(int n1,int n2,Integer d)
	{
		TicTacToe.forCA(d);
		do {
			System.out.println("Player 1 , your turn:");
			TicTacToe.fill(n1,n2,'X');
			if(TicTacToe.isWin(n1,n2, 'X'))
			{
				System.out.println("Player 1 , you win the game.");
				break;
			}
			if(TicTacToe.isGameOver())
			{
				System.out.println("Game Over ! ");
				break;
			}
			System.out.println("AI, your turn:");
//			int randR=(int)(Math.random()*d);
//			int randC=(int)(Math.random()*d);
//			TicTacToe.cfill(randR,randC,'O');
//			if(TicTacToe.isWin(randR,randC,'O'))
//			{
//				System.out.println("AI, you win the game.");
//				break;
//			}
//			if(TicTacToe.isGameOver())
//			{
//				System.out.println("Game Over ! ");
//				break;
//			}
		}while(true);
	}
	public Integer getButton()
	{
		Integer butt=Integer.valueOf(no.getText().trim());
		return butt;
	}
	@Override
	public void start(Stage stage) throws Exception 
	{
		CreateNode();
		Scene sc=new Scene(mainPane,300,300);
		stage.setScene(sc);
		stage.setTitle("Tic_Tac_Toe");
		stage.show();
	}
	public static void main(String[] args) 
	{
		Application.launch(args);
	}

}

