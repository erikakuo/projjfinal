package acc.br.projetofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import acc.br.projetofinal.service.AutenticaService;

@RestController
@RequestMapping("/")
public class AutenticaController {
	
	
	    
	    @Autowired
	    private AutenticaService autenticaService;

	    @PostMapping
	    public String autenticarUsuario(@RequestParam String nomeUsuario, @RequestParam String senha) {
	        boolean autenticado = autenticaService.autenticar(nomeUsuario, senha);

	        if (autenticado) {
	            return "Autenticação bem-sucedida!";
	        } else {
	            return "Credenciais incorretas!";
	        }
	    }
	}