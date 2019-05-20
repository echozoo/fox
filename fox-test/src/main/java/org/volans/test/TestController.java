package org.volans.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019-05-19
 * @since JDK1.8
 */
@RestController
@RequestMapping("/test")
public class TestController {


  private final TestService testService;

  @Autowired public TestController(TestService testService) {this.testService = testService;}

  @GetMapping
  public String helloWorld() {
    return testService.getHelloWorld();
  }

  @PostMapping
  public String postHelloWorld(@RequestBody String helloWorld) {
    return helloWorld;
  }
}
