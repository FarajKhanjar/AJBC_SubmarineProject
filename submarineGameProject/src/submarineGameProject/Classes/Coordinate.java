package submarineGameProject.Classes;

import java.io.Serializable;

/**
* This class represents a set of coordinates
*/
public class Coordinate  implements Serializable
{
	// Coordinate fields
	private static final long serialVersionUID = 111125499484783L;
	private int x;
	private int y;
	private int numId;

	
	public Coordinate(int x, int y) 
	{
		this.x = x;
		this.y = y;
		
	}
	
	public Coordinate(int numId, int x, int y) {
		setNumId(numId);
		setX(x);
		setY(y);
	}

	public int getX() 
	{
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	private void setNumId(int numId) {
		this.numId = numId;
	}

	private void setX(int x) {
		this.x = x;
	}

	private void setY(int y) {
		this.y = y;
	}

	public boolean equals(Coordinate coord) 
	{
		if (this.x == coord.getX() && this.y == coord.getY()) 
		{
			return true;
		} 
		else
		{
			return false;
		}
	}
}
