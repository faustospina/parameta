package com.parameta.demo.repository;

import com.parameta.demo.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, UUID> {

}
