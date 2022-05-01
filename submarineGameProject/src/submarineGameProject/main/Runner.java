package submarineGameProject.main;

import submarineGameProject.Exceptions.BoardException;
import submarineGameProject.Exceptions.CoordinateException;
import submarineGameProject.Exceptions.SubmarineException;

public class Runner {

	public static void main(String[] args) throws BoardException, CoordinateException, SubmarineException 
	{
		Game game = new Game();
		
			game.play();
	}
}
