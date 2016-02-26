package by.robotun.webapp.socket.decoder;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import org.springframework.stereotype.Controller;

import by.robotun.webapp.domain.json.Message;

@Controller
public class MessageDecoder implements Decoder.Text<Message> {
	
	@Override
	public Message decode(String string) throws DecodeException {
		JsonObject jsonObject = Json.createReader(new StringReader(string))
				.readObject();
		String cost = jsonObject.getString("cost");
		int idUser = jsonObject.getInt("idUser");
		int idLot = jsonObject.getInt("idLot");
//		try {
//			userService.addBet(cost, idUser, idLot);
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		return new Message(jsonObject);
	}

	@Override
	public boolean willDecode(String string) {
		try {
			Json.createReader(new StringReader(string)).readObject();
			return true;
		} catch (JsonException ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public void init(EndpointConfig ec) {
	}

	@Override
	public void destroy() {
	}

}
