package org.volans.es.po;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * * @Document
 * * @param indexName 文档存储的地方
 * * @param type      文档代表的对象的类
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @author dujf
 * @Document
 * @date 09/04/2018
 * @since JDK1.8
 */
@Document(indexName = "login_log", shards = 1, replicas = 0, refreshInterval = "-1")
public class LoginLog implements Serializable {

  @Id
  private Long id;

  private String usr;

  private String value;

  private String remark;

  public LoginLog() {
  }

  public LoginLog(Long id, String usr, String value, String remark, Long careateAt) {
    this.id = id;
    this.usr = usr;
    this.value = value;
    this.remark = remark;
    this.careateAt = careateAt;
  }

  private Long careateAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsr() {
    return usr;
  }

  public void setUsr(String usr) {
    this.usr = usr;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Long getCareateAt() {
    return careateAt;
  }

  public void setCareateAt(Long careateAt) {
    this.careateAt = careateAt;
  }
}




