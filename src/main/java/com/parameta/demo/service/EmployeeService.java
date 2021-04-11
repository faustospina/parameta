package com.parameta.demo.service;

import com.parameta.demo.exception.EmployeeBusinessException;
import io.spring.guides.gs_producing_web_service.Employee;
import io.spring.guides.gs_producing_web_service.EmployeeResponse;

import java.text.ParseException;

public interface EmployeeService {

    EmployeeResponse saveEmployee(Employee employee) throws ParseException, EmployeeBusinessException;

}
