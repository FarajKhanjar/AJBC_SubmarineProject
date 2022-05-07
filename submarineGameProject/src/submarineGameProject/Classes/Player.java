package submarineGameProject.Classes;

import java.io.Serializable;
import java.util.Arrays;

import submarineGameProject.main.Game;

public class Player implements Serializable
{

	private static final long serialVersionUID = 793667094464372017L;
	private String name;
	private String email;
	private String phoneNumber;
	private Coordinate[] CoordinateArray;
	private int guessCounter;

	public Player(String name, String email, String phoneNumber) {
		setName(name);
		setEmail(email);
		setPhoneNumber(phoneNumber);
		this.CoordinateArray = new Coordinate[Game.GUESSES_COORDINATE];
		this.guessCounter = 0;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	private void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void addGuess(int x, int y) {
		this.CoordinateArray[guessCounter++] = new Coordinate(guessCounter, x, y);
	}
	
	public Coordinate[] getGuesses() {
		return CoordinateArray;
	}

	public void setGuesses(Coordinate[] guesses) {
		this.CoordinateArray = guesses;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + ", \nguesses:\n"
				+ Arrays.toString(CoordinateArray) + "]";
	}
}
