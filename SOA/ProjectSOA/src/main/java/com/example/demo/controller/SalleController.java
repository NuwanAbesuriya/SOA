package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Salle;
import com.example.demo.service.SalleService;
import java.util.List;

@RestController
@RequestMapping("/salles")
public class SalleController {

    private final SalleService salleService;

    @Autowired
    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Salle>> getAllSalles() {
        List<Salle> salles = salleService.getAllSalles();
        return ResponseEntity.ok(salles);
    }


    @GetMapping("/{salleid}")
    public ResponseEntity<Salle> getSalleById(@PathVariable Long salleid) {
        return ResponseEntity.of(salleService.getSalleById(salleid));
    }

    @GetMapping("/searchByType/{type}")
    public ResponseEntity<List<Salle>> searchSallesByType(@PathVariable String type) {
        List<Salle> salles = salleService.searchSallesByType(type);
        return ResponseEntity.ok(salles);
    }


    @PostMapping("/add")
    public ResponseEntity<Salle> addSalle(@RequestBody Salle salle) {
        Salle addedSalle = salleService.saveSalle(salle);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedSalle);
    }

    @PutMapping("/update/{salleid}")
    public ResponseEntity<Salle> updateSalle(@PathVariable Long salleid, @RequestBody Salle salle) {
        return salleService.getSalleById(salleid)
                .map(existingSalle -> {
                    salle.setId(salleid);
                    Salle updatedSalle = salleService.saveSalle(salle);
                    return ResponseEntity.ok(updatedSalle);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{salleid}")
    public ResponseEntity<Void> deleteSalle(@PathVariable Long salleid) {
        if (salleService.getSalleById(salleid).isPresent()) {
            salleService.deleteSalle(salleid);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
