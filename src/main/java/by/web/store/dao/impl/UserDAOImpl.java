package by.web.store.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.web.store.dao.IUserDAO;
import by.web.store.domain.User;
import by.web.store.exeption.DaoException;

@Repository("jpaUserDAO")
public class UserDAOImpl implements IUserDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
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

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectUsersByRole(int idRole) throws DaoException {
		List<User> users = entityManager.createNamedQuery("User.findUsersByRole").setParameter("idRole", idRole).getResultList();
		return users;
	}

	@Transactional
	@Override
	public void insertUser(User user) throws DaoException {
		entityManager.persist(user);
	}

	@Transactional
	@Override
	public void removeUser(Integer idUser) throws DaoException {
		User user = entityManager.find(User.class, idUser);
		entityManager.remove(user);
	}

	
}
