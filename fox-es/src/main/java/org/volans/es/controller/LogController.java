package org.volans.es.controller;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.volans.es.domain.LoginLogDomain;
import org.volans.es.po.LoginLog;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019-09-16
 * @since JDK1.8
 */

@RequestMapping("/log")
@RestController
public class LogController {

  @Autowired
  private LoginLogDomain loginLogDomain;

  @GetMapping
  public Page<LoginLog> page() {
    return loginLogDomain.page(PageRequest.of(1, 10));
  }

  @GetMapping("search")
  public Page<LoginLog> page(String searchContent, int pageSize, int pageNo) {
    NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
    BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
    //
//    builder.withFilter(QueryBuilders.termQuery("id", searchContent));

    //模糊查询
    queryBuilder.must(
        QueryBuilders.fuzzyQuery("usr", searchContent)
    );

    //匹配查询
    queryBuilder.must(
        QueryBuilders.wildcardQuery("usr", "*" + searchContent + "*")
    );

    //文本匹配多个字段
    queryBuilder.must(
        QueryBuilders.multiMatchQuery(searchContent, "usr", "value")
    );

    //字段匹配多个文本
    queryBuilder.must(
        QueryBuilders.termsQuery("usr", "value", searchContent)
    );

//前缀匹配查询
    queryBuilder.must(
        QueryBuilders.prefixQuery("usr", searchContent)
    );

//正则匹配查询
    queryBuilder.must(
        QueryBuilders.regexpQuery("usr", "[0-9].+")
    );

//    queryBuilder.must(QueryBuilders.termsQuery("usr", searchContent, "login_Log0.10281059874316689", "login_Log0.21595178720773678"));
    //term & terms
//    builder.withQuery(QueryBuilders.multiMatchQuery("login_Log0.10281059874316689", "usr", "value", "remark"));
//    builder.withQuery(queryBuilder);
    //分页
    builder.withPageable(PageRequest.of(pageNo, pageSize));
    builder.withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC));
    logger.info("\n" + queryBuilder.toString());
//    logger.info("\n" + builder.build().getFilter().toString());
    return loginLogDomain.search(builder.build());
  }

  private Logger logger = LoggerFactory.getLogger(LogController.class);
}
