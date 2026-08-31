package com.smartmonitoring.modelvalidator;

import java.util.List;
import com.smartmonitoring.modelvalidator.loader.ModelLoader;
import com.smartmonitoring.modelvalidator.model.Requirement;
import com.smartmonitoring.modelvalidator.model.RequirementsModel;
import com.smartmonitoring.modelvalidator.model.Component;
import com.smartmonitoring.modelvalidator.model.ComponentsModel;
import com.smartmonitoring.modelvalidator.model.TraceabilityModel;
import com.smartmonitoring.modelvalidator.model.TraceabilityLink;
import com.smartmonitoring.modelvalidator.validation.ModelValidator;

public class Main {
    public static void main(String[] args) throws Exception {

        ModelLoader loader = new ModelLoader();
        ModelValidator validator = new ModelValidator();

        
        RequirementsModel requirementsModel =
                loader.loadRequirements("C:\\\\Users\\\\Khalil\\\\Desktop\\\\smart-medical-monitoring-mbse\\\\model-data\\\\requirements.json");

        for (Requirement requirement : requirementsModel.getRequirements()) {
            System.out.println("Requirement ID: " + requirement.getId());
            System.out.println("Requirement Description: " + requirement.getDescription());
            System.out.println("Requirement Type: " + requirement.getType());
            System.out.println("Requirement Priority: " + requirement.getPriority());
            System.out.println("Requirement Verification Method: " + requirement.getVerificationMethod());
            System.out.println();
        }

        ComponentsModel componentsModel =
        loader.loadComponents("C:\\\\Users\\\\Khalil\\\\Desktop\\\\smart-medical-monitoring-mbse\\\\model-data\\\\components.json");

        for (Component component : componentsModel.getComponents()) {
            System.out.println("Component ID: " + component.getId());
            System.out.println("Component Name: " + component.getName());
            System.out.println("Component Type: " + component.getType());
            System.out.println("Component Responsibility: " + component.getResponsibility());
            System.out.println("Component Dependencies: " + component.getDependencies());
            System.out.println();
        }

        TraceabilityModel traceabilityModel =
        loader.loadTraceability("C:\\\\Users\\\\Khalil\\\\Desktop\\\\smart-medical-monitoring-mbse\\\\model-data\\\\traceability.json");

        for (TraceabilityLink traceability : traceabilityModel.getTraceability()) {
            System.out.println("Requirement ID: " + traceability.getRequirementId());
            System.out.println("Component ID: " + traceability.getComponentIds());
            System.out.println("Verification ID: " + traceability.getVerificationId());
            System.out.println();
        }
    
        List<String> errors =
        validator.findInvalidRequirementReferences(
                requirementsModel.getRequirements(),
                traceabilityModel.getTraceability()
        );

        if (errors.isEmpty()) {
            System.out.println("No invalid requirement references found.");
        } else {
            for (String error : errors) {
                System.out.println(error);
            }
        }

        List<String> errorsComponents =
        validator.findInvalidComponentReferences(
                componentsModel.getComponents(),
                traceabilityModel.getTraceability()
        );

        if (errorsComponents.isEmpty()) {
            System.out.println("No invalid component references found.");
        } else {
            for (String error : errorsComponents) {
                System.out.println(error);
            }
        }

                List<String> errorsRequirements =
        validator.findRequirementsWithoutTraceability(
                requirementsModel.getRequirements(),
                traceabilityModel.getTraceability()
        );

        if (errorsRequirements.isEmpty()) {
            System.out.println("No requirements without traceability links found.");
        } else {
            for (String error : errorsRequirements) {
                System.out.println(error);
            }
        }

        List<String> duplicateRequirementsIds= validator.findDuplicateRequirementIds
        (requirementsModel.getRequirements());

        if(duplicateRequirementsIds.isEmpty()){
            System.out.println("No duplicate requirement IDs found.");
        } else {
            for (String error : duplicateRequirementsIds) {
                System.out.println(error);
            }
        }

        List<String> duplicateComponentIds= validator.findDuplicateComponentIds
        (componentsModel.getComponents());

        if(duplicateComponentIds.isEmpty()){
            System.out.println("No duplicate component IDs found.");
        } else {
            for (String error : duplicateComponentIds) {
                System.out.println(error);
            }
        }

        List<String> invalidComponentDependencies = validator.findInvalidComponentDependencies
        (componentsModel.getComponents());

        if(invalidComponentDependencies.isEmpty()){
            System.out.println("No invalid component dependencies found.");
        } else {
            for (String error : invalidComponentDependencies) {
                System.out.println(error);
            }
        }
    }
}