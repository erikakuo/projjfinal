package acc.br.projetofinal.model;

import org.springframework.data.annotation.Id;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;


@Entity
@Table(name = "STUDENT")
public class LoginModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long identificador;

	@Column(nullable = false, unique = true)
	private String nomeUsuario;

	@Column(nullable = false)
	private String senhaUsuario;

	// Getters e Setters
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

	public String getSenhaUsuario() {
	    return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
	    this.senhaUsuario = senhaUsuario;
	}

	public String criptografarSenhaUsuario(String senha) {
	    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	    return encoder.encode(senha);
	}}