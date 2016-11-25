package tp2;

public class Fruit {
	  private final String name;
	  private final long price;

	  public Fruit(String name, long price) {
	    this.name = name;
	    this.price = price;
	  }
	  
	  @Override
	  public boolean equals(Object o) {
	    if (!(o instanceof Fruit)) {
	      return false;
	    }
	    Fruit fruit = (Fruit)o;
	    return name.equals(fruit.name);
	  }
	  
	  @Override
	  public int hashCode() {
	    return name.hashCode();
	  }
	  
	  public String getName() {
	    return name;
	  }
	  
	  public long getPrice() {
	    return price;
	  }
	  
	  @Override
	  public String toString() {
	    return name + " (" + price + ')';
	  }
	}