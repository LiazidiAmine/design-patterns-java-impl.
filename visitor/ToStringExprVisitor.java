package visitor;

public class ToStringExprVisitor implements ExprVisitor<String>{

	@Override
	public String visitValue(Value value) {
		return Integer.toString(value.getValue());
	}

	@Override
	public String visitBinOp(BinOp binOp) {
		Expr left = binOp.getLeft();
		Expr right = binOp.getRight();
		String opName = binOp.getOpName();
		String leftString = left.accept(this);
		String rightString = right.accept(this);
		return "(" + leftString + ' ' + opName + ' ' + rightString + ')';
	}
}
