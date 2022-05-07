package submarineGameProject.main;

import submarineGameProject.Exceptions.OutOfBoardException;
import submarineGameProject.Classes.Player;
import submarineGameProject.Exceptions.CoordinateException;
import submarineGameProject.Exceptions.OutOfTargetsException;

public class Runner 
{
	public static Game game = new Game();
	public static Player player = new Player("Faraj", "farajkhanjar@gmail.com", "0542459909");

	public static void main(String[] args) throws OutOfBoardException, CoordinateException, OutOfTargetsException 
	{		
		game.play();
		Record.record(player, ("Player status: " + game.getStatus()), game.getBoard());
	}
}
