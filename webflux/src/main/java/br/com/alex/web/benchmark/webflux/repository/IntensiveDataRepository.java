package br.com.alex.web.benchmark.webflux.repository;

import br.com.alex.web.benchmark.webflux.entity.IntensiveDataEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface IntensiveDataRepository extends CrudRepository<IntensiveDataEntity, Long> {
}
