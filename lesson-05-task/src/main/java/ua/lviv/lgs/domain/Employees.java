package ua.lviv.lgs.domain;

import java.util.Objects;

public class Employees {
	private Integer id;
	private String firstName;
	private String lastName;
	private String position;
	private double salary;

	public Employees(Integer id, String firstName, String lastName, String position, double salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.salary = salary;
	}

	public Employees(String firstName, String lastName, String position, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName, position, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employees other = (Employees) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(position, other.position)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", position=" + position
				+ ", salary=" + salary + "]";
	}

}
