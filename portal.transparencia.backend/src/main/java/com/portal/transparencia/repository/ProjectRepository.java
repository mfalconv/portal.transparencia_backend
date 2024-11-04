package com.portal.transparencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.transparencia.model.Project;

public interface ProjectRepository  extends JpaRepository <Project, Long>{
	

}
