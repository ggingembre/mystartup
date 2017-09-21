package ua.goit.entity;

/**
 * Created by Guillaume Gingembre on 21/09/2017.
 */
public class BusinessPlanRegistrationForm {

    private BusinessPlan businessPlan;
    private Address address;

    public BusinessPlanRegistrationForm() {
    }

    public BusinessPlanRegistrationForm(BusinessPlan businessPlan, Address address) {
        this.businessPlan = businessPlan;
        this.address = address;
    }

    public BusinessPlan getBusinessPlan() {
        return businessPlan;
    }

    public void setBusinessPlan(BusinessPlan businessPlan) {
        this.businessPlan = businessPlan;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
