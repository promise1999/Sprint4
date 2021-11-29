package com.keyin.demo.restservice;

import com.keyin.demo.Repository.CurrentTournamentRepository;
import com.keyin.demo.accessdatarest.CurrentTournament;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {CurrentTournamentController.class})
@ExtendWith(SpringExtension.class)
class CurrentTournamentControllerTest {
    @Autowired
    private CurrentTournamentController currentTournamentController;

    @MockBean
    private CurrentTournamentRepository currentTournamentRepository;

    @Test
    void name() {

    }

    @Test
    void testCreateCurrentTournament() {
        CurrentTournamentController currentTournamentController = new CurrentTournamentController();

        CurrentTournament currentTournament = new CurrentTournament();
        currentTournament.setLocation("Location");
        currentTournament.setStartDate(LocalDate.ofEpochDay(1L));
        currentTournament.setParticipatingMembers("Participating Members");
        currentTournament.setFinalStandings("Final Standings");
        currentTournament.setEndDate(LocalDate.ofEpochDay(1L));
        currentTournament.setPrizeAmount(1);
        currentTournament.setEntryFee(10.0);
        ResponseEntity<CurrentTournament> actualCreateCurrentTournamentResult = currentTournamentController
                .createCurrentTournament(currentTournament);
        assertNull(actualCreateCurrentTournamentResult.getBody());
        assertEquals("<500 INTERNAL_SERVER_ERROR Internal Server Error,[]>",
                actualCreateCurrentTournamentResult.toString());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualCreateCurrentTournamentResult.getStatusCode());
        assertTrue(actualCreateCurrentTournamentResult.getHeaders().isEmpty());
    }

    @Test
    void testDeleteCurrentTournament() throws Exception {
        doNothing().when(this.currentTournamentRepository).deleteById((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/CurrentTournament/{Id}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.currentTournamentController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void testGetAllCurrentTournament() throws Exception {
        when(this.currentTournamentRepository.findAll()).thenReturn((Iterable<CurrentTournament>) mock(Iterable.class));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/currentTournament");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.currentTournamentController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void testGetAllCurrentTournament2() throws Exception {
        when(this.currentTournamentRepository.findByStartDate((String) any()))
                .thenReturn(new ArrayList<CurrentTournament>());
        when(this.currentTournamentRepository.findAll()).thenReturn((Iterable<CurrentTournament>) mock(Iterable.class));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/currentTournament")
                .param("startDate", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.currentTournamentController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void testGetAllCurrentTournament3() throws Exception {
        CurrentTournament currentTournament = new CurrentTournament();
        currentTournament.setLocation("?");
        currentTournament.setStartDate(LocalDate.ofEpochDay(1L));
        currentTournament.setParticipatingMembers("?");
        currentTournament.setFinalStandings("?");
        currentTournament.setEndDate(LocalDate.ofEpochDay(1L));
        currentTournament.setPrizeAmount(0);
        currentTournament.setEntryFee(10.0);

        ArrayList<CurrentTournament> currentTournamentList = new ArrayList<CurrentTournament>();
        currentTournamentList.add(currentTournament);
        when(this.currentTournamentRepository.findByStartDate((String) any())).thenReturn(currentTournamentList);
        when(this.currentTournamentRepository.findAll()).thenReturn((Iterable<CurrentTournament>) mock(Iterable.class));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/currentTournament")
                .param("startDate", "foo");
        MockMvcBuilders.standaloneSetup(this.currentTournamentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"startDate\":[1970,1,2],\"endDate\":[1970,1,2],\"location\":\"?\",\"entryFee\":10.0,\"prizeAmount\":0,"
                                        + "\"participatingMembers\":\"?\",\"finalStandings\":\"?\",\"id\":0}]"));
    }

    @Test
    void testGetPersonById() throws Exception {
        CurrentTournament currentTournament = new CurrentTournament();
        currentTournament.setLocation("Location");
        currentTournament.setStartDate(LocalDate.ofEpochDay(1L));
        currentTournament.setParticipatingMembers("Participating Members");
        currentTournament.setFinalStandings("Final Standings");
        currentTournament.setEndDate(LocalDate.ofEpochDay(1L));
        currentTournament.setPrizeAmount(1);
        currentTournament.setEntryFee(10.0);
        Optional<CurrentTournament> ofResult = Optional.<CurrentTournament>of(currentTournament);
        when(this.currentTournamentRepository.findById((Long) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/currentTournament/{Id}", 123L);
        MockMvcBuilders.standaloneSetup(this.currentTournamentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"startDate\":[1970,1,2],\"endDate\":[1970,1,2],\"location\":\"Location\",\"entryFee\":10.0,\"prizeAmount\":1,"
                                        + "\"participatingMembers\":\"Participating Members\",\"finalStandings\":\"Final Standings\",\"id\":0}"));
    }

    @Test
    void testGetPersonById2() throws Exception {
        when(this.currentTournamentRepository.findById((Long) any())).thenReturn(Optional.<CurrentTournament>empty());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/currentTournament/{Id}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.currentTournamentController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }


}