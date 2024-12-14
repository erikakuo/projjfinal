package acc.br.projetofinal.model;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "STUDENT") // Nome da tabela no banco de dados
public class UsuarioModel {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long identificador; 

	    @Column(name = "nome_usuario", nullable = false, unique = true)
	    private String nomeUsuario;

	    @Column(name = "senha", nullable = false)
	    private String senha;

	    // Getters e setters
	    public Long getIdentificador() {
	        return identificador;
	    }

	    public void setIdentificador(Long identificador) {
	        this.identificador = identificador;
	    }

	    public String getNomeUsuario() {
	        return nomeUsuario;
	    }

	    public void setNomeUsuario(String nomeUsuario) {
	        this.nomeUsuario = nomeUsuario;
	    }

	    public String getSenha() {
	        return senha;
	    }

	    public void setSenha(String senha) {
	        this.senha = senha;
	    }

	    public interface UsuarioCadastroRepository extends JpaRepository<UsuarioModel, Long> {
	        UsuarioModel findByNomeUsuario(String nomeUsuario);
	    }
	}