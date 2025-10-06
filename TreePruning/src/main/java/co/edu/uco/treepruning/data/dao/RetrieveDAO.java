package co.edu.uco.treepruning.data.dao;

import java.util.List;

public interface RetrieveDAO<E, ID> {
	void update(E entity);

	List<E> findAll();
	
	List<E> findByFilter(E filterEntity);
	
	E findById(ID id);
}
