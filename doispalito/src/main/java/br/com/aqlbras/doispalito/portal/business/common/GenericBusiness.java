package br.com.aqlbras.doispalito.portal.business.common;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hibernate.Session;

import br.com.aqlbras.doispalito.portal.model.common.AbstractEntity;
import br.com.aqlbras.doispalito.portal.repository.common.GenericRepository;

public abstract class GenericBusiness<T extends AbstractEntity> implements GenericRepository<T> 
{
	protected static final Logger logger = LoggerFactory.getLogger(GenericBusiness.class);
	protected final Session session;
	protected Class<T> classType;
	
	@SuppressWarnings("unchecked")
	protected GenericBusiness(Session session)
	{
		this.session = session;
		
		/**
		 * Através da classe atual, GenericBusiness, o tipo genérico é recuperado e convertido para o tipo parametrizado. Com isso o método
		 * getActualTypeArguments() recupera a lista dos argumentos e devolve apenas o primeiro por meio de seu índice [0], que é exatamente
		 * o tipo genérico. Por fim, esse tipo genérico é convertido em um Class para que possamos saber qual classe a nossa classe genérica
		 * irá manipular.
		 */
		this.classType = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
		
	@Override
	public void save(T t)
    {
    	logger.info(String.format("Salvando (%s)", t));
    	this.session.save(t);
    }	
	
	@Override
	@SuppressWarnings("unchecked")
	public T find(Long id)
    {
    	logger.debug(String.format("Lendo (%s) com o id (%s)", this.classType, id));
    	T a = (T) this.session.load(this.classType, id);
    	return a;
    }
	
	@Override
	@SuppressWarnings("unchecked")
	public Collection<T> list()
    {
		logger.debug(String.format("Listando (%s)", this.classType));
    	return this.session.createCriteria(this.classType).list();
    }
    
	@Override
	public void saveOrUpdate(T t)
    {
    	logger.info(String.format("Salvando ou atualizado (%s)", t));
    	this.session.saveOrUpdate(t); 
    }	
	
	@Override
	public void remove(T t)
	{
		logger.info(String.format("Removendo (%s)", t));
    	this.session.delete(t);
	}

	@Override
	public void update(T t) 
	{
		logger.info(String.format("Atualizando (%s)", t));
    	this.session.update(t);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T merge(T t) {
		logger.info(String.format("Mesclando (%s)", t));
		return (T) this.session.merge(t);
	}
	
	
}
