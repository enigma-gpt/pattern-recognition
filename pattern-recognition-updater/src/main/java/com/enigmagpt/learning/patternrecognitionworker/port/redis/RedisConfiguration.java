package com.enigmagpt.learning.patternrecognitionworker.port.redis;

import com.enigmagpt.learning.patternrecognitionworker.domain.Progress;
import org.apache.tools.ant.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate<String, Progress> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Progress> template = new RedisTemplate<>();
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Progress.class));
        template.setConnectionFactory(connectionFactory);
        return template;
    }
}