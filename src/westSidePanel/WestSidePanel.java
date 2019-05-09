package westSidePanel;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.border.Border;

public class WestSidePanel extends JPanel {

	/**
	 * WestPanel which shows Info about each Boxes.
	 * 
	 * @author Rohan
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblInfoTitle, lblHistoryTitle;
	private JPanel pnlSpace, pnlHeading, pnlInfo, pnlHistory, pnlBtn, pnlInBtn;
	private Font font = new Font("ALGERIAN", Font.BOLD, 16);
	private JTextArea txtTileInfo = new JTextArea();
	private JTextArea txtMessage = new JTextArea();
	private JScrollPane scroller = new JScrollPane(txtMessage);
	private Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
	private JButton btnManage = new JButton("Manage Properties");
	private String def = "Move your mouse on a tile \nwhich you wanna see \ninformation about!";
	private String title = "Information";
	private Color titleColor = Color.DARK_GRAY;

	public WestSidePanel() {

		// HeadPanel with Information Label
		pnlSpace = new JPanel();

		pnlSpace.setPreferredSize(new Dimension(10, 15));
		pnlSpace.setOpaque(false);
		pnlHeading = new JPanel();
		pnlHeading.setBorder(border);
		pnlHeading.setPreferredSize(new Dimension(340, 80));
		lblInfoTitle = new JLabel(title);

		lblInfoTitle.setFont(new Font("ALGERIAN", Font.BOLD, 26));
		lblInfoTitle.setPreferredSize(new Dimension(320, 70));
		lblInfoTitle.setBorder(BorderFactory.createLineBorder(Color.black));
		lblInfoTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoTitle.setBackground(titleColor);
		lblInfoTitle.setOpaque(true);
		lblInfoTitle.setForeground(Color.white);

		pnlHeading.setBackground(new Color(0, 0, 0, 20));
		pnlHeading.add(lblInfoTitle, BorderLayout.SOUTH);

		// TileInformation Panel
		pnlInfo = new JPanel();
		pnlInfo.setPreferredSize(new Dimension(340, 315));
		pnlInfo.setBorder(border);
		pnlInfo.setBackground(new Color(0, 0, 0, 20));
		txtTileInfo.setForeground(new Color(71, 60, 50, 225));

		txtTileInfo.setPreferredSize(new Dimension(320, 300));
		txtTileInfo.setFont(font);
		txtTileInfo.setEditable(false);
		txtTileInfo.setMargin(new Insets(10, 10, 10, 10));
		txtTileInfo.setText(def);

		pnlInfo.add(txtTileInfo);

		// Button Panel with a ButtonListener
		pnlInBtn = new JPanel(new GridLayout());
		pnlInBtn.setPreferredSize(new Dimension(320, 60));
		pnlBtn = new JPanel();
		pnlBtn.setBackground(new Color(0, 0, 0, 20));
		pnlBtn.setBorder(border);
		pnlBtn.setPreferredSize(new Dimension(340, 70));

		btnManage.setForeground(new Color(71, 60, 50, 225));
		btnManage.setFont(font);
		btnManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ManageWindow();
			}
		});

//		Extra knappar kan vi ha
//		pnlInBtn.add(btn);

		pnlInBtn.add(btnManage);
		pnlBtn.add(pnlInBtn);

		// HistoryPanel
		pnlHistory = new JPanel();
		txtMessage.setFont(new Font("ALGERIAN", Font.BOLD, 18));
		txtMessage.setMargin(new Insets(10, 10, 10, 10));
		txtMessage.setEditable(false);
		txtMessage.setForeground(new Color(71, 60, 50, 225));

		scroller.setBackground(Color.white);
		scroller.setForeground(new Color(71, 60, 50, 225));
		scroller.setPreferredSize(new Dimension(320, 300));
		scroller.setAutoscrolls(false);
		
		lblHistoryTitle = new JLabel("Game history shows here");
		lblHistoryTitle.setPreferredSize(new Dimension(320, 30));
		lblHistoryTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistoryTitle.setBorder(BorderFactory.createLineBorder(Color.white, 2, false));
		lblHistoryTitle.setForeground(Color.white);
		lblHistoryTitle.setFont(font);

		pnlHistory.setPreferredSize(new Dimension(340, 350));
		pnlHistory.setBackground(new Color(0, 0, 0, 20));
		pnlHistory.setBorder(border);
		pnlHistory.add(lblHistoryTitle);
		pnlHistory.add(scroller);

		// The main Panel
		setOpaque(false);
		setPreferredSize(new Dimension(345, 860));
		setBackground(Color.yellow);
		setBorder(border);
		add(pnlSpace);
		add(pnlHeading);
		add(pnlInfo);
		add(pnlBtn);
		add(pnlHistory);
	}

	/**
	 * It updates the title's text and color. this method is only for the boxes with
	 * color
	 * 
	 * @param info:       gets the box's text
	 * @param lblTitle:   gets the title's text
	 * @param titleColor: gets the title's color
	 */
	public void setTileInfo(String info, String lblTitle, Color titleColor) {
		txtTileInfo.setText(info);
		lblInfoTitle.setText(lblTitle);
		lblInfoTitle.setBackground(titleColor);
	}

	/**
	 * This method is like the above method but only for those boxes which has
	 * default color.
	 * 
	 * @param info
	 * @param lblTitle
	 * @param titleColor
	 * @param titleTxtColor
	 */
	public void setTitleText(String info, String lblTitle, Color titleColor, Color titleTxtColor) {
		txtTileInfo.setText(info);
		lblInfoTitle.setText(lblTitle);
		lblInfoTitle.setBackground(titleColor);
		lblInfoTitle.setForeground(titleTxtColor);
	}

	/**
	 * sets the info text to default when mouse does not pointing on any box.
	 */
	public void setTextDefault() {
		txtTileInfo.setText(def);
		lblInfoTitle.setText(title);
		lblInfoTitle.setBackground(titleColor);
		lblInfoTitle.setForeground(Color.white);
	}

	/**
	 * Adds the history of the game and updates it.
	 * 
	 * @param res
	 */
	public void append(String res) {
		txtMessage.append(res);
	}

//	public static void main(String[] args) {
//		WestSidePanel wi = new WestSidePanel();
//		JFrame frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.add(wi);
//		frame.pack();
//		frame.setVisible(true);
//		frame.setLocationRelativeTo(null);
//	}
}
