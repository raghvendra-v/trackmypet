package com.trackmypet.demo.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pets")
public class Pet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pet_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id",  nullable = false)
    private Owner owner;

    @Column(unique = true)
    private String collarId;


    private String friendlyName;

}
