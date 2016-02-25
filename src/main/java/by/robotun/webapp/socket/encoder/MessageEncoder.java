package by.robotun.webapp.socket.encoder;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import by.robotun.webapp.domain.json.Message;

public class MessageEncoder implements Encoder.Text<Message> {

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
