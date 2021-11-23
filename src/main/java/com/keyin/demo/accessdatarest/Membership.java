package com.keyin.demo.accessdatarest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String normal;
    private String trial;
    private String specialOffer;
    private String familyPlan;
    private String other;

    public Membership() {
    }

    public Membership(String normal, String trial, String specialOffer, String familyPlan, String other) {
        this.normal = normal;
        this.trial = trial;
        this.specialOffer = specialOffer;
        this.familyPlan = familyPlan;
        this.other = other;
    }

    public long getId() {
        return Id;
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public String getTrial() {
        return trial;
    }

    public void setTrial(String trial) {
        this.trial = trial;
    }

    public String getSpecialOffer() {
        return specialOffer;
    }

    public void setSpecialOffer(String specialOffer) {
        this.specialOffer = specialOffer;
    }

    public String getFamilyPlan() {
        return familyPlan;
    }

    public void setFamilyPlan(String familyPlan) {
        this.familyPlan = familyPlan;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public void setId(long Id) {
        this.Id = Id;
    }


}
