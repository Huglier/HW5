package sky.pro.HW5.service;

import sky.pro.HW5.model.Employee;
import java.util.Collection;

public interface EmployeeService {
    void addEmployee(Employee employee);

    void removeEmployee(String firstName, String lastName, Integer salary, Integer departmentId);

    Employee findEmployee(String firstName, String lastName, Integer salary, Integer departmentId);

    Collection<Employee> getAll();
}
