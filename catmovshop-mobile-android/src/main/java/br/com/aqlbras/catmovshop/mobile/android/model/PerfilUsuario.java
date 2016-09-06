package br.com.aqlbras.catmovshop.mobile.android.model;

public class PerfilUsuario
{	
	private PerfilUsuarioType tipo;
	private int tempoLimiteAtendimento;
	private Usuario usuario;
	
	public PerfilUsuarioType getTipo() {
		return tipo;
	}
	public void setTipo(PerfilUsuarioType tipo) {
		this.tipo = tipo;
	}
	public int getTempoLimiteAtendimento() {
		return tempoLimiteAtendimento;
	}
	public void setTempoLimiteAtendimento(int tempoLimiteAtendimento) {
		this.tempoLimiteAtendimento = tempoLimiteAtendimento;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}