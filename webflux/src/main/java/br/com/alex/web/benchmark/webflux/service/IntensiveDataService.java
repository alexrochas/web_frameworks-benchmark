package br.com.alex.web.benchmark.webflux.service;

import br.com.alex.web.benchmark.webflux.entity.IntensiveDataEntity;
import br.com.alex.web.benchmark.webflux.repository.IntensiveDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

import java.util.concurrent.Callable;

@Service
public class IntensiveDataService {
    private final IntensiveDataRepository repository;
    private final Scheduler scheduler;

    @Autowired
    public IntensiveDataService(IntensiveDataRepository repository, @Qualifier("jdbcScheduler") Scheduler scheduler) {
        this.repository = repository;
        this.scheduler = scheduler;
    }
    public Flux<IntensiveDataEntity> findAll() {
        return async(repository::findAll)
                .flatMapIterable(it -> it);
    }
    private <T> Mono<T> async(Callable<T> callable) {
        return Mono.fromCallable(callable)
                .publishOn(scheduler);
    }
}
