package com.echozoo.foxrabiitmq.controller.consumer;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author: ddd
 * @Date: 2023/11/13
 */
@Slf4j
@Component
public class TestConsumer {

    @RabbitListener(queues = "test-queue", ackMode = "MANUAL")
    public void consumer(String message) {
        log.info("消费者消费消息：{}", message);
        // 生成一个排序算法

    }

    /***
     * @Description: TODO
     * @Param: 生成一个排序算法
     * @return:
     * @Author: ddd
     * @Date: 2025/5/7
     */
    public void sort() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        log.info("排序后的数组：{}", arr);
    }

    /**
     * 生成一个二叉树对象
     */
    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 帮我写一个sql 查询product 里面的数量有多少 根据sku 分组
     */
    public void sql() {
        String sql = "SELECT sku, COUNT(*) as count FROM product GROUP BY sku";
        log.info("sql:{}", sql);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            TestConsumer.testFor();
        }
    }


    public static void testFor() {
        for (int i = 0; i < 10; i++) {
            switch (i) {
                case 1-> {
                    if (i % 2 == 0){
                        return;
                    }
                }
                case 2 -> {
                    if (i % 2 == 0){
                        return;
                    }
                    if (i == 2) {
                        return;
                    }
                }
            }

log.info("xhz");
        }


    }
}
