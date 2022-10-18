package com.portfoliochupitea.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProject {
    
    @NotBlank
    private String projectDesc;
    @NotBlank
    private String projectVideo;

    //Constructor
    public dtoProject() {
    }

    public dtoProject(String projectDesc, String projectVideo) {
        this.projectDesc = projectDesc;
        this.projectVideo = projectVideo;
    }

    //Getters and Setters
    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public String getProjectVideo() {
        return projectVideo;
    }

    public void setProjectVideo(String projectVideo) {
        this.projectVideo = projectVideo;
    }
}
