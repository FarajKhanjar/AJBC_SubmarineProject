package submarineGameProject.main;

import java.util.Random;
import java.util.Scanner;

import submarineGameProject.Classes.Board;
import submarineGameProject.Classes.Submarine;

public class Game 
{
	Scanner scanner = new Scanner(System.in);
	//Fields
	private Board board;
	private int hitsNumber;
	private int missNumber;
	private Status status;
	private int points = 1000;
	private int firstHitPoints;
	public  int numberOfSubmarineThatFound = 1;
	private int submarineLengthCounter=1;
	private boolean flag=false;
	
	//Constructor
	public Game() 
	{
		board = new Board(); //Create our board
		this.hitsNumber = 0; //default value
		this.missNumber = 0; //default value
		status = Status.PLAY;  //default value
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

	public void setPointsHit() 
	{		
		System.out.println(numberOfSubmarineThatFound);
		System.out.println(Submarine.coord1.getX());
		System.out.println(Board.randomRow);
		System.out.println(board.getSubmaribeLength());
		
		if(numberOfSubmarineThatFound == 1)
		{
			firstHitPoints = points;
			this.points = points + 200;					
			numberOfSubmarineThatFound++;		
		}
		else
		{
			if((this.points-firstHitPoints) == 200)
			{
				flag = true;	
			}
			else
			{
				flag = false;	
			}
			
			if (numberOfSubmarineThatFound == 2 && (Submarine.coord1.getX() == Board.randomRow) && flag == true) 
			{
				this.points = points + 1000;
				flag = false;
				numberOfSubmarineThatFound++;
			}
			
			if(flag = true) 
			{				
				this.numberOfSubmarineThatFound = 1;
				
			}
		}

	}
	
	public void setPointsMiss() 
	{
		this.points = points - 10;

	}
	
	public void play() 
	{		
		Random random = new Random();
		int rowChoice;
		int colChoice;
		
		System.out.println("Lets start the game...\n");
		Board.printConsole();
		
		while(status == Status.PLAY) 
		{
			System.out.print("Enter row: ");
			rowChoice = scanner.nextInt();
			System.out.print("Enter col: ");
			colChoice = scanner.nextInt();
			
		//	rowChoice = random.nextInt(Board.ROWS);
		//	colChoice = random.nextInt(Board.COLS);
			System.out.println("("+rowChoice+","+colChoice+")");
			scoreOfTheGame(board.changeTheBoard(rowChoice, colChoice));
			Board.print();
			System.out.println("The miss number is: "+this.missNumber);
			System.out.println("The hit number is: "+this.hitsNumber);
			statusInTheGame();
			System.out.println("Your status is: "+status);
			System.out.println("Your Points is: "+points);
		}

		System.out.println("You " + status + " the game!");
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
