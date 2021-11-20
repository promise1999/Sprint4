package com.keyin.demo.accessdatarest;

public class Membership {
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
}
