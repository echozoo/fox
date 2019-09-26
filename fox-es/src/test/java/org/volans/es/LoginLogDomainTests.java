package org.volans.es;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.volans.es.domain.LoginLogDomain;
import org.volans.es.po.LoginLog;

public class LoginLogDomainTests extends BaseTest {

  @Autowired
  private LoginLogDomain domain;

  @Test
  public void create() {
      LoginLog loginLog = domain.create(
          new LoginLog(System.currentTimeMillis(), "login_Log" + Math.random(), System.currentTimeMillis() + "要使用指定相应的分词器" + System.currentTimeMillis(), System.currentTimeMillis() + "本文原创发布于慕课网" + System.currentTimeMillis(), System.currentTimeMillis())
      );
      Assertions.assertNotNull(loginLog);
  }

  /**
   * must
   * 所有的语句都 必须（must） 匹配，与 AND 等价。
   * must_not
   * 所有的语句都 不能（must not） 匹配，与 NOT 等价。
   * should
   * 至少有一个语句要匹配，与 OR 等价。
   * trem
   * 精确查找 与= 号等价。
   * trems
   * terms是包含操作
   * match
   * 模糊匹配 与like 等价。
   * range
   * 范围查找 相当于between
   * <p>
   * exists
   * 不为空查找 相当于is not null
   * missing
   * missing 过滤器本质上是 exists 的反义词
   */
  @Test
  public void page() {
    BoolQueryBuilder builder = QueryBuilders.boolQuery();
    builder.filter(
        QueryBuilders.termsQuery("value", "441")
    );
    //{
    //  "bool" : {
    //    "filter" : [
    //      {
    //        "terms" : {
    //          "value" : [
    //            "441"
    //          ],
    //          "boost" : 1.0
    //        }
    //      }
    //    ],
    //    "adjust_pure_negative" : true,
    //    "boost" : 1.0
    //  }
    //}
    Page page = domain.search(builder, PageRequest.of(0, 10));

    System.out.println(page);
  }

  @Test
  public void pag2() {
    NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
    //分页
    builder.withPageable(PageRequest.of(0, 10));
    builder.withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC));
    Page page = domain.search(builder.build());

    System.out.println(page);
  }


}
