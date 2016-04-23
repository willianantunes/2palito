/**
 * 
 */
package br.com.aqlbras.catmovshop.mobile.android.domain;

import java.util.Date;

/**
 * @author Almeida
 *
 */
public class Usuario {
	private String login;
	private String password;
	private Date dataNascimento;	
	private String email;
	private String nome;
	/**
	 * @param login
	 * @param password
	 * @param dataNascimento
	 * @param email
	 * @param nome
	 */
	public Usuario(String login, String password, Date dataNascimento,
			String email, String nome) {
		super();
		this.login = login;
		this.password = password;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.nome = nome;
	}
	/**
	 * 
	 */
	public Usuario() {
		super();
	}
	
	
}
