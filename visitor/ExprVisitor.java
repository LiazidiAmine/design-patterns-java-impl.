package visitor;

public interface ExprVisitor<R> {
    public R visitValue(Value value);
    public R visitBinOp(BinOp binOp);
  }
