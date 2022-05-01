package submarineGameProject.Classes;

/**
5 * This class represents a set of coordinates
6 */
public class Coordinate 
{
	// Coordinate fields
	private int x;
	private int y;

	
	public Coordinate(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}

	public int getX() 
	{
		return this.x;
	}

	public int getY() {
		return this.y;
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
