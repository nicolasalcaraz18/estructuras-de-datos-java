package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import dto.PedidoDto;

public class Restaurant {

	private Map<Integer,Cajero> mapCajeros;
	private Map<String,Robot>mapRobots;
	private List<Pedido>pedidos;
	private String name;
	
	public Restaurant(String name) {
		this.mapCajeros = new HashMap<Integer,Cajero>();
		this.mapRobots = new HashMap<String,Robot>();
		this.pedidos = new ArrayList<>();
		this.name = name;
	}
	
	public void agregarPedidos(Pedido p) {
		pedidos.add(p);
	}
	

	public void agregarCajeros(Cajero cajero) {
		mapCajeros.put(cajero.getId(), cajero);
	}
	
	public void agregarRobots(Robot r) {
		mapRobots.put(r.getCod(), r);
	}
	
	public void mostrarLista() {
		System.out.println("Mostrando pedidos");
		for(Pedido p : pedidos) {
			System.out.println(p);
		}
	}
	/**
	 * This version with Stream API
	 * @return
	 */
	public Map<Integer, Double> montosPorCajeroStreamVersion() {
	    return pedidos.stream()
	            .filter(p -> mapCajeros.containsKey(p.getIdCajero()))
	            .collect(Collectors.groupingBy(
	                Pedido::getIdCajero,
	                Collectors.summingDouble(Pedido::getMonto)
	            ));
	}
	
	
	public Map<Integer,Double> montosPorCajero(){
		Map<Integer,Double>montosPorCajero = new HashMap<>();
		for(Pedido p : pedidos) {
			if(mapCajeros.containsKey(p.getIdCajero())) {
				this.cargarMontosPorCajero(montosPorCajero, p);
			}
		}
		
		return montosPorCajero;
	}
	
	private void cargarMontosPorCajero(Map<Integer, Double> montosPorCajero,Pedido p) {	
		Double acu = 0.0;
		if(!montosPorCajero.containsKey(p.getIdCajero())) {
			montosPorCajero.put(p.getIdCajero(), p.getMonto());
		} else {
			acu = montosPorCajero.get(p.getIdCajero());
			acu += p.getMonto();
			montosPorCajero.replace(p.getIdCajero(),acu);
		}
	}

	public void mostrarMontosXCajero(Map<Integer,Double> montosPorCajero){
		System.err.println("REstaurante " + name);
		for(Map.Entry<Integer,Double> entry : montosPorCajero.entrySet()) {
			System.out.println("Para el cajero" + entry.getKey() + " se registro un monto de: " + entry.getValue());
		}
	}
	
	public List<PedidoDto> informePedidos(){
		List<PedidoDto> pedidosDtos = new ArrayList<>();
		for (Pedido p: pedidos) {
			Double monto = p.getMonto();
			String lastName = obtenerApellido(p);
			int nivelBat = obtenerNivelBat(p);
			pedidosDtos.add(new PedidoDto(monto,lastName,nivelBat));
		}
		return pedidosDtos;
	}

	private String obtenerApellido(Pedido p) {
	    Cajero cajero = mapCajeros.get(p.getIdCajero());
	    if (cajero == null) {
	        throw new IllegalArgumentException("Cajero no encontrado: " + p.getIdCajero());
	    }
	    return cajero.getLastName();
	}
	
	/*Optional version
	 * 
	 * private String obtenerApellido(Pedido p) {
    		return Optional.ofNullable(mapCajeros.get(p.getIdCajero()))
                   .map(Cajero::getLastName)
                   .orElse("Desconocido");
		}
	 */

	private int obtenerNivelBat(Pedido p) {
	    Robot robot = mapRobots.get(p.getCod());
	    if (robot == null) {
	        throw new IllegalArgumentException("Robot no encontrado: " + p.getCod());
	    }
	    return robot.getNivelBat();
	}
	
	public void mostrarPedidosConMasRiesgo() {
		for(Pedido p : pedidos) {
			if(mapRobots.containsKey(p.getCod())) {
				Robot r = mapRobots.get(p.getCod());
				if(r.getNivelBat() <= 20) {
					System.out.println("Pedido de riesgo: " +  p +  " con un niveL de bateria " + r.getNivelBat());
				}
			} else {
				System.out.println("Robot inexistente");
			}
		}
	}
	
	
	@Override
	public String toString() {
		return "Restaurant [mapCajeros=" + mapCajeros + ", mapRobots=" + mapRobots + ", pedidos=" + pedidos + ", name="
				+ name + "]";
	}

	
}
