package com.weratework.weratework.controller;

import com.weratework.weratework.model.Category;
import com.weratework.weratework.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // return all categories
    @GetMapping
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    // send a new category
    @PostMapping
    public Category createCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }

    // delete a category
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        categoryRepository.deleteById(id);
    }

    // edit a category
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable int id, @RequestBody Category updated) {
        Category cat = categoryRepository.findById(id).orElseThrow();
        cat.setName(updated.getName());
        cat.setDescription(updated.getDescription());
        return categoryRepository.save(cat);
    }




}
