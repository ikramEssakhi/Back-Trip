package com.MysqlService.MysqlService.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Lignecommande")
public class LigneCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Lignecommande")
    private Long id_Lignecommande;




    @Column(name = "id_produit")
    private int id_produit;

    @Column(name = "qte")
    private int qte;

    @Column(name = "prix")
    private float prix;

    @Column(name = "id_cmd")
    private float id_cmd;


    public LigneCommande() {
    }

    public LigneCommande(Long id_Lignecommande, int id_produit, int qte, float prix, float id_cmd) {
        this.id_Lignecommande = id_Lignecommande;
        this.id_produit = id_produit;
        this.qte = qte;
        this.prix = prix;
        this.id_cmd = id_cmd;
    }

    public float getId_cmd() {
        return id_cmd;
    }

    public void setId_cmd(float id_cmd) {
        this.id_cmd = id_cmd;
    }

    public Long getId_Lignecommande() {
        return id_Lignecommande;
    }

    public void setId_Lignecommande(Long id_Lignecommande) {
        this.id_Lignecommande = id_Lignecommande;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}