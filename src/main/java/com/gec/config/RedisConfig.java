package com.gec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean("redisTemplate")
    public RedisTemplate getRedisTemplate(
            RedisConnectionFactory factory ){
        //{1}我们自己创建 RedisTemplate
        RedisTemplate<String,Object> template = new RedisTemplate();
        //{2}自己设置连接工厂
        template.setConnectionFactory( factory );

        //{3}这里还要设置序列化相关的内容..
        //{ps}针对 string 类型来做序列化。
        //    user 类要实现 java.io.Serializable
        template.setKeySerializer( keySerializer() );
        template.setValueSerializer( valueSerializer() );

        template.setHashKeySerializer( keySerializer() );
        template.setHashValueSerializer( valueSerializer() );

        //{7}返回 template 对象.
        return template;
    }

    public StringRedisSerializer keySerializer(){
        return new StringRedisSerializer();
    }

    public GenericJackson2JsonRedisSerializer valueSerializer(){
        return new GenericJackson2JsonRedisSerializer();
    }

}
