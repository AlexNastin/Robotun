package by.robotun.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	public RedisTemplate<String, String> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void insertValue(String a, String b) {
		redisTemplate.opsForValue().set(a, b);
	}

	public String getValue(String a) {
		String result = redisTemplate.opsForValue().get(a);
		return result;
	}

}
