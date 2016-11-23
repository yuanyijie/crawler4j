package edu.uci.ics.crawler4j.util.redis;

import redis.clients.jedis.Jedis;

/**
 * redis queue
 * @author yuanyijie
 *
 */
public class Queue {
	private static JedisUtil util = JedisUtil.getInstance();
	
	/**
	 * 从队列的头部push n个字符串
	 * @param key
	 * @param value
	 */
	public static void lpush(final String key, final String...value){
		util.invoke(new RedisExecutor<Void>() {

			@Override
			public Void execute(Jedis jedis) {
				jedis.lpush(key, value);
				return null;
			}
		});
	}
	
	/**
	 * 从队列的尾部push n个字符串
	 * @param key
	 * @param value
	 */
	public static void rpush(final String key, final String...value){
		util.invoke(new RedisExecutor<Void>() {

			@Override
			public Void execute(Jedis jedis) {
				jedis.rpush(key, value);
				return null;
			}
		});
	}
	
	/**
	 * 从队列的头部pop 一个字符串
	 * @param key
	 * @return
	 */
	public static String lpop(final String key){
		return util.invoke(new RedisExecutor<String>() {

			@Override
			public String execute(Jedis jedis) {
				return jedis.lpop(key);
			}
		});
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public static String rpop(final String key){
		return util.invoke(new RedisExecutor<String>() {

			@Override
			public String execute(Jedis jedis) {
				return jedis.rpop(key);
			}
		});
	}
	
}
