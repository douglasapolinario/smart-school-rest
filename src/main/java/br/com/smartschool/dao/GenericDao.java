package br.com.smartschool.dao;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.neo4j.ogm.session.Session;

import br.com.smartschool.model.Entity;

public abstract class GenericDao<T> implements Dao<T> {

	private static final int DEPTH_ENTITY = 0;
	private static final int DEPTH_LIST = 1;
	
	@Inject
	private Session session;

	@Override
	public List<T> findAll() {
		return (List<T>) session.loadAll(getEntityType(), DEPTH_ENTITY);
	}
	
	@Override
	public T find(Long id) {
		return session.load(getEntityType(), id, DEPTH_LIST);
	}
	
	@Override
	public void delete(Long id) {
		session.delete(session.load(getEntityType(), id));
	}
	
	@Override
	public T createOrUpdate(T entity) {
		session.save(entity, DEPTH_LIST);
		return find(((Entity) entity).getId());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T findByCypherQuery(String cypherQuery) {
		Entity ent = (Entity) session.queryForObject(getEntityType(), cypherQuery, Collections.EMPTY_MAP);
		
		if (!Optional.ofNullable(ent).isPresent()) {
			return null;
		}
		
		return find(ent.getId());
	}
	
	public abstract Class<T> getEntityType();
}
