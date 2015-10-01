package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Articulo;
import service.ArticuloService;

@Controller
@RequestMapping("/articulos*")
public class ArticuloController {
	@Autowired
	private ArticuloService articuloService;
	
	@RequestMapping("")
	public String index(Model model) {
		List<Articulo> articulos = 
				articuloService.obtenerArticulos();
		model.addAttribute("articulos", articulos);
		
		return "/WEB-INF/jsps/articulo/index.jsp";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "/WEB-INF/jsps/articulo/admin.jsp";
	}
}
