package org.volans.test.config;

import lombok.Data;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019-05-21
 * @since JDK1.8
 */

public class DemoConfig {

  private DemoProperties demoProperties;

  public DemoProperties getDemoProperties() {
    return demoProperties;
  }

  public void setDemoProperties(DemoProperties demoProperties) {
    this.demoProperties = demoProperties;
  }

  public DemoConfig() {
  }
}
