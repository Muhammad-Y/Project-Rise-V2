package messageGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import tiles.FortuneTeller;

public class FortuneTellerGUI extends JPanel{

    private FortuneTeller cardo;

    private JPanel centerPanel = new JPanel();
    private JPanel outerPanel = new JPanel();
    private JLabel type = new JLabel();
    private JTextPane dis = new JTextPane();

    private Color color1 = new Color(102,178,255);
    private Font fontType = new Font("ALGERIAN", Font.BOLD, 30);
    private Font fontDis = new Font("ALGERIAN", Font.ITALIC, 20);


    public FortuneTellerGUI(String fortune, String description, int amount) {
        setLayout(new BorderLayout());
        outerPanel.setLayout(new BorderLayout());
        centerPanel.setLayout(new BorderLayout());

        setPreferredSize(new Dimension(500, 250));
        setBackground(Color.black);
        setForeground(Color.black);

        setBorder(BorderFactory.createMatteBorder(3,3, 3, 3, Color.black));
        outerPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.DARK_GRAY));
        centerPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.gray));

        type.setPreferredSize(new Dimension(200,70));
        type.setText("\nBlessed");
        type.setFont(fontType);
        type.setHorizontalAlignment(SwingConstants.CENTER);

        dis.setText("\n                        Fortune smiles upon you. \n"
                + "                            You recived " + 2 + " gold");
        dis.setFont(fontDis);
        dis.setBackground(color1);

    //    dis.setHorizontalAlignment(SwingConstants.CENTER);


        centerPanel.setBackground(color1);
        centerPanel.add(type,BorderLayout.NORTH);
        centerPanel.add(dis,BorderLayout.CENTER);


        add(outerPanel, BorderLayout.CENTER);
        outerPanel.add(centerPanel, BorderLayout.CENTER);


 
}
}
