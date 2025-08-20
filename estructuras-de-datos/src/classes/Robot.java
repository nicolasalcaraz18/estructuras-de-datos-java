package classes;

public class Robot {

	private String codigo;
	private int nivelBat;
	
	public Robot(String codigo, int nivelBat) {
		this.codigo = codigo;
		this.nivelBat = nivelBat;
	}
	
	public String getCod() {
		return codigo;
	}
	
	public int getNivelBat() {
		return this.nivelBat;
	}

	@Override
	public String toString() {
		return "Robot [codigo=" + codigo + ", nivelBat=" + nivelBat + "]";
	}
	
	
	
}
