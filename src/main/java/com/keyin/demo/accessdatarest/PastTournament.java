package com.keyin.demo.accessdatarest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class PastTournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private double entryFee;
    private int prizeAmount;
    private String participatingMembers;
    private String finalStandings;

    public PastTournament() {
    }

    public PastTournament(LocalDate startDate, LocalDate endDate, String location,
                          double entryFee, int prizeAmount,
                          String participatingMembers, String finalStandings) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.prizeAmount = prizeAmount;
        this.participatingMembers = participatingMembers;
        this.finalStandings = finalStandings;
    }

    public PastTournament(LocalDate startDate, String finalStandings, boolean b) {

    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public void setPrizeAmount(int prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public String getParticipatingMembers() {
        return participatingMembers;
    }

    public void setParticipatingMembers(String participatingMembers) {
        this.participatingMembers = participatingMembers;
    }

    public String getFinalStandings() {
        return finalStandings;
    }

    public void setFinalStandings(String finalStandings) {
        this.finalStandings = finalStandings;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
