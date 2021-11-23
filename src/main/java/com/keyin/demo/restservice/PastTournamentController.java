
package com.keyin.demo.restservice;

import com.keyin.demo.Repository.PastTournamentRepository;
import com.keyin.demo.accessdatarest.PastTournament;
import org.apache.tomcat.util.net.SendfileDataBase;
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


public class PastTournamentController {

    @Autowired
    PastTournamentRepository pastTournamentRepository;


    @GetMapping("/pastTournament")
    public ResponseEntity<List<PastTournament>> getAllPastTournament(@RequestParam(required = false) String endDate) {
        try {
            List<PastTournament> pastTournaments = new ArrayList<PastTournament>();

            if (endDate == null)
                pastTournamentRepository.findAll().forEach(pastTournaments::add);
            else
                pastTournamentRepository.findByEndDate(endDate).forEach(pastTournaments::add);

            if (pastTournaments.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(pastTournaments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/pastTournament")
    public ResponseEntity<PastTournament> createPastTournament(@RequestBody PastTournament pastTournament) {
        try {
            PastTournament _pastTournament = pastTournamentRepository
                    .save(new PastTournament(pastTournament.getStartDate(), pastTournament.getEndDate(), pastTournament.getLocation(), pastTournament.getEntryFee(),
                            pastTournament.getPrizeAmount(), pastTournament.getParticipatingMembers(), pastTournament.getFinalStandings()));
            return new ResponseEntity<>(_pastTournament, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pastTournament/{Id}")
    public ResponseEntity<PastTournament> updatePastTournament(@PathVariable("Id") long Id, @RequestBody PastTournament pastTournament) {
        Optional<PastTournament> pastTournamentsData = pastTournamentRepository.findById(Id);


        if (pastTournamentsData.isPresent()) {
            PastTournament _pastTournament = pastTournamentsData.get();
            _pastTournament.setStartDate(pastTournament.getStartDate());
            _pastTournament.setEndDate(pastTournament.getEndDate());
            _pastTournament.setLocation(pastTournament.getLocation());
            _pastTournament.setEntryFee(pastTournament.getEntryFee());
            _pastTournament.setPrizeAmount(pastTournament.getPrizeAmount());
            _pastTournament.setParticipatingMembers(pastTournament.getParticipatingMembers());
            _pastTournament.setFinalStandings(pastTournament.getFinalStandings());
            return new ResponseEntity<>(pastTournamentRepository.save(_pastTournament), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/pastTournament/{Id}")
    public ResponseEntity<HttpStatus> deletePastTournament(@PathVariable("Id") long Id) {
        try {
            pastTournamentRepository.deleteById(Id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
/*
    @DeleteMapping("/pastTournament")
    public ResponseEntity<HttpStatus> deleteAllPastTournament() {
        try {
            PastTournamentRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/pastTournament/published")
    public ResponseEntity<List<PastTournament>> findByPublished() {
        try {
            List<PastTournament> currentTournament = PastTournamentRepository.findByPublished(true);

            if (PastTournament.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(pastTournament, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

*/
}




