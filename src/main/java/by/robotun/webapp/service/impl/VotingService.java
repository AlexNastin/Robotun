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
	public void votingLot(Integer mark, String idCandidate, Integer idUser) {
		redisDAO.insertVotingLot(mark, idCandidate, idUser);
	}

	@Override
	public float getVotingLot(String idCandidate) {
		return new BigDecimal(redisDAO.getVotingLot(idCandidate)).setScale(2, RoundingMode.HALF_UP).floatValue();
	}

	@Override
	public Integer checkVotingLot(String idCandidate, Integer idUser) {
		return redisDAO.checkVotingLot(idCandidate, idUser);
	}
}
