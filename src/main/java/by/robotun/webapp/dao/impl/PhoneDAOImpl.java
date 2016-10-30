package by.robotun.webapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import by.robotun.webapp.dao.IPhoneDAO;
import by.robotun.webapp.exception.DaoException;

@Repository("jpaPhoneDAO")
public class PhoneDAOImpl implements IPhoneDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<String> selectPhonesStringByIdUser(Integer idUser) throws DaoException {
		List<String> phones = entityManager.createNamedQuery("Phone.findPhonesStringByIdUser").setParameter("idUser", idUser).getResultList();
		return phones;
	}
}
