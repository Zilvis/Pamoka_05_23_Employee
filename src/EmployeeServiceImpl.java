import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService{
	private Scanner scannerInt = new Scanner(System.in);
	private Scanner scannerStr = new Scanner(System.in);

	/**
	 * Keicia darbuotojo duomenis
	 * Name, Age
	 * @param employee perduodamas darbuotojo objektas
	 */
	@Override
	public void keistiDarbuotojoDuomenis (Employee employee){
		getEmployeeInfo(employee);
		System.out.print("Iveskite nauja darbuotojo varda: ");
		String darbuotojoVardas = scannerStr.nextLine();
		System.out.print("Iveskite nauja darbuotojo amziu: ");
		int darbuotojoAmzius = scannerInt.nextInt();

		employee.setAge(darbuotojoAmzius);
		employee.setName(darbuotojoVardas);
	}

	/**
	 * Istrina darbuotojo objekta is saraso esancio UI klaseje
	 * @param employee darbuotojo objektas
	 */
	@Override
	public void fireEmployee(Employee employee) {
		for (Employee d : UI.darbuotojuSarasas) {
			if (d.getName().equalsIgnoreCase(employee.getName())){
				UI.darbuotojuSarasas.remove(employee);
				break;
			}
		}
	}

	/**
	 * Apskaiciuoja darbuotojo bonusa
	 * Jei manageris pakelia 10 %
	 * Jei programuotojas pakelia 5 %
	 * Visiems kitiems pakelia 3 %
	 * @param employee
	 * @return
	 */
	@Override
	public double calculateBonus(Employee employee) {
		double premija = 0;
		if (employee instanceof Manager){
			premija = employee.getSalary() + (employee.getSalary() * (10.0 / 100)) - employee.getSalary();
		} else if (employee instanceof Developer){
			premija = employee.getSalary() + (employee.getSalary() * (5.0 / 100)) - employee.getSalary();
		} else {
			premija = employee.getSalary() + (employee.getSalary() * (3.0 / 100)) - employee.getSalary();
		}
		return premija;
	}

	/**
	 * Pakelia darbuotojo alga pagal jo nasuma
	 * nasumo procentas sugeneruojamas atsitiktinai
	 * jei daugiau arba lygu 9 pakeliamas 10% alga
	 * jei daugiau negu 7 pakeliama 5%
	 * Jeigu maziau nei 7 isvedama jog yvertinimas yra prastas
	 * @param employee
	 * @param performanceScore
	 */
	@Override
	public void evaluatePerformance(Employee employee, int performanceScore) {
		if (performanceScore >=9){
			System.out.println("Darbuotojo pakelta alga 10 %. Ivertinimas " +performanceScore);
			employee.setSalary(employee.getSalary() + (employee.getSalary() * (10.0 / 100)));
		} else if (performanceScore >= 7) {
			System.out.println("Darbuotojo pakelta alga 5 %. Ivertinimas " +performanceScore);
			employee.setSalary(employee.getSalary() + (employee.getSalary() * (5.0 / 100)));
		}else {
			System.out.println("Darbuotojo veila nepatenkinama su yvertinimu " +performanceScore);
		}
	}

	/**
	 * Priskiria darbuotojui nauja departamenta
	 * @param employee
	 * @param newDepartment
	 */

	@Override
	public void transferDepartment(Employee employee, String newDepartment) {
		employee.setDepartamentas(newDepartment);
	}

	/**
	 * Atspauzdinami visi esantys darbuotojai is duoto saraso
	 * @param employees
	 */
	@Override
	public void listAllEmployees(List<Employee> employees) {
		for (Employee e : employees){
			System.out.println(e);
		}
	}

	/**
	 * Ieskomas darbuotojas pagal varda
	 * @param employees
	 * @param name
	 * @return
	 */
	@Override
	public Employee findEmployeeByName(List<Employee> employees, String name) {
		for (Employee e : employees){
			if (e.getName().equalsIgnoreCase(name)){
				return e;
			}
		}
		return null;
	}

	/**
	 * Atspauzdina infromacija apie darbuotojus su papildomais parametrais
	 * Jeigu manager klases objektas turi didesne nei 20 drbuotoju komanda atspauzdiname jog jo komanda yra didele jei mazesne tiesiog isvedam kokio dydzio komanda
	 * Jeigu Developer isvedam programavimo kalba
	 * @param employee
	 */

	@Override
	public void performDuties(Employee employee) {
		if (employee instanceof Manager){
			if (((Manager) employee).getTeamSize() > 20){
				System.out.println(employee.getName() + " Valdo didele komanda kurios dydis yra " + ((Manager) employee).getTeamSize() + " zmoniu");
			} else {
				System.out.println(employee.getName() + " Valdomos komandos dydis yra " + ((Manager) employee).getTeamSize() + " zmoniu");
			}
		} else if (employee instanceof Developer){
			if (((Developer) employee).getProgrammingLanguage().equalsIgnoreCase("C#")){
				System.out.println(employee.getName() + " yra " + ((Developer) employee).getProgrammingLanguage() + " programuotojas " + employee.getSalary());
			} else if (((Developer) employee).getProgrammingLanguage().equalsIgnoreCase("java")){
				System.out.println(employee.getName() + " yra " + ((Developer) employee).getProgrammingLanguage() + " programuotojas " + employee.getSalary());
			} else {
				System.out.println(employee.getName() + " yra " + ((Developer) employee).getProgrammingLanguage() + " programuotojas " + employee.getSalary());
			}
		}
	}

	/**
	 * Paauksita darbuotoja pakelianta alga pagal nurodytus parametrus
	 * Jeigu manager ir turi didesne nei 15 zmoniu komanda padidinama 10%
	 * Jeigu Developeris programuoja su C# pakeliama 7% o jei javbba 12 %
	 * @param employee
	 */
	@Override
	public void promoteEmployee(Employee employee) {
		if (employee instanceof Manager){
			if (((Manager) employee).getTeamSize() > 15){
				employee.setSalary(employee.getSalary() + (employee.getSalary() * (10.0 / 100)));
				System.out.println(employee.getName() + " Alga padidinta 10 % " + employee.getSalary());
			} else {
				System.out.println(employee.getName() + " Valdomos komandos dydis yra " + ((Manager) employee).getTeamSize() + " zmoniu");
			}
		} else if (employee instanceof Developer){
			if (((Developer) employee).getProgrammingLanguage().equalsIgnoreCase("C#")){
				employee.setSalary(employee.getSalary() + (employee.getSalary() * (7.0 / 100)));
			} else if (((Developer) employee).getProgrammingLanguage().equalsIgnoreCase("java")){
				employee.setSalary(employee.getSalary() + (employee.getSalary() * (12.0 / 100)));
			} else {
				// Jeigu paprastas tai nieko :)
			}
		}
	}

	@Override
	public String getEmployeeInfo(Employee employee) {
		return String.format("%s,%s,%s,%s",employee.getName(),employee.getAge(),employee.getSalary(),employee.getDepartamentas());
	}
}
