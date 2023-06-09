package com.product.product.domain.service;

import com.product.product.domain.exception.DeleteException;
import com.product.product.domain.exception.NotFoundException;
import com.product.product.domain.model.Department;
import com.product.product.domain.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository jpa;

    public Department insert(Department obj){
        jpa.save(obj);
        return obj;
    }

    public Department findById(Long id){
        Optional<Department> dpto = jpa.findById(id);
        return dpto.orElseThrow(() -> new NotFoundException("Department não encontrado"));
    }

    public Department update (Department obj){
        findById(obj.getId());
        jpa.save(obj);
        return  obj;

    }


    public void delete(Long id) {
        findById(id);

        try {
            jpa.deleteById(id);
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }

    }

    public List<Department> findAll() {
        return jpa.findAll();
    }
}
