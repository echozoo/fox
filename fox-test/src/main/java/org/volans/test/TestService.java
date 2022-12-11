package org.volans.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.stereotype.Service;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019-05-19
 * @since JDK1.8
 */
@Service
public class TestService {

  String getHelloWorld() {

    // 原子性 有序性
    return "hello world";
  }
}
