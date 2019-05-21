package org.volans.test.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019-05-21
 * @since JDK1.8
 */
@ConfigurationProperties("abc.def")
@Data
public class AbcProperties {

  private String key;

  private String value;
}
