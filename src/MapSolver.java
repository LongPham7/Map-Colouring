import java.util.ArrayList;
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
	public void solve(ArrayList<String> colours) {
		String t1 = "consult('mapcolouring.pl')";
		System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));

		String t2 = String.format("test_colour(test, %s, X)", format(colours));
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
			result[i] = Colour.convertColour(colour);
		}
		refresh(result);
	}

	// Refreshes the JPanel where a map is displayed.
	private void refresh(Colour[] result) {
		map.setData(result);
		map.repaint();
	}
	
	// Returns a properly formatted string for a list of colours. 
	private String format(ArrayList<String> colours) {
		String result = String.join(", ", colours);
		return "[" + result + "]";
	}
}
