package api.payloads;

public class Students {
	
	/*
	 * id
	 * name
	 * lastname
	 */
	
	int id;
	String name;
	String lastName;
	
	public int getId() {
		return id;
	}
	public void setId(int idNumber) {
		this.id = idNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


}
