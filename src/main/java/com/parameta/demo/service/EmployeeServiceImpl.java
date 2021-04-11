package com.parameta.demo.service;

import com.parameta.demo.common.NotificationCode;
import com.parameta.demo.entity.EmployeeEntity;
import com.parameta.demo.exception.EmployeeBusinessException;
import com.parameta.demo.repository.EmployeeRepository;
import io.spring.guides.gs_producing_web_service.Employee;
import io.spring.guides.gs_producing_web_service.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;


@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeResponse saveEmployee(Employee employee) throws ParseException, EmployeeBusinessException {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(UUID.randomUUID());
        employeeEntity.setNombres(employee.getNombres());
        employeeEntity.setApellidos(employee.getApellidos());
        employeeEntity.setTipoDocumento(employee.getTipoDocumento().value());
        employeeEntity.setNumeroDocumento(employee.getNumeroDocumento());
        try {
            employeeEntity.setFechaNacimiento(validateDate(employee.getFechaNacimiento()));
            employeeEntity.setFechaVinculacion(validateDate(employee.getFechaVinculacion()));
        } catch (EmployeeBusinessException e) {
            throw new EmployeeBusinessException(e.getErrorCode());
        }

        employeeEntity.setNumeroDocumento(employee.getNumeroDocumento());
        employeeEntity.setCargo(employee.getCargo().value());
        employeeEntity.setSalario(employee.getSalario());

        Optional.ofNullable(employeeRepository.save(employeeEntity)).orElseThrow(() -> new EmployeeBusinessException(NotificationCode.NULL_DATE));

        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setEmployee(employee);
        employeeResponse.setEdadActual(tiempo(employeeEntity.getFechaNacimiento()));
        employeeResponse.setTiempoVinculacion(tiempo(employeeEntity.getFechaVinculacion()));

        return employeeResponse;

    }

    private Date validateDate(XMLGregorianCalendar dateIn) throws ParseException, EmployeeBusinessException {
        String temp = Optional
                .ofNullable(dateIn.toString())
                .orElseThrow(() -> new EmployeeBusinessException(NotificationCode.NULL_DATE));
        Date valid = new SimpleDateFormat("yyyy-MM-dd").parse(temp);

        return valid;
    }

    private String tiempo(Date date) {
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate(), ahora);
        return periodo.getYears() + " años, " + periodo.getMonths() + " meses y " + periodo.getDays() + " días";

    }



}
