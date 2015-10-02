package service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import model.Articulo;

public interface ArticuloService {
	@Secured("ROLE_USER")
	List<Articulo> obtenerArticulos();
	
}
