package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Medecin;
import com.example.demo.service.MedecinService;
import java.util.List;

@RestController
@RequestMapping("/medecins")
public class MedecinController {

    private final MedecinService medecinService;

    @Autowired
    public MedecinController(MedecinService medecinService) {
        this.medecinService = medecinService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Medecin>> getAllMedecins() {
        List<Medecin> medecins = medecinService.getAllMedecins();
        return ResponseEntity.ok(medecins);
    }

    @GetMapping("/{medecinid}")
    public ResponseEntity<Medecin> getMedecinById(@PathVariable Long medecinid) {
        return ResponseEntity.of(medecinService.getMedecinById(medecinid));
    }

    @GetMapping("/searchMedecinsBySpecialite")
    public ResponseEntity<List<Medecin>> searchMedecinsBySpecialite(
            @RequestParam String specialite) {
        List<Medecin> medecins = medecinService.searchMedecinsBySpecialite(specialite);
        return ResponseEntity.ok(medecins);
    }

    @PostMapping("/add")
    public ResponseEntity<Medecin> addMedecin(@RequestBody Medecin medecin) {
        Medecin addedMedecin = medecinService.saveMedecin(medecin);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedMedecin);
    }

    @PutMapping("/update/{medecinid}")
    public ResponseEntity<Medecin> updateMedecin(@PathVariable Long medecinid, @RequestBody Medecin medecin) {
        return medecinService.getMedecinById(medecinid)
                .map(existingMedecin -> {
                    medecin.setId(medecinid);
                    Medecin updatedMedecin = medecinService.saveMedecin(medecin);
                    return ResponseEntity.ok(updatedMedecin);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{medecinid}")
    public ResponseEntity<Void> deleteMedecin(@PathVariable Long medecinid) {
        if (medecinService.getMedecinById(medecinid).isPresent()) {
            medecinService.deleteMedecin(medecinid);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
