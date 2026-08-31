package com.smartmonitoring.modelvalidator.model;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Requirement {
    private String id;
    private String title;
    private String description; 
    private RequirementType type;
    private Priority priority;
    private String rationale;
    private VerificationMethod verificationMethod;

    @JsonCreator
    public Requirement(
        @JsonProperty("id") String id,
        @JsonProperty("title") String title,
        @JsonProperty("description") String description,
        @JsonProperty("type") RequirementType type,
        @JsonProperty("priority") Priority priority,
        @JsonProperty("rationale") String rationale,
        @JsonProperty("verificationMethod") VerificationMethod verificationMethod){
            this.id = id;
            this.title = title;
            this.description = description;
            this.type = type;
            this.priority = priority;
            this.rationale = rationale;
            this.verificationMethod = verificationMethod;
        }

    public String getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public RequirementType getType(){
        return type;
    }

    public Priority getPriority(){
        return priority;
    }

    public String getRationale(){
        return rationale;
    }

    public VerificationMethod getVerificationMethod(){
        return verificationMethod;
    }

    @Override
public String toString() {
    return "Requirement{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", type=" + type +
            ", priority=" + priority +
            ", verificationMethod=" + verificationMethod +
            '}';
}
    
}
