package org.volans.es.po;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 09/04/2018
 * @since JDK1.8
 */
@Data
@Document(indexName = "trade_transactions", shards = 1, replicas = 0, refreshInterval = "-1")
public class TradeTransaction implements Serializable {
  private Long id;
  private String tradeId;
  private String orderId;
  private String memberUsr;
  private String pairCode;
  private String tradeCoinKey;
  private String priceCoinKey;
  private Long memberId;
  private Long createdAt;
  private BigDecimal fee;
  private BigDecimal price;
  private BigDecimal quantity;
  private short orderType;

}




