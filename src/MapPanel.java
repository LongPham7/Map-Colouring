import java.awt.*;
import java.awt.geom.*;

import javax.swing.JPanel;

public class MapPanel extends JPanel {
	
	// Default serial version UID
	private static final long serialVersionUID = 1L;
	
	public static final int NUMBER_NODES = 7;
	
	private Colour[] colours = new Colour[NUMBER_NODES];
	private Coordinate[]  coordinates = new Coordinate[NUMBER_NODES];
	
	public MapPanel() {
		// Initialize the data array.
		for (int i = 0; i != NUMBER_NODES; i++) {
			colours[i] = Colour.WHITE;
		}
		
		// Initialize the coordinates.
		coordinates[0] = new Coordinate(50, 180);
		coordinates[1] = new Coordinate(150, 50);
		coordinates[2] = new Coordinate(330, 50);
		coordinates[3] = new Coordinate(450, 170);
		coordinates[4] = new Coordinate(450, 300);
		coordinates[5] = new Coordinate(270, 230);
		coordinates[6] = new Coordinate(400, 400);
	}
	
	public void setData(Colour[] colours) {
		assert colours.length == NUMBER_NODES;
		this.colours = colours;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		setBackground(Color.WHITE);
		connectNodes(g2);
		for (int i = 0; i != NUMBER_NODES; i++) {
			Coordinate xy = coordinates[i];
			paintCircle(g2, xy.getX(), xy.getY(), 40, colours[i]);
		}
	}
	
	private void paintCircle(Graphics2D g, int x, int y, int r, Colour c) {
		double halfRadius = ((double)r) / 2;
		switch (c) {
		case BLUE:
			g.setColor(Color.blue);
			break;
		case RED:
			g.setColor(Color.red);
			break;
		case GREEN:
			g.setColor(Color.green);
			break;
		case YELLOW:
			g.setColor(Color.yellow);
			break;
		case WHITE:
			g.setColor(Color.white);
			break;
		default:
			throw new Error("Illegal Colour");
			
		}
		g.fill(new Ellipse2D.Double(x - halfRadius, y - halfRadius, r, r));
		
		g.setColor(Color.black);
		g.draw(new Ellipse2D.Double(x - halfRadius, y - halfRadius, r, r));
	}
	
	private void connectNodes(Graphics2D g) {
		for (int i = 0; i != 4; i++) {
			drawLine(g, coordinates[i], coordinates[i+1]);
			drawLine(g, coordinates[i], coordinates[5]);
		}
		drawLine(g, coordinates[4], coordinates[5]);
	}
	
	private void drawLine(Graphics2D g, Coordinate first, Coordinate second) {
		g.setColor(Color.black);
		g.draw(new Line2D.Double(first.getX(), first.getY(), second.getX(), second.getY()));
	}
	
}
