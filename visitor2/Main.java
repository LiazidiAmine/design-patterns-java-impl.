package visitor2;

import java.util.Iterator;
import java.util.function.IntBinaryOperator;
import java.util.regex.Pattern;

import visitor.BinOp;
import visitor.Expr;
import visitor.Value;

public class Main {

	public static void main(String[] args) {
	     ExprVisitor<Integer> evalVisitor = new ExprVisitor<>();
	     evalVisitor
	       .when(Value.class, value -> {
	    	   return value.getValue();
	       })
	       .when(BinOp.class, binOp -> {
	   		IntBinaryOperator operator = binOp.getOperator();
			Expr left = binOp.getLeft();
			Expr right = binOp.getRight();
			return operator.applyAsInt(evalVisitor.call(left), evalVisitor.call(right));
	       });
	     
	     Iterator<String> it = Pattern.compile(" ").splitAsStream("+ * 4 + 1 1 + 2 3").iterator();
	     Expr expr = Expr.parseExpr(it);
	     evalVisitor.call(expr); 

	}

}
