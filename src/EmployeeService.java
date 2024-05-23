import java.util.List;

public interface EmployeeService {

	void performDuties(Employee employee);
	String getEmployeeInfo(Employee employee);
	void promoteEmployee(Employee employee);
	void keistiDarbuotojoDuomenis (Employee employee);
	void fireEmployee(Employee employee);
	double calculateBonus(Employee employee);
	void evaluatePerformance(Employee employee, int performanceScore);
	void transferDepartment(Employee employee, String newDepartment);
	void listAllEmployees(List<Employee> employees);
	Employee findEmployeeByName(List<Employee> employees, String name);
}
