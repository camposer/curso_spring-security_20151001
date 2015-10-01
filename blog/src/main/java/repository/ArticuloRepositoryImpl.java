package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Articulo;

public class ArticuloRepositoryImpl implements ArticuloRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Articulo> findByAutor(String nombreAutor) {
		Query q = entityManager.createQuery("from Articulo a where a.autor.nombre = :nombreAutor");
		q.setParameter("nombreAutor", nombreAutor);
		
		return q.getResultList();
	}

}
