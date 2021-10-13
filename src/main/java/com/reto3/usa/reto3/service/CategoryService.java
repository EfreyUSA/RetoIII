/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.usa.reto3.service;

import com.reto3.usa.reto3.entity.Category;
import com.reto3.usa.reto3.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author efrey
 */
@Service
public class CategoryService {
        @Autowired
        private CategoryRepository repositoryCat;
    
        //Crud - Create - post
        public Category saveCategory(Category category){
                return repositoryCat.save(category);
        }
    
        //cRud - Read - get
        public List<Category> getCategoryAll() {
                return repositoryCat.findAll();
        }
    
        //crUd - Update - put
        public Category updateCategory(Category category) {
                Category existCategory=repositoryCat.findById(category.getId()).orElse(null);
                existCategory.setName(category.getName());
                existCategory.setDescription(category.getDescription());
                return repositoryCat.save(existCategory);
        }

        //cruD - Delete - delete
        public String deleteCategory(Category category){
                repositoryCat.deleteById(category.getId());
                return "Registro de ID: "+category.getId()+" ha sido eliminado";
        }
}
