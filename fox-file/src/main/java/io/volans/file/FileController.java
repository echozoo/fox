package io.volans.file;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019-05-25
 * @since JDK1.8
 */
@RestController
@RequestMapping
public class FileController {

  @RequestMapping("/")
  public String index() {
    return "Hello Docker!";
  }
}
