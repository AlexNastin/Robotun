package by.robotun.webapp.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.robotun.webapp.dao.IUserDAO;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.exeption.DaoException;

@Repository("jpaUserDAO")
public class UserDAOImpl implements IUserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User selectUserById(int idUser) throws DaoException {
		User user = null;
		try {
			user = (User) entityManager.createNamedQuery("User.findUserById").setParameter("idUser", idUser)
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
			user = (User) entityManager.createNamedQuery("User.findUserByLogin").setParameter("login", login)
					.getSingleResult();
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
}
