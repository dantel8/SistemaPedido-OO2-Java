package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Curso;
import datos.Materia;
import datos.NotaPedido;

public class NotaPedidoDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public NotaPedido traerNotaPedidoConMateria(int idNotaPedido) {
		NotaPedido np = null;
		try {
			iniciaOperacion();
			np = (NotaPedido) session
					.createQuery("from NotaPedido n inner join fetch n.materia m where n.idNotaPedido=" + idNotaPedido)
					.uniqueResult();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return np;
	}

	@SuppressWarnings("unchecked")
	public List<NotaPedido> traer(LocalDate fecha) {
		List<NotaPedido> lstNotaPedido = null;
		try {
			iniciaOperacion();
			lstNotaPedido = session.createQuery("from NotaPedido n inner join fetch n.materia m where n.fecha= '" + fecha + "'").list();
		} finally {
			// TODO: handle finally clause
			session.close();
		}

		return lstNotaPedido;
	}

	@SuppressWarnings("unchecked")
	public List<NotaPedido> traerFinales(LocalDate desde, LocalDate hasta) {
		List<NotaPedido> lstNotaPedido = null;
		try {
			iniciaOperacion();
			lstNotaPedido = session
					.createQuery("from Final f inner join fetch f.materia where f.fechaExamen BETWEEN '" + desde + "' AND '" + hasta + "'").list();
		} finally {
			// TODO: handle finally clause
			session.close();
		}

		return lstNotaPedido;
	}

	@SuppressWarnings("unchecked")
	public List<NotaPedido> traerFinales(LocalDate desde, LocalDate hasta, Materia materia) {
		List<NotaPedido> lstNotaPedido = null;
		try {
			iniciaOperacion();
			lstNotaPedido = session.createQuery(
					"from Final f inner join fetch f.materia m where f.fechaExamen BETWEEN '"
							+ desde + "' AND '" + hasta + "' AND m.idMateria= " + materia.getIdMateria())
					.list();
		} finally {
			// TODO: handle finally clause
			session.close();
		}

		return lstNotaPedido;
	}
	
	public int agregar(LocalDate fecha, int cantEstudiantes, Materia materia, String codCurso) throws HibernateException{
		Curso c = new Curso(fecha, cantEstudiantes, materia, codCurso);
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(c).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
			// TODO: handle exception
		} finally {
			session.close();
		}
		
		return id;
	}
}
