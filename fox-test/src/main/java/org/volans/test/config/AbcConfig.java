package org.volans.test.config;

import lombok.Data;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019-05-21
 * @since JDK1.8
 */
@Data
public class AbcConfig {

  private AbcProperties abcProperties;

  public AbcProperties getAbcProperties() {
    return abcProperties;
  }

  public void setAbcProperties(AbcProperties abcProperties) {
    this.abcProperties = abcProperties;
  }
}
