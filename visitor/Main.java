package visitor;

import java.util.Iterator;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     Iterator<String> it = Pattern.compile(" ").splitAsStream("+ * 4 + 1 1 + 2 3").iterator();
	     Expr expr = Expr.parseExpr(it);
	     
	     ExprVisitor<Integer> visitor1 = new EvalExprVisitor();
	     System.out.println(expr.accept(visitor1));
	     
	     ExprVisitor<String> visitor = new ToStringExprVisitor();
	     System.out.println(expr.accept(visitor));
	     
	     StringBuilder builder = new StringBuilder();
	     ExprVisitor<Void> visitor2 = new ToStringExprVisitor2(builder);
	     expr.accept(visitor2);
	     System.out.println(builder);
	     
	}

}
