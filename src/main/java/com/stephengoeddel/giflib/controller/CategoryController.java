package com.stephengoeddel.giflib.controller;

import com.stephengoeddel.giflib.data.CategoryRepository;
import com.stephengoeddel.giflib.data.GifRepository;
import com.stephengoeddel.giflib.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    @Autowired private CategoryRepository categoryRepository;
    @Autowired private GifRepository gifRepository;

    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap) {
        modelMap.put("categories", categoryRepository.getAllCategories());
        return "categories";
    }
    
    @RequestMapping("/category/{id}")
    public String categoryDetail(@PathVariable int id,
                                 ModelMap modelMap) {
        modelMap.put("category", categoryRepository.findById(id));
        modelMap.put("gifs", gifRepository.findByCategoryId(id));
        return "category";
    }
}
