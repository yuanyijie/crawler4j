package edu.uci.ics.crawler4j.util.redis;

import redis.clients.jedis.Jedis;

public interface RedisExecutor<T> {
	T execute(Jedis jedis);
}
