package by.robotun.webapp.service.converter;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import by.robotun.webapp.domain.ArchiveLot;
import by.robotun.webapp.domain.Lot;
import by.robotun.webapp.domain.User;
import by.robotun.webapp.domain.json.Views;
import by.robotun.webapp.exception.ServiceException;

@Component("serializationJSON")
public class SerializationJSON {

	public String toJson(Object object) throws ServiceException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonObjects = null;
		try {
			jsonObjects = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new ServiceException(e);
		}
		return jsonObjects;
	}

	public String toJsonViewsPublic(Object object) throws ServiceException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonObjects = null;
		try {
			jsonObjects = mapper.writerWithView(Views.Public.class).writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new ServiceException(e);
		}
		return jsonObjects;
	}

	public String toJsonViewsInternalLot(Lot lot) throws ServiceException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonObjects = null;
		try {
			jsonObjects = mapper.writerWithView(Views.Internal.class).writeValueAsString(lot);
		} catch (JsonProcessingException e) {
			throw new ServiceException(e);
		}
		return jsonObjects;
	}
	
	public String toJsonViewsInternalLot(ArchiveLot archiveLot) throws ServiceException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonObjects = null;
		try {
			jsonObjects = mapper.writerWithView(Views.Internal.class).writeValueAsString(archiveLot);
		} catch (JsonProcessingException e) {
			throw new ServiceException(e);
		}
		return jsonObjects;
	}

	public String toJsonViewsInternalRejectMessages(Object object) throws ServiceException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonObjects = null;
		try {
			jsonObjects = mapper.writerWithView(Views.InternalRejectMessages.class).writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new ServiceException(e);
		}
		return jsonObjects;
	}
	
	public String toJsonViewsInternalConfirmLot(Lot lot) throws ServiceException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonObjects = null;
		try {
			jsonObjects = mapper.writerWithView(Views.InternalConfirmLot.class).writeValueAsString(lot);
		} catch (JsonProcessingException e) {
			throw new ServiceException(e);
		}
		return jsonObjects;
	}
	
	public String toJsonViewsPublicCategories(Object object) throws ServiceException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonObjects = null;
		try {
			jsonObjects = mapper.writerWithView(Views.PublicCategories.class).writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new ServiceException(e);
		}
		return jsonObjects;
	}
	
	public String toJsonViewsInternalForListModerators(Object object) throws ServiceException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonObjects = null;
		try {
			jsonObjects = mapper.writerWithView(Views.InternalForListModerators.class).writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new ServiceException(e);
		}
		return jsonObjects;
	}
	
	public String toJsonViewsInternalUserSubclass(User user) throws ServiceException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonObjects = null;
		try {
			jsonObjects = mapper.writerWithView(Views.InternalUserSubclass.class).writeValueAsString(user);
		} catch (JsonProcessingException e) {
			throw new ServiceException(e);
		}
		return jsonObjects;
	}
}
