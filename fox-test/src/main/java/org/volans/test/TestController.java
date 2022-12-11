//package org.volans.test;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.volans.test.config.DemoConfig;
//
///**
// * @author <a href="http://github.com/athc">dujf</a>
// * @date 2019-05-19
// * @since JDK1.8
// */
//@RestController
//@RequestMapping("/test")
//public class TestController {
//
//
//  private final TestService testService;
//
//  private final DemoConfig demoConfig;
//
//  @Autowired public TestController(TestService testService, DemoConfig demoConfig) {
//    this.testService = testService;
//    this.demoConfig = demoConfig;
//  }
//
//  @GetMapping
//  public String helloWorld() {
//    String ak = demoConfig.getDemoProperties().getAccessKey();
//    String sk = demoConfig.getDemoProperties().getSecurityKey();
//    return testService.getHelloWorld();
//  }
//
//  @PostMapping
//  public String postHelloWorld(@RequestBody String helloWorld) {
//    return helloWorld;
//  }
//}
