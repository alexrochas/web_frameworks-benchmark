package br.com.alex.web.benchmark.tomcat.api;

import br.com.alex.web.benchmark.tomcat.repository.IntensiveDataRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/intensive-processing")
public class IntensiveProcessingAPI {

    private IntensiveDataRepository intensiveDataRepository;

    public IntensiveProcessingAPI(IntensiveDataRepository intensiveDataRepository) {
        this.intensiveDataRepository = intensiveDataRepository;
    }

    @GetMapping
    private ResponseEntity getIntensiveProcessing(@RequestParam(required = false) String description) {
        return ok(intensiveDataRepository.findAll()
                .stream()
                .filter(data -> data.getDescription().contains(description))
                .collect(Collectors.toList()));
    }

}
