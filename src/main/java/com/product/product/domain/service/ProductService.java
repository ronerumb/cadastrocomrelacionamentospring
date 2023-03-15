package com.product.product.domain.service;

import com.product.product.domain.exception.NotFoundException;
import com.product.product.domain.model.Department;
import com.product.product.domain.model.Product;
import com.product.product.domain.repository.DepartmentRepository;
import com.product.product.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository jpa;

    @Autowired
    DepartmentService serviceDPTO;

    public Product insert(Product obj){
       Department dpto = serviceDPTO.findById(obj.getDepartment().getId());
       obj.setDepartment(dpto);
        jpa.save(obj);
        return obj;
    }

    public Product findById(Long id){
        Optional<Product> product = jpa.findById(id);
        return product.orElseThrow(() -> new NotFoundException("Product não encontrado"));
    }

    public Product update (Product obj){
        findById(obj.getId());
        jpa.save(obj);
        return  obj;

    }


    public void delete(Long id) {
        findById(id);
        jpa.deleteById(id);
    }

    public List<Product> findAll() {
        return jpa.findAll();
    }
}
