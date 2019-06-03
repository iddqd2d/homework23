package com.store.service;

import com.store.model.Producer;

import java.util.List;

public interface ProducerService {

    void addProducer(Producer producer);

    void changeProducer(Producer producer);

    void deleteProducerById(Integer id);

    List<Producer> getAllProducers();
}
