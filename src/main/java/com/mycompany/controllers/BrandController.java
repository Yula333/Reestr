package com.mycompany.controllers;

import com.mycompany.models.Brand;
import com.mycompany.models.Category;
import com.mycompany.models.ModelOfBrand;
import com.mycompany.repo.BrandRepository;
import com.mycompany.repo.CategoryRepository;
import com.mycompany.repo.ModelOfBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BrandController {

    @Autowired
    private BrandRepository repoBrand;

    @Autowired
    private CategoryRepository repoCategory;

    @Autowired
    private ModelOfBrandRepository repoModel;

    @GetMapping("/categories/brands")
    public String listAllBrands(Model model){
        List<Brand> listAllBrands = repoBrand.findAll();
        List<Category> categoryList = repoCategory.findAll();
        List<ModelOfBrand> modelOfBrands = repoModel.findAll();
        model.addAttribute("listAllBrands", listAllBrands);
        model.addAttribute("modelOfBrands", modelOfBrands);
        model.addAttribute("categoryList", categoryList);
        return "brands";
    }

    @GetMapping("/categories/brands/new")
    public String showNewBrandForm(Model model) {
        List<Category> listCategories = repoCategory.findAll();
        model.addAttribute("listCategories", listCategories);
        model.addAttribute("brand", new Brand());
        return "brand_form";
    }

    @PostMapping("/categories/brands/save")
    public String saveBrand(Brand brand){
        repoBrand.save(brand);
        return "redirect:/categories/brands";
    }

}
