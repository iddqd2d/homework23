package com.store.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import javax.persistence.*;
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
