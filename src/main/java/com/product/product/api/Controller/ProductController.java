package com.product.product.api.Controller;

import com.product.product.domain.model.Department;
import com.product.product.domain.model.Product;
import com.product.product.domain.service.DepartmentService;
import com.product.product.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductService service;

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product obj){
        return ResponseEntity.ok().body(service.insert(obj));
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product obj){
        return ResponseEntity.ok().body(service.update(obj));
    }

    @DeleteMapping(value = "{id}")
    public void delete (@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Product> findById (@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll (){
        return ResponseEntity.ok(service.findAll());
    }

}
