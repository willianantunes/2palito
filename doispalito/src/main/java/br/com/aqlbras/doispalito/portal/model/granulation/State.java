package br.com.aqlbras.doispalito.portal.model.granulation;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//import br.com.brutanjo.util.DataChecker;

@Entity
public final class State {

	@Id
	@Column(name = "id_estado")
	@Access(AccessType.FIELD)
	private final int id;

	@Column(name = "descricao_estado", length = 2, nullable = false, unique = true)
	@Access(AccessType.FIELD)
	private final String descricao;

	/**
	 * Private Hibernate constructor
	 */
	@SuppressWarnings("unused")
	private State() {
		id = 0;
		descricao = null;
	}

	public State(String descricao) {
		super();
		id = 0;// hibernate vai definir esse valor

		if (descricao == null /*|| DataChecker.isOnlySpaceOrEmpty(descricao)*/) {
			throw new IllegalArgumentException("Descri��o do estado n�o pode ser null ou vazio.");
		}

		if (descricao.length() != 2) {
			throw new IllegalArgumentException(
					"Descri��o do estado tem que ter duas letras.");
		}
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
}