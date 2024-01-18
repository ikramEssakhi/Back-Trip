package com.example.MarketPlace.controller;

import com.example.MarketPlace.model.Commande;
import com.example.MarketPlace.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/commandes")
@CrossOrigin(origins = "http://localhost:3000")
public class CommandeController {

    private final CommandeService commandeService;

    @Autowired
    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping("/getAll")
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    @PostMapping("/create")
    public Commande createCommande(@RequestBody Commande commande) {
        return commandeService.createCommande(commande);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Commande> updateStatut(
            @PathVariable Long id,
            @RequestBody Map<String, String> requestBody
    ) {
        String statut = requestBody.get("statut");
        return commandeService.updateStatut(id, statut);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCommande(@PathVariable Long id) {
        return commandeService.deleteCommande(id);
    }
}

