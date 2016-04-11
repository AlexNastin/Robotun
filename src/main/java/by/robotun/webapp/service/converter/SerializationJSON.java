package by.robotun.webapp.service.converter;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import by.robotun.webapp.domain.json.Views;
import by.robotun.webapp.exeption.ServiceException;

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

	public String toJsonViewsInternal(Object object) throws ServiceException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonObjects = null;
		try {
			jsonObjects = mapper.writerWithView(Views.Internal.class).writeValueAsString(object);
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
}
