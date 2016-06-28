package by.robotun.webapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import by.robotun.webapp.dao.ISubcategoryDAO;
import by.robotun.webapp.domain.Subcategory;
import by.robotun.webapp.exception.DaoException;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Subcategory> selectAllSubcategoriesByCategory(int idCategory) throws DaoException {
		List<Subcategory> subcategories = entityManager.createNamedQuery("Subcategory.findAllByIdCategory").setParameter("idCategory", idCategory).getResultList();
		return subcategories;
	}

}
