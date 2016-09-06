package br.com.aqlbras.catmovshop.mobile.android.model;

public class PerfilFornecedor
{
	private boolean atendimentoNoBalcao;
	private int tempoLimiteAtendimento;	
	private Fornecedor fornecedor;

	public boolean isAtendimentoNoBalcao() {
		return atendimentoNoBalcao;
	}

	public void setAtendimentoNoBalcao(boolean atendimentoNoBalcao) {
		this.atendimentoNoBalcao = atendimentoNoBalcao;
	}

	public int getTempoLimiteAtendimento() {
		return tempoLimiteAtendimento;
	}

	public void setTempoLimiteAtendimento(int tempoLimiteAtendimento) {
		this.tempoLimiteAtendimento = tempoLimiteAtendimento;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
}
