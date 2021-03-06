package by.robotun.webapp.socket;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import by.robotun.webapp.domain.json.Message;
import by.robotun.webapp.exception.ServiceException;
import by.robotun.webapp.service.IUserService;
import by.robotun.webapp.socket.decoder.MessageDecoder;
import by.robotun.webapp.socket.encoder.MessageEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.server.standard.SpringConfigurator;

@ServerEndpoint(value = "/messagesocket/{id}", encoders = { MessageEncoder.class }, decoders = {
		MessageDecoder.class }, configurator = SpringConfigurator.class)
public class MessageSocket {

	@Autowired
	IUserService userService;

	private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

	@OnMessage
	public void broadcastMessage(Message message, Session session) throws IOException, EncodeException {
		JsonObject jsonObject = message.getJson();
		String cost = jsonObject.getString("cost");
		int idUser = jsonObject.getInt("idUser");
		int idLot = jsonObject.getInt("idLot");
		Date endDate;
		Date date = new Date();
		boolean isEndDate = false;
		try {
			endDate = userService.getDateLotById(idLot);
			if (date.getTime() <= endDate.getTime()) {
				userService.addBet(cost, idUser, idLot);
			} else {
				isEndDate = true;
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String id = (String) session.getUserProperties().get("id");
		if (isEndDate) {
			for (Session peer : peers) {
				if (peer.isOpen() && peer.equals(session) && id.equals(peer.getUserProperties().get("id"))) {
					peer.getBasicRemote().sendObject(isEndDate);
					break;
				}
			}
		} else {
			for (Session peer : peers) {
				if (peer.isOpen() && !peer.equals(session) && id.equals(peer.getUserProperties().get("id"))) {
					peer.getBasicRemote().sendObject(message);
				}
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

	@OnError
	public void onError(Session peer, Throwable t) {
		peers.remove(peer);
	}

}
