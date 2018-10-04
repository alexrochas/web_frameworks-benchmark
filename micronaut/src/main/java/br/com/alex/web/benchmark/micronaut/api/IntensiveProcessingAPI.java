package br.com.alex.web.benchmark.micronaut.api;

import br.com.alex.web.benchmark.micronaut.entity.IntensiveDataEntity;
import br.com.alex.web.benchmark.micronaut.repository.IntensiveDataRepository;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.QueryValue;

import java.util.List;
import java.util.stream.Collectors;

@Controller("/intensive-processing")
public class IntensiveProcessingAPI {

    private IntensiveDataRepository repository;

    public IntensiveProcessingAPI(IntensiveDataRepository repository) {
        this.repository = repository;
    }

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    List<IntensiveDataEntity> getIntensiveProcessing(@QueryValue("description") String description) {
        return repository.findAll()
                .stream()
                .filter(data -> data.getDescription().contains(description))
                .collect(Collectors.toList());
    }
}
