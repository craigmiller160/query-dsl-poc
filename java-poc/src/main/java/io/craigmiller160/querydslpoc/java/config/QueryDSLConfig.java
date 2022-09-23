package io.craigmiller160.querydslpoc.java.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class QueryDSLConfig {
    private final EntityManager entityManager;

    @Bean
    public JPAQueryFactory queryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
