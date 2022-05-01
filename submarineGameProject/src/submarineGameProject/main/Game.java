package submarineGameProject.main;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import submarineGameProject.Classes.Board;
import submarineGameProject.Classes.Submarine;
import submarineGameProject.Exceptions.BoardException;
import submarineGameProject.Exceptions.CoordinateException;
import submarineGameProject.Exceptions.SubmarineException;

public class Game 
{
	Scanner scanner = new Scanner(System.in);
	//Fields
	private Board board;
	private int hitsNumber;
	private int missNumber;
	private Status status;
	private int points = 1000;
	private int secondtHitPoints;
	public  int numberOfSubmarineThatFound = 1;
	private int submarineLengthCounter=1;
	private boolean flagOfDoubleHit;
	private boolean flagCheckCoordinate;
	private boolean flagCheckCoordinateOnBoard;

	
	//Constructor
	public Game() 
	{
		board = new Board(); //Create our board
		this.hitsNumber = 0; //default value
		this.missNumber = 0; //default value
		status = Status.PLAY;  //default value
		setDoubleHit(false);
	}

	private void setNumOfHits(int numOfHits) 
	{
		this.hitsNumber = numOfHits;
	}

	private void setNumOfMiss(int numOfMiss) 
	{
		this.missNumber = numOfMiss;
	}	
	
	public int getPoints() 
	{
		return points;
	}
	
	
	private boolean isDoubleHit() 
	{
		return flagOfDoubleHit;
	}
	
	private void setDoubleHit(boolean flagOfDoubleHit) 
	{
		this.flagOfDoubleHit = flagOfDoubleHit;
	}

	public void setPointsHit() 
	{		
		
		if(flagOfDoubleHit == true && secondtHitPoints==1000)
		{
			this.points+=secondtHitPoints;
		}
		else
		{
			this.points+=200;
			setDoubleHit(true);
			secondtHitPoints=1000;
		}
		
	}
	
	
	public void setPointsMiss() 
	{
		setDoubleHit(false);
		this.points = points - 10;

	}
	
	
	public void play() throws SubmarineException //throws BoardException, CoordinateException, SubmarineException 	
, BoardException
	{		
		Random random = new Random();
		int rowChoice;
		int colChoice;
		char resultVal;
		
		boolean breakOrContinue = true;
		System.out.println("Lets start the game...\n");
		Board.printConsole();
		
		while(status == Status.PLAY) 
		{	
			while(breakOrContinue = true)
			{
				System.out.print("Enter row: ");
				rowChoice = scanner.nextInt();
				System.out.print("Enter col: ");
				colChoice = scanner.nextInt();

				// rowChoice = random.nextInt(Board.ROWS);
				// colChoice = random.nextInt(Board.COLS);		
				
				flagCheckCoordinateOnBoard = checkIfCoordinateInRange(rowChoice,colChoice);	
				if(flagCheckCoordinateOnBoard)
				{					
					break;
				}	
				flagCheckCoordinate = (board.XYmatrix[rowChoice][colChoice]==' ') || (board.XYmatrix[rowChoice][colChoice]=='*');
				if(!flagCheckCoordinate)
				{
						System.out.println("Watch out please! ~> you choiced this coordinate before.");	
						break;
				}
				
				continueCheackingBoard(rowChoice,colChoice);				
			}

			if (!board.checkIfThereIsASubmarineAtBoard()) 
			{
				this.status = Status.WIN;
				//throw new SubmarineException();
			}
			
			
		}
		
		System.out.println("You " + status + " the game!");
	}
	
	public void continueCheackingBoard(int rowChoice,int colChoice)
	{
		System.out.println("Your Guess is: (" + rowChoice + "," + colChoice + ")");
		scoreOfTheGame(board.changeTheBoard(rowChoice, colChoice));
		Board.print();
		System.out.println("The miss number is: " + this.missNumber);
		System.out.println("The hit number is: " + this.hitsNumber);
		statusInTheGame();
		System.out.println("Your status is: " + status);
		System.out.println("Your Points is: " + points);
	}
	
	
	public boolean checkIfCoordinateInRange(int row, int col) 
	{
		boolean flagCheckX = checkCoordinateRange(row, board.ROWS, "Row");
		boolean flagCheckY =checkCoordinateRange(col, board.COLS, "Col");
		if((flagCheckX || flagCheckY))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean checkCoordinateRange(int index, int max, String nameOfIndex) //throws BoardException 
	{
		if (index < 0 || index >= max)
		{
			System.out.println("Its Invalid number of "+nameOfIndex+", it should be between 0 and " + (max - 1));
			return true;
		}
		else
		{
			return false;
		}
			
	}
		
	public void statusInTheGame() 
	{
		if(hitsNumber + missNumber == 100) 
		{
			if(hitsNumber > missNumber)
			{
				this.status = Status.WIN;
			}
			else
			{
				this.status = Status.LOST;
			}			
		}
	}

	public void scoreOfTheGame(char result) 
	{
		if(result == 'H') 
		{
			setNumOfHits(hitsNumber + 1);
			setPointsHit();
		}
		if(result == 'M') 
		{
			setNumOfMiss(missNumber + 1);
			setPointsMiss();
		}
	}
	
	public enum Status
	{
		PLAY,
		WIN,
		LOST;
	}
}
