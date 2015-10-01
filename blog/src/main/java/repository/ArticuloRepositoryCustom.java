package repository;

import java.util.List;

import model.Articulo;

public interface ArticuloRepositoryCustom {
	List<Articulo> findByAutor(String nombreAutor);
}
