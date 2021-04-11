package com.parameta.demo.mapper;

import com.parameta.demo.entity.EmployeeEntity;
import io.spring.guides.gs_producing_web_service.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {

    Employee generateEntityToEmployee(EmployeeEntity employeeEntity);

}
