package tp1_C;

public class Student extends AbstractSalaried implements Salaried{

	Student(String name, long salary) {//visibilité package, pourquoi ? a voir question 4.
		super(name,salary);
	}

	@Override
	long computeSalary(long salary, long bonus){
		return bonus + salary / 2;
	}


}
