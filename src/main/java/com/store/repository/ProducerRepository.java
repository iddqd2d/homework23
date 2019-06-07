package com.store.repository;

import com.store.model.Producer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends CrudRepository<Producer, Integer> {
    @Query(value = "SELECT MAX(id) FROM producers", nativeQuery = true)
    Integer getMaxId();
}
