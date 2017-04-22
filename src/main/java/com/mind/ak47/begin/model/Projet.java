/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 *
 * @author ak47@minduos
 */
@Entity
@Table(name = "projet")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Projet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProjetPK projetPK;
    @Basic(optional = false)
    @Lob
    @Column(name = "adresse")
    private String adresse;
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "datedebut")
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Basic(optional = false)
    @Column(name = "datefin")
    @Temporal(TemporalType.DATE)
    private Date datefin;
    @Basic(optional = false)
    @Column(name = "personneacontacter")
    private String personneacontacter;
    @Basic(optional = false)
    @Column(name = "numtel")
    private int numtel;
    @Basic(optional = false)
    @Column(name = "maitreouvrage")
    private String maitreouvrage;
    @Basic(optional = false)
    @Column(name = "montatnttravaux")
    private double montatnttravaux;
    
    @JoinColumn(name = "codeclient", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Client codeclient;
    
    

    public Projet() {
    }

    public Projet(ProjetPK projetPK) {
        this.projetPK = projetPK;
    }

    public Projet(ProjetPK projetPK, String adresse, String description, Date datedebut, Date datefin, String personneacontacter, int numtel, String maitreouvrage, double montatnttravaux) {
        this.projetPK = projetPK;
        this.adresse = adresse;
        this.description = description;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.personneacontacter = personneacontacter;
        this.numtel = numtel;
        this.maitreouvrage = maitreouvrage;
        this.montatnttravaux = montatnttravaux;
    }

    public Projet(short annee, int code) {
        this.projetPK = new ProjetPK(annee, code);
    }

    public ProjetPK getProjetPK() {
        return projetPK;
    }

    public void setProjetPK(ProjetPK projetPK) {
        this.projetPK = projetPK;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public String getPersonneacontacter() {
        return personneacontacter;
    }

    public void setPersonneacontacter(String personneacontacter) {
        this.personneacontacter = personneacontacter;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public String getMaitreouvrage() {
        return maitreouvrage;
    }

    public void setMaitreouvrage(String maitreouvrage) {
        this.maitreouvrage = maitreouvrage;
    }

    public double getMontatnttravaux() {
        return montatnttravaux;
    }

    public void setMontatnttravaux(double montatnttravaux) {
        this.montatnttravaux = montatnttravaux;
    }



    public Client getCodeclient() {
        return codeclient;
    }

    public void setCodeclient(Client codeclient) {
        this.codeclient = codeclient;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projetPK != null ? projetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projet)) {
            return false;
        }
        Projet other = (Projet) object;
        if ((this.projetPK == null && other.projetPK != null) || (this.projetPK != null && !this.projetPK.equals(other.projetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mind.ak47.begin.model.Projet[ projetPK=" + projetPK + " ]";
    }
    
}
