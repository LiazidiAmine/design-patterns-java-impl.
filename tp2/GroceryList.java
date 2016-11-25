package tp2;

import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collectors;

public class GroceryList {
  private final String name;
  private final HashMap<Fruit, Integer> orderMap = new HashMap<>();
  
  public GroceryList(String name) {
    this.name = name;
  }

  public void addOrder(Fruit fruit, int count) {
    orderMap.merge(fruit, count, Integer::sum);
  }
  
  public int getQuantityOfFruit(Fruit fruit) {
    return orderMap.get(fruit);
  }
  
  public long price() {
    return orderMap.entrySet().stream().mapToLong(entry -> entry.getKey().getPrice() + entry.getValue()).sum();
  }
  
  @Override
  public String toString() {
    String orders = orderMap.entrySet().stream().map(entry -> entry.getKey() + " * " + entry.getValue()).collect(Collectors.joining("\n"));
    return "list for " + name + '\n' + orders + '\n' + "price: " + price();
  }
}
