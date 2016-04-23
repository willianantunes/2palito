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
	private Collection<Pedido> pedidos;	
	
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
		this.pedidos = null;
	}
	
	public static Usuario getInstance()
	{
		if (usuario == null){
			usuario = new Usuario();
		}
		return usuario;
	}	
	

}
