package com.yogop.dbprojectapi.controller;

import com.yogop.dbprojectapi.model.Project;
import com.yogop.dbprojectapi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jeffrey Y. Pogoy
 * @created 14 Sep 2017 12:05 PM
 */
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository repository;

    @GetMapping("")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Project> getAllProjects() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Project getProject(@PathVariable Long id) {
        return repository.findOne(id);
    }

    @PostMapping("")
    public void addProject(@RequestBody Project project) {
        repository.save(project);
    }

    @PutMapping("")
    public void updateProject(@RequestBody Project project) {
        repository.save(project);
    }

    @DeleteMapping("{id}")
    public void deleteProject(@PathVariable Long id) {
        repository.delete(id);
    }

}
