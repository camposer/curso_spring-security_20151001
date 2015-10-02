package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AutenticacionController {
	@RequestMapping("/login") // /login.do
	public String login() {
		return "/WEB-INF/jsps/login.jsp";
	}
	
}
