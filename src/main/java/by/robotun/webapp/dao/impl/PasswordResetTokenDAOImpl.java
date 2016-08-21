package by.robotun.webapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.robotun.webapp.dao.IPasswordResetTokenDAO;
import by.robotun.webapp.domain.PasswordResetToken;
import by.robotun.webapp.exception.DaoException;

@Repository("jpaPasswordResetTokenDAO")
public class PasswordResetTokenDAOImpl implements IPasswordResetTokenDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void updatePasswordResetToken(PasswordResetToken passwordResetToken) throws DaoException {
		em.merge(passwordResetToken);
	}

	@Override
	@Transactional
	public void insertPasswordResetToken(PasswordResetToken passwordResetToken) throws DaoException {
		em.persist(passwordResetToken);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PasswordResetToken> selectAllPasswordResetTokens() throws DaoException {
		return em.createNamedQuery("PasswordResetToken.findAll").getResultList();
	}

	@Override
	@Transactional
	public void deletePasswordResetToken(Integer idToken) throws DaoException {
		PasswordResetToken passwordResetToken = em.find(PasswordResetToken.class, idToken);
		em.remove(passwordResetToken);
	}

	@Override
	@Transactional
	public PasswordResetToken selectTokenByUser(Integer idUser) throws DaoException {
		PasswordResetToken passwordResetToken = null;
		try {
			passwordResetToken = (PasswordResetToken) em.createNamedQuery("PasswordResetToken.findTokenByUser").setParameter("idUser", idUser).getSingleResult();
		} catch (NoResultException e) {
			return passwordResetToken;
		}
		return passwordResetToken;
	}

	@Override
	@Transactional
	public PasswordResetToken selectTokenByToken(String token) throws DaoException {
		PasswordResetToken passwordResetToken = null;
		try {
			passwordResetToken = (PasswordResetToken) em.createNamedQuery("PasswordResetToken.findTokenByToken").setParameter("token", token).getSingleResult();
		} catch (NoResultException e) {
			return passwordResetToken;
		}
		return passwordResetToken;
	}
}
