package com.keyin.demo.accessdatarest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;

@Entity
public class CurrentTournament {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private double entryFee;
    private int prizeAmount;
    private String participatingMembers;
    private String finalStandings;

    public CurrentTournament() {
    }

    public CurrentTournament(LocalDate startDate, LocalDate endDate,
                             String location, double entryFee, int prizeAmount,
                             String participatingMembers, String finalStandings) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.prizeAmount = prizeAmount;
        this.participatingMembers = participatingMembers;
        this.finalStandings = finalStandings;
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

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        Id = Id;
    }


}
