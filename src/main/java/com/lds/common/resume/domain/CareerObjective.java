package com.lds.common.resume.domain;


import com.lds.common.resume.annatations.Label;

public class CareerObjective {

    @Label(keys ="期望月薪")
    private String expectingSalary;
    @Label(keys ="意向行业")
    private String expectingIndustry;
    @Label(keys ="意向岗位")
    private String expectingPosition;
    @Label(keys ="意向地区")
    private String expectingLocation;
    @Label(keys ="到岗时间")
    private String hiredate;
    @Label(keys ="住房要求")
    private String requireApartment;

    public CareerObjective() {
    }

    public String getExpectingSalary() {
        return expectingSalary;
    }

    public void setExpectingSalary(String expectingSalary) {
        this.expectingSalary = expectingSalary;
    }

    public String getExpectingIndustry() {
        return expectingIndustry;
    }

    public void setExpectingIndustry(String expectingIndustry) {
        this.expectingIndustry = expectingIndustry;
    }

    public String getExpectingPosition() {
        return expectingPosition;
    }

    public void setExpectingPosition(String expectingPosition) {
        this.expectingPosition = expectingPosition;
    }

    public String getExpectingLocation() {
        return expectingLocation;
    }

    public void setExpectingLocation(String expectingLocation) {
        this.expectingLocation = expectingLocation;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getRequireApartment() {
        return requireApartment;
    }

    public void setRequireApartment(String requireApartment) {
        this.requireApartment = requireApartment;
    }
}
