package by.robotun.webapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.robotun.webapp.dao.nosql.IRedisDAO;
import by.robotun.webapp.service.IVotingService;

@Component("votingService")
public class VotingService implements IVotingService {

	@Autowired
	private IRedisDAO redisDAO;

	@Override
	public void votingLot(int mark, String idLot, int idUser) {
		redisDAO.insertVotingLot(mark, idLot, idUser);
	}

	@Override
	public Integer getVotingLot(String idLot) {
		return redisDAO.getVotingLot(idLot);
	}
}
