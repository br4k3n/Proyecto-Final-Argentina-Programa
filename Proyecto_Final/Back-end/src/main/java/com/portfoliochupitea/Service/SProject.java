package com.portfoliochupitea.Service;

import com.portfoliochupitea.Entity.Project;
import com.portfoliochupitea.Repository.RProject;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProject {
     @Autowired
    RProject rProject;
    
    public List<Project> list(){
        return rProject.findAll();
    }
    
    public Optional<Project> getOne(int id){
        return rProject.findById(id);
    }
    
    public Optional<Project> getByProjectDesc(String projectDesc){
        return rProject.findByProjectDesc(projectDesc);
    }
    
    public void save(Project pro){
        rProject.save(pro);
    }
    
    public void delete(int id){
        rProject.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rProject.existsById(id);
    }
    
    public boolean existsByProjectDesc(String projectDesc){
        return rProject.existsByProjectDesc(projectDesc);
    }
}
