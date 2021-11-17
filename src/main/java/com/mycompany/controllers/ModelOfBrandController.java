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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
    public class ModelOfBrandController {

    @Autowired
    private ModelOfBrandRepository repoModelOfBrand;

    @Autowired
    private CategoryRepository repoCategory;

    @Autowired
    private BrandRepository repoBrand;

    @GetMapping("/categories/brands/models")
    public String listAllModels(Model model){
        List<ModelOfBrand> listAllModels = repoModelOfBrand.findAll();
        model.addAttribute("listAllModels", listAllModels);
        return "allModels";
    }

    @GetMapping("/categories/brands/models/new")
    public String showNewModelForm(Model model){
        List<Category> listCategories = repoCategory.findAll();
        List<Brand> listBrands = repoBrand.findAll();
        model.addAttribute("listBrands", listBrands);
        model.addAttribute("listCategories", listCategories);
        model.addAttribute("modelOfBrand", new ModelOfBrand());
        return "modelOfBrand_form";
}

    @PostMapping("/categories/brands/models/save")
    public String saveModelOfBrand(ModelOfBrand modelOfBrand, HttpServletRequest request){
        String [] attributeNames = request.getParameterValues("attributeName");
        String [] attributeValues = request.getParameterValues("attributeValue");
        for(int i = 0; i<attributeNames.length; i++){
            modelOfBrand.addAttribute(attributeNames[i], attributeValues[i]);
        }
        repoModelOfBrand.save(modelOfBrand);
        return "redirect:/categories/brands/models";
    }


    //по ID
        @GetMapping("/categories/brands/models/{id}")
        public String modelById(@PathVariable("id") int id, Model model){

            Brand brand = repoBrand.getById(id);
            List<ModelOfBrand> listBrand = brand.getModelOfBrands();

            model.addAttribute("listBrand", listBrand);

            model.addAttribute("brand", brand);
            return "modelById";
        }

}
