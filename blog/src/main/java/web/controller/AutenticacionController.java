package web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AutenticacionController {
	@RequestMapping("/login") // /login.do
	public String login(HttpSession session) {
		session.setAttribute("nombre", "uno");
		System.out.println("nombre = " + session.getAttribute("nombre"));
		return "/WEB-INF/jsps/login.jsp";
	}
	
	@RequestMapping("/logout") // /logout.do
	public String logout(HttpSession session) {
		//session.invalidate();
		SecurityContextHolder.clearContext();
		System.out.println("nombre = " + session.getAttribute("nombre"));
		return "redirect:/";
	}
}
