package homework;

import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class TicTacToeModelAgain extends Application{
	private Button clickbtn;
	private TextField text;
	private Label title,win,lose,gameover;
	private HBox assignbox;
	private GridPane gp;
	private BorderPane mainPane;
	private int dimension=0;
	private Button[][]btn;
	private boolean check=true;
	public void creatNode()
	{
		title=new Label("Enter no of dimension **(greater than or equal 3)**");
		text=new TextField();
		text.setPrefSize(150,40);
		clickbtn=new Button("Click");
		clickbtn.setMinSize(70,40);
		win=new Label();
		lose=new Label();
		gameover=new Label();
		clickbtn.setOnAction(e->{
			dimension=getTextButton();
			System.out.println(dimension);
			createButton(dimension);
			title.setText("");
			clickbtn.setDisable(true);
			text.setDisable(true);
		});
	}
	public void createButton(int dimension)
	{
		TicTacToe.forCA(dimension);
		gp=new GridPane();
		btn=new Button[dimension][dimension];
		for(int i=0;i<dimension;i++)
		{
			for(int j=0;j<dimension;j++)
			{
				int n1=i;
				int n2=j;
				Button b=new Button();
				btn[i][j]=b;
				b.setOnAction(e->{
					functionCall(btn,b,n1,n2);
					b.setDisable(true);
				});
				gp.add(b, i, j);
				btn[i][j].setMinSize(70,70);
				gp.setAlignment(Pos.CENTER);
				gp.setPadding(new Insets(50));
			}
		}
		mainPane.setCenter(gp);
	}
	public void setDisableButton(Button btn[][])
	{
		char arr[][]=TicTacToe.getSpace();
		for(int i=0;i<btn.length;i++)
		{
			for(int j=0;j<btn.length;j++)
			{
				
				if(arr[i][j]=='_')
				{
					btn[i][j].setDisable(true);
					System.out.println("i divisible to btn["+i+"]["+j+"].");
				}
			}
		}
	}
	public void functionCall(Button btn[][],Button b,int r,int c)
	{
		
		if(check)
		{
			TicTacToe.fill(c,r,'X');
			System.out.println("R"+r);
			System.out.println("C"+c);
			b.setText("X");
			System.out.println();
			TicTacToe.display();
			if(TicTacToe.isWin(c,r,'X'))
			{
				setDisableButton(btn);
				win.setText("You win the game");
				mainPane.setTop(win);			
				mainPane.getStyleClass().add("mainpaneWin");
				TicTacToe.display();
				System.out.println("Palyer X Win");
				check=false;
				
			}
		}
		if(check && TicTacToe.isGameOver())
		{
			setDisableButton(btn);
			gameover.setText("Game Over");
			mainPane.setTop(gameover);
			mainPane.getStyleClass().add("mainpaneLose");
			System.out.println("Game Over");
			check=false;
			
		}
		if(check)
		{
			String st=TicTacToe.upgradeAI('O',dimension);
			String arr[]=st.split("_");
			int randR=Integer.valueOf(arr[0]);
			int randC=Integer.valueOf(arr[1]);
			
			System.out.println("RandR"+randR);
			System.out.println("RandC"+randC);
			System.out.println();
			TicTacToe.display();
			System.out.println("AI turn and his random r and c is "+randR+" and "+randC);
			btn[randC][randR].setText("O");
			btn[randC][randR].setDisable(true);
			if(TicTacToe.isWin(randR, randC,'O'))
			{
				setDisableButton(btn);
				lose.setText("You lose the game");
				mainPane.setTop(lose);
				mainPane.getStyleClass().add("mainpaneLose");
				TicTacToe.display();
				System.out.println("AI win the game");
				check=false;
				
			}
		}
		if(check && TicTacToe.isGameOver())
		{
			setDisableButton(btn);
			gameover.setText("Game Over");
			mainPane.setTop(gameover);
			mainPane.getStyleClass().add("mainpaneLose");
			System.out.println("Game Over");
			check=false;
			
		}
	}
	public int getTextButton()
	{
		int no=Integer.valueOf(text.getText());
		return no;
	}
	public void setLayout()
	{
		assignbox=new HBox(text,clickbtn);
		assignbox.setSpacing(20);
		assignbox.setAlignment(Pos.CENTER);
		mainPane=new BorderPane();
		mainPane.setTop(title);
		mainPane.setBottom(assignbox);
	}
	public void setStyle()
	{
		title.setId("header");
		gameover.setId("gameover");
		win.setId("win");
		lose.setId("lose");
		
		mainPane.getStyleClass().add("mainpane");
		clickbtn.setId("clickbtn");
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		creatNode();
		setLayout();
		Scene sc=new Scene(mainPane,500,500);
		URL url=this.getClass().getResource("imageStyle.css");
		sc.getStylesheets().add(url.toExternalForm());
		setStyle();
		stage.setScene(sc);
		stage.setTitle("Tic Tac Toe");
		stage.show();
		
	}
	public static void main(String
			arg[])
	{
		Application.launch(arg);
	}

}
