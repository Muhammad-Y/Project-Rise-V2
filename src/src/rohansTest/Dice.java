package rohansTest;

import java.util.Random;

public class Dice {
	private Random random = new Random();
	private int faceValueDiceOne1, faceValueDiceTwo1, faceValueDiceOne2, faceValueDiceTwo2, faceValueDiceOne3,
				faceValueDiceTwo3, faceValueDiceOne4 , faceValueDiceTwo4; 
	private int tot1, tot2, tot3, tot4;
	public Dice() {
		
	}
	
	public int totalDice1() {		
		faceValueDiceOne1 = random.nextInt(7-1) +1 ;
		faceValueDiceTwo1 = random.nextInt(7-1) +1 ;
		tot1 = faceValueDiceOne1 + faceValueDiceTwo1;
		return tot1;
	}
	public int totalDice2() {		
		faceValueDiceOne2 = random.nextInt(7-1) +1 ;
		faceValueDiceTwo2 = random.nextInt(7-1) +1 ;
		tot2 = faceValueDiceOne2 + faceValueDiceOne2;
		return tot2;
	}
	public int totalDice3() {		
		faceValueDiceOne3 = random.nextInt(7-1) +1 ;
		faceValueDiceTwo3 = random.nextInt(7-1) +1 ;
		tot3 = faceValueDiceOne3 + faceValueDiceTwo3;
		return tot3;
	}
	public int totalDice4() {		
		faceValueDiceOne4 = random.nextInt(7-1) +1 ;
		faceValueDiceTwo4 = random.nextInt(7-1) +1 ;
		tot4 = faceValueDiceOne4 + faceValueDiceTwo4;
		return tot4;
	}
	
}
