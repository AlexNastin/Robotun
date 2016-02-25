package by.robotun.webapp.socket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import by.robotun.webapp.domain.json.Message;
import by.robotun.webapp.socket.decoder.MessageDecoder;
import by.robotun.webapp.socket.encoder.MessageEncoder;

@ServerEndpoint(value="/messagesocket/{id}", encoders = {MessageEncoder.class}, decoders = {MessageDecoder.class})
public class MessageSocket {

	private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

	@OnMessage
	public void broadcastMessage(Message message, Session session) throws IOException, EncodeException {
		String id = (String) session.getUserProperties().get("id");
		for (Session peer : peers) {
            if (peer.isOpen() && !peer.equals(session) && id.equals(peer.getUserProperties().get("id"))) {
                peer.getBasicRemote().sendObject(message);
            }
        }
    }

	@OnOpen
	public void onOpen(Session peer, @PathParam("id") String id) {
		peer.getUserProperties().put("id", id);
		peers.add(peer);
	}

	@OnClose
	public void onClose(Session peer) {
		peers.remove(peer);
	}

}
