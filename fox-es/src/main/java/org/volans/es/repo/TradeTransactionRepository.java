package org.volans.es.repo;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.volans.es.po.TradeTransaction;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019-05-18
 * @since JDK1.8
 */
public interface TradeTransactionRepository extends ElasticsearchRepository<TradeTransaction, String> {
}
