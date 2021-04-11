package com.parameta.demo.utilities;

import com.parameta.demo.common.NotificationCode;
import com.parameta.demo.exception.EmployeeBusinessException;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Utilities {

    public final static Date validateDate(XMLGregorianCalendar dateIn) throws ParseException, EmployeeBusinessException {
        if (dateIn==null){
            throw new EmployeeBusinessException(NotificationCode.NULL_DATE);
        }
        String temp = dateIn.toString();
        Date valid = new SimpleDateFormat("yyyy-MM-dd").parse(temp);

        return valid;
    }

    public final static String tiempo(Date date) {
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate(), ahora);
        return periodo.getYears() + " años, " + periodo.getMonths() + " meses y " + periodo.getDays() + " días";
    }

    public final static  Boolean validateAge(Date date) throws EmployeeBusinessException {
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate(), ahora);
        if (periodo.getYears()>17)
            return true;
        throw new EmployeeBusinessException(NotificationCode.MENOR_AGE);
    }
}
