package sky.pro.HW5.service;

import sky.pro.HW5.model.Employee;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findEmployeeMaxSalary(Integer departmentId);

    Employee findEmployeeMinSalary(Integer departmentId);

    Collection<Employee> addAllDepartmentId(Integer departmentId);

    Map<Integer, List<Employee>> getAllDepartmentIdEmployee();
}
