package com.portfoliochupitea.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String projectDesc;
    private String projectVideo;
    
    //Constructores

    public Project() {
    }

    public Project(String projectDesc, String projectVideo) {
        this.projectDesc = projectDesc;
        this.projectVideo = projectVideo;
    }
    
    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
