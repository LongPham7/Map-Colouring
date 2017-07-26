import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AppFrame {
	
	private JFrame frame;
	
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private MapPanel map = new MapPanel();
	
	private MapSolver solver = new MapSolver(map);
	
	private JButton button1;
	private JButton button2;
	
	private JCheckBox blue;
	private JCheckBox red;
	private JCheckBox green;
	private JCheckBox yellow;
	
	public void activate() {
		frame = new JFrame("Map Colouring");
		frame.getContentPane().add(BorderLayout.NORTH, panel1);
		frame.getContentPane().add(BorderLayout.CENTER, panel2);
		
		button1 = new JButton("Colour the map");
		button2 = new JButton("Next colouring");
		
		blue = new JCheckBox("Blue");
		red = new JCheckBox("Red");
		green = new JCheckBox("Green");
		yellow = new JCheckBox("Yellow");

		panel1.setLayout(new GridBagLayout());
		addComponent(blue, panel1, 0, 0, 1);
		addComponent(red, panel1, 1, 0, 1);
		addComponent(green, panel1, 2, 0, 1);
		addComponent(yellow, panel1, 3, 0, 1);
		addComponent(button1, panel1, 0, 1, 2);
		addComponent(button2, panel1, 2, 1, 2);
		panel1.setBorder(BorderFactory.createTitledBorder("Control Panel"));
		
		panel2.setLayout(new GridBagLayout());
		addComponent(map, panel2, 0, 0, 1);
		panel2.setBorder(BorderFactory.createTitledBorder("Map"));
		
		map.setPreferredSize(new Dimension(500, 450));
		//map.repaint();
		//map.setVisible(true);

		button1.addActionListener(new Button1Listener());
		button2.addActionListener(new Button2Listener());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 600);
		frame.setVisible(true);
	}

	// Adds an input component to a specified JPanel at a specified coordinate.
	private void addComponent(Component component, JPanel panel, int x, int y, int width) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		panel.add(component, c);
	}
	
	// Action listener for a button
	class Button1Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			solver.solve();
		}
	}
	
	// Action listener for a button
	class Button2Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			solver.nextSolution();
		}
	}

}
