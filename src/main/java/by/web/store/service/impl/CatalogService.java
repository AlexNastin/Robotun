package by.web.store.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.web.store.dao.ICategoryDAO;
import by.web.store.domain.Role;
import by.web.store.exeption.DaoException;
import by.web.store.service.ICatalogService;

@Component
public class CatalogService implements ICatalogService {
	
	@Autowired
	private ICategoryDAO categoryDAO;

	@Override
	public List<Role> get() {
		List<Role> roles = new ArrayList<>();
		try {
			roles = categoryDAO.selectAllCategories();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roles;
	}

}
