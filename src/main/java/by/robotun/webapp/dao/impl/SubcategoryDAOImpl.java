package by.robotun.webapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import by.robotun.webapp.dao.ISubcategoryDAO;
import by.robotun.webapp.domain.Subcategory;
import by.robotun.webapp.exeption.DaoException;

@Repository("jpaSubcategoryDAO")
public class SubcategoryDAOImpl implements ISubcategoryDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Subcategory> selectAllSubcategories() throws DaoException {
		List<Subcategory> subcategories = entityManager.createNamedQuery("Subcategory.findAll").getResultList();
		return subcategories;
	}

}