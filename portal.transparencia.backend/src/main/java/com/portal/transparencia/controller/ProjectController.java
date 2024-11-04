package com.portal.transparencia.controller;
import com.portal.transparencia.exceptions.ResourceNotFoundException;
import com.portal.transparencia.model.Project;
import com.portal.transparencia.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/")
public class ProjectController {
	 @Autowired
	    private ProjectRepository projectRepository;

	    // Listar todos los proyectos
	    @GetMapping("/projects")
	    public List<Project> listAllProjects() {
	        return projectRepository.findAll();
	    }

	    // Crear un nuevo proyecto
	    @PostMapping("/projects")
	    public Project saveProject(@RequestBody Project project) {
	        return projectRepository.save(project);
	    }

	    // Obtener un proyecto por ID
	    @GetMapping("/projects/{id}")
	    public ResponseEntity<Project> getProjectByID(@PathVariable Long id) {
	        Project project = projectRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("No existe el proyecto con el ID: " + id));
	        return ResponseEntity.ok(project);
	    }

	    // Actualizar un proyecto existente
	    @PutMapping("/projects/{id}")
	    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project projectDetails) {
	        Project project = projectRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("No existe el proyecto con el ID: " + id));

	        // Actualizar los campos del proyecto
	        project.setNombre_proyecto(projectDetails.getNombre_proyecto());
	        project.setIncio_proyecyo(projectDetails.getIncio_proyecyo());
	        project.setProgreso_proyecto(projectDetails.getProgreso_proyecto());

	        Project updatedProject = projectRepository.save(project);
	        return ResponseEntity.ok(updatedProject);
	    }

	    // Eliminar un proyecto
	    @DeleteMapping("/projects/{id}")
	    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
	        Project project = projectRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("No existe el proyecto con el ID: " + id));

	        projectRepository.delete(project);
	        return ResponseEntity.noContent().build();
	    }

}
