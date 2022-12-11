package org.volans.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019-05-19
 * @since JDK1.8
 */

public class TestServiceTest extends BaseTest {



  @Autowired
  private TestService testService;

  @Test
  public void getHelloWorld() {
    String result = testService.getHelloWorld();
    Assert.assertNotNull(result);
  }


}