package com.example.appretrofit.Model;

import com.google.gson.annotations.SerializedName;

public class Processus {
    private String deploymentDate;
    private String displayName;
    private String name;
    private String deployedBy;
    private String id;
    private String configurationState;
    private String last_update_date;

    @SerializedName("body")
    private String text;

    public String getDeploymentDate() {
        return deploymentDate;
    }

    public void setDeploymentDate(String deploymentDate) {
        this.deploymentDate = deploymentDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeployedBy() {
        return deployedBy;
    }

    public void setDeployedBy(String deployedBy) {
        this.deployedBy = deployedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConfigurationState() {
        return configurationState;
    }

    public void setConfigurationState(String configurationState) {
        this.configurationState = configurationState;
    }

    public String getLast_update_date() {
        return last_update_date;
    }


    public void setLast_update_date(String last_update_date) {
        this.last_update_date = last_update_date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Processus(String deploymentDate, String displayName, String name, String deployedBy, String id, String configurationState, String last_update_date, String text) {
        this.deploymentDate = deploymentDate;
        this.displayName = displayName;
        this.name = name;
        this.deployedBy = deployedBy;
        this.id = id;
        this.configurationState = configurationState;
        this.last_update_date = last_update_date;
        this.text = text;
    }
}
