package com.store.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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

    @Column
    private Long producer_id;
}
