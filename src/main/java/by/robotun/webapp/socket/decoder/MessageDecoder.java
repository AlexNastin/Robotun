package by.robotun.webapp.socket.decoder;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import org.springframework.web.socket.server.standard.SpringConfigurator;

import by.robotun.webapp.domain.json.Message;

public class MessageDecoder extends SpringConfigurator implements Decoder.Text<Message> {

	@Override
	public Message decode(String string) throws DecodeException {
		JsonObject jsonObject = Json.createReader(new StringReader(string))
				.readObject();
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
