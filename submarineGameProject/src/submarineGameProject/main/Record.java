package submarineGameProject.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import submarineGameProject.Classes.Board;
import submarineGameProject.Classes.Coordinate;
import submarineGameProject.Classes.Player;

public class Record 
{

	public static void record(Player player, String info, Board myBoard) 
	{

		try (FileOutputStream myFile = new FileOutputStream("files/recordSaveFile.txt");
				ObjectOutputStream output = new ObjectOutputStream(myFile)) 
		{
			output.writeObject(player);
			output.writeObject(info);
			output.writeObject(myBoard);
		} 
		catch (IOException e) 
		{
			System.out.println(e);
		}
	}

	public static void printFile() 
	{
		try (FileInputStream myFile = new FileInputStream("files/recordSaveFile.txt");
				ObjectInputStream input = new ObjectInputStream(myFile)) 
		{

			System.out.println(input.readObject());
			System.out.println(input.readObject());
			System.out.println(input.readObject());

		} catch (IOException | ClassNotFoundException e) 
		{
			System.out.println(e);
		}
	}

	public static Coordinate[] getRecordedGuesses() 
	{
		try (FileInputStream myFile = new FileInputStream("files/recordSaveFile.txt");
				ObjectInputStream input = new ObjectInputStream(myFile)) 
		{

			Player player = (Player) input.readObject();
			return player.getGuesses();
			
		} catch (IOException | ClassNotFoundException e) 
		{
			System.out.println(e);
			return null;
		}
	}
	
	public static Board getMyBoard() 
	{
		try (FileInputStream myFile = new FileInputStream("files/recordSaveFile.txt");
				ObjectInputStream input = new ObjectInputStream(myFile)) 
		{

			input.readObject();
			input.readObject();
			return (Board)input.readObject();
			
		} catch (IOException | ClassNotFoundException e) 
		{
			System.out.println(e);
			return null;
		}
	}
}
