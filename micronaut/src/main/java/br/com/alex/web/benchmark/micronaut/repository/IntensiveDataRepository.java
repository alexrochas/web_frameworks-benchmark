package br.com.alex.web.benchmark.micronaut.repository;

import br.com.alex.web.benchmark.micronaut.entity.IntensiveDataEntity;
import io.micronaut.spring.tx.annotation.Transactional;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Singleton
public class IntensiveDataRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(readOnly = true)
	public List<IntensiveDataEntity> findAll() {
		String qlString = "SELECT data FROM intensive_data as data";
		TypedQuery<IntensiveDataEntity> query = entityManager.createQuery(qlString, IntensiveDataEntity.class);

		return query.getResultList();
	}
}
