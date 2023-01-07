package com.enigmagpt.learning.patternrecognitionfinder.port.redis;

import com.enigmagpt.learning.patternrecognitionfinder.domain.Result;
import org.apache.tools.ant.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate<String, Result> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Result> template = new RedisTemplate<>();
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Task.class));
        template.setConnectionFactory(connectionFactory);
        return template;
    }
}
