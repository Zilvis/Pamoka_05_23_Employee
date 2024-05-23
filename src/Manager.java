public class Manager extends Employee{
	private int teamSize;

	public Manager(String name, int age, double salary, int teamSize, String departamentas) {
		super(name, age, salary,departamentas);
		this.teamSize = teamSize;
	}

	@Override
	public void Work (){

	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	@Override
	public String toString() {
		return String.format("%s,%s",super.toString(),teamSize);
	}
}
