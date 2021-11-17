package com.mycompany.models;

import javax.persistence.*;

@Entity
public class Attributes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn(name="modelOfBrand_id")
    private ModelOfBrand modelOfBrand;

    public Attributes() {
    }

    public Attributes(String name, String value, ModelOfBrand modelOfBrand) {
        this.name = name;
        this.value = value;
        this.modelOfBrand = modelOfBrand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ModelOfBrand getModelOfBrand() {
        return modelOfBrand;
    }

    public void setModelOfBrand(ModelOfBrand modelOfBrand) {
        this.modelOfBrand = modelOfBrand;
    }

    @Override
    public String toString() {
        return name + ": " + value;
    }
}
