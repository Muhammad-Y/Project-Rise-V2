package projectrise;

import javax.swing.ImageIcon;

public class Movement {

	private PaintWindow pw = new PaintWindow(); 
	private ImageIcon image = new ImageIcon("images/pawn.png");
	int width = pw.getBackgroundWidth();
	int height = pw.getBackgroundHeight();
	int dx = -3;
	int dy = 0;
	int x = 450;
	int y = 450;  
	int steps = 0;
	private int counter = 0;
	
	public Movement() {
		pw.setMovement(this);
		pw.showImage(image, x, y);
	}
	
	public void move(int steps) {
		this.steps = steps * 100;
		//for (int i = 0; i < steps * 100; i++) {
		while(counter <= this.steps ) {
		pw.showImage(image, x, y);
		PaintWindow.pause(20); // pausa exekveringen i 20 ms innan n�sta f�rflyttning
		x += dx;
		y += dy;
		System.out.println("X värde: " + x + " Y värde: " + y);
		/*
		 * F�rflyttselsen i sidleds styrs likt exercise1e, d� v�rdet p� f�rflyttningen dx sl�s om n�r bilden tr�ffar en av kanterna.
		 * F�rflyttelsen i h�jd fungerar p� samma s�tt. N�r y blir mindre �n noll kommer v�rdet p� dy sl�ss om och bilden kommer 
		 * b�rja f�rflytta sig p� andra h�llet. Samma sak sker n�r y blir st�rre �n v�rdet av h�jden p� f�nstret minus bildens h�jd. 
		 *
		 */
		if(x<0) {
			dx = 0;
			dy = -3;
			if(y < 0) {
				dx = 3;
				dy = 0;
			}
		}
		if(x>=width - image.getIconWidth()) {
			dx = 0;
			dy = 3;
			if(y > height - image.getIconHeight()) {
				dx = -3;
				dy = 0;
			}
		}
		counter += 3;
//		if(y<50) {
//			dy = 0;
//			dx = 3;
//		}
//		if(y> height - image.getIconHeight()){
//			dy = 0;
//			dx = -3;
//	}
}
		counter = 0;
		//}
		
	}

	public static void main (String[]args) {
		Movement m = new Movement();
//		m.move();
	}
}
