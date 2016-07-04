package by.robotun.webapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import by.robotun.webapp.dao.ICategoryDAO;
import by.robotun.webapp.domain.Category;
import by.robotun.webapp.exception.DaoException;

@Repository("jpaCategoryDAO")
public class CategoryDAOImpl implements ICategoryDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> selectAllCategories() throws DaoException {
		List<Category> categories = entityManager.createNamedQuery("Category.findAll").getResultList();
		return categories;
	}
	
	@Override
	public Category selectCategoryById(int idCategory) throws DaoException {
		Category category = (Category) entityManager
				.createNamedQuery("Category.findCategoryById")
				.setParameter("idCategory", idCategory).getSingleResult();
		return category;

	}
}
