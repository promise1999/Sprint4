package com.keyin.demo.accessdatarest;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class PersonTest {

    @Test
    void getId() {
    }

    @Test
    void testPerson() {
        Person actualPerson = new Person();
        actualPerson.setEmailAddress("42 Main St");
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualPerson.setEndDate(ofEpochDayResult);
        actualPerson.setFirstName("Jane");
        actualPerson.setId(123L);
        actualPerson.setLastName("Doe");
        actualPerson.setPhoneNumber(10);
        LocalDate ofEpochDayResult1 = LocalDate.ofEpochDay(1L);
        actualPerson.setStartDate(ofEpochDayResult1);
        assertEquals("42 Main St", actualPerson.getEmailAddress());
        assertSame(ofEpochDayResult, actualPerson.getEndDate());
        assertEquals("Jane", actualPerson.getFirstName());
        assertEquals(123L, actualPerson.getId());
        assertEquals("Doe", actualPerson.getLastName());
        assertEquals(10, actualPerson.getPhoneNumber());
        assertSame(ofEpochDayResult1, actualPerson.getStartDate());
    }

    @Test
    void testPerson2() {
        Person actualPerson = new Person("Jane", "Doe", "42 Main St", 10, LocalDate.ofEpochDay(1L),
                LocalDate.ofEpochDay(1L));
        actualPerson.setEmailAddress("42 Main St");
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualPerson.setEndDate(ofEpochDayResult);
        actualPerson.setFirstName("Jane");
        actualPerson.setId(123L);
        actualPerson.setLastName("Doe");
        actualPerson.setPhoneNumber(10);
        LocalDate ofEpochDayResult1 = LocalDate.ofEpochDay(1L);
        actualPerson.setStartDate(ofEpochDayResult1);
        assertEquals("42 Main St", actualPerson.getEmailAddress());
        assertSame(ofEpochDayResult, actualPerson.getEndDate());
        assertEquals("Jane", actualPerson.getFirstName());
        assertEquals(123L, actualPerson.getId());
        assertEquals("Doe", actualPerson.getLastName());
        assertEquals(10, actualPerson.getPhoneNumber());
        assertSame(ofEpochDayResult1, actualPerson.getStartDate());
    }

    @Test
    void name() {
    }

    @Test
    void setId() {
    }

    @Test
    void getFirstName() {
    }

    @Test
    void setFirstName() {
    }

    @Test
    void getLastName() {
    }

    @Test
    void setLastName() {
    }

    @Test
    void getEmailAddress() {
    }

    @Test
    void setEmailAddress() {
    }

    @Test
    void getPhoneNumber() {
    }

    @Test
    void setPhoneNumber() {
    }

    @Test
    void getStartDate() {
    }

    @Test
    void setStartDate() {
    }

    @Test
    void getEndDate() {
    }


}