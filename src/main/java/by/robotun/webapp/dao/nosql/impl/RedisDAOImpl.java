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
	private RedisTemplate<String, Map<String, Integer>> redisTemplate;

	@Override
	public void insertVotingCandidate(Integer mark, String idCandidate, String idUser) {
		Map<String, Integer> votingCandidate = redisTemplate.opsForValue().get(idCandidate);
		if (votingCandidate != null) {
			Integer vote = votingCandidate.get(String.valueOf(idUser));
			System.out.println(vote);
			if (vote == null) {
				System.out.println("!");
				vote = mark;
				votingCandidate.put(idUser, vote);
				redisTemplate.opsForValue().set(idCandidate, votingCandidate);
			} else {
				System.out.println("!!");
				votingCandidate.replace(String.valueOf(idUser), mark);
				for (Map.Entry<String, Integer> entry : votingCandidate.entrySet())
				{
				    System.out.println(entry.getKey() + "/" + entry.getValue());
				}
				redisTemplate.opsForValue().set(idCandidate, votingCandidate);
			}
		} else {
			Map<String, Integer> value = new HashMap<>();
			value.put(idUser, mark);
			redisTemplate.opsForValue().set(idCandidate, value);
		}
	}

	@Override
	public Double getVotingCandidate(String idCandidate) {
		Double summ = 0.0;
		Map<String, Integer> votingCandidate = redisTemplate.opsForValue().get(idCandidate);
		if (votingCandidate != null) {
			Collection<Integer> valuesVotingCandidate = votingCandidate.values();
			for (Integer integer : valuesVotingCandidate) {
				summ += integer;
			}
			summ /= valuesVotingCandidate.size();
		}
		return summ;
	}

	@Override
	public Integer checkVotingCandidate(String idCandidate, String idUser) {
		Map<String, Integer> votingCandidate = redisTemplate.opsForValue().get(idCandidate);
		Integer vote = votingCandidate.get(String.valueOf(idUser));
		if (vote == null) {
			vote = 0;
		}
		return vote;
	}
}
