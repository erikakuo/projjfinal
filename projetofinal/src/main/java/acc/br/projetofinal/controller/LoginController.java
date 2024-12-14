package acc.br.projetofinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import acc.br.projetofinal.service.AutenticaService;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@GetMapping("/entrar")
	public String exibirPaginaLogin() {
	    return "login"; 
	}

	@PostMapping("/entrar")
	public String autenticarUsuario(String nomeUsuario, String senha, HttpSession sessao, Model modelo) {
	    if (AutenticaService.validarLogin(nomeUsuario, senha)) {
	        sessao.setAttribute("nomeUsuario", nomeUsuario);
	        return "redirect:/"; 
	    } else {
	        modelo.addAttribute("erro", "Usuário ou senha incorretos"); 
	        return "login"; 
	    }
	}

	@GetMapping("/sair")
	public String deslogarUsuario(HttpSession sessao) {
	    sessao.invalidate();
	    return "redirect:/entrar";
	}
}