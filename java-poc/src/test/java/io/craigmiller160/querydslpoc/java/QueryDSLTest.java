package io.craigmiller160.querydslpoc.java;

import static org.assertj.core.api.Assertions.assertThat;

import io.craigmiller160.querydslpoc.java.service.QueryDSLService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class QueryDSLTest {
  private final QueryDSLService queryDSLService;

  @Test
  public void test_queryDslOperation() {
    final var result = queryDSLService.getOneEmployee();
    assertThat(result).isPresent();
  }
}
