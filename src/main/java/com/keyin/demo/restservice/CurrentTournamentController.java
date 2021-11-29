package com.keyin.demo.restservice;

import com.keyin.demo.Repository.CurrentTournamentRepository;
import com.keyin.demo.accessdatarest.CurrentTournament;
import com.keyin.demo.accessdatarest.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
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
    public ResponseEntity<List<CurrentTournament>> getAllCurrentTournament(@RequestParam(required = false) String startDate) {
        try {
            List<CurrentTournament> currentTournaments = new ArrayList<CurrentTournament>();

            if (startDate == null)
                currentTournamentRepository.findAll().forEach(currentTournaments::add);
            else
                currentTournamentRepository.findByStartDate(startDate).forEach(currentTournaments::add);

            if (currentTournaments.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(currentTournaments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/currentTournament/{Id}")
    public ResponseEntity<CurrentTournament> getPersonById(@PathVariable("Id") long Id) {
        Optional<CurrentTournament> currentTournamentData = currentTournamentRepository.findById(Id);
        if (currentTournamentData.isPresent()){
            return new ResponseEntity<>(currentTournamentData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/currentTournament")
    public ResponseEntity<CurrentTournament> createCurrentTournament(@RequestBody CurrentTournament currentTournament) {
        try {
            CurrentTournament _currentTournament = currentTournamentRepository
                    .save(new CurrentTournament(currentTournament.getStartDate(),
                            currentTournament.getStartDate(), currentTournament.getLocation(), currentTournament.getEntryFee(),
                            currentTournament.getPrizeAmount(), currentTournament.getParticipatingMembers(), currentTournament.getFinalStandings()));
            return new ResponseEntity<>(_currentTournament, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/currentTournament/{Id}")
    public ResponseEntity<CurrentTournament> updateCurrentTournament(@PathVariable("Id") long Id, @RequestBody CurrentTournament currentTournament) {
        Optional<CurrentTournament> currentTournamentsData = currentTournamentRepository.findById(Id);

        if (currentTournamentsData.isPresent()) {
            CurrentTournament _currentTournament = currentTournamentsData.get();
            _currentTournament.setStartDate(currentTournament.getStartDate());
            _currentTournament.setEndDate(currentTournament.getEndDate());
            _currentTournament.setLocation(currentTournament.getLocation());
            _currentTournament.setEntryFee(currentTournament.getEntryFee());
            _currentTournament.setPrizeAmount(currentTournament.getPrizeAmount());
            _currentTournament.setParticipatingMembers(currentTournament.getParticipatingMembers());
            _currentTournament.setFinalStandings(currentTournament.getFinalStandings());
            return new ResponseEntity<>(currentTournamentRepository.save(_currentTournament), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/CurrentTournament/{Id}")
    public ResponseEntity<HttpStatus> deleteCurrentTournament(@PathVariable("Id") long Id) {
        try {
            currentTournamentRepository.deleteById(Id);
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