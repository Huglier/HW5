package sky.pro.HW5.service;

import sky.pro.HW5.model.Employee;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee findEmployeeMaxSalary(Integer departmentId) {
        return (Employee)this.employeeService.getAll().stream().filter((employee) -> {
            return Objects.equals(employee.getDepartmentId(), departmentId);
        }).max(Comparator.comparingInt(Employee::getSalary)).orElseThrow(() -> {
            return new IllegalArgumentException("No employee department");
        });
    }

    public Employee findEmployeeMinSalary(Integer departmentId) {
        return (Employee)this.employeeService.getAll().stream().filter((employee) -> {
            return Objects.equals(employee.getDepartmentId(), departmentId);
        }).min(Comparator.comparingInt(Employee::getSalary)).orElseThrow(() -> {
            return new IllegalArgumentException("No employee department");
        });
    }

    public Collection<Employee> addAllDepartmentId(Integer departmentId) {
        return (Collection)this.employeeService.getAll().stream().filter((employee) -> {
            return Objects.equals(employee.getDepartmentId(), departmentId);
        }).collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> getAllDepartmentIdEmployee() {
        return (Map)this.employeeService.getAll().stream().collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
