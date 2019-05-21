package org.volans.test.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019-05-21
 * @since JDK1.8
 */
@Configuration
@EnableConfigurationProperties({ DemoProperties.class, AbcProperties.class })
public class ConfigAutoConfig {

  @Bean
  public DemoConfig demoConfig(DemoProperties demoProperties) {
    DemoConfig demoConfig = new DemoConfig();
    demoConfig.setDemoProperties(demoProperties);
    return demoConfig;
  }

  @Bean
  public AbcConfig abcConfig(AbcProperties abcProperties) {
    AbcConfig abcConfig = new AbcConfig();
    abcConfig.setAbcProperties(abcProperties);
    return abcConfig;
  }
}
