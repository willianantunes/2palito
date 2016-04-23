package br.com.aqlbras.doispalito.portal.model.granulation;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//import br.com.brutanjo.util.DataChecker;

@Entity
public final class City 
{
	@Id
	@Column(name = "id_cidade")
	@Access(AccessType.FIELD)
	private final int id;

	@Column(name = "descricao_cidade", unique = true, length = 60, nullable = false)
	@Access(AccessType.FIELD)
	private final String descricao;


	@ManyToOne
	@JoinColumn(name = "id_estado", referencedColumnName = "id_estado", nullable = false)
	@Access(AccessType.FIELD)
	private final State estado;

	/**
	 * Private Hibernate constructor
	 */
	@SuppressWarnings("unused")
	private City() {
		id = 0;
		descricao = null;
		estado = null;
	}

	public City(String descricao, State estado) {
		super();
		this.id = 0;// hibernate vai definir esse valor

		if (descricao == null /*|| DataChecker.isOnlySpaceOrEmpty(descricao) */) {
			throw new IllegalArgumentException(
					"Descri��o da cidade n�o pode ser null ou vazio.");
		}

		if (descricao.length() > 60) {
			throw new IllegalArgumentException(
					"Descri��o da cidade n�o pode ser maior do que 60.");
		}

		if (estado == null) {
			throw new IllegalArgumentException("Estado n�o pode ser null.");
		}

		this.descricao = descricao;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public State getEstado() {
		return estado;
	}
}