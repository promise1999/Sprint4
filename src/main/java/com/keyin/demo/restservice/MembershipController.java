package com.keyin.demo.restservice;

import com.keyin.demo.Repository.MembershipRepository;
import com.keyin.demo.Repository.PersonRepository;
import com.keyin.demo.accessdatarest.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import com.keyin.demo.Repository.PastTournamentRepository;
import com.keyin.demo.Repository.PersonRepository;
import com.keyin.demo.accessdatarest.Membership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

    @CrossOrigin(origins = "http://localhost:8081")
    @RestController
    @RequestMapping("/api")
    public class MembershipController {


        @Autowired
        public Membership membership;


        @GetMapping("/normal")
        public ResponseEntity<List<Membership >> getAllMembership(@RequestParam(required = false) String normal) {
            try {
                List<Membership> memberships = new ArrayList<Membership>();

                if (Id == null)
                    MembershipRepository.findByNormal().forEach(Membership::add);
                else MembershipRepository.findByNormal().forEach(Membership::add);

                if (Membership.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }

                return new ResponseEntity<>(memberships, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


    }


    /*
    If family plan – indicate which other members in the database, if any,
    are connected on their plan.
    If other – you should include the monthly membership cost.
     */
