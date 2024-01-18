package com.MysqlService.MysqlService.model;


import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cmd")
    private Long id_cmd;


    @Column(name = "id_user")
    private int id_user;

    @Column(name = "total")
    private float total;

    @Column(name = "statut")
    private String statut;

    @Column(name = "date_cmd")
    private LocalDate date_cmd;
    public Commande() {
    }

    public Commande(Long id_cmd, int id_user, float total, String statut, LocalDate date_cmd) {
        this.id_cmd = id_cmd;
        this.id_user = id_user;
        this.total = total;
        this.statut = statut;
        this.date_cmd = date_cmd;
    }

    public LocalDate getDate_cmd() {
        return date_cmd;
    }

    public void setDate_cmd(LocalDate date_cmd) {
        this.date_cmd = date_cmd;
    }

    public Long getId_cmd() {
        return id_cmd;
    }

    public void setId_cmd(Long id_cmd) {
        this.id_cmd = id_cmd;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}