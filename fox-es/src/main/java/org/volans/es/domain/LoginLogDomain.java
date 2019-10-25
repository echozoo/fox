package org.volans.es.domain;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.volans.es.po.LoginLog;
import org.volans.es.repo.LoginLogRepository;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019-08-31
 * @since JDK1.8
 */
@Service
public class LoginLogDomain {

  @Autowired
  private LoginLogRepository logRepository;

  public LoginLog create(LoginLog log) {
    return logRepository.save(log);
  }

  public Iterable<LoginLog> all() {
    return logRepository.findAll();
  }

  public Page<LoginLog> page(Pageable pageable) {
    return logRepository.findAll(pageable);
  }

  public Page<LoginLog> search(QueryBuilder builder, Pageable pageable) {
    return logRepository.search(builder, pageable);
  }

  public Page<LoginLog> search(SearchQuery query) {
    return logRepository.search(query);
  }
}
