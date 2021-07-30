package controller;

import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.category.ICategoryService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryControllerAPI {
    @Autowired
    ICategoryService categoryService;

    @GetMapping("/categories")
    @ModelAttribute("category")
    public ResponseEntity<Iterable<Category>> findAll() {
        Iterable<Category> categoryList = categoryService.findAll();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
    @PostMapping("/categories")
    public ResponseEntity<Void> create(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> delete(@PathVariable  long id) {
        Optional<Category> selected = categoryService.findOneById(id);
        if(selected.isPresent()) {
            categoryService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    };
}
