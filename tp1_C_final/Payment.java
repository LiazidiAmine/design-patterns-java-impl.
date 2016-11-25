package tp1_C_final;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Payment {
  private final ArrayList<Salaried> employees = new ArrayList<>();
  
  public Salaried addEmployee(String name, long salary, Status status) {
    Salaried emp = new Salaried(name, salary, status);
    employees.add(emp);
    return emp;
  }

  public List<Salaried> getAllEmployees() {
    return Collections.unmodifiableList(employees);
  }
  
}
