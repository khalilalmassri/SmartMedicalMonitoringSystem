package com.smartmonitoring.modelvalidator.model;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TraceabilityLink {
    private String requirementId;
    private List<String> componentIds;
    private String verificationId;

    @JsonCreator
    public TraceabilityLink(
        @JsonProperty("requirementId") String requirementId,
        @JsonProperty("componentIds") List<String> componentsIds,
        @JsonProperty("verificationId") String verificationId){
        this.requirementId = requirementId;
        this.componentIds = componentsIds;
        this.verificationId = verificationId;
    }

    public String getRequirementId() {
        return requirementId;
    }

    public List<String> getComponentIds() {
        return componentIds;
    }

    public String getVerificationId() {
        return verificationId;
    }

    @Override
    public String toString(){
        return "traceabilityLink{" +
                "requirementId='" + requirementId + '\'' +
                ", componentIds=" + componentIds +
                ", verificationId='" + verificationId + '\'' +
                '}';
    }
}
