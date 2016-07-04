package by.robotun.webapp.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
	public float getVotingLot(String idLot) {
		return new BigDecimal(redisDAO.getVotingLot(idLot)).setScale(2, RoundingMode.HALF_UP).floatValue();
	}

	@Override
	public Integer checkVotingLot(String idLot, int idUser) {
		return redisDAO.checkVotingLot(idLot, idUser);
	}
}
