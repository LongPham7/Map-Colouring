import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AppFrame {
	
	private JFrame frame;
	
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel map = new MapPanel();
	
	private JLabel label1;
	private JLabel label2;
	
	private JButton button;
	
	private JCheckBox blue;
	private JCheckBox red;
	private JCheckBox green;
	private JCheckBox yellow;
	
	public void activate() {
		frame = new JFrame("Map Colouring");
		frame.getContentPane().add(BorderLayout.NORTH, panel1);
		frame.getContentPane().add(BorderLayout.CENTER, panel2);
		
		label1 = new JLabel("Select the colours you wish to use.");
		label2 = new JLabel("Result");
		
		button = new JButton("Colour the map");
		
		blue = new JCheckBox("Blue");
		red = new JCheckBox("Red");
		green = new JCheckBox("Green");
		yellow = new JCheckBox("Yellow");

		panel1.setLayout(new GridBagLayout());
		addComponent(label1, panel1, 0, 0, 1);
		addComponent(blue, panel1, 0, 1, 1);
		addComponent(red, panel1, 0, 2, 1);
		addComponent(green, panel1, 0, 3, 1);
		addComponent(yellow, panel1, 0, 4, 1);
		addComponent(button, panel1, 1, 1, 1);
		
		panel2.setLayout(new GridBagLayout());
		addComponent(label2, panel2, 0, 0, 1);
		addComponent(map, panel2, 0, 1, 1);
		
		map.setBackground(Color.WHITE);
		map.setPreferredSize(new Dimension(500, 350));

		button.addActionListener(new ButtonListener());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
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
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
		}
	}

}
