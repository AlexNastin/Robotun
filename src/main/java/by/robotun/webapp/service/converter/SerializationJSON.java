package by.robotun.webapp.service.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import by.robotun.webapp.domain.ArchiveBet;
import by.robotun.webapp.domain.ArchiveLot;
import by.robotun.webapp.domain.Bet;
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
	
	public String toJsonViewsPublicLot(List<Lot> lots) throws ServiceException {
		for (Lot lot : lots) {
			lot.setName(lot.getName().replace("\"", "\\\""));
			lot.setDescription(lot.getDescription().replace("\"", "\\\"").replace("\\", "\\\\"));
		}
		ObjectMapper mapper = new ObjectMapper();
		String jsonObjects = null;
		try {
			jsonObjects = mapper.writerWithView(Views.Public.class).writeValueAsString(lots);
		} catch (JsonProcessingException e) {
			throw new ServiceException(e);
		}
		return jsonObjects;
	}
	
	public String toJsonViewsPublicArchiveLot(List<ArchiveLot> archiveLots) throws ServiceException {
		for (ArchiveLot archiveLot : archiveLots) {
			archiveLot.setName(archiveLot.getName().replace("\"", "\\\""));
			archiveLot.setDescription(archiveLot.getDescription().replace("\"", "\\\"").replace("\\", "\\\\"));
		}
		ObjectMapper mapper = new ObjectMapper();
		String jsonObjects = null;
		try {
			jsonObjects = mapper.writerWithView(Views.Public.class).writeValueAsString(archiveLots);
		} catch (JsonProcessingException e) {
			throw new ServiceException(e);
		}
		return jsonObjects;
	}

	public String toJsonViewsInternalLot(Lot lot) throws ServiceException {
		lot.getUser().setNickname(lot.getUser().getNickname().replace("\"", "\\\""));
		lot.setName(lot.getName().replace("\"", "\\\""));
		lot.setDescription(lot.getDescription().replace("\"", "\\\"").replace("\\", "\\\\"));
		for (Bet bet : lot.getBets()) {
			bet.getUser().setNickname(bet.getUser().getNickname().replace("\"", "\\\""));
		}
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
		archiveLot.getUser().setNickname(archiveLot.getUser().getNickname().replace("\"", "\\\""));
		archiveLot.setName(archiveLot.getName().replace("\"", "\\\""));
		archiveLot.setDescription(archiveLot.getDescription().replace("\"", "\\\"").replace("\\", "\\\\"));
		for (ArchiveBet archiveBet : archiveLot.getBets()) {
			archiveBet.getUser().setNickname(archiveBet.getUser().getNickname().replace("\"", "\\\""));
		}
		ObjectMapper mapper = new ObjectMapper();
		String jsonObjects = null;
		try {
			jsonObjects = mapper.writerWithView(Views.Internal.class).writeValueAsString(archiveLot);
		} catch (JsonProcessingException e) {
			throw new ServiceException(e);
		}
		return jsonObjects;
	}

	public String toJsonViewsInternalRejectMessages(List<Lot> lots) throws ServiceException {
		for (Lot lot : lots) {
			lot.setName(lot.getName().replace("\"", "\\\""));
			lot.setDescription(lot.getDescription().replace("\"", "\\\"").replace("\\", "\\\\"));
		}
		ObjectMapper mapper = new ObjectMapper();
		String jsonObjects = null;
		try {
			jsonObjects = mapper.writerWithView(Views.InternalRejectMessages.class).writeValueAsString(lots);
		} catch (JsonProcessingException e) {
			throw new ServiceException(e);
		}
		return jsonObjects;
	}
	
	public String toJsonViewsInternalConfirmLot(Lot lot) throws ServiceException {
		lot.getUser().setNickname(lot.getUser().getNickname().replace("\"", "\\\""));
		lot.setName(lot.getName().replace("\"", "\\\""));
		lot.setDescription(lot.getDescription().replace("\"", "\\\"").replace("\\", "\\\\"));
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
		user.setNickname(user.getNickname().replace("\"", "\\\""));
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
