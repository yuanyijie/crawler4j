package edu.uci.ics.crawler4j.util.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * @author yuanyijie
 *
 */
public class JedisUtil {
	
	private JedisPool pool;
	
	private static class JedisHolder {
		private static JedisUtil instance =new JedisUtil();
	}
	
	private JedisUtil(){
		JedisPoolConfig config = new JedisPoolConfig();
		pool = new JedisPool(config, "127.0.0.1", 6379);
	}
	
	public static JedisUtil getInstance(){
		return JedisHolder.instance;
	}
	
	public void destroy(){
		pool.destroy();
	}
	
	public <T> T invoke(RedisExecutor<T> executor){
		Jedis jedis = pool.getResource();
		T result = null;
		try{
			result = executor.execute(jedis);
		}finally{
			if(jedis!=null){
				jedis.close();
			}
		}
		return result;
	}
	
	
}
