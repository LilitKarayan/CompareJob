package edu.gatech.seclass.jobcompare6300;

import android.widget.EditText;

import java.io.Serializable;

public class Job implements Serializable {
    private String title;
    private String company;
    private String city;
    private String state;
    private int costOfLiving;
    private double yearlySalary;
    private double yearlyBonus;
    private double restrictedStockUnitAward;
    private double relocationStipend;
    private int personalChoiceHolidays;

    private boolean isCurrent;

    // add constructor
    public Job(String title, String company,String city,  String state, int costOfLiving,double yearlySalary,double yearlyBonus, double restrictedStockUnitAward,double relocationStipend,int personalChoiceHolidays,boolean isCurrent)
    {
        this.title = title;
        this.company = company;
        this.city = city;
        this.state = state;
        this.costOfLiving = costOfLiving;
        this.yearlySalary = yearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.restrictedStockUnitAward = restrictedStockUnitAward;
        this.relocationStipend = relocationStipend;
        this.personalChoiceHolidays = personalChoiceHolidays;
        this.isCurrent = isCurrent;


    }
    public Job(){

    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCostOfLiving() {
        return costOfLiving;
    }

    public void setCostOfLiving(int costOfLiving) {
        this.costOfLiving = costOfLiving;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public double getYearlyBonus() {
        return yearlyBonus;
    }

    public void setYearlyBonus(double yearlyBonus) {
        this.yearlyBonus = yearlyBonus;
    }

    public double getRestrictedStockUnitAward() {
        return restrictedStockUnitAward;
    }

    public void setRestrictedStockUnitAward(double restrictedStockUnitAward) {
        this.restrictedStockUnitAward = restrictedStockUnitAward;
    }

    public double getRelocationStipend() {
        return relocationStipend;
    }

    public void setRelocationStipend(double relocationStipend) {
        this.relocationStipend = relocationStipend;
    }

    public int getPersonalChoiceHolidays() {
        return personalChoiceHolidays;
    }

    public void setPersonalChoiceHolidays(int personalChoiceHolidays) {
        this.personalChoiceHolidays = personalChoiceHolidays;
    }

    public boolean getCurrent() {
        return isCurrent;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }
}
