package io.volans.file;

import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019-05-25
 * @since JDK1.8
 */
@RestController
@RequestMapping
public class FileController {

  @RequestMapping("/")
  public String index(HttpServletRequest request) {
    MultipartHttpServletRequest r = (MultipartHttpServletRequest) request;
    //参数名list
    Iterator<String> paramNames = r.getFileNames();
    while (paramNames.hasNext()) {
      r.getFile(paramNames.next());
      //todo： 上传
    }
    return "Hello Docker!";
  }
}
