package org.volans.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.volans.kafka.service.KafkaStreamService;

/**
 * @author dujf
 * @version 1.0
 * @date 2022/12/23 13:46
 */
@RestController
@RequestMapping("/kafka/stream/test")
public class KafkaStreamController {

    @Autowired
    private KafkaStreamService streamService;

    @GetMapping
    public void test() {
        streamService.produce();
    }

}
