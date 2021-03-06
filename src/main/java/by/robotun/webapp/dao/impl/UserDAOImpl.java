package by.robotun.webapp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.robotun.webapp.dao.DaoParamConstant;
import by.robotun.webapp.dao.IUserDAO;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exception.DaoException;
import by.robotun.webapp.property.PropertyManager;
import by.robotun.webapp.property.PropertyName;
import by.robotun.webapp.service.ServiceParamConstant;

@Repository("jpaUserDAO")
public class UserDAOImpl implements IUserDAO {
	
	@Autowired
	private PropertyManager propertyManager;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User selectUser(int idUser) throws DaoException {
		User user = null;
		try {
			user = (User) entityManager.createNamedQuery("User.findUserById").setParameter("idUser", idUser).getSingleResult();
		} catch (NoResultException e) {
			return user;
		}
		return user;
	}
	
	@Override
	public User selectStaffUser(int idUser) throws DaoException {
		User user = null;
		try {
			user = (User) entityManager.createNamedQuery("User.findStaffById").setParameter("idUser", idUser)
					.getSingleResult();
		} catch (NoResultException e) {
			return user;
		}
		return user;
	}

	@Override
	public User selectUser(String login) throws DaoException {
		User user = null;
		try {
			user = (User) entityManager.createNamedQuery("User.findUserByLogin").setParameter("login", login).getSingleResult();
		} catch (NoResultException e) {
			return user;
		}
		return user;
	}

	@Override
	@Transactional
	public void insertUser(User user) throws DaoException {
		entityManager.persist(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectAllStaffs() throws DaoException {
		List<User> users = entityManager.createNamedQuery("User.findAllStaffs").setParameter("idRole", ServiceParamConstant.ID_ROLE_MODERATOR).setMaxResults(Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE))).getResultList();
		return users;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectAllModeratorsLimitOffset(int offset) throws DaoException {
		Integer limit = Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE));
		List<User> users = entityManager.createNamedQuery("User.findAllStaffs").setParameter("idRole", ServiceParamConstant.ID_ROLE_MODERATOR).setFirstResult(offset*limit).setMaxResults(limit).getResultList();
		return users;
	}

	@Transactional
	@Override
	public void deleteUser(Integer id) throws DaoException {
		User user = entityManager.find(User.class, id);
		entityManager.remove(user);
	}

	@Transactional
	@Override
	public void updateUser(User user) throws DaoException {
		entityManager.merge(user);
	}

	@Override
	public User selectUserByIdWithCity(int idUser) throws DaoException {
		User user = null;
		try {
			user = (User) entityManager.createNamedQuery("User.findUserByIdWithCity").setParameter("idUser", idUser)
					.getSingleResult();
		} catch (NoResultException e) {
			return user;
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectUsersSearchCriteria(Integer idUser, String name) throws DaoException {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> criteria = criteriaQuery.from(User.class);
		criteriaQuery = criteriaQuery.select(criteria);
		List<Predicate> predicatesList = new ArrayList<Predicate>();
		if (idUser != null) {
			Predicate idUserPredicate = criteriaBuilder.equal(criteria.get("idUser"), idUser);
			predicatesList.add(idUserPredicate);
		}
		if (!name.trim().equals("")) {
			Predicate namePredicate = criteriaBuilder.like(criteria.get("nickname"), name);
			predicatesList.add(namePredicate);
		}
		Predicate predicate = criteriaBuilder.and(predicatesList.toArray(new Predicate[0]));
		criteriaQuery.where(predicate);
		criteriaQuery.orderBy(criteriaBuilder.asc(criteria.get("idUser")));
		Query query = entityManager.createQuery(criteriaQuery).setMaxResults(DaoParamConstant.FIND_USERS_MAX_FOR_ADMIN);
		List<User> users = query.getResultList();
		return users;
	}
}
