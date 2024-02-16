package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.NotaPedidoDao;
import datos.Materia;
import datos.NotaPedido;

public class NotaPedidoABM {
	NotaPedidoDao dao = new NotaPedidoDao();
	
	public NotaPedido traerNotaPedidoConMateria(int idNotaPedido) {
		return dao.traerNotaPedidoConMateria(idNotaPedido);
	}
	
	public List<NotaPedido> traer(LocalDate fecha) {
		return dao.traer(fecha);
	}
	
	public List<NotaPedido> traerFinales(LocalDate desde, LocalDate hasta) {
		return dao.traerFinales(desde, hasta);
	}
	
	public List<NotaPedido> traerFinales(LocalDate desde, LocalDate hasta, Materia materia) {
		return dao.traerFinales(desde, hasta, materia);
	}
	
	public int agregar(LocalDate fecha, int cantEstudiantes, Materia materia, String codCurso){
		return dao.agregar(fecha, cantEstudiantes, materia, codCurso);
	}
}
