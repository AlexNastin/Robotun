package by.web.store.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.web.store.dao.ICategoryDAO;
import by.web.store.domain.Role;

@Repository("jpaCategoryDAO")
public class CategoryDAOImpl implements ICategoryDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> selectAllCategories() throws by.web.store.exeption.DaoException {
		List<Role> cities = entityManager.createNamedQuery("Role.findAll").getResultList();
		return cities;
	}

	
}
