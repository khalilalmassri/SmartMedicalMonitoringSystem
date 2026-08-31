package com.smartmonitoring.modelvalidator.model;
import java.util.List;

public class TraceabilityModel {
    private List<TraceabilityLink> traceability;

    public TraceabilityModel(){
    }

    public List<TraceabilityLink> getTraceability() {
        return traceability;
    }

    public void setTraceability(List<TraceabilityLink> traceability) {
        this.traceability = traceability;
    }
}
