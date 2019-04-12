package test;

/**
 * Enums are a lot like constants in Java but enums can do so much
 * more! Each enum/rank is equal to a numeric value, the value they're
 * equal to is their place below. The first enum (Peassant) is equal to
 * zero while our last and 5th enum is equal to 4.
 * 
 * The private constructor is used to set a value to each rank. The multipliers
 * for each rank will therefore be different yet unchangeable. Should you want
 * to add more qualities to the ranks, you'll have to add the type to the private
 * constructor as well.
 * 
 * The "qualities" can be called upon from other classes and are meant to be public.
 * 
 * @author AevanDino
 */

public enum PlayerRankTest {
	
	PEASANT {
		public int getSalary(int dots) {
			return 20 * dots;
		}

		public int nbrOfHouses() {
			return 1;
		}
	},
	
	KNIGHT {
		public int getSalary(int dots) {
			return 25 * dots;
		}

		public int nbrOfHouses() {
			return 2;
		}
	},
	
	LORD {
		public int getSalary(int dots) {
			return 30 * dots;
		}

		public int nbrOfHouses() {
			return 3;
		}
	},
	
	RULER {
		public int getSalary(int dots) {
			return 40 * dots;
		}

		public int nbrOfHouses() {
			return 4;
		}
	};

	public abstract int getSalary(int dots);
	public abstract int nbrOfHouses();
	
	
}
