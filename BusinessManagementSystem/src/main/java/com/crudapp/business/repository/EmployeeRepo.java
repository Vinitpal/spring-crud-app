package com.crudapp.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudapp.business.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
