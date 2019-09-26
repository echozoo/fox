package org.volans.test.config;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019-09-03
 * @since JDK1.8
 */
@Configuration
public class TreadPoolConfig {

  @Bean
  public ExecutorService executorService() {
    ExecutorService pool = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
        new ArrayBlockingQueue<Runnable>(5), new ThreadPoolExecutor.AbortPolicy());
    return pool;
  }
}
