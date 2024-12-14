package acc.br.projetofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import acc.br.projetofinal.model.UsuarioModel;

public interface UsuarioRepository<Usuario> extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String usuario);

	UsuarioModel buscarPorNome(String Usuario);
}