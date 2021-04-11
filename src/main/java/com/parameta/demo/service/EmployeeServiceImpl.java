package com.parameta.demo.service;

import com.parameta.demo.entity.EmployeeEntity;
import com.parameta.demo.exception.EmployeeBusinessException;
import com.parameta.demo.repository.EmployeeRepository;
import com.parameta.demo.utilities.Utilities;
import io.spring.guides.gs_producing_web_service.Employee;
import io.spring.guides.gs_producing_web_service.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;


    @Override
    public EmployeeResponse saveEmployee(Employee employee) throws ParseException, EmployeeBusinessException {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(UUID.randomUUID());
        employeeEntity.setNombres(employee.getNombres());
        employeeEntity.setApellidos(employee.getApellidos());
        employeeEntity.setTipoDocumento(employee.getTipoDocumento().value());
        employeeEntity.setNumeroDocumento(employee.getNumeroDocumento());
        employeeEntity.setNumeroDocumento(employee.getNumeroDocumento());
        employeeEntity.setCargo(employee.getCargo().value());
        employeeEntity.setSalario(employee.getSalario());
        try {
            employeeEntity.setFechaNacimiento(Utilities.validateDate(employee.getFechaNacimiento()));
            employeeEntity.setFechaVinculacion(Utilities.validateDate(employee.getFechaVinculacion()));
        } catch (EmployeeBusinessException e) {
            throw new EmployeeBusinessException(e.getErrorCode());
        }

        Utilities.validateAge(employeeEntity.getFechaNacimiento());
        employeeRepository.save(employeeEntity);
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setEmployee(employee);
        employeeResponse.setEdadActual(Utilities.tiempo(employeeEntity.getFechaNacimiento()));
        employeeResponse.setTiempoVinculacion(Utilities.tiempo(employeeEntity.getFechaVinculacion()));
        return employeeResponse;


    }


}
