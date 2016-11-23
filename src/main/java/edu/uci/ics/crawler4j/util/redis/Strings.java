package edu.uci.ics.crawler4j.util.redis;

import redis.clients.jedis.Jedis;

/**
 * redis queue
 * @author yuanyijie
 *
 */
public class Strings {
	
	private static JedisUtil util = JedisUtil.getInstance();
	
	public static void set(final String key, final String value){
		util.invoke(new RedisExecutor<Void>() {
			@Override
			public Void execute(Jedis jedis) {
				jedis.set(key, value);
				return null;
			}
		});
	}
	
	public static String get(final String key){
		return util.invoke(new RedisExecutor<String>() {
			@Override
			public String execute(Jedis jedis) {
				return jedis.get(key);
			}
		});
	}
}
