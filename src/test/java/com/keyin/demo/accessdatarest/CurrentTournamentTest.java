package com.keyin.demo.accessdatarest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class CurrentTournamentTest {
    @Test
    void testCurrentTournament() {
        CurrentTournament actualCurrentTournament = new CurrentTournament();
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualCurrentTournament.setEndDate(ofEpochDayResult);
        actualCurrentTournament.setEntryFee(10.0);
        actualCurrentTournament.setFinalStandings("Final Standings");
        actualCurrentTournament.setLocation("Location");
        actualCurrentTournament.setParticipatingMembers("Participating Members");
        actualCurrentTournament.setPrizeAmount(1);
        LocalDate ofEpochDayResult1 = LocalDate.ofEpochDay(1L);
        actualCurrentTournament.setStartDate(ofEpochDayResult1);
        assertSame(ofEpochDayResult, actualCurrentTournament.getEndDate());
        assertEquals(10.0, actualCurrentTournament.getEntryFee());
        assertEquals("Final Standings", actualCurrentTournament.getFinalStandings());
        assertEquals(0L, actualCurrentTournament.getId());
        assertEquals("Location", actualCurrentTournament.getLocation());
        assertEquals("Participating Members", actualCurrentTournament.getParticipatingMembers());
        assertEquals(1, actualCurrentTournament.getPrizeAmount());
        assertSame(ofEpochDayResult1, actualCurrentTournament.getStartDate());
    }

    @Test
    void testCurrentTournament2() {
        CurrentTournament actualCurrentTournament = new CurrentTournament(LocalDate.ofEpochDay(1L),
                LocalDate.ofEpochDay(1L), "Location", 10.0, 1, "Participating Members", "Final Standings");

        assertEquals("1970-01-02", actualCurrentTournament.getEndDate().toString());
        assertEquals("1970-01-02", actualCurrentTournament.getStartDate().toString());
        assertEquals(1, actualCurrentTournament.getPrizeAmount());
        assertEquals("Participating Members", actualCurrentTournament.getParticipatingMembers());
        assertEquals("Location", actualCurrentTournament.getLocation());
        assertEquals("Final Standings", actualCurrentTournament.getFinalStandings());
        assertEquals(10.0, actualCurrentTournament.getEntryFee());
    }

    @Test
    void testSetId() {
        CurrentTournament currentTournament = new CurrentTournament();
        currentTournament.setId(12);
        assertEquals(0, currentTournament.getPrizeAmount());
        assertEquals(0L, currentTournament.getId());
        assertEquals(0.0, currentTournament.getEntryFee());
    }
}

