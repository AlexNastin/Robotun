package by.robotun.webapp.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import by.robotun.webapp.dao.ILotDAO;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.exception.DaoException;
import by.robotun.webapp.property.PropertyManager;
import by.robotun.webapp.property.PropertyName;
import by.robotun.webapp.service.ServiceParamConstant;

@Repository("jpaLotDAO")
public class LotDAOImpl implements ILotDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private PropertyManager propertyManager;

	@Override
	@Transactional
	public void insertLot(Lot lot) throws DaoException {
		entityManager.persist(lot);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectAllLots(Date endDate) throws DaoException {
		List<Lot> lots = entityManager.createNamedQuery("Lot.findAllActiveLot").setParameter("endDate", endDate)
				.setParameter("isVisible", ServiceParamConstant.ON_PUBLIC_NUMBER)
				.setMaxResults(Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE)))
				.getResultList();
		return lots;
	}

	@Override
	@Transactional
	public void deleteLot(Integer id) throws DaoException {
		Lot lot = entityManager.find(Lot.class, id);
		entityManager.remove(lot);
	}

	@Override
	@Transactional
	public void updateLot(Lot lot) throws DaoException {
		entityManager.merge(lot);

	}

	@Override
	public Lot selectLotById(int idLot) throws DaoException {
		Lot lot = null;
		try {
			lot = (Lot) entityManager.createNamedQuery("Lot.findLotById").setParameter("id", idLot).getSingleResult();
		} catch (NoResultException e) {
			throw new DaoException(e);

		}
		return lot;
	}
	
	@Override
	public int selectIdOwnerLot(int idLot) throws DaoException {
		int idUser = 0;
		try {
			idUser = (int) entityManager.createNamedQuery("Lot.findIdOwnerLot").setParameter("id", idLot).getSingleResult();
		} catch (NoResultException e) {
			throw new DaoException(e);

		}
		return idUser;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectLotByCategory(int idCategory, Date endDate) throws DaoException {
		List<Lot> lots = entityManager.createNamedQuery("Lot.findLotByCategory").setParameter("idCategory", idCategory)
				.setParameter("endDate", endDate).setParameter("isVisible", ServiceParamConstant.ON_PUBLIC_NUMBER)
				.getResultList();
		return lots;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectLotByCategoryAndSubcategory(int idCategory, int idSubcategory, Date endDate)
			throws DaoException {
		List<Lot> lots = entityManager.createNamedQuery("Lot.findLotByCategoryAndSubcategory")
				.setParameter("idCategory", idCategory).setParameter("idSubcategory", idSubcategory)
				.setParameter("endDate", endDate).setParameter("isVisible", ServiceParamConstant.ON_PUBLIC_NUMBER)
				.setMaxResults(Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE)))
				.getResultList();
		return lots;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectLotsByCategoryAndSubcategoryLimitOffset(int offset, Date endDate, int idCategory,
			int idSubcategory) throws DaoException {
		Integer limit = Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE));
		List<Lot> lots = entityManager.createNamedQuery("Lot.findLotByCategoryAndSubcategory")
				.setParameter("idCategory", idCategory).setParameter("idSubcategory", idSubcategory)
				.setParameter("endDate", endDate).setParameter("isVisible", ServiceParamConstant.ON_PUBLIC_NUMBER)
				.setFirstResult(offset * limit).setMaxResults(limit).getResultList();
		return lots;
	}

	@Override
	public Date selectDateLotById(Integer idLot) throws DaoException {
		Date endDate = (Date) entityManager.createNamedQuery("Lot.findDateLotById").setParameter("idLot", idLot)
				.getSingleResult();
		return endDate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectLotsLimitOffset(int offset, Date date) throws DaoException {
		Integer limit = Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE));
		List<Lot> lots = entityManager.createNamedQuery("Lot.findAllActiveLot").setParameter("endDate", date)
				.setParameter("isVisible", ServiceParamConstant.ON_PUBLIC_NUMBER).setFirstResult(offset * limit)
				.setMaxResults(limit).getResultList();
		return lots;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectLotsOnModeration() throws DaoException {
		List<Lot> lots = entityManager.createNamedQuery("Lot.findAllLotOnModeration")
				.setParameter("isVisible", ServiceParamConstant.ON_MODERATION_NUMBER)
				.setMaxResults(Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE)))
				.getResultList();
		return lots;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectLotsCreatedUser(int idUser) throws DaoException {
		List<Lot> lots = entityManager.createNamedQuery("Lot.findLotsCreatedUser").setParameter("id", idUser)
				.setMaxResults(Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE)))
				.getResultList();
		return lots;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectLotsRespondedUser(int idUser) throws DaoException {
		List<Lot> lots = entityManager.createNamedQuery("Lot.findLotsRespondedUser").setParameter("id", idUser)
				.setMaxResults(Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE)))
				.getResultList();
		return lots;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectMyLotsLimitOffset(int offset, int idUser) throws DaoException {
		Integer limit = Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE));
		List<Lot> lots = entityManager.createNamedQuery("Lot.findLotsCreatedUser").setParameter("id", idUser)
				.setFirstResult(offset).setMaxResults(limit).getResultList();
		return lots;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectMyResponsesLimitOffset(int offset, int idUser) throws DaoException {
		Integer limit = Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE));
		List<Lot> lots = entityManager.createNamedQuery("Lot.findLotsRespondedUser").setParameter("id", idUser)
				.setFirstResult(offset).setMaxResults(limit).getResultList();
		return lots;
	}

	@Override
	public Lot selectLotByIdForModeration(int idLot) throws DaoException {
		Lot lot = null;
		try {
			lot = (Lot) entityManager.createNamedQuery("Lot.findLotByIdForModeration").setParameter("id", idLot)
					.getSingleResult();
		} catch (NoResultException e) {
			throw new DaoException(e);

		}
		return lot;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectOnModerationLimitOffset(int offset) throws DaoException {
		Integer limit = Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE));
		List<Lot> lots = entityManager.createNamedQuery("Lot.findAllLotOnModeration")
				.setParameter("isVisible", ServiceParamConstant.ON_MODERATION_NUMBER).setFirstResult(offset * limit)
				.setMaxResults(limit).getResultList();
		return lots;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectLotsOnUpdateByUser(int idUser) throws DaoException {
		List<Lot> lots = entityManager.createNamedQuery("Lot.findLotOnUpdateByUser")
				.setParameter("isVisible", ServiceParamConstant.ON_UPDATE_NUMBER).setParameter("id", idUser)
				.setMaxResults(Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE)))
				.getResultList();
		return lots;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectLotsOnUpdateByUserLimitOffset(int offset, int idUser) throws DaoException {
		Integer limit = Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE));
		List<Lot> lots = entityManager.createNamedQuery("Lot.findLotOnUpdateByUser")
				.setParameter("isVisible", ServiceParamConstant.ON_UPDATE_NUMBER).setParameter("id", idUser)
				.setFirstResult(offset).setMaxResults(limit).getResultList();
		return lots;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectLotsFiltering(String endDateString, Integer budgetFrom, Integer budgetTo, String desc,
			Integer idCity) throws DaoException {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Lot> criteriaQuery = criteriaBuilder.createQuery(Lot.class);
		Root<Lot> criteria = criteriaQuery.from(Lot.class);
		criteriaQuery = criteriaQuery.select(criteria);
		List<Predicate> predicatesList = new ArrayList<Predicate>();
		Date date = new Date();
		Predicate currentDatePredicate = criteriaBuilder.greaterThanOrEqualTo(criteria.<Date> get("endDate"), date);
		predicatesList.add(currentDatePredicate);
		Predicate isVisiblePredicate = criteriaBuilder.equal(criteria.get("isVisible"),
				ServiceParamConstant.ON_PUBLIC_NUMBER);
		predicatesList.add(isVisiblePredicate);
		if (!"".equals(endDateString) && endDateString != null) {
			try {
				DateFormat dateFormat = new SimpleDateFormat(ServiceParamConstant.FORMAT_DATE_WITH_TIME);
				Date endDate = dateFormat.parse(endDateString);
				Predicate endDatePredicate = criteriaBuilder.lessThanOrEqualTo(criteria.<Date> get("endDate"), endDate);
				predicatesList.add(endDatePredicate);
			} catch (ParseException e) {
				throw new DaoException(e);
			}
		}
		if (budgetFrom != null) {
			Predicate budgetFromPredicate = criteriaBuilder.ge(criteria.get("budget"), budgetFrom);
			predicatesList.add(budgetFromPredicate);
		}
		if (budgetTo != null) {
			Predicate budgetToPredicate = criteriaBuilder.le(criteria.get("budget"), budgetTo);
			predicatesList.add(budgetToPredicate);
		}
		if (idCity != 0) {
			Predicate cityPredicate = criteriaBuilder.equal(criteria.get("idCity"), idCity);
			predicatesList.add(cityPredicate);
		}
		Predicate predicate = criteriaBuilder.and(predicatesList.toArray(new Predicate[0]));
		criteriaQuery.where(predicate);
		switch (desc.toLowerCase()) {
		case DaoParamConstant.SORT_TYPE_NEW:
			criteriaQuery.orderBy(criteriaBuilder.desc(criteria.get("startDate")));
			break;
		case DaoParamConstant.SORT_TYPE_OLD:
			criteriaQuery.orderBy(criteriaBuilder.asc(criteria.get("startDate")));
			break;
		case DaoParamConstant.SORT_TYPE_EXPENSIVE:
			criteriaQuery.orderBy(criteriaBuilder.desc(criteria.get("budget")));
			break;
		case DaoParamConstant.SORT_TYPE_CHEAP:
			criteriaQuery.orderBy(criteriaBuilder.asc(criteria.get("budget")));
			break;
		default:
			break;
		}
		Integer limit = Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE));
		Query query = entityManager.createQuery(criteriaQuery).setMaxResults(limit);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> selectLotsFilteringOffset(String endDateString, Integer budgetFrom, Integer budgetTo, String desc,
			Integer idCity, Integer offset, Date date) throws DaoException {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Lot> criteriaQuery = criteriaBuilder.createQuery(Lot.class);
		Root<Lot> criteria = criteriaQuery.from(Lot.class);
		criteriaQuery = criteriaQuery.select(criteria);
		List<Predicate> predicatesList = new ArrayList<Predicate>();
		Predicate currentDatePredicate = criteriaBuilder.greaterThanOrEqualTo(criteria.<Date> get("endDate"), date);
		predicatesList.add(currentDatePredicate);
		Predicate isVisiblePredicate = criteriaBuilder.equal(criteria.get("isVisible"),
				ServiceParamConstant.ON_PUBLIC_NUMBER);
		predicatesList.add(isVisiblePredicate);
		if (!"".equals(endDateString)) {
			try {
				DateFormat dateFormat = new SimpleDateFormat(ServiceParamConstant.FORMAT_DATE_WITH_TIME);
				Date endDate = dateFormat.parse(endDateString);
				Predicate endDatePredicate = criteriaBuilder.lessThanOrEqualTo(criteria.<Date> get("endDate"), endDate);
				predicatesList.add(endDatePredicate);
			} catch (ParseException e) {
				throw new DaoException(e);
			}
		}
		if (budgetFrom != null) {
			Predicate budgetFromPredicate = criteriaBuilder.ge(criteria.get("budget"), budgetFrom);
			predicatesList.add(budgetFromPredicate);
		}
		if (budgetTo != null) {
			Predicate budgetToPredicate = criteriaBuilder.le(criteria.get("budget"), budgetTo);
			predicatesList.add(budgetToPredicate);
		}
		if (idCity != 0) {
			Predicate cityPredicate = criteriaBuilder.equal(criteria.get("idCity"), idCity);
			predicatesList.add(cityPredicate);
		}
		Predicate predicate = criteriaBuilder.and(predicatesList.toArray(new Predicate[0]));
		criteriaQuery.where(predicate);
		switch (desc.toLowerCase()) {
		case DaoParamConstant.SORT_TYPE_NEW:
			criteriaQuery.orderBy(criteriaBuilder.desc(criteria.get("startDate")));
			break;
		case DaoParamConstant.SORT_TYPE_OLD:
			criteriaQuery.orderBy(criteriaBuilder.asc(criteria.get("startDate")));
			break;
		case DaoParamConstant.SORT_TYPE_EXPENSIVE:
			criteriaQuery.orderBy(criteriaBuilder.desc(criteria.get("budget")));
			break;
		case DaoParamConstant.SORT_TYPE_CHEAP:
			criteriaQuery.orderBy(criteriaBuilder.asc(criteria.get("budget")));
			break;
		default:
			break;
		}
		Integer limit = Integer.parseInt(propertyManager.getValue(PropertyName.AJAX_LOT_MAXSIZE));
		Query query = entityManager.createQuery(criteriaQuery).setFirstResult(offset * limit).setMaxResults(limit);
		return query.getResultList();
	}
	
	@Override
	public void callFunctionDeleteLotForTime() throws DaoException {
		entityManager.createNativeQuery("SELECT count(*) FROM delete_lot_for_time()").getSingleResult();
	}
}
