package com.stephengoeddel.giflib.data;

import com.stephengoeddel.giflib.model.Category;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "fun"),
            new Category(2, "sun"),
            new Category(3, "run")
    );
    
    public Category findById(int id) {
        return ALL_CATEGORIES.stream()
                .filter(category -> category.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Category> getAllCategories() {
        return ALL_CATEGORIES;
    }
}
