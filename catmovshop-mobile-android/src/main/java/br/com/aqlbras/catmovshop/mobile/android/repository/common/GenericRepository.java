package br.com.aqlbras.catmovshop.mobile.android.repository.common;

public interface GenericRepository<T> 
{
	void save(T t) throws Exception;
	T find(T t) throws Exception;
	// We must change to collection, but for compatibility I put as array - Antunes
	T[] list() throws Exception;
	T update(T t) throws Exception;
	void remove(T t) throws Exception;
}
