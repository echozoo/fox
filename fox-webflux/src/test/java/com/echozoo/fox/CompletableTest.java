package com.echozoo.fox;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * TODO
 *
 * @author dujf
 * @version 1.0
 * @date 2022/12/14 17:02
 */

public class CompletableTest {


    @Test
    public void testDeadLock() {
        CompletableFuture<Map<String, String>> future = CompletableFuture.supplyAsync(() -> {
            return getPriceByCoinMarket();
        });

        CompletableFuture<Map<String, String>> futureB = CompletableFuture.supplyAsync(() -> {
            return getPriceByCoinMarket();
        });

        System.out.println("主线程执行开始");
        final CompletableFuture<Object> anyOf = CompletableFuture.anyOf(future, futureB);
        anyOf.join();
        System.out.println("主线程执行结束");
    }

    private final String COIN_MARKET_API = "https://v1.hitokoto.cn/";

    private Map<String, String> getPriceByCoinMarket() {
        final HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(COIN_MARKET_API)).build();
        final HttpResponse<String> send;
        try {
            send = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }

        System.out.println(Thread.currentThread().getName() + "" + send.body());
        return Collections.emptyMap();
    }
}
