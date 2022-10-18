
package com.portfoliochupitea.Repository;

import com.portfoliochupitea.Entity.Project;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RProject extends JpaRepository<Project, Integer>{
    public Optional<Project> findByProjectDesc(String projectDesc);
    
    public boolean existsByProjectDesc(String projectDesc);
}
