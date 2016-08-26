package by.robotun.webapp.dao.nosql.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import by.robotun.webapp.dao.nosql.IRedisDAO;

@Repository("redisDAOImpl")
public class RedisDAOImpl implements IRedisDAO {

	@Autowired
	private RedisTemplate<String, Map<Integer, Integer>> redisTemplate;

	@Override
	public void insertVotingLot(Integer mark, String idCandidate, Integer idUser) {
		Map<Integer, Integer> votingLot = redisTemplate.opsForValue().get(idCandidate);
		if (votingLot != null) {
			votingLot.put(idUser, mark);
			redisTemplate.opsForValue().set(idCandidate, votingLot);
		} else {
			Map<Integer, Integer> value = new HashMap<>();
			value.put(idUser, mark);
			redisTemplate.opsForValue().set(idCandidate, value);
		}
	}

	@Override
	public Double getVotingLot(String idCandidate) {
		Map<Integer, Integer> votingLot = redisTemplate.opsForValue().get(idCandidate);
		Collection<Integer> valuesVotingLot = votingLot.values();
		Double summ = 0.0;
		for (Integer integer : valuesVotingLot) {
			summ += integer;
		}
		summ /= valuesVotingLot.size();
		return summ;
	}

	@Override
	public Integer checkVotingLot(String idCandidate, Integer idUser) {
		Map<Integer, Integer> votingLot = redisTemplate.opsForValue().get(idCandidate);
		Integer vote = votingLot.get(String.valueOf(idUser));
		if (vote == null) {
			vote = 0;
		}
		return vote;
	}
}
