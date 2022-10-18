package com.portfoliochupitea.Controller;

import com.portfoliochupitea.Dto.dtoProject;
import com.portfoliochupitea.Entity.Project;
import com.portfoliochupitea.Security.Controller.Mensaje;
import com.portfoliochupitea.Service.SProject;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
@CrossOrigin(origins = {"https://frontendportafoliochupitea.web.app","http://localhost:4200"})
public class CProject {
    @Autowired
    SProject sProject;

    @GetMapping("/lista")
    public ResponseEntity<List<Project>> list() {
        List<Project> list = sProject.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") int id) {
        if (!sProject.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Project project = sProject.getOne(id).get();
        return new ResponseEntity(project, HttpStatus.OK);
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable("id") int id) {
//        if (!sProject.existsById(id)) {
//            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
//        }
//        sProject.delete(id);
//        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<?> create(@RequestBody dtoProject dtopro) {
//        if (StringUtils.isBlank(dtopro.getProjectDesc())) {
//            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
//        }
//        if (sProject.existsByProjectDesc(dtopro.getProjectDesc())) {
//            return new ResponseEntity(new Mensaje("Ese project existe"), HttpStatus.BAD_REQUEST);
//        }
//
//        Project project = new Project(dtopro.getProjectDesc(), dtopro.getProjectVideo());
//        sProject.save(project);
//
//        return new ResponseEntity(new Mensaje("Project agregada"), HttpStatus.OK);
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProject dtopro) {
        //Validamos si existe el ID
        if (!sProject.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de projects
        if (sProject.existsByProjectDesc(dtopro.getProjectDesc()) && sProject.getByProjectDesc(dtopro.getProjectDesc()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese projecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtopro.getProjectDesc())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Project project = sProject.getOne(id).get();
        project.setProjectDesc(dtopro.getProjectDesc());
        project.setProjectVideo((dtopro.getProjectVideo()));

        sProject.save(project);
        return new ResponseEntity(new Mensaje("Projecto actualizado"), HttpStatus.OK);

    }
}
