package com.store.service;

import com.store.model.Producer;

public interface ProducerService {

    void addProducer(Producer producer);

    void changeProducer(Producer producer);

    void deleteProducerById(Integer id);

    Producer getProducerById(Integer id);

    Iterable<Producer> getAllProducers();

    void deleteAllProducers();

    Integer getMaxId();
}
