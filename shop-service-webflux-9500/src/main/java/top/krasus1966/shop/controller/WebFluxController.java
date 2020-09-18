package top.krasus1966.shop.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * WebFluxController，暂无用途
 * @author Krasus1966
 * @date 2020/8/3 22:04
 **/
@RestController
public class WebFluxController {

    @PostMapping("/webflux")
    public Mono<String> webFluxTest() throws Exception {
        return null;
    }
}
