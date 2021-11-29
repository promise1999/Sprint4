package com.keyin.demo.accessdatarest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class MembershipTest {
    @Test
    void testMenmbership() {
        Membership actualMembership = new Membership();
        actualMembership.setFamilyPlan("Family Plan");
        actualMembership.setId(123L);
        actualMembership.setNormal("Normal");
        actualMembership.setOther("Other");
        actualMembership.setSpecialOffer("Special Offer");
        actualMembership.setTrial("Trial");
        assertEquals("Family Plan", actualMembership.getFamilyPlan());
        assertEquals(123L, actualMembership.getId());
        assertEquals("Normal", actualMembership.getNormal());
        assertEquals("Other", actualMembership.getOther());
        assertNull(actualMembership.getPerson());
        assertEquals("Special Offer", actualMembership.getSpecialOffer());
        assertEquals("Trial", actualMembership.getTrial());
    }

    @Test
    void testMembership2() {
        Membership actualMembership = new Membership("Normal", "Trial", "Special Offer", "Family Plan", "Other");
        actualMembership.setFamilyPlan("Family Plan");
        actualMembership.setId(123L);
        actualMembership.setNormal("Normal");
        actualMembership.setOther("Other");
        actualMembership.setSpecialOffer("Special Offer");
        actualMembership.setTrial("Trial");
        assertEquals("Family Plan", actualMembership.getFamilyPlan());
        assertEquals(123L, actualMembership.getId());
        assertEquals("Normal", actualMembership.getNormal());
        assertEquals("Other", actualMembership.getOther());
        assertNull(actualMembership.getPerson());
        assertEquals("Special Offer", actualMembership.getSpecialOffer());
        assertEquals("Trial", actualMembership.getTrial());
    }
}

