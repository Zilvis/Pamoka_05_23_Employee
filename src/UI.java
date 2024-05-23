import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UI {
	private boolean veikia;
	private Scanner scannerStr = new Scanner(System.in);
	private Scanner scannerInt = new Scanner(System.in);
	private EmployeeService employeeService = new EmployeeServiceImpl();
	public static List<Employee> darbuotojuSarasas = new ArrayList<>();
	private Random random = new Random();

	public UI() {
		darbuotojuSarasas.add(new Developer("Petras",20,35_000,"C#","Pirmas"));
		darbuotojuSarasas.add(new Developer("Jona",34,45_000,"C++","Pirmas"));
		darbuotojuSarasas.add(new Developer("Ona",31,40_000,"Java","Pirmas"));

		darbuotojuSarasas.add(new Manager("Vygatas",36,55_000,10,"Antras"));
		darbuotojuSarasas.add(new Manager("Gustas",32,65_000,30,"Antras"));
		darbuotojuSarasas.add(new Manager("Egle",37,75_000,40,"Antras"));
	}

	public void run (){
		veikia = true;
		int darbotojoId;
		while (veikia){
			System.out.println("\nPASIRINKIMAS");
			System.out.println("1. Atspauzdinti sarasa ");
			System.out.println("2. PerformDuties ");
			System.out.println("3. Darbuotojo informacija");
			System.out.println("4. Paaukstinti darbuotoja");
			System.out.println("5. Keisti darbuotojo informacija");
			System.out.println("6. Atleisti darbuotoja");
			System.out.println("7. Darbuotojo bonusas");
			System.out.println("8. Darbuotojo nasumo balas");
			System.out.println("9. Darbuotojo perkelimas");
			System.out.println("10. Visu darbuotoju sarasas");
			System.out.println("11. Surasti darbuotoja pagal varda");
			System.out.println("12. Iseiti");
			String pasirinkimas = scannerStr.nextLine();
			switch (pasirinkimas){
				case "1":
					atspauzdintiDarbuotojuSarasa();
					break;
				case "2":
					performDuties();
					break;
				case "3":
					atspauzdintiDarbuotojuSarasa();
					System.out.println("\n Iveskite darbuotojo varda: ");
					darbotojoId = scannerInt.nextInt();
					System.out.println(employeeService.getEmployeeInfo(darbuotojuSarasas.get(darbotojoId)));
					break;
				case "4":
					atspauzdintiDarbuotojuSarasa();
					System.out.println("\n Iveskite darbuotojo id: ");
					darbotojoId = scannerInt.nextInt();
					employeeService.promoteEmployee(darbuotojuSarasas.get(darbotojoId));
					break;
				case "5":
					atspauzdintiDarbuotojuSarasa();
					System.out.println("\n Iveskite darbuotojo id: ");
					darbotojoId = scannerInt.nextInt();
					employeeService.keistiDarbuotojoDuomenis(darbuotojuSarasas.get(darbotojoId));
					break;
				case "6":
					atspauzdintiDarbuotojuSarasa();
					System.out.println("\n Iveskite darbuotojo id: ");
					darbotojoId = scannerInt.nextInt();
					employeeService.fireEmployee(darbuotojuSarasas.get(darbotojoId));
					veikia = true;
					break;
				case "7":
					atspauzdintiDarbuotojuSarasa();
					System.out.println("\n Iveskite darbuotojo id: ");
					darbotojoId = scannerInt.nextInt();
					System.out.println("Darbuotojo bonusas yra " + employeeService.calculateBonus(darbuotojuSarasas.get(darbotojoId)));
					veikia = true;
					break;

				case "8":
					atspauzdintiDarbuotojuSarasa();
					System.out.println("\n Iveskite darbuotojo id: ");
					darbotojoId = scannerInt.nextInt();
					employeeService.evaluatePerformance(darbuotojuSarasas.get(darbotojoId),random.nextInt(5,10));
					break;
				case "9":
					atspauzdintiDarbuotojuSarasa();
					System.out.println("\n Iveskite darbuotojo id: ");
					darbotojoId = scannerInt.nextInt();
					System.out.println("Iveskite departamento pavadinima");
					String departamentas = scannerStr.nextLine();
					employeeService.transferDepartment(darbuotojuSarasas.get(darbotojoId),departamentas);
					break;
				case "10":
					employeeService.listAllEmployees(darbuotojuSarasas);
					break;
				case "11":
					System.out.println("Iveskite darbuotojo varda: ");
					String darbuotojoVardas = scannerStr.nextLine();
					System.out.println(employeeService.findEmployeeByName(darbuotojuSarasas,darbuotojoVardas));
					break;
				case "12":
					veikia = false;
					break;
				default:
					System.out.println("Blogas pasirinkimas");
			}
		}
	}

	private void performDuties(){
		for (Employee e : darbuotojuSarasas){
			employeeService.performDuties(e);
		}
	}

	private void atspauzdintiDarbuotojuSarasa(){
		int i = 0;
		for (Employee e : darbuotojuSarasas){
			System.out.println("ID: "+i+ " " +e);
			i++;
		}
	}
}
