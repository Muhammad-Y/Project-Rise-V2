package cheat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dice.BetterDice;

/**
 * @author Sebastian Viro, Muhammad Abdulkhuder
 *
 */
public class CheatGui extends JPanel implements ActionListener {

	private JTextField inputTF = new JTextField("");
	private JButton btnTeleport = new JButton("Teleport");
	private BetterDice betterDice;
	private int index;

	public CheatGui(BetterDice betterDice) {
		this.betterDice = betterDice;
		startGUI();
	}

	private void startGUI() {
		setPreferredSize(new Dimension(300, 100));
		setLayout(new BorderLayout());
		
	//	btnTeleport.setPreferredSize(new Dimension(300,50));
		add(inputTF, BorderLayout.CENTER);
		add(btnTeleport, BorderLayout.SOUTH);
		btnTeleport.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnTeleport) {
			try {
				setIndex(Integer.parseInt(inputTF.getText()));
				betterDice.moveWCheat(getIndex());

			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}

	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
		
	}

}
