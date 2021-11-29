package com.keyin.demo.accessdatarest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class PastTournamentTest {
    @Test
    void testConstructor() {
        PastTournament actualPastTournament = new PastTournament();
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualPastTournament.setEndDate(ofEpochDayResult);
        actualPastTournament.setEntryFee(10.0);
        actualPastTournament.setFinalStandings("Final Standings");
        actualPastTournament.setLocation("Location");
        actualPastTournament.setParticipatingMembers("Participating Members");
        actualPastTournament.setPrizeAmount(1);
        LocalDate ofEpochDayResult1 = LocalDate.ofEpochDay(1L);
        actualPastTournament.setStartDate(ofEpochDayResult1);
        assertSame(ofEpochDayResult, actualPastTournament.getEndDate());
        assertEquals(10.0, actualPastTournament.getEntryFee());
        assertEquals("Final Standings", actualPastTournament.getFinalStandings());
        assertEquals(0L, actualPastTournament.getId());
        assertEquals("Location", actualPastTournament.getLocation());
        assertEquals("Participating Members", actualPastTournament.getParticipatingMembers());
        assertNull(actualPastTournament.getPerson());
        assertEquals(1, actualPastTournament.getPrizeAmount());
        assertSame(ofEpochDayResult1, actualPastTournament.getStartDate());
    }

    @Test
    void testConstructor2() {
        PastTournament actualPastTournament = new PastTournament(LocalDate.ofEpochDay(1L), LocalDate.ofEpochDay(1L),
                "Location", 10.0, 1, "Participating Members", "Final Standings");

        assertEquals("1970-01-02", actualPastTournament.getEndDate().toString());
        assertEquals("1970-01-02", actualPastTournament.getStartDate().toString());
        assertEquals(1, actualPastTournament.getPrizeAmount());
        assertEquals("Participating Members", actualPastTournament.getParticipatingMembers());
        assertEquals("Location", actualPastTournament.getLocation());
        assertEquals("Final Standings", actualPastTournament.getFinalStandings());
        assertEquals(10.0, actualPastTournament.getEntryFee());
    }

    @Test
    void testSetId() {
        PastTournament pastTournament = new PastTournament();
        pastTournament.setId(123L);
        assertEquals(0, pastTournament.getPrizeAmount());
        assertEquals(0L, pastTournament.getId());
        assertEquals(0.0, pastTournament.getEntryFee());
    }
}

