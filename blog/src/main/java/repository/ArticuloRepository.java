package repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Articulo;

public interface ArticuloRepository 
		extends JpaRepository<Articulo, Integer>, ArticuloRepositoryCustom {
	
	List<Articulo> findByTitulo(String titulo);
	
	@Query("from Articulo a where a.fecha >= :fecha")
	List<Articulo> findGreaterThanFecha(@Param("fecha") Date fecha);
}
