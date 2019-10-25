package org.volans.es.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import lombok.Data;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * * @Document
 * * @param indexName 文档存储的地方(数据库)
 * * @param type      文档代表的对象的类（表）
 * refreshInterval 刷新间隔时间
 * replicas 默认备份数
 * shards默认分区数
 * indexStoreType 索引文件存储类型
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @author dujf
 * @Document
 * @date 09/04/2018
 * @since JDK1.8
 */
@Document(indexName = "es_core", type = "login_log", shards = 1, replicas = 0, refreshInterval = "-1")
public class LoginLog implements Serializable {

  @Id
  private Long id;

  /**
   * @type 自动检测属性的类型
   * @index 分不分词
   * <p>
   * FieldType type() default FieldType.Auto;#自动检测属性的类型
   * <p>
   * FieldIndex index() default FieldIndex.analyzed;#默认情况下分词
   * <p>
   * DateFormat format() default DateFormat.none;
   * <p>
   * String pattern() default "";
   * <p>
   * boolean store() default false;#默认情况下不存储原文
   * <p>
   * String searchAnalyzer() default "";#指定字段搜索时使用的分词器
   * <p>
   * String indexAnalyzer() default "";#指定字段建立索引时指定的分词器
   * <p>
   * String[] ignoreFields() default {};#如果某个字段需要被忽略
   * <p>
   * boolean includeInParent() default false;
   */
//  @Field(type = FieldType.Auto)
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




