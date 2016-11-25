package tp1_C;

import java.util.Objects;

abstract class AbstractSalaried{//pas forcement besoin d'implementer Salaried, ce qui m'interesse ce sont les deux classe qui partagent du code

	private final String name;
	long salary;
	Bonus bonus = new Bonus(0);

	static long requirePositive(long salary) {
		if (salary < 0) {
			throw new IllegalArgumentException("amount < 0");
		}
		return salary;
	}

	AbstractSalaried(String name, long salary) {
		this.name = Objects.requireNonNull(name);
		this.salary = requirePositive(salary);
	}

	@Override
	public String toString() {
		return name;
	}

	public void setBonus(Bonus bonus) {
		this.bonus = Objects.requireNonNull(bonus);
	}
	
	public long totalSalary() {
		return computeSalary(salary, bonus.amount);//TCHIIIIKHHH YA!
	}
	
	abstract long computeSalary(long salary, long bonus);

}