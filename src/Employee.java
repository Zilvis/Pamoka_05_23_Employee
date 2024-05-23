import java.util.Random;

public class Employee {
	private String name;
	private int age;
	private double salary;
	private String departamentas;


	public Employee(String name, int age, double salary, String departamentas) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.departamentas = departamentas;
	}

	public String getDepartamentas() {
		return departamentas;
	}

	public void setDepartamentas(String departamentas) {
		this.departamentas = departamentas;
	}

	public void Work (){

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s ",name,age,salary,departamentas);
	}
}
