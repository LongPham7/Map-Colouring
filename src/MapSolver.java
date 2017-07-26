import java.util.Map;

import javax.swing.JOptionPane;

import org.jpl7.Query;
import org.jpl7.Term;

/**
 * This class is a solver for a map colouring problem.
 */
public class MapSolver {

	// JPanel where a map is displayed
	private MapPanel map;

	// Prolog Query whose solutions are currently iterated
	private Query query;

	public MapSolver(MapPanel map) {
		this.map = map;
	}

	// Solves the map colouring problem and obtains the first solution. The Prolog
	// query issued in this method is stored in the instance variable "query".
	public void solve() {
		String t1 = "consult('mapcolouring.pl')";
		System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));

		String t2 = "test_colour(test, X)";
		Query q2 = new Query(t2);
		query = q2;
		nextSolution();
	}

	// Obtains the next solution if it exists.
	public void nextSolution() {
		if (query == null) {
			JOptionPane.showMessageDialog(null, "Click 'Colour the map' first.", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (query.hasMoreSolutions()) {
			Map<String, Term> ans = query.nextSolution();
			displayResult(ans.get("X"));
		} else {
			JOptionPane.showMessageDialog(null, "No more solution", "Warning", JOptionPane.PLAIN_MESSAGE);
		}
	}

	// Displays a solution on the map.
	private void displayResult(Term answer) {
		Term[] resultArray = answer.toTermArray();
		assert resultArray.length == MapPanel.NUMBER_NODES;
		Colour[] result = new Colour[MapPanel.NUMBER_NODES];
		for (int i = 0; i != 7; i++) {
			String colour = resultArray[i].arg(2).toString(); // Retrieve the second argument.
			result[i] = convertColour(colour);
		}
		refresh(result);
	}

	// Converts an input string to the corresponding object of class Colour.
	private Colour convertColour(String colour) {
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

	// Refreshes the JPanel where a map is displayed.
	private void refresh(Colour[] result) {
		map.setData(result);
		map.repaint();
	}
}
