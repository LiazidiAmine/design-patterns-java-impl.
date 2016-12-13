package visitor;

public class ToStringExprVisitor2 implements ExprVisitor<Void>{
	
	private final StringBuilder builder;
	
	public ToStringExprVisitor2(StringBuilder builder) {
		this.builder = builder;
	}

	@Override
	public Void visitValue(Value value) {
		builder.append(value.getValue());
		return null;
	}

	@Override
	public Void visitBinOp(BinOp binOp) {
		String opName = binOp.getOpName();
		Expr left = binOp.getLeft();
		Expr right = binOp.getRight();
		builder.append('(');
		left.accept(this);
		builder.append(' ').append(opName).append(' ');
		right.accept(this);
		builder.append(')');
		return null;
	}
	
	
}
