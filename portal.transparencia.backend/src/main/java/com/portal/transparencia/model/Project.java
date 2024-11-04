package com.portal.transparencia.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyectos")

public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long proyecto_id;

	@Column(name = "nombre_proyecto", length = 60, unique = true, nullable = false)
	private String nombre_proyecto;

	@Column(name = "inicio_proyecto", nullable = false)
	private LocalDate incio_proyecyo;

	@Column(name = "progreso_proyecto", nullable = false)
	private String progreso_proyecto;

	public Project() {
		super();

	}

	public Project(Long proyecto_id, String nombre_proyecto, LocalDate incio_proyecyo, String progreso_proyecto) {
		super();
		this.proyecto_id = proyecto_id;
		this.nombre_proyecto = nombre_proyecto;
		this.incio_proyecyo = incio_proyecyo;
		this.progreso_proyecto = progreso_proyecto;
	}

	public Long getProyecto_id() {
		return proyecto_id;
	}

	public void setProyecto_id(Long proyecto_id) {
		this.proyecto_id = proyecto_id;
	}

	public String getNombre_proyecto() {
		return nombre_proyecto;
	}

	public void setNombre_proyecto(String nombre_proyecto) {
		this.nombre_proyecto = nombre_proyecto;
	}

	public LocalDate getIncio_proyecyo() {
		return incio_proyecyo;
	}

	public void setIncio_proyecyo(LocalDate incio_proyecyo) {
		this.incio_proyecyo = incio_proyecyo;
	}

	public String getProgreso_proyecto() {
		return progreso_proyecto;
	}

	public void setProgreso_proyecto(String progreso_proyecto) {
		this.progreso_proyecto = progreso_proyecto;
	}

}
