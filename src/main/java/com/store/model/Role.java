package com.store.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "roles")
public class Role extends MappedEntity{

    @Column
    private String role;
}
