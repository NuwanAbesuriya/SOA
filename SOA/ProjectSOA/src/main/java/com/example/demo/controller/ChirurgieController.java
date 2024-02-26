package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ChirurgieService;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/chirurgies")
public class ChirurgieController {

    private final ChirurgieService chirurgieService;

    @Autowired
    public ChirurgieController(ChirurgieService chirurgieService) {
        this.chirurgieService = chirurgieService;
    }
    
    
    @GetMapping("/all")
    public ResponseEntity<List<Chirurgie>> getAllChirurgies() {
        List<Chirurgie> chirurgies = chirurgieService.getAllChirurgies();
        return ResponseEntity.ok(chirurgies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chirurgie> getChirurgieById(@PathVariable Long id) {
        return ResponseEntity.of(chirurgieService.getChirurgieById(id));
    }
    /*

    @GetMapping("/searchByDate")
    public ResponseEntity<List<Chirurgie>> searchChirurgiesByDateBetween(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
        List<Chirurgie> chirurgies = chirurgieService.searchChirurgiesByDateBetween(dateDebut, dateFin);
        return ResponseEntity.ok(chirurgies);
    */
    
    @PostMapping("/add")
    public ResponseEntity<Chirurgie> addChirurgie(@RequestBody Chirurgie chirurgie) {
    	
        Chirurgie addedChirurgie = chirurgieService.saveChirurgie(chirurgie);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedChirurgie);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Chirurgie> updateChirurgie(@PathVariable Long id, @RequestBody Chirurgie chirurgie) {
        return chirurgieService.getChirurgieById(id)
                .map(existingChirurgie -> {
                    chirurgie.setId(id);
                    Chirurgie updatedChirurgie = chirurgieService.saveChirurgie(chirurgie);
                    return ResponseEntity.ok(updatedChirurgie);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteChirurgie(@PathVariable Long id) {
        if (chirurgieService.getChirurgieById(id).isPresent()) {
            chirurgieService.deleteChirurgie(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
