//package com.echozoo.foxshardingjdbc;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReadWriteLock;
//import java.util.concurrent.locks.ReentrantReadWriteLock;
//import javax.sql.DataSource;
//import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
//import org.apache.shardingsphere.infra.config.mode.ModeConfiguration;
//import org.apache.shardingsphere.infra.config.rule.RuleConfiguration;
//import org.apache.shardingsphere.sharding.api.config.ShardingRuleConfiguration;
//import org.apache.shardingsphere.sharding.api.config.rule.ShardingTableRuleConfiguration;
//import org.apache.shardingsphere.sharding.api.config.strategy.sharding.ShardingStrategyConfiguration;
//import org.apache.shardingsphere.sharding.api.config.strategy.sharding.StandardShardingStrategyConfiguration;
//import org.apache.shardingsphere.spring.boot.rule.LocalRulesCondition;
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Conditional;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import java.util.*;
//
//@Configuration
//@ConfigurationProperties(prefix = "spring.shardingsphere.datasource")
//public class ShardingConfig {
//
//    private Map<String, DataSource> datasource;
//    private Map<String, Object> sharding;
//    private Map<String, String> props;
//
//
//    @Bean
//    public DataSource shardingSphereDataSource() throws SQLException {
//        // 从 YAML 里读取 datasource
//        Map<String, DataSource> dataSourceMap = this.datasource;
//
//        // 构建分表规则
//        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
//
//        Map<String, Map<String, Object>> tables = (Map<String, Map<String, Object>>) sharding.get(
//                "tables");
//        for (Map.Entry<String, Map<String, Object>> entry : tables.entrySet()) {
//            String logicTable = entry.getKey();
//            Map<String, Object> tableConfig = entry.getValue();
//
//            ShardingTableRuleConfiguration tableRule = new ShardingTableRuleConfiguration(
//                    logicTable, (String) tableConfig.get("actual-data-nodes"));
//            // 分表策略
//            Map<String, Map<String, String>> tableStrategyMap = (Map<String, Map<String, String>>) tableConfig.get(
//                    "table-strategy");
//            Map<String, String> inline = tableStrategyMap.get("standard");
//            String shardingColumn = inline.get("sharding-column");
//            String algorithmExpression ="t_order_$->{order_id % 3}";//inline.get("algorithm-expression");
//
//            tableRule.setTableShardingStrategy(
//                    new StandardShardingStrategyConfiguration(shardingColumn, algorithmExpression));
//
//            shardingRuleConfig.getTables().add(tableRule);
//        }
//
//
//        ReadWriteLock lock = new ReentrantReadWriteLock();
//        Lock lock1 = lock.readLock();
//        lock1.lock();
//        // 创建 ShardingSphereDataSource
//        Collection<RuleConfiguration> ruleConfigs = new ArrayList<>();
//        ruleConfigs.add(shardingRuleConfig);
//
//        // 提示
//        // spring.shardingsphere.props.xxx
//
//        // spring.shardingsphere.props.sql-show: true
//
//        Properties properties = new Properties();
//        if (props != null) {
//            properties.putAll(props);
//        }
//
//        return ShardingSphereDataSourceFactory.createDataSource(dataSourceMap, ruleConfigs,
//                properties);
//    }
//
//    // getter & setter
//    public Map<String, DataSource> getDatasource() {
//        return datasource;
//    }
//
//    public void setDatasource(Map<String, DataSource> datasource) {
//        this.datasource = datasource;
//    }
//
//    public Map<String, Object> getSharding() {
//        return sharding;
//    }
//
//    public void setSharding(Map<String, Object> sharding) {
//        this.sharding = sharding;
//    }
//
//    public Map<String, String> getProps() {
//        return props;
//    }
//
//    public void setProps(Map<String, String> props) {
//        this.props = props;
//    }
//}
