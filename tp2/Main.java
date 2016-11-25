package tp2;

public class Main {
	  public static void main(String[] args) {
	    Fruit orange = new Fruit("Orange", 2);
	    Fruit apple = new Fruit("Apple", 2);
	    
	    GroceryList list = new GroceryList("doc");
	    list.addOrder(orange, 1);
	    list.addOrder(apple, 2);
	    list.addOrder(orange, 1);
	    System.out.println(list);
	  }
}