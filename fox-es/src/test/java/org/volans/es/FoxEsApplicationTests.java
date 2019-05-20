package org.volans.es;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.volans.es.repo.TradeTransactionRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FoxEsApplicationTests {

  @Autowired
  private TradeTransactionRepository repository;

  @Test
  public void testR() {
    Page page = repository.findAll(PageRequest.of(1, 10));
    System.out.println(page.getTotalElements());
  }

}
