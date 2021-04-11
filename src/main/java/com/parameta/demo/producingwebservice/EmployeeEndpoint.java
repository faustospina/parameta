package com.parameta.demo.producingwebservice;

import com.parameta.demo.exception.EmployeeBusinessException;
import com.parameta.demo.service.EmployeeService;
import io.spring.guides.gs_producing_web_service.EmployeeRequest;
import io.spring.guides.gs_producing_web_service.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.text.ParseException;


@Endpoint
public class EmployeeEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @Autowired
    private EmployeeService employeeService;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EmployeeRequest")
    @ResponsePayload
    public EmployeeResponse getEmployee(@RequestPayload EmployeeRequest request) throws ParseException, EmployeeBusinessException {
        try {
            return employeeService.saveEmployee(request.getEmployee());
        } catch (EmployeeBusinessException e) {
            throw new EmployeeBusinessException(e.getErrorCode());
        }

    }
}
