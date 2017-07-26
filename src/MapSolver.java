import java.util.Map;

import javax.swing.JOptionPane;

import org.jpl7.Query;
import org.jpl7.Term;

public class MapSolver {
	
	private MapPanel map;
	private Query query;
	
	public MapSolver(MapPanel map) {
		this.map = map;
	}
	
	public void solve() {
		String t1 = "consult('mapcolouring.pl')";
		System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
		//
		String t2 = "test_colour(test, X)";
		Query q2 = new Query(t2);
		query = q2;
		nextSolution();
	}
	
	public void nextSolution() {
		if (query.hasMoreSolutions()) {
			Map<String, Term> ans = query.nextSolution();
			//String result = ans.get("X").toString();
			displayResult(ans.get("X"));
		}
		else {
			JOptionPane.showMessageDialog(null, "No more solution", "Warning",
					JOptionPane.PLAIN_MESSAGE);
		}
	}
	
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
	
	private void refresh(Colour[] result) {
		map.setData(result);
		map.repaint();
	}

}
