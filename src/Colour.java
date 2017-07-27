/** 
 * This enumerates the four colours used for map colouring, plus white, which is 
 * the colour of nodes in the initial state. 
 * */
public enum Colour {
	BLUE, RED, GREEN, YELLOW, WHITE;
	
	// Converts an input string to the corresponding object of class Colour.
	public static Colour convertColour(String colour) {
		switch (colour) {
		case "blue":
			return Colour.BLUE;
		case "red":
			return Colour.RED;
		case "green":
			return Colour.GREEN;
		case "yellow":
			return Colour.YELLOW;
		default:
			throw new Error("Illegal colour");
		}
	}
}
