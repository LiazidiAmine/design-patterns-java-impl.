package visitor;

public class Value implements Expr {
  private final int value;

  public Value(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
  
  @Override
  public <R> R accept(ExprVisitor<? extends R> visitor){
	  return visitor.visitValue(this);
  }
  
}

