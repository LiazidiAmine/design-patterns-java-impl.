package visitor;

import java.util.function.IntBinaryOperator;

public class EvalExprVisitor implements ExprVisitor<Integer>{

	@Override
	public Integer visitValue(Value value) {
		return value.getValue();
	}

	@Override
	public Integer visitBinOp(BinOp binOp) {
		IntBinaryOperator operator = binOp.getOperator();
		Expr left = binOp.getLeft();
		Expr right = binOp.getRight();
		return operator.applyAsInt(left.accept(this), right.accept(this));
	}

}
