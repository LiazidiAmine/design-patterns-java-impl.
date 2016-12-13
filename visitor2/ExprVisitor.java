package visitor2;

import java.util.HashMap;
import java.util.function.Function;

import visitor.Expr;

public class ExprVisitor<R> {
	private final HashMap<Class<?>, Function<Expr, ? extends R>> map = new HashMap<>();
	
	public <T extends Expr> ExprVisitor<R> when(Class<T> type, Function<? super T, ? extends R> fun){
		//map.put(type, expr -> fun.apply(type.cast(expr)));
		map.put(type, fun.compose(type::cast));
		return this;
	}
	
	public R call(Expr expr){
		return map.get(expr.getClass()).apply(expr);
	}
}
