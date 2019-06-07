package com.store.service.impl;

import com.store.model.Producer;
import com.store.service.ProducerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test-application.properties")
public class ProducerServiceImplTest {
    @Autowired
    ProducerService producerService;

    @Before
    public void setUp() throws Exception {
        producerService.deleteAllProducers();
    }

    @Test
    public void addProducer() {
        Producer producer = new Producer();
        producer.setName("Test");
        producerService.addProducer(producer);
        assertEquals("Test", producerService.getProducerById(producerService.getMaxId()).getName());
    }

    @Test
    public void changeProducer() {
        Producer producer = new Producer();
        producer.setName("Test");
        producerService.addProducer(producer);
        producer.setName("Test1");
        producerService.changeProducer(producer);
        assertEquals("Test1", producerService.getProducerById(producerService.getMaxId()).getName());
    }

    @Test
    public void deleteProducerById() {
        Producer producer = new Producer();
        producer.setName("Test");
        producerService.addProducer(producer);
        producerService.deleteProducerById(producerService.getMaxId());
        assertFalse(Objects.nonNull(producerService.getMaxId()));
    }

    @Test
    public void getProducerById() {
        Producer producer = new Producer();
        producer.setName("Test");
        producerService.addProducer(producer);
        assertEquals(producerService.getProducerById(producerService.getMaxId()), producer);
    }

    @Test
    public void getAllProducers() {
        Producer producer = new Producer().setName("Test");
        producerService.addProducer(producer);
        Iterable<Producer> producers = producerService.getAllProducers();
        assertEquals(producer, producers.iterator().next());
    }
}
