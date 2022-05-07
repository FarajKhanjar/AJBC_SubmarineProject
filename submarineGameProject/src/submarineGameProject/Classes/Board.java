package submarineGameProject.Classes;

import java.util.Arrays;
import java.util.Random;

import submarineGameProject.Exceptions.OutOfBoardException;
import submarineGameProject.Exceptions.CoordinateException;
import submarineGameProject.Exceptions.OutOfTargetsException;

public class Board 
{
	Random random = new Random();
	public static char[][] XYmatrix;
	private Submarine submarines;	
	public static int ROWS = 10;
	public static int COLS = 20;
	public static int SUBMARINES_NUMBER = 5;
	public static int SUBMARINE_LENGTH = 4;
	public static int randomLength;
	public static int randomRow;
	private boolean flagThatThereIsASubmarine=false;
	private static int patternsNumberThatHit;

	public Board() 
	{
		XYmatrix = new char[ROWS][COLS];
		initBoard();
		placeTheSubmarineOnBoard();
	}
	
	public int getSubmaribeLength()
	{
		return this.randomLength;
	}

	public void initBoard() 
	{		
		for (int i = 0; i < ROWS; i++) 
		{
			for (int j = 0; j < COLS; j++) 
			{
					XYmatrix[i][j] = ' ';
			}
		}
	}
	
	public void placeTheSubmarineOnBoard() 
	{		
		int index=0;
		int rowRandom;	
		int colRandom;
		
		for (int i = 0; i < ROWS; i++) 
		{
			for (int j = 0; j < COLS; j++) 
			{
				while(index<SUBMARINES_NUMBER)
				{
			    rowRandom = random.nextInt(ROWS);
			    colRandom = random.nextInt(COLS-4);
			    this.randomLength = (int) ((Math.random() * (3)) + 1);
			  //  System.out.println(randomLength);
			    randomRow = (int) (Math.random() * 9);
			 //   System.out.println(randomRow);
			    								
					Coordinate coordinat1 = new Coordinate (randomRow,colRandom);
					Coordinate coordinat2 = new Coordinate (randomRow,colRandom+(this.randomLength));
					
					submarines = new Submarine(coordinat1,coordinat2);
					
					for(int w=coordinat1.getY(); w<coordinat2.getY();w++)
					{
						XYmatrix[randomRow][w] = '*';
						
					}
					index++;
							
				//	print();  // step by step , creating the board
				}				
			}
		}
	}
	
	public static void print() 
	{
		int rowsNum = 10 ;

		System.out.print("   ");
		printRowNumbers(0, rowsNum);
		printRowNumbers(rowsNum, COLS);
		System.out.println();

		for (int i = 0; i < ROWS; i++) 
		{
			for (int j = 0; j < COLS; j++) 
			{
				if (j == 0) 
				{
					System.out.print(i + "  ");
				}
				if(j > 10)
				{
					System.out.print(" " + XYmatrix[i][j] + "  ");
				}
				else
				{
					System.out.print(XYmatrix[i][j] + "  ");
				}
			}
			System.out.println();
		}
	}
	
	public static void printConsole() 
	{
		int rowsNum = 10 ;

		System.out.print("   ");
		printRowNumbers(0, rowsNum);
		printRowNumbers(rowsNum, COLS);
		System.out.println();

		for (int i = 0; i < ROWS; i++) 
		{
			for (int j = 0; j < COLS; j++) 
			{
				if (j == 0) 
				{
					System.out.print(i + "  ");
				}
				
			}
			System.out.println();
		}
	}
	
	public static void printWithout() 
	{
		int rowsNum = 10 ;

		System.out.print("   ");
		printRowNumbers(0, rowsNum);
		printRowNumbers(rowsNum, COLS);
		System.out.println();

		for (int i = 0; i < ROWS; i++) 
		{
			for (int j = 0; j < COLS; j++) 
			{
				
				if (j == 0) 
				{
					System.out.print(i + "  ");
				}
				if(j > 10)
				{
					if(XYmatrix[i][j] == '*')
					{
						System.out.print(" " + " " + "  ");
					}
					else
					{
					System.out.print(" " + XYmatrix[i][j] + "  ");
					}
				}
				else
				{
					if(XYmatrix[i][j] == '*')
					{
						System.out.print(" " + "  ");
					}
					else
					{
					System.out.print(XYmatrix[i][j] + "  ");
					}
				}
			}
			System.out.println();
		}
	}

	private static void printRowNumbers(int firstNumber, int lastNumber) 
	{
		for (int i = firstNumber; i < lastNumber; i++) 
		{
			System.out.print(i + "  ");
		}
	}

	public char changeTheBoard(int row, int col) 
	{
		if(XYmatrix[row][col] == '*')
		{
			XYmatrix[row][col] = 'H';
		}
		if(XYmatrix[row][col] == ' ') 
		{
			XYmatrix[row][col] = 'M';
		}
		
		return (XYmatrix[row][col]);
	}
	
	
	public boolean checkIfThereIsASubmarineAtBoard() 
	{		
		for (int i = 0; i < ROWS; i++) 
		{
			for (int j = 0; j < COLS; j++) 
			{
				if(XYmatrix[i][j] == '*')
				{
					flagThatThereIsASubmarine = true;
					return flagThatThereIsASubmarine;				
				}
					
			}
		}
		return false;
	}
}
