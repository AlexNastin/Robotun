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
	public void votingCandidate(Integer mark, String idCandidate, Integer idUser) {
		redisDAO.insertVotingCandidate(mark, idCandidate, idUser);
	}

	@Override
	public float getVotingCandidate(String idCandidate) {
		return new BigDecimal(redisDAO.getVotingCandidate(idCandidate)).setScale(2, RoundingMode.HALF_UP).floatValue();
	}

	@Override
	public Integer checkVotingCandidate(String idCandidate, Integer idUser) {
		return redisDAO.checkVotingCandidate(idCandidate, idUser);
	}
}
