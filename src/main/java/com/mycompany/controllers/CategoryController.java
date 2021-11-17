package com.mycompany.controllers;

import com.mycompany.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/categories")
@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository repo;

    @GetMapping("")
    public String categories(){
        return "categories";
    }
}
