package com.smartmonitoring.modelvalidator.model;
import java.util.List;

public class RequirementsModel {
    private List<Requirement> requirements;

    public RequirementsModel(){
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }
}
