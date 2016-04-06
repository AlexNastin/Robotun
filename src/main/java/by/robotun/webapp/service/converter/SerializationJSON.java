package by.robotun.webapp.service.converter;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component("serializationJSON")
public class SerializationJSON {

	public String toJson(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonObjects= null;
		try {
			jsonObjects = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObjects;
	}

}
