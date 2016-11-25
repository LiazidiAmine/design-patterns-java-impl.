package tp1_C;

public class Bonus {
	  final long amount;//may be null

	  public Bonus(long amount) {
	    if (amount < 0) {
	      throw new IllegalArgumentException("amount < 0");
	    }
	    this.amount = amount;
	  }
	}
