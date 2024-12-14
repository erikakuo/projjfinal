package acc.br.projetofinal.service;

import org.springframework.stereotype.Service;

import acc.br.projetofinal.config.SecurityConfig;
import acc.br.projetofinal.model.UsuarioModel;
import acc.br.projetofinal.repository.UsuarioRepository;

@Service
public class AutenticaService {

	private final UsuarioRepository usuarioRepositorio;
	private UsuarioRepository UsuarioRepository;

	public AutenticaService(UsuarioRepository usuarioRepository) {
		this.UsuarioRepository = usuarioRepository;
		this.SecurityConfig = new SecurityConfig();
	}

	public boolean validarCredenciais(String nomeUsuario, String senhaInformada) {

		UsuarioModel usuario = UsuarioRepository.buscarPorNome(nomeUsuario);

		if (usuario == null) {

			return false;
		}

		return SecurityConfig.passwordEncoder(senhaInformada, usuario.getSenha());
	}

	public UsuarioRepository getUsuarioRepositorio() {
		return usuarioRepositorio;
	}

	public SecurityConfig getCriptografadorSenha(SecurityConfig SecurityConfig) {
		return SecurityConfig;
	}

	public boolean autenticar(String nomeUsuario, String senha) {

		return false;
	}

	public static boolean validarLogin(String nomeUsuario, String senha) {
		// TODO Auto-generated method stub
		return false;
	}
}