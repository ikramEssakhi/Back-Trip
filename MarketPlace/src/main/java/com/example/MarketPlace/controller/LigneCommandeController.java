package com.example.MarketPlace.controller;

import com.example.MarketPlace.model.LigneCommande;
import com.example.MarketPlace.service.LigneCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/Lignecmd/")
public class LigneCommandeController {

    private final LigneCommandeService ligneCommandeService;

    @Autowired
    public LigneCommandeController(LigneCommandeService ligneCommandeService) {
        this.ligneCommandeService = ligneCommandeService;
    }

    @GetMapping("/Lignecommandes")
    public List<LigneCommande> getAllLigneCommandes() {
        return ligneCommandeService.getAllLigneCommandes();
    }

    @PostMapping("/lignecommandes")
    public LigneCommande createLigneCommande(@RequestBody LigneCommande ligneCommande) {
        return ligneCommandeService.createLigneCommande(ligneCommande.getId_produit(),
                ligneCommande.getQte(),
                ligneCommande.getPrix(),
                ligneCommande.getId_cmd());
    }

    @GetMapping("/lignecommandes/{idCmd}")
    public List<LigneCommande> getLigneCommandesByCmdId(@PathVariable float idCmd) {
        return ligneCommandeService.getLigneCommandesByCmdId(idCmd);
    }




}
