package com.mycompany.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30, nullable = false, name = "name", unique = true)
    private String name;

    @Column(length = 30, nullable = false, name = "country")
    private String country;

    @Column(length = 30, nullable = false, name = "company")
    private String company;

    @Column(nullable = false, name = "online")
    private String online;

    @Column(nullable = false, name = "installPayment")
    private String installPayment;

    @Column(nullable = false, name = "modelsInStock")
    private String modelsInStock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany
    @JoinColumn(name = "brand_id")
    private List<ModelOfBrand> modelOfBrands = new ArrayList<>();

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getInstallPayment() {
        return installPayment;
    }

    public void setInstallPayment(String installPayment) {
        this.installPayment = installPayment;
    }

    public List<ModelOfBrand> getModelOfBrands() {
        return modelOfBrands;
    }

    public void setModelOfBrands(List<ModelOfBrand> modelOfBrands) {
        this.modelOfBrands = modelOfBrands;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getModelsInStock() {
        return modelsInStock;
    }

    public void setModelsInStock(String modelsInStock) {
        this.modelsInStock = modelsInStock;
    }

}
