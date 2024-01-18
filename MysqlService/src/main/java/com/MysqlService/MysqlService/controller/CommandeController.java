package com.MysqlService.MysqlService.controller;


import com.MysqlService.MysqlService.model.Commande;
import com.MysqlService.MysqlService.service.CommandeService;
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
            @RequestParam String statut
    ) {
        return commandeService.updateStatut(id, statut);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCommande(@PathVariable Long id) {
        return commandeService.deleteCommande(id);
    }
}

