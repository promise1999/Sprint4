package com.keyin.demo.restservice;

import com.keyin.demo.Repository.PastTournamentRepository;
import com.keyin.demo.accessdatarest.PastTournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Index;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Table(indexes = {
        @Index(name = "idx_PastTournamentController", columnList = "pastTournamentRepository")
})
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
class PastTournamentController {


    @Autowired
    PastTournamentController pastTournamentController;


    @GetMapping("/endDate")
    public ResponseEntity<List<PastTournament>> getAllPastTournament(@RequestParam(required = false) String endDate) {
        try {
            List<PastTournament> pastTournaments = new ArrayList<PastTournament>();

            if (endDate == null)
                PastTournamentRepository.findAll().forEach(pastTournaments::add);
            else
                PastTournamentRepository.findByEndDate(endDate).forEach(PastTournament::add);

            if (pastTournaments.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(pastTournaments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/pastTournament/{endDate}")
    public ResponseEntity getPastTournamentsById(@PathVariable("endDate") String endDate) {
        Optional<PastTournament> pastTournaments = PastTournamentRepository.findByEndDate(endDate);

        if (pastTournaments.isPresent()) {
            return new ResponseEntity<>(pastTournaments.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/pastTournament")
    public ResponseEntity<pastTournament> createPastTournament(@RequestBody PastTournament pastTournament) {
        try {
            PastTournament _pastTournament = PastTournamentRepository
                    .save(new PastTournament(pastTournament.getEndDate(),
                            pastTournament.getFinalStandings(), false));
            return new ResponseEntity<>(_pastTournament, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pastTournament/{endDate}")
    public ResponseEntity<PastTournament> updatePastTournament(@PathVariable("endDate") String endDate, @RequestBody PastTournament pastTournament) {
        Optional<PastTournament>PastTournament = PastTournamentRepository.findByEndDate(endDate);

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



