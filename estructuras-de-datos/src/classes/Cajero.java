package classes;

public class Cajero {

	private Integer id;
	private String lastName;
	private int antiguedadEnMeses;
	
	public Cajero(Integer id, String lastName, int antiguedadEnMeses) {
		this.id = id;
		this.lastName = lastName;
		this.antiguedadEnMeses = antiguedadEnMeses;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Cajero [id=" + id + ", lastName=" + lastName + ", antiguedadEnMeses=" + antiguedadEnMeses + "]";
	}
	
	
	
}
