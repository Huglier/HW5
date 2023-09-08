package sky.pro.HW5.service;

import sky.pro.HW5.exception.EmployeeAlreadyAddedException;
import sky.pro.HW5.exception.EmployeeNotFoundException;
import sky.pro.HW5.model.Employee;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Employee> employees = new HashMap();

    public EmployeeServiceImpl() {
    }

    public void addEmployee(Employee employee) {
        Map var10000 = this.employees;
        String var10001 = employee.getFirstName();
        if (var10000.containsKey(var10001 + employee.getLastName() + employee.getSalary() + employee.getDepartmentId())) {
            throw new EmployeeAlreadyAddedException("This employee has already been added");
        } else {
            this.employees.put(employee.getFirstName() + employee.getLastName(), employee);
        }
    }

    public void removeEmployee(String firstName, String lastName, Integer salary, Integer departmentId) {
        if (!this.employees.containsKey(firstName + lastName + salary + departmentId)) {
            throw new EmployeeNotFoundException("Employee has not been found");
        } else {
            this.employees.remove(firstName + lastName + salary + departmentId);
        }
    }

    public Employee findEmployee(String firstName, String lastName, Integer salary, Integer departmentId) {
        if (!this.employees.containsKey(firstName + lastName + salary + departmentId)) {
            throw new EmployeeNotFoundException("Employee has not been found");
        } else {
            return (Employee)this.employees.get(firstName + lastName + salary + departmentId);
        }
    }

    public Collection<Employee> getAll() {
        return this.employees.values();
    }
}
