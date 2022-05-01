package submarineGameProject.Classes;

import java.util.Scanner;

public class Submarine 
{
	Scanner scanner = new Scanner(System.in);

	 public static Coordinate coord1 = null;
	 public static Coordinate coord2 = null;
	 public static final char PATTERN = '*';
	 private int submarineLength=4;
	
	
	 Coordinate[] coords = new Coordinate[submarineLength];
	
	 public Submarine(Coordinate coord1, Coordinate coord2) 
	 {
		 
		// System.out.println(coord1.getX()+""+coord1.getY());
		// System.out.println(coord2.getX()+""+coord2.getY());
		// System.out.println("***");
		 this.coord1 = coord1;
		 this.coord2 = coord2;
		 coords[0] = (coord1);
		 coords[1]=(coord2);
	 }
	
}
