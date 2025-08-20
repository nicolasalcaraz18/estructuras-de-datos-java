package classes;

public class Pedido {

	private String nameClient;
	private Integer idCajero;
	private String cod;
	private Double monto;
	
	public Pedido(String nameClient, Integer idCajero, String cod, Double monto) {
		this.nameClient = nameClient;
		this.idCajero = idCajero;
		this.cod = cod;
		this.monto = monto;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public Integer getIdCajero() {
		return idCajero;
	}

	public void setIdCajero(Integer idCajero) {
		this.idCajero = idCajero;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Pedido [nameClient=" + nameClient + ", idCajero=" + idCajero + ", cod=" + cod + ", monto=" + monto
				+ "]";
	}

	
}
