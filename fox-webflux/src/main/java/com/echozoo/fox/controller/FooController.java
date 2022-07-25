package com.echozoo.fox.controller;

import com.echozoo.fox.model.FooDTO;
import com.echozoo.fox.model.FooVO;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * @author dujf
 * @version 1.0
 * @date 2022/7/25 10:59
 */
@RestController
@RequestMapping("/foo")
public class FooController {

    @GetMapping("/foo/test")
    Mono<String> test(@RequestParam String name) {
        return Mono.create(it -> it.success(name));
    }

    @PostMapping("/v1/create")
    Mono<Boolean> create(@RequestBody FooDTO dto) {
        return Mono.just(Boolean.TRUE);
    }

    @PostMapping("/v1/page")
    Flux<FooVO> page(@RequestBody FooDTO dto) {
        return Flux.fromIterable(List.of(new FooVO()));
    }

    @PostMapping("/v1/detail/{id}")
    Mono<FooVO> detail(@PathVariable String id) {
        return Mono.justOrEmpty(Optional.empty());
    }

    @PutMapping("/v1/update/{id}")
    Mono<Boolean> update(@PathVariable String id, @RequestBody FooDTO dto) {
        return Mono.just(Boolean.TRUE);
    }

    @DeleteMapping("/v1/delete/{id}")
    Mono<Boolean> delete(@PathVariable String id) {
        return Mono.just(Boolean.TRUE);
    }
}
