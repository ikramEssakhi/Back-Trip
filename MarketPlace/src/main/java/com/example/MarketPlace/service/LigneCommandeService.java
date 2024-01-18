package com.example.MarketPlace.service;



import com.example.MarketPlace.model.LigneCommande;
import com.example.MarketPlace.repository.LigneCommandeRepository;
import com.example.MarketPlace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LigneCommandeService {

    private final LigneCommandeRepository ligneCommandeRepository;
    private final ProductRepository productRepository;

    @Autowired
    public LigneCommandeService(LigneCommandeRepository ligneCommandeRepository, ProductRepository productRepository) {
        this.ligneCommandeRepository = ligneCommandeRepository;
        this.productRepository = productRepository;
    }

    public List<LigneCommande> getAllLigneCommandes() {
        return ligneCommandeRepository.findAll();
    }

    public LigneCommande createLigneCommande(@RequestParam("id_produit") int id_produit,
                                             @RequestParam("qte") int qte,
                                             @RequestParam("prix") float prix,
                                             @RequestParam("id_cmd") float id_cmd) {
        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setId_produit(id_produit);
        ligneCommande.setQte(qte);
        ligneCommande.setPrix(prix);
        ligneCommande.setId_cmd(id_cmd);
        return ligneCommandeRepository.save(ligneCommande);
    }

    public List<LigneCommande> getLigneCommandesByCmdId(float idCmd) {
        return ligneCommandeRepository.findById_cmd(idCmd);
    }


}
