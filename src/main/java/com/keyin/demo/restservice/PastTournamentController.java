
package com.keyin.demo.restservice;

import com.keyin.demo.Repository.PastTournamentRepository;
import com.keyin.demo.accessdatarest.PastTournament;
import org.apache.tomcat.util.net.SendfileDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Index;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

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
/*
    @PutMapping("/pastTournament/{endDate}")
    public ResponseEntity<PastTournament> updatePastTournament(@PathVariable("endDate") String endDate, @RequestBody PastTournament pastTournament) {
        Optional<PastTournament> PastTournament = PastTournamentRepository.findByEndDate(endDate);

        if (pastTournament.isPresent()) {
            PastTournament _pastTournament = pastTournament.get();
            _pastTournament.setStartDate(pastTournament.getStartDate());
            _pastTournament.setFinalStandings(pastTournament.getFinalStandings());
            _pastTournament.setPublished(pastTournament.isPublished());
            return new ResponseEntity<>(PastTournamentRepository.save(_pastTournament), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/pastTournament/{endDate}")
    public ResponseEntity<HttpStatus> deletePastTournament(@PathVariable("endDate") String endDate) {
        try {
            PastTournamentRepository.deleteByEndDate(endDate);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

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




