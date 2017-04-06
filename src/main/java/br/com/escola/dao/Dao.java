package br.com.escola.dao;

import java.util.List;

public interface Dao<T> {
	
	public List<T> findAll();
	
	public T find(Long id);
	
	public void delete(Long id);
	
	public T createOrUpdate(T entity);
	
	public T findByCypherQuery(String cypherQuery);
}
