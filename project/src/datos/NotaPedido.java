package datos;

import java.time.LocalDate;

public class NotaPedido {
	private int idNotaPedido;
	private LocalDate fecha;
	private int cantEstudiantes;
	private Materia materia;

	public NotaPedido() {

	}

	public NotaPedido(LocalDate fecha, int cantEstudiantes, Materia materia) {
		this.fecha = fecha;
		this.cantEstudiantes = cantEstudiantes;
		this.materia = materia;
	}

	public int getIdNotaPedido() {
		return idNotaPedido;
	}

	
	protected void setIdNotaPedido(int idNotaPedido) {
		this.idNotaPedido = idNotaPedido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getCantEstudiantes() {
		return cantEstudiantes;
	}

	public void setCantEstudiantes(int cantEstudiantes) {
		this.cantEstudiantes = cantEstudiantes;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	@Override
	public String toString() {
		return "NotaPedido [idNotaPedido=" + idNotaPedido + ", fecha=" + fecha + ", cantEstudiantes=" + cantEstudiantes
				+ ", materia=" + materia + "]";
	}

}
