package tp1_C_final;

import java.util.function.LongBinaryOperator;

public enum Status {
	STUDENT((salary, bonus) -> bonus + salary /2),
	EMPLOYEE((salary, bonus) -> bonus + salary);
	

	private final LongBinaryOperator op; 
	//fonction qui prend 2 long et qui renvoi un long
	
	private Status(LongBinaryOperator op){
		this.op = op;
	}
	
	public long computeTotalSalary(long salary, long amount){
		return op.applyAsLong(salary, amount);
	}
}
