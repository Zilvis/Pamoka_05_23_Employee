public class Developer extends Employee {
	private String programmingLanguage;

	public Developer(String name, int age, double salary, String programmingLanguage, String departamentas) {
		super(name, age, salary, departamentas);
		this.programmingLanguage = programmingLanguage;
	}

	@Override
	public void Work (){

	}

	public String getProgrammingLanguage() {
		return programmingLanguage;
	}

	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}

	@Override
	public String toString() {
		return String.format("%s,%s",super.toString(),programmingLanguage);
	}
}
