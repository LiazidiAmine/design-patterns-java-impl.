package tp1_C;

public class Employee extends AbstractSalaried implements Salaried{

	Employee(String name, long salary) {//visibilité package, pourquoi ? a voir question 4.
		super(name,salary);
	}

	public void setSalary(long salary) {
		this.salary = requirePositive(salary);
	}

	@Override
	long computeSalary(long salary, long bonus){
		return salary + bonus;
	}
}
