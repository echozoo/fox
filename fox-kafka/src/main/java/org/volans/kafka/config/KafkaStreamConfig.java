package org.volans.kafka.config;

import java.util.Properties;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="http://github.com/athc">j</a>
 * @date 2019-10-31
 * @since JDK1.8
 */
@Configuration
public class KafkaStreamConfig {

    @Bean
    @ConditionalOnMissingBean
    public AdminClient adminClient() {
        Properties props = new Properties();
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "10.0.0.32:9092");
        return AdminClient.create(props);
    }
}
