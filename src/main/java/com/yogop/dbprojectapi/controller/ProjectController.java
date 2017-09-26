package com.yogop.dbprojectapi.controller;

import com.yogop.dbprojectapi.model.Project;
import com.yogop.dbprojectapi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.query.Param;
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
    //@CrossOrigin(origins = "http://localhost:4200")
    public List<Project> getAllProjects() {
        System.out.println("HI");
        return repository.findAll();
    }

    @GetMapping("/filter")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Project> getProjectsByKeyword(@RequestParam("keyword") String keyword, @RequestParam("page") int page, 
            @RequestParam("displaySize") int displaySize, @RequestParam("sortDirection") String sortDirection, @RequestParam("sortField") String sortField) {  
        return repository.findByKeyword(keyword, new PageRequest(page, displaySize, Direction.valueOf(sortDirection), sortField));
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
