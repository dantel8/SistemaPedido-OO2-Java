package test;

import java.time.LocalDate;

import negocio.MateriaABM;
import negocio.NotaPedidoABM;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotaPedidoABM notaPedidoABM = new NotaPedidoABM();
		MateriaABM materiaABM = new MateriaABM();
		
		System.out.println("1)");
		System.out.println(materiaABM.traerMateria(1));
		System.out.println("2)");
		System.out.println(notaPedidoABM.traerNotaPedidoConMateria(1));
		System.out.println("3)");
		System.out.println(notaPedidoABM.traer(LocalDate.of(2022, 3, 1)));
		System.out.println("4)");
		System.out.println(notaPedidoABM.traerFinales(LocalDate.of(2022, 5, 10), LocalDate.of(2022, 5, 11)));
		System.out.println("5)");
		System.out.println(notaPedidoABM.traerFinales(LocalDate.of(2022, 5, 10), LocalDate.of(2022, 5, 11), materiaABM.traerMateria(3)));
		System.out.println("6)");
		System.out.println(notaPedidoABM.agregar(LocalDate.of(2022, 6, 5), 100, materiaABM.traerMateria(5) , "555"));
	}

}
