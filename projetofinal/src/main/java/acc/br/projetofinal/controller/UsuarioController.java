package acc.br.projetofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import acc.br.projetofinal.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired(required=true)
    private UsuarioService usuarioService;

    @GetMapping("/cadastrar")
    public String mostrarFormularioCadastro() {
        return "cadastro"; 
    }

    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@ModelAttribute Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "CadastroUsuario";
        }

        usuarioService.cadastrarUsuario(usuario);
        return "redirect:/login";
    }
}