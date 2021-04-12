package com.parameta.demo.controller;

import com.parameta.demo.exception.EmployeeBusinessException;
import com.parameta.demo.service.EmployeeService;
import io.spring.guides.gs_producing_web_service.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    /**
     * @param employee
     * @return
     */
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
        try {
            return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.OK);
        } catch (EmployeeBusinessException | ParseException g) {
            return new ResponseEntity<>(g.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
