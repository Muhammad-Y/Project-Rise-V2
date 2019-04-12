package rohansTest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;


import javax.swing.JPanel;

public class GridPanel extends JPanel {
	private int numberOfGrids;
	
	public GridPanel(int numberOfGrids) {
		this.numberOfGrids = numberOfGrids;
		setPreferredSize(new Dimension(100, 100));
		
	}
	
	public void setBackgroundColor(Color color) {
		setBackground(color);
	}
	
	public void rowPanel() {
		setLayout(new GridLayout(numberOfGrids, 1));
		
	}
	
	public void colPanel() {
		setLayout(new GridLayout(1, numberOfGrids));
	}
	
	public int getNumberOfGrids() {
		return this.numberOfGrids;
	}
	
}
