package com.keyin.demo.restservice;

import com.keyin.demo.Repository.CurrentTournamentRepository;
import com.keyin.demo.accessdatarest.CurrentTournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Index;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CurrentTournamentController {

    @Autowired
    CurrentTournamentRepository currentTournamentRepository;


    @GetMapping("/currentTournament")
    public ResponseEntity<List<CurrentTournament>> getAllCurrentTournament(@RequestParam(required = false) String lastName) {
        try {
            List<CurrentTournament> currentTournaments = new ArrayList<CurrentTournament>();

            if (lastName == null)
                currentTournamentRepository.findAll().forEach(currentTournaments::add);
            else
                currentTournamentRepository.findByLastName(lastName).forEach(currentTournaments::add);

            if (currentTournaments.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(currentTournaments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
/*
    @PostMapping("/CurrentTournament")
    public ResponseEntity<CurrentTournament> createCurrentTournament(@RequestBody CurrentTournament currentTournament) {
        try {
            CurrentTournament _currentTournament = currentTournamentRepository
                    .save(new CurrentTournament(currentTournament.getStartDate(),
                            currentTournament.getFinalStandings(), false));
            return new ResponseEntity<>(_currentTournament, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/CurrentTournament/{startDate}")
    public ResponseEntity<CurrentTournament> updateCurrentTournament(@PathVariable("startDate") String startDate, @RequestBody CurrentTournament currentTournament) {
        List<CurrentTournament> CurrentTournament = currentTournamentRepository.findByStartDate(startDate);

        if (currentTournament.isPresent()) {
            CurrentTournament _currentTournament = currentTournament.get();
            _currentTournament.setStartDate(currentTournament.getStartDate());
            _currentTournament.setFinalStandings(currentTournament.getFinalStandings());
            _currentTournament.setPublished(currentTournament.isPublished());
            return new ResponseEntity<>(currentTournamentRepository.save(_currentTournament), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/CurrentTournament/{startDate}")
    public ResponseEntity<HttpStatus> deleteCurrentTournament(@PathVariable("startDate") String startDate) {
        try {
            currentTournamentRepository.deleteByStartDate(startDate);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
/*
    @DeleteMapping("/currentTournament")
    public ResponseEntity<HttpStatus> deleteAllCurrentTournament() {
        try {
            CurrentTournamentRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/currentTournament/published")
    public ResponseEntity<List<CurrentTournament>> findByPublished() {
        try {
            List<CurrentTournament> currentTournament = CurrentTournamentRepository.findByPublished(true);

            if (currentTournament.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(currentTournament, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

*/
}