package com.smartmonitoring.modelvalidator.model;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Component {
    private String id;
    private String name;
    private ComponentType type;
    private String responsibility;
    private List<String> dependencies;
    
    @JsonCreator
    public Component(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("type") ComponentType type,
        @JsonProperty("responsibility") String responsibility,
        @JsonProperty("dependencies") List<String> dependencies) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.responsibility = responsibility;
        this.dependencies = dependencies;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ComponentType getType() {
        return type;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public List<String> getDependencies() {
        return dependencies;
    }

    @Override
    public String toString() {
        return "Component{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", responsibility='" + responsibility +'\''+
                ", dependencies=" + dependencies +
                '}';
    }
}
