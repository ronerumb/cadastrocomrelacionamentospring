package com.product.product.api.Controller;

import com.product.product.domain.model.Department;
import com.product.product.domain.service.DepartmentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "department")
public class DepartmentController {
    @Autowired
    DepartmentService service;

    @PostMapping
    public ResponseEntity<Department> insert(@RequestBody Department obj){
        return ResponseEntity.ok().body(service.insert(obj));
    }

    @PutMapping
    public ResponseEntity<Department> update(@RequestBody Department obj){
        return ResponseEntity.ok().body(service.update(obj));
    }

    @DeleteMapping(value = "{id}")
    public void delete (@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Department> findById (@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAll (){
        return ResponseEntity.ok(service.findAll());
    }

}
