package com.smartmonitoring.modelvalidator.validation;

import com.smartmonitoring.modelvalidator.model.Component;
import com.smartmonitoring.modelvalidator.model.Requirement;
import com.smartmonitoring.modelvalidator.model.TraceabilityLink;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class ModelValidator {

    public List<String> findInvalidRequirementReferences(
        List<Requirement> requirements,
        List<TraceabilityLink> traceabilityLinks)
    {
        List<String> errors = new ArrayList<>();
        for(TraceabilityLink traceabilityLink : traceabilityLinks){
            boolean found = false;
            for(Requirement requirement : requirements){
                String requirementId = requirement.getId();  
                if(traceabilityLink.getRequirementId().equals(requirementId)){
                    found = true;
                break;
                }
            }
            if (!found) {
                errors.add("Traceability link references not found: " + traceabilityLink.getRequirementId());
            }
        }
        return errors;
    }

    public List<String> findInvalidComponentReferences(
        List<Component> components,
        List<TraceabilityLink> traceabilityLinks){
            List<String> errors = new ArrayList<>();

            for(TraceabilityLink traceabilityLink : traceabilityLinks){
                for(String componentId : traceabilityLink.getComponentIds()){
                    boolean found = false;
                    for(Component component : components){
                        if(component.getId().equals(componentId)){
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        errors.add("Traceability link references not found: " + componentId);
                    }
                }
            }
        return errors;
    }

    public List<String> findRequirementsWithoutTraceability(
        List<Requirement> requirements,
        List<TraceabilityLink> traceabilityLinks){
            List<String> errors = new ArrayList<>();
            for (Requirement requirement : requirements){
                boolean found = false;
                for(TraceabilityLink traceabilityLink : traceabilityLinks){
                    if(traceabilityLink.getRequirementId().equals(requirement.getId())){
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    errors.add("Requirement without traceability link: " + requirement.getId());
                }
            }        
            return errors;
        }

        public List<String> findDuplicateRequirementIds(List<Requirement> requirements){
            Set<String> seenIds = new HashSet<>();
            List<String> errors = new ArrayList<>();
            for(Requirement requirement : requirements){
                if(!seenIds.add(requirement.getId())){
                    errors.add("Duplicate requirement ID found: " + requirement.getId());
                }
                
            }
            return errors;
        }

        public List<String> findDuplicateComponentIds(List<Component> components){
            Set<String> seenIds = new HashSet<>();
            List<String> errors = new ArrayList<>();
            for(Component component : components){
                if(!seenIds.add(component.getId())){
                    errors.add("Duplicate component ID found: " + component.getId());
                }
                
            }
            return errors;
        }

        public List<String> findInvalidComponentDependencies(
            List<Component> components){
                List<String> errors = new ArrayList<>();
                Set<String> componentIds = new HashSet<>();
                for(Component component : components){
                    componentIds.add(component.getId());
                }
                for(Component component : components){
                    for(String dependencyIds : component.getDependencies()){
                        if(!componentIds.contains(dependencyIds)){
                            errors.add(
                            "Component " + component.getId()
                            + " references missing dependency: "
                            + dependencyIds
                        );
                        }
                    }
                }
                return errors;
            }
}