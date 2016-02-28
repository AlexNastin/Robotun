package by.robotun.webapp.socket.encoder;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import org.springframework.web.socket.server.standard.SpringConfigurator;

import by.robotun.webapp.domain.json.Message;

public class MessageEncoder extends SpringConfigurator implements Encoder.Text<Message> {

	@Override
    public String encode(Message message) throws EncodeException {
        return message.getJson().toString();
    }

    @Override
    public void init(EndpointConfig ec) {
    }

    @Override
    public void destroy() {
    }

}
