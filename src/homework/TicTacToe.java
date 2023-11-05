package homework;

import java.util.*;

public class TicTacToe{

	static char arr2[][];
	static int Hc=0,Vc=0,MDc=0,ODc=0;
	static int d;
	static int count=1;
	public static void forCA(Integer d)
	{
		arr2=new char[d][d];
		for(int r=0;r<d;r++)
		{
			for(int c=0;c<d;c++)
			{
				arr2[r][c]=' ';
			}
		}
	}
	public static int getDimension()
	{
		return arr2.length;
	}
	public static boolean isGameOver()
	{
		for(int r=0;r<arr2.length;r++)
		{
			for(int c=0;c<arr2[r].length;c++)
			{
				if(arr2[r][c]==' ')
				{
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isHWin(int r,char ch)
	{
		for(int c=0;c<arr2[r].length;c++)
		{
			if(arr2[r][c]!=ch)
			{
				return false;
			}
		}
		return true;
	}
	public static boolean isVWin(int c,char ch)
	{
		for(int r=0;r<arr2.length;r++)
		{
			if(arr2[r][c]!=ch)
				return false;
		}
		return true;
	}
	public static boolean isMDWin(int r,int c,char ch)
	{
		if(r!=c)
			return false;
		else
		{
			for(int i=0;i<arr2.length;i++)
			{
				if(arr2[i][i]!=ch)
					return false;
			}
			return true;
		}
	}
	public static boolean isODWin(int r,int c,char ch)
	{
		int length=arr2.length;
		if(length-1-r!=c)
		{
			return false;
		}
		else
		{
			for(int i=0;i<arr2.length;i++)
			{
				if(arr2[i][length-1-i]!=ch)
					return false;
			}
			return true;
		}
	}
	public static boolean isWin(int r,int c,char ch)
	{
		return isHWin(r, ch) || isVWin(c, ch) || isMDWin(r, c, ch) || isODWin(r, c, ch);
	}
	public static void display()
	{
		System.out.println("The current "
				+ "board is ");
		for(int r=0;r<arr2.length;r++)
		{
			System.out.print("|");
			for(int c=0;c<arr2.length;c++)
			{
				System.out.print(arr2[r][c]+"|");
			}
			System.out.println();
		}
	}		
	public static void fill(int r,int c,char ch)
	{
		if(arr2[r][c]==' ')
		{
			arr2[r][c]=ch;
		}
		count++;
		System.out.println("count in fill "+count);
	}
	public static String cfill(char ch,int d)
	{
		String st="";
		int r,c;
		do{
		r=(int)(Math.random()*d);
		c=(int)(Math.random()*d);
		}while(arr2[r][c]!=' ');
		arr2[r][c]=ch;
		count++;
		System.out.println("count in cfill"+count);
		st+=r+"_"+c;
		return st;
	}
	public static char[][] getSpace()
	{
		for(int r=0;r<arr2.length;r++)
		{
			for(int c=0;c<arr2[r].length;c++)
			{
				if(arr2[r][c]==' ')
				{
					arr2[r][c]='_';
				}
			}
		}
		return arr2;
	}
	public static String upgradeAI(char ch,int dimension)
	{
		String st="";
		int r,c,length;
		r=(int)(Math.random()*dimension);
		c=(int)(Math.random()*dimension);
		System.out.println("count in upgradeAI"+count);
		if(count==2 && (dimension%2)!=0)
		{
			count++;
			length=(dimension-1)/2;
			if(arr2[length][length]==' ')
			{
				System.out.println(length+" length");
				arr2[length][length]=ch;
				st+=length+"_"+length;
				System.out.println("count==2 in upgradeAI"+count);
			}
			else
			{
				st=cfill('O', dimension);
			}
		}
		else
		{
			st=cfill('O', dimension);
		}
		return st;
	}
//	public static String makeComputerMove(int dimension)
//	{
//		String st="";
//		int bestScore=Integer.MIN_VALUE;
//		int bestRow=-1;
//		int bestColum=-1;
//		for(int row=0;row<dimension;row++)
//		{
//			for(int col=0;col<dimension;col++)
//			{
//				row=(int)(Math.random()*d);
//				col=(int)(Math.random()*d);
//				if(arr2[row][col]==' ')
//				{
//					arr2[row][col]='O';
//					int score=evaluated('O');
//					arr2[row][col]=' ';
//					
//					if(score>bestScore)
//					{
//						bestScore=score;
//						bestRow=row;
//						bestColum=col;
//						System.out.println("best score "+bestScore);
//						System.out.println("best row"+bestRow);
//						System.out.println("best col"+bestColum);
//					}
//				}
//			}
//		}
//		st+=bestRow+"_"+bestColum;
//		return st;
//		
//	}
//	public static int evaluated(char c)
//	{
//		int score=0;
//		//check row
//		for(int row=0;row<arr2.length;row++)
//		{
//			int count=0;
//			for(int col=0;col<arr2.length;col++)
//			{
//				if(arr2[row][col]!=' ' && arr2[row][col]==c)
//				{
//					count++;
//				}
//			}
//		}
//		score+=scoreCount(count);
//		//check col
//		for(int col=0;col<arr2.length;col++)
//		{
//			int count=0;
//			for(int row=0;row<arr2.length;row++)
//			{
//				if(arr2[row][col]!=' ' && arr2[row][col]==c)
//				{
//					count++;
//				}
//			}
//		}
//		score+=scoreCount(count);
//		//check diagonals
//		 int count = 0;
//		    for (int i = 0; i < arr2.length; i++) {
//		        if (arr2[i][i] !=' ' && arr2[i][i]==c) {
//		            count++;
//		        }
//		    }
//		    score += scoreCount(count);
//		    count = 0;
//		    for (int i = 0; i < arr2.length; i++) {
//		        if (arr2[i][arr2.length - 1 - i] !=' ' && arr2[i][arr2.length- 1 - i]==c) {
//		            count++;
//		        }
//		    }
//		    score += scoreCount(count);
//		    return score;
//	}
//	public static int scoreCount(int count)
//	{
//		if(count==2)
//		{
//			return 2;
//		}
//		else if(count==3)
//		{
//			return 10;
//		}
//		else
//		{
//			return 0;
//		}
//	}
//	public static String hightlevelAI(char ch,int d)
//	{
//		if((r==0&&c==0)|(r==d-1&& c==d-1))
//		{
//			Hc++;
//			Vc++;
//			MDc++;
//		}
//		String st="";
//		int r,c;
//		r=(int)(Math.random()*d);
//		c=(int)(Math.random()*d);
//		if(count==1)
//		{
//			if(checkOnlyBlank(r,c))
//			{
//				arr2[r][c]=ch;
//				st+=r+"_"+c;
//				return st;
//			}
//			else
//			{
//				r=(int)(Math.random()*d);
//				c=(int)(Math.random()*d);
//			}
//		}
//		return "";
//		}

}
