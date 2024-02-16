package negocio;

import dao.MateriaDao;
import datos.Materia;

public class MateriaABM {
	MateriaDao dao = new MateriaDao();

	public Materia traerMateria(int idMateria) {
		return dao.traerMateria(idMateria);
	}
}
