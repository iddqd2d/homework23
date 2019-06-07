package com.store.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "products")
public class Product extends MappedEntity {

    @Column
    private String name;

    @Column
    private BigDecimal cost;

    @ManyToOne
    @JoinColumn
    private Producer producer;
}
