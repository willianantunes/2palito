package br.com.aqlbras.doispalito.portal.repository.common;

import java.util.Collection;

import br.com.aqlbras.doispalito.portal.model.common.AbstractEntity;

public interface GenericRepository<T extends AbstractEntity>
{
	void save(T t);

	T find(Long id);

	Collection<T> list();

	void saveOrUpdate(T t);
	
	T merge(T t);

	void remove(T t);
	
	void update(T t);
}