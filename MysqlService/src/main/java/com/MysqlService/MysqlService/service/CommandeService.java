package com.MysqlService.MysqlService.service;


import com.MysqlService.MysqlService.exception.ResourceNotFoundException;
import com.MysqlService.MysqlService.model.Commande;
import com.MysqlService.MysqlService.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;

    @Autowired
    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public Commande createCommande(Commande commande) {
        commande.setDate_cmd(LocalDate.now());
        return commandeRepository.save(commande);
    }

    public ResponseEntity<Commande> updateStatut(Long id, String statut) {
        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Commande not found with id: " + id));

        commande.setStatut(statut);
        Commande updatedCommande = commandeRepository.save(commande);
        return ResponseEntity.ok(updatedCommande);
    }

    public ResponseEntity<Map<String, Boolean>> deleteCommande(Long id) {
        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Commande not found with id: " + id));

        commandeRepository.delete(commande);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
