package tp1_C_final;

import java.util.Objects;

public class Salaried {
	private final String name;
	private long salary;
	private Status status;
	private Bonus bonus = new Bonus(0);  // may be null

	public Salaried(String name, long salary, Status status) {
		this.name = Objects.requireNonNull(name);
		this.salary = requirePositive(salary);
		this.status = Objects.requireNonNull(status);
	}

	@Override
	public String toString() {
		return name;
	}

	public void setSalary(long salary) {
		if (salary < 0) {
			throw new IllegalArgumentException("amount < 0");
		}
		this.salary = salary;
	}
	public void setBonus(Bonus bonus) {
		this.bonus = Objects.requireNonNull(bonus);
	}
	private static long requirePositive(long salary) {
		if (salary < 0) {
			throw new IllegalArgumentException("amount < 0");
		}
		return salary;
	}
	
	public long totalSalary(){
		return status.computeTotalSalary(salary, bonus.amount);//jamais de switch ou de if sur un type, on délégue!
	}
	
	public void setStatus(Status status){
		this.status = Objects.requireNonNull(status);
	}

}
