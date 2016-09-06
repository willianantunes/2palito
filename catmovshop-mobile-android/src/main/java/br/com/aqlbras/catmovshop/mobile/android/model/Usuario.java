package br.com.aqlbras.catmovshop.mobile.android.model;

import java.util.Collection;

import org.joda.time.DateTime;

public class Usuario 
{
	// Singleton design pattern
	private static Usuario usuario = null;
	// Standard attributes
	private Long id;
	private String nome;
	private String login;	
	private String password;
	private DateTime dataNascimento;
	private DateTime dataCadastro;
	private String email;
	private PerfilUsuario perfilUsuario;
	private Bandeja bandeja;
	
	
	// the constructor is private in a singleton class
	private Usuario()
	{
		this.id = 0L;
		this.nome = null;
		this.login = null;
		this.password = null;
		this.dataNascimento = null;
		this.dataCadastro = null;
		this.email = null;
		this.perfilUsuario = null;
		this.bandeja = null;
	}
	
	public static Usuario getInstance()
	{
		if (usuario == null){
			usuario = new Usuario();
		}
		return usuario;
	}

	public static Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario usuario) {
		Usuario.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(DateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public DateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(DateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PerfilUsuario getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}

	public Bandeja getBandeja() {
		return bandeja;
	}

	public void setBandeja(Bandeja bandeja) {
		this.bandeja = bandeja;
	}

}
