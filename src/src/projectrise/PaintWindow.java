package projectrise;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;
import java.awt.geom.*;
import java.awt.image.BufferedImage;

/**
 * I ett fönster av typen PaintWindow kan man visa bilder och rita linjer, ellipser 
 * och rektanglar. När fönstret skapas kan man ange en bild som ska vara bakgrundsbild.
 * @author Rolf Axelsson
 */
public class PaintWindow extends JFrame {
    private PaintPanel panel = new PaintPanel();
    private BufferedImage bImage;
    private Graphics2D bg;
    private ImageIcon background;
    private LinkedList<IconXY> icons = new LinkedList<IconXY>();
    private LinkedList<DPShape> buffer = new LinkedList<DPShape>();
    private JButton button = new JButton("Sl�");
    private Movement m;
    private Random rng = new Random();
    private int rand = 0; 

    // Ett fönster med vit bakgrund, 600x400 pixlar stort skapas
    public PaintWindow() {
        this(null);
    }
    
    public void setMovement(Movement m) {
    	this.m = m;
    }

    
    /**
     * Skapar ett PaintWindow-objekt med angiven bakgrundsbild. Storleken på fönstret blir bildens storlek, dock 
     * max 800x800 pixlar stort
     * @param background bakgrundsbild att visa i PaintWindow. Om null så skapas ett 600x400 pixlar stort fönster 
     * med vit bakgrund.
     */
    public PaintWindow(ImageIcon background) {
        super("Paint Window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.background = background;
        if (background != null) {
            panel.setPreferredSize(new Dimension( Math.min(background.getIconWidth(),800), 
                                                  Math.min(background.getIconHeight(),800)));
        } else {
            panel.setPreferredSize(new Dimension(600, 600));
        }
        button.addActionListener(new Lyssnare());
        panel.add(button);
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }

    private class Lyssnare implements ActionListener{
    	
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == button) {
				rand = rng.nextInt(4)+1;
//				m.move(rng.nextInt(6)+1);
				m.move(rand);
			}
		}
    	
    }
    /**
     * Sätter bakgrundsbilden. Fönstrets dimensioner ändras ej.
     * @param icon Ett ImageIcon-objekt att visa i fönstret
     */
    public void setBackground(ImageIcon icon) {
        this.background = icon;
    } 

    /**
     * Visar en Icon-implementering på angiven plats. Om icon-implementeringen redan visas i fönstret
     * så flyttas den till angiven position.
     * @param icon Icon-implementering att visa
     * @param x Anger x-position för övre vänstra hörnet i Icon-implementeringen
     * @param y Anger y-position för övre vänstra hörnet i Icon-implementeringen
     */
    public void showImage(Icon icon, int x, int y) {
        int index;
        if (icon == null) {
            return;
        }
        IconXY newIcon = new IconXY(icon, x, y);
        index = icons.indexOf(newIcon);
        if (index == -1) {
            icons.add(new IconXY(icon, x, y));
        } else {
            icons.get(index).setX(x);
            icons.get(index).setY(y);
        }
        repaint();
    }
    
    /**
     * Tar bort en Icon-implementering som visas i fönstret
     * @param icon Icon-implementeringen som ska tas bort
     */
    public void hideImage(Icon icon) {
        int index;
        if (icon == null) {
            return;
        }
        IconXY newIcon = new IconXY(icon, 0, 0);
        index = icons.indexOf(newIcon);
        if (index != -1) {
            icons.remove(index);
            repaint();
        } 
    }
    
    /**
     * Rensar bakgrunden från ritade objekt
     */
    public void clear() {
        if (background != null) {
            bg.drawImage(background.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
        } else {
            bg.setPaint(Color.WHITE);
            bg.fillRect(0, 0, this.getWidth(), this.getHeight());
        }
        repaint();
    }
    
    /**
     * Returnerar ritytans bredd
     * @return ritytans bredd
     */
    public int getBackgroundWidth() {
        return panel.getWidth();
    }
    
    /**
     * returnerar ritytans höjd
     * @return ritytans höjd
     */
    public int getBackgroundHeight() {
        return panel.getHeight();
    }

    /**
     * Ritar en linje med angiven färg och tjocklek från (x1,y1) till (x2,y2)
     * @param x1 x-koordinat i första punkten
     * @param y1 y-koordinat i första punkten
     * @param x2 x-koordinat i andra punkten
     * @param y2 y-koordinat i andra punkten
     * @param color ritfärg
     * @param lineWidth linjens tjocklek
     */
    public void line(int x1, int y1, int x2, int y2, Color color, int lineWidth) {
        buffer.add(new Line(x1, y1, x2, y2, color, lineWidth));
        repaint();
    }

    /**
     * ritar en rektangel med övre vänstra hörnet i (x,y).
     * @param x x-koordinat i rektangeln övre vänstra hörn
     * @param y y-koordinat i rektangeln övre vänstra hörn
     * @param width rektangelns bredd
     * @param height rektangelns höjd
     * @param color färg på rektangeln
     * @param lineWidth bredd på rektangelns sidor
     */
    public void drawRect(int x, int y, int width, int height, Color color, int lineWidth) {
        buffer.add(new DrawRect(x, y, width, height, color, lineWidth));
        repaint();
    }

    /**
     * ritar en fylld rektangel med övre vänstra hörnet i (x,y).
     * @param x x-koordinat i rektangeln övre vänstra hörn
     * @param y y-koordinat i rektangeln övre vänstra hörn
     * @param width rektangelns bredd
     * @param height rektangelns höjd
     * @param color färg på rektangeln
     */
    public void fillRect(int x, int y, int width, int height, Color color) {
        buffer.add(new FillRect(x, y, width, height, color));
        repaint();
    }

    /**
     * ritar en ellips innesluten i en rektangel med övre vänstra hörnet i (x,y).
     * @param x x-koordinat i rektangeln övre vänstra hörn
     * @param y y-koordinat i rektangeln övre vänstra hörn
     * @param width rektangelns bredd
     * @param height rektangelns höjd
     * @param color färg på ellipsen
     * @param lineWidth bredd på ellipsens sidor
     */
    public void drawOval(int x, int y, int width, int height, Color color, int lineWidth) {
        buffer.add(new DrawOval(x, y, width, height, color, lineWidth));
        repaint();
    }

    /**
     * ritar en fylld ellips innesluten i en rektangel med övre vänstra hörnet i (x,y).
     * @param x x-koordinat i rektangeln övre vänstra hörn
     * @param y y-koordinat i rektangeln övre vänstra hörn
     * @param width rektangelns bredd
     * @param height rektangelns höjd
     * @param color färg på ellipsen
     */
    public void fillOval(int x, int y, int width, int height, Color color) {
        buffer.add(new FillOval(x, y, width, height, color));
        repaint();
    }

    /**
     * Pausar exekveringen under ms millisekunder
     * @param ms
     */
    public static void pause(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }
    
    private class PaintPanel extends JPanel {

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Point point;
            if (bImage == null) {
                bImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
                bg = bImage.createGraphics();
                if (background != null) {
                    bg.drawImage(background.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
                } else {
                    bg.setPaint(Color.WHITE);
                    bg.fillRect(0, 0, this.getWidth(), this.getHeight());
                }
            }
            while (buffer.size() > 0) {
                buffer.get(0).draw(bg);
                buffer.remove(0);
            }
            g.drawImage(bImage, 0, 0, null);
            for (int i = 0; i < icons.size(); i++) {
                icons.get(i).paintIcon(g);
            }
        }
    }

    private class IconXY {

        private Icon icon;
        private int x;
        private int y;

        public IconXY(Icon icon, int x, int y) {
            this.icon = icon;
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public void paintIcon(Graphics g) {
            icon.paintIcon(PaintWindow.this, g, this.x, this.y);
        }
        
        public boolean equals(Object obj) {
            IconXY iconXY = (IconXY)obj;
            return this.icon.equals(iconXY.icon);
        }
    }

    private abstract class DPShape {

        public abstract void draw(Graphics2D g);
    }

    private class Line extends DPShape {

        private int x1,  y1,  x2,  y2,  lineWidth;
        private Color color;

        public Line(int x1, int y1, int x2, int y2, Color color, int lineWidth) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.color = color;
            this.lineWidth = lineWidth;
        }

        public void draw(Graphics2D g) {
            g.setStroke(new BasicStroke(lineWidth));
            g.setPaint(color);
            g.draw(new Line2D.Double(x1, y1, x2, y2));
        }
    }

    private class DrawRect extends DPShape {

        private int x,  y,  width,  height,  lineWidth;
        private Color color;

        public DrawRect(int x, int y, int width, int height, Color color, int lineWidth) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.color = color;
            this.lineWidth = lineWidth;
        }

        public void draw(Graphics2D g) {
            g.setStroke(new BasicStroke(lineWidth));
            g.setPaint(color);
            g.draw(new Rectangle2D.Double(x, y, width, height));
        }
    }

    private class FillRect extends DPShape {

        private int x,  y,  width,  height;
        private Color color;

        public FillRect(int x, int y, int width, int height, Color color) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.color = color;
        }

        public void draw(Graphics2D g) {
            g.setPaint(color);
            g.fill(new Rectangle2D.Double(x, y, width, height));
        }
    }

    private class DrawOval extends DPShape {

        private int x,  y,  width,  height,  lineWidth;
        private Color color;

        public DrawOval(int x, int y, int width, int height, Color color, int lineWidth) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.color = color;
            this.lineWidth = lineWidth;
        }

        public void draw(Graphics2D g) {
            g.setStroke(new BasicStroke(lineWidth));
            g.setPaint(color);
            g.draw(new Ellipse2D.Double(x, y, width, height));
        }
    }

    private class FillOval extends DPShape {

        private int x,  y,  width,  height;
        private Color color;

        public FillOval(int x, int y, int width, int height, Color color) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.color = color;
        }

        public void draw(Graphics2D g) {
            g.setPaint(color);
            g.fill(new Ellipse2D.Double(x, y, width, height));
        }
    }
    
}
