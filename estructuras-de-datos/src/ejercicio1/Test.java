package ejercicio1;

import java.util.List;
import java.util.Map;

import classes.Cajero;
import classes.Pedido;
import classes.Restaurant;
import classes.Robot;
import dto.PedidoDto;

public class Test {

	public static void main(String[] args) {
		Restaurant rest = new Restaurant("El Cosmopolita");
		System.out.println("Cargando cajeros");
		
		rest.agregarCajeros(new Cajero(1, "Gómez", 24));
		rest.agregarCajeros(new Cajero(2, "Fernández", 36));
		rest.agregarCajeros(new Cajero(3, "López", 12));
		
		System.out.println("Cargando Robots");
		rest.agregarRobots(new Robot("RBT-01", 80));
		rest.agregarRobots(new Robot("RBT-02", 20)); // bateria baja = riesgo
		rest.agregarRobots(new Robot("RBT-03", 55));
	
		System.out.println("Cargando pedidos");
		
		rest.agregarPedidos(new Pedido("Ana", 1, "RBT-01", 2500.0));
		rest.agregarPedidos(new Pedido("Juan", 2, "RBT-02", 1800.0));
		rest.agregarPedidos(new Pedido("Lucía", 1, "RBT-03", 3200.0));
		rest.agregarPedidos(new Pedido("Carlos", 3, "RBT-02", 1500.0));
		rest.agregarPedidos(new Pedido("María", 2, "RBT-01", 2700.0));
		
		
		rest.mostrarLista();
		
		Map<Integer,Double>montosPorCajero = rest.montosPorCajero();
		System.out.println("Probando montos por cajero: ");
		rest.mostrarMontosXCajero(montosPorCajero);
		
		System.out.println("Probando informe de pedidos");
		List<PedidoDto> dtos = rest.informePedidos();
		for (PedidoDto pedidoDto : dtos) {
			System.out.println(pedidoDto);
		}

		System.out.println("Probando pedidos de riesgo");
		rest.mostrarPedidosConMasRiesgo();
		
		
		
	}
	

}
