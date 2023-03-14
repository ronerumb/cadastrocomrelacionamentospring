package com.product.product.domain.repository;

import com.product.product.domain.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {


}
