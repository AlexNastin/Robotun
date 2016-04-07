package by.robotun.webapp.dao.nosql.impl;

import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.hibernate.metamodel.source.binder.SubclassEntitySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import by.robotun.webapp.dao.nosql.IRedisDAO;

@Repository("redisDAOImpl")
public class RedisDAOImpl implements IRedisDAO {

	@Autowired
	private RedisTemplate<String, Map<Integer, Integer>> redisTemplate;

	@Override
	public void insertVotingLot(Integer mark, String idLot, Integer idUser) {
		Map<Integer, Integer> votingLot = redisTemplate.opsForValue().get(idLot);
		if (votingLot != null) {
			votingLot.put(idUser, mark);
			redisTemplate.opsForValue().set(idLot, votingLot);
		} else {
			Map<Integer, Integer> value = new HashMap<>();
			value.put(idUser, mark);
			redisTemplate.opsForValue().set(idLot, value);
		}
	}

	@Override
	public Integer getVotingLot(String idLot) {
		Map<Integer, Integer> votingLot = redisTemplate.opsForValue().get(idLot);
		Collection<Integer> valuesVotingLot =  votingLot.values();
		Integer summ = 0;
		for (Integer integer : valuesVotingLot) {
			summ += integer;
		}
		return summ;
	}
}
