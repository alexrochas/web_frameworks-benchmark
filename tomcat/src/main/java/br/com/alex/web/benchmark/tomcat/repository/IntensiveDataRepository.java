package br.com.alex.web.benchmark.tomcat.repository;

import br.com.alex.web.benchmark.tomcat.entity.IntensiveDataEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IntensiveDataRepository extends CrudRepository<IntensiveDataEntity, Long> {

	@Override
	List<IntensiveDataEntity> findAll();
}
