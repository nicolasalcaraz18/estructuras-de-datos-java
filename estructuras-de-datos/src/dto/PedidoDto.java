package dto;

public class PedidoDto {
	private Double monto;
	private String apellido;
	private int nivelBat;
	
	public PedidoDto(Double monto, String apellido, int nivelBat) {
		super();
		this.monto = monto;
		this.apellido = apellido;
		this.nivelBat = nivelBat;
	}

	@Override
	public String toString() {
		return "PedidoDto [monto=" + monto + ", apellido=" + apellido + ", nivelBat=" + nivelBat + "]";
	}
	
	

}
