package com.smartmonitoring.modelvalidator.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartmonitoring.modelvalidator.model.ComponentsModel;
import com.smartmonitoring.modelvalidator.model.RequirementsModel;
import com.smartmonitoring.modelvalidator.model.TraceabilityModel;

import java.io.File;
import java.io.IOException;

public class ModelLoader {
    ObjectMapper mapper = new ObjectMapper();

    public RequirementsModel loadRequirements(String filePath) throws IOException {
        return mapper.readValue(new File(filePath), RequirementsModel.class);
    }

    public ComponentsModel loadComponents(String filePath) throws IOException {
        return mapper.readValue(new File(filePath), ComponentsModel.class);
    }

    public TraceabilityModel loadTraceability(String filePath) throws IOException {
        return mapper.readValue(new File(filePath), TraceabilityModel.class);
    }
}
