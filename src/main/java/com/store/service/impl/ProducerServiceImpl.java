package com.store.service.impl;

import com.store.model.Producer;
import com.store.repository.ProducerRepository;
import com.store.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProducerServiceImpl implements ProducerService {
    private final ProducerRepository repository;


    @Override
    public void addProducer(Producer producer) {
        repository.save(producer);
    }

    @Override
    public void changeProducer(Producer producer) {
        repository.save(producer);
    }

    @Override
    public void deleteProducerById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Producer> getAllProducers() {
        return repository.findAll();
    }
}
