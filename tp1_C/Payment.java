package tp1_C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Payment {
  private final ArrayList<Salaried> employees = new ArrayList<>();
  
  public Employee addEmployee(String name, long salary) {//Question 4
    Employee emp = new Employee(name, salary);
    employees.add(emp);
    return emp;
  }
  
  public Student addStudent(String name, long salary){
	  Student stu = new Student(name, salary);
	  employees.add(stu);
	  return stu;
  }
  
  public List<Salaried> getAllEmployees() {
    return Collections.unmodifiableList(employees);
  }
  
  public long totalPayment(){
	  return employees.stream()
			  .mapToLong(Salaried::totalSalary).sum();
  }
}
