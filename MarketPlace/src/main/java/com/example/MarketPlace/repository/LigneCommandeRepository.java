package com.example.MarketPlace.repository;


import com.example.MarketPlace.model.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long> {

    @Query("SELECT lc FROM LigneCommande lc WHERE lc.id_cmd = :idCmd")
    List<LigneCommande> findById_cmd(float idCmd);

}