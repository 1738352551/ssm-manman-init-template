package cn.chenmanman.ssm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;
/**
 * redis配置
 *
 * */
@PropertySource("classpath:redis.properties")
public class RedisConfig {

    @Bean
    public JedisPoolConfig jedisPoolConfig(
            @Value("${redis.maxIdle}") Integer maxIdle,
            @Value("${redis.minIdle}") Integer minIdle,
            @Value("${redis.maxTotal}") Integer maxTotal,
            @Value("${redis.maxWaitMillis}") Long maxWaitMillis
    ){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        return jedisPoolConfig;
    }


    @Bean
    public JedisConnectionFactory jedisConnectionFactory(
            JedisPoolConfig jedisPoolConfig,
            @Value("${redis.host}") String hostName,
            @Value("${redis.port}") Integer port
    ) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(hostName);
        jedisConnectionFactory.setPort(port);
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
        jedisConnectionFactory.setTimeout(100000);

        return jedisConnectionFactory;
    }

    @Bean("redisTemplate")
    public RedisTemplate redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();


        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(stringRedisSerializer);
        return redisTemplate;
    }

}
