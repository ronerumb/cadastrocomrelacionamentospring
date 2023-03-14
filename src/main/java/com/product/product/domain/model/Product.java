package com.product.product.domain.model;

import com.product.product.domain.service.DepartmentService;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    private Department department;

    public Product(){}

    public Product(Long id, String name, String description, Department department) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.department = department;
    }
    

}
