package br.com.alex.web.benchmark.webflux.api;

import br.com.alex.web.benchmark.webflux.entity.IntensiveDataEntity;
import br.com.alex.web.benchmark.webflux.service.IntensiveDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/intensive-processing")
public class IntensiveProcessingAPI {

    private IntensiveDataService intensiveDataService;

    public IntensiveProcessingAPI(IntensiveDataService intensiveDataService) {
        this.intensiveDataService = intensiveDataService;
    }

    @GetMapping
    private Flux<IntensiveDataEntity> getIntensiveProcessing(@RequestParam(required = false) String description) {
        return intensiveDataService.findAll()
                .filter(data -> data.getDescription().contains(description));
    }

}
