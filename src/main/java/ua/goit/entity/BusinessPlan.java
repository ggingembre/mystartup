package ua.goit.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Created by Guillaume Gingembre on 14/09/2017.
 */


@Entity
@Table(name = "businessplans")
public class BusinessPlan {


    //Переименовать все поля согласно тому что сказал андрей и егор
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "businessplan_id", updatable=false, nullable=false)
    private long businessplan_id;

    @Column(name = "project_id")
    private long projectId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Address address;

    @Column(name = "idea")
    private String idea;

    @Column(name = "current_state")
    private String currentState;

    @Column(name = "market")
    private String market;

    @Column(name = "opportunity")
    private String opportunity;

    @Column(name = "solution")
    private String solution;

    @Column(name = "competition")
    private String competition;

    @Column(name = "usp")
    private String usp;

    @Column(name = "business_model")
    private String businessModel;

    @Column(name = "funds_uses")
    private String fundsUses;

    @Column(name = "mentors")
    private String mentors;

    @Column(name = "risks")
    private String risks;

    @Column(name = "weburl")
    private String weburl;

    @Column(name = "docurl")
    private String docurl;

    @Column(name = "businessplan_expected_raise")
    private BigDecimal businessPlanExpectedRaise;

    @Column(name = "businessplan_amount_raised")
    private BigDecimal businessPlanAmountRaised;

    @Column(name = "businessplan_min_inv")
    private BigDecimal businessPlanMinInv;

    @Column(name = "businessplan_return")
    private double businessPlanReturn;

    @Column(name = "finances")
    private String finances;

    @Column(name = "previous_rounds")
    private BigDecimal previousRounds;

    @Column(name = "collateral")
    private String collateral;

    @Column(name = "businessplan_last_change")
    private LocalDate businessPlanLastChange;

    @Column(name = "isActive")
    private boolean isActive;

    // many to many relationship mapping:

    //@JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "businessPlans")
    private Collection<Project> projects;


    public BusinessPlan(){}

    public BusinessPlan(long projectId, Address address, String idea, String currentState, String market, String opportunity, String solution, String competition, String usp, String businessModel, String fundsUses, String mentors, String risks, String weburl, String docurl, BigDecimal businessPlanExpectedRaise, BigDecimal businessPlanAmountRaised, BigDecimal businessPlanMinInv, double businessPlanReturn, String finances, BigDecimal previousRounds, String collateral, LocalDate businessPlanLastChange, boolean isActive) {
        this.projectId = projectId;
        this.address = address;
        this.idea = idea;
        this.currentState = currentState;
        this.market = market;
        this.opportunity = opportunity;
        this.solution = solution;
        this.competition = competition;
        this.usp = usp;
        this.businessModel = businessModel;
        this.fundsUses = fundsUses;
        this.mentors = mentors;
        this.risks = risks;
        this.weburl = weburl;
        this.docurl = docurl;
        this.businessPlanExpectedRaise = businessPlanExpectedRaise;
        this.businessPlanAmountRaised = businessPlanAmountRaised;
        this.businessPlanMinInv = businessPlanMinInv;
        this.businessPlanReturn = businessPlanReturn;
        this.finances = finances;
        this.previousRounds = previousRounds;
        this.collateral = collateral;
        this.businessPlanLastChange = businessPlanLastChange;
        this.isActive = isActive;
    }

    public long getBusinessplan_id() {
        return businessplan_id;
    }

    public void setBusinessplan_id(long businessplan_id) {
        this.businessplan_id = businessplan_id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(String opportunity) {
        this.opportunity = opportunity;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public String getUsp() {
        return usp;
    }

    public void setUsp(String usp) {
        this.usp = usp;
    }

    public String getBusinessModel() {
        return businessModel;
    }

    public void setBusinessModel(String businessModel) {
        this.businessModel = businessModel;
    }

    public String getFundsUses() {
        return fundsUses;
    }

    public void setFundsUses(String fundsUses) {
        this.fundsUses = fundsUses;
    }

    public String getMentors() {
        return mentors;
    }

    public void setMentors(String mentors) {
        this.mentors = mentors;
    }

    public String getRisks() {
        return risks;
    }

    public void setRisks(String risks) {
        this.risks = risks;
    }

    public String getFinances() {
        return finances;
    }

    public void setFinances(String finances) {
        this.finances = finances;
    }

    public BigDecimal getPreviousRounds() {
        return previousRounds;
    }

    public void setPreviousRounds(BigDecimal previousRounds) {
        this.previousRounds = previousRounds;
    }

    public String getCollateral() {
        return collateral;
    }

    public void setCollateral(String collateral) {
        this.collateral = collateral;
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

    public String getDocurl() {
        return docurl;
    }

    public void setDocurl(String docurl) {
        this.docurl = docurl;
    }

    public BigDecimal getBusinessPlanExpectedRaise() {
        return businessPlanExpectedRaise;
    }

    public void setBusinessPlanExpectedRaise(BigDecimal businessPlanExpectedRaise) {
        this.businessPlanExpectedRaise = businessPlanExpectedRaise;
    }

    public BigDecimal getBusinessPlanAmountRaised() {
        return businessPlanAmountRaised;
    }

    public void setBusinessPlanAmountRaised(BigDecimal businessPlanAmountRaised) {
        this.businessPlanAmountRaised = businessPlanAmountRaised;
    }

    public BigDecimal getBusinessPlanMinInv() {
        return businessPlanMinInv;
    }

    public void setBusinessPlanMinInv(BigDecimal businessPlanMinInv) {
        this.businessPlanMinInv = businessPlanMinInv;
    }

    public double getBusinessPlanReturn() {
        return businessPlanReturn;
    }

    public void setBusinessPlanReturn(double businessPlanReturn) {
        this.businessPlanReturn = businessPlanReturn;
    }

    public LocalDate getBusinessPlanLastChange() {
        return businessPlanLastChange;
    }

    public void setBusinessPlanLastChange(LocalDate businessPlanLastChange) {
        this.businessPlanLastChange = businessPlanLastChange;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @JsonIgnore
    public Collection<Project> getProjects() {
        return projects;
    }

    //@JsonProperty
    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "BusinessPlan{" +
                "businessplan_id=" + businessplan_id +
                ", projectId=" + projectId +
                ", address=" + address +
                ", idea='" + idea + '\'' +
                ", currentState='" + currentState + '\'' +
                ", market='" + market + '\'' +
                ", opportunity='" + opportunity + '\'' +
                ", solution='" + solution + '\'' +
                ", competition='" + competition + '\'' +
                ", usp='" + usp + '\'' +
                ", businessModel='" + businessModel + '\'' +
                ", fundsUses='" + fundsUses + '\'' +
                ", mentors='" + mentors + '\'' +
                ", risks='" + risks + '\'' +
                ", weburl='" + weburl + '\'' +
                ", docurl='" + docurl + '\'' +
                ", businessPlanExpectedRaise=" + businessPlanExpectedRaise +
                ", businessPlanAmountRaised=" + businessPlanAmountRaised +
                ", businessPlanMinInv=" + businessPlanMinInv +
                ", businessPlanReturn=" + businessPlanReturn +
                ", finances='" + finances + '\'' +
                ", previousRounds=" + previousRounds +
                ", collateral='" + collateral + '\'' +
                ", businessPlanLastChange=" + businessPlanLastChange +
                ", isActive=" + isActive +
                ", projects=" + projects +
                '}';
    }
}
