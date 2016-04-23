package br.com.aqlbras.doispalito.portal.model.granulation;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public final class District 
{

	@Id
	@Column(name = "id_bairro")
	@Access(AccessType.FIELD)
	private final int id;

	@Column(unique = true, length = 60, nullable = false)
	@Access(AccessType.FIELD)
	private final String descricao;

	@ManyToOne
	@JoinColumn(name = "id_cidade", referencedColumnName = "id_cidade", nullable = false)
	@Access(AccessType.FIELD)
	private final City cidade;

	/**
	 * Private Hibernate constructor
	 */
	@SuppressWarnings("unused")
	private District() {
		id = 0;
		descricao = null;
		cidade = null;
	}

	public District(String descricao, City cidade) {
		super();
		this.id = 0;// hibernate vai definir esse valor

		if (descricao == null /*|| DataChecker.isOnlySpaceOrEmpty(descricao)*/) {
			throw new IllegalArgumentException(
					"Descri��o do bairro n�o pode ser null ou vazio.");
		}

		if (descricao.length() > 60) {
			throw new IllegalArgumentException(
					"Descri��o do bairro n�o pode ser maior do que 60.");
		}

		if (cidade == null) {
			throw new IllegalArgumentException("Cidade n�o pode ser null.");
		}

		this.descricao = descricao;
		this.cidade = cidade;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public City getCidade() {
		return cidade;
	}
}