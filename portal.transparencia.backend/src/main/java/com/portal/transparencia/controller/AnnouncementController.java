package com.portal.transparencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.transparencia.exceptions.ResourceNotFoundException;
import com.portal.transparencia.model.Announcement;
import com.portal.transparencia.repository.AnnouncementRepository;

@RestController
@RequestMapping("/api/v1/anuncios")
public class AnnouncementController {

    @Autowired
    private AnnouncementRepository announcementRepository;

    @GetMapping
    public List<Announcement> listAllAnnouncements() {
        return announcementRepository.findAll();
    }

    @PostMapping
    public Announcement saveAnnouncement(@RequestBody Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Announcement> getAnnouncementById(@PathVariable Long id) {
        Announcement announcement = announcementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el anuncio con el ID: " + id));
        return ResponseEntity.ok(announcement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Announcement> updateAnnouncement(@PathVariable Long id, @RequestBody Announcement announcementDetails) {
        Announcement announcement = announcementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el anuncio con el ID: " + id));

        // Actualizar los campos del anuncio
        announcement.setContent(announcementDetails.getContent());
        announcement.setStartDate(announcementDetails.getStartDate());
        announcement.setEndDate(announcementDetails.getEndDate());

        Announcement updatedAnnouncement = announcementRepository.save(announcement);
        return ResponseEntity.ok(updatedAnnouncement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnouncement(@PathVariable Long id) {
        Announcement announcement = announcementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el anuncio con el ID: " + id));

        announcementRepository.delete(announcement);
        return ResponseEntity.noContent().build();
    }
}
