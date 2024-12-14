package acc.br.projetofinal.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import acc.br.projetofinal.model.UsuarioModel;
import acc.br.projetofinal.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final BCryptPasswordEncoder passwordEncoder;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	public UsuarioModel cadastrarUsuario(UsuarioModel usuario) {

		String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);

		return UsuarioRepository.save(usuario);
	}
}
