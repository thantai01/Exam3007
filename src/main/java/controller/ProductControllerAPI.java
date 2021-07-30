package controller;

import model.Category;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.category.ICategoryService;
import service.product.IProductService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductControllerAPI {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/products")
    public ResponseEntity<Iterable<Product>> findAll () {
        Iterable<Product> productList = productService.findAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
    @PostMapping("/products")
    public ResponseEntity<Void> create(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Void> findOne(@PathVariable long id) {
        Optional<Product> selected = productService.findOneById(id);
        if (selected.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<Void> edit(@PathVariable long id, @RequestBody Product product) {
        Optional<Product> selected = productService.findOneById(id);
        if(selected.isPresent()) {
            product.setId(id);
            productService.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> delete(@PathVariable long id) {
        Optional<Product> selected = productService.findOneById(id);
        if(selected.isPresent()) {
            productService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/products/find/{name}")
    public ResponseEntity<Iterable<Product>>findAllByName(@PathVariable String name) {
        Iterable<Product> foundList = productService.findALlByPName(name);
        return new ResponseEntity<>(foundList,HttpStatus.OK);
    }
    @GetMapping("/products/findByCategory/{cName}")
    public ResponseEntity<Iterable<Product>> findAllByCate(@PathVariable String cName) {
        for (Category category: categoryService.findAll()) {
            if(category.getCName().equals(cName)) {
                Iterable<Product> foundList = productService.findAllByCategoryId(category.getId());
                return new ResponseEntity<>(foundList,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
