package com.portal.transparencia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Table(name = "anuncios")
@Entity
public class Announcement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "contenido", length = 100000, unique = false, nullable = false)
	private String contenido;

	@Column(name = "fecha_inicio", unique = false, nullable = false)
	private LocalDate fecha_inicio;

	@Column(name = "fecha_fin", unique = false, nullable = false)
	private LocalDate fecha_fin;

	public Announcement() {
		super();
	}

	// Getters and Setters

	public Announcement(Long id, LocalDate startDate, LocalDate endDate, String content) {
		super();
		this.id = id;
		this.contenido = content;
		this.fecha_inicio = startDate;
		this.fecha_fin = endDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return contenido;
	}

	public void setContent(String content) {
		this.contenido = content;
	}

	public LocalDate getStartDate() {
		return fecha_inicio;
	}

	public void setStartDate(LocalDate startDate) {
		this.fecha_inicio = startDate;
	}

	public LocalDate getEndDate() {
		return fecha_fin;
	}

	public void setEndDate(LocalDate endDate) {
		this.fecha_fin = endDate;
	}
}
