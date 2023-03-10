package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SalariedEmployeeTest {
    // object under test - called a "fixture" in JUnit
    private SalariedEmployee emp;
    private SalariedEmployee emp2;

    @Before
    public void setUp() {
       emp = new SalariedEmployee("Mary", Date.valueOf("2005-11-12"), 1250.0);
       emp2 = new SalariedEmployee("Mary", Date.valueOf("2005-11-12"), 1250.0);
    }

    @Test
    public void hashCode_equalObjects_mustHaveEqualHashCodes() {
        assertEquals(emp.hashCode(), emp2.hashCode());
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_differentSalary() {
        emp2.setSalary(1300.0);

        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate_sameSalary() {
        emp2.setHireDate(Date.valueOf("2011-09-09"));
        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate_sameSalary() {
        emp2.setName("LeBron");
        assertNotEquals(emp, emp2);
    }

    @Test
    public void testPay() {
        assertEquals(1250.0, emp.pay(), .001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(375.0, emp.payTaxes(), .001);
    }
}