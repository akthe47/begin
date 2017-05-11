/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.format.annotation.DateTimeFormat;



/**
 *
 * @author ak47@minduos
 */
@Entity
@Table(name = "projet")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Projet {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code")
    private Integer code;
    /*@Basic(optional = false)
    @Column(name = "annee")
    private short annee;*/
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
    @DateTimeFormat(pattern = "dd-MM-yyyy")
     @NotNull
    private Date datedebut;
    @Basic(optional = false)
    @Column(name = "datefin")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
     @NotNull
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
    private double montanttravaux;
    @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name="codeclient")
    private Client codeclient;
    

    public Projet() {
    }

    public Projet(Integer code) {
        this.code = code;
    }

    public Projet(Integer code, /*short annee,*/ String adresse, String description, Date datedebut, Date datefin, String personneacontacter, int numtel, String maitreouvrage, double montatnttravaux) {
        this.code = code;
        //this.annee = annee;
        this.adresse = adresse;
        this.description = description;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.personneacontacter = personneacontacter;
        this.numtel = numtel;
        this.maitreouvrage = maitreouvrage;
        this.montanttravaux = montatnttravaux;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    /*public short getAnnee() {
        return annee;
    }

    public void setAnnee(short annee) {
        this.annee = annee;
    }*/

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

    public double getMontanttravaux() {
        return montanttravaux;
    }

    public void setMontanttravaux(double montatnttravaux) {
        this.montanttravaux = montatnttravaux;
    }


    public Client getCodeclient() {
        Client vehiculeImpl;
        if (codeclient instanceof HibernateProxy) {
         // Véhicule proxifié
            HibernateProxy vehiculeProxy=(HibernateProxy) codeclient;
            vehiculeImpl=(Client) vehiculeProxy.getHibernateLazyInitializer().getImplementation();
        } else {
            // Véhicule véritable
            vehiculeImpl=codeclient;
    }
            return vehiculeImpl;
        
    }

    public void setCodeclient(Client codeclient) {
        this.codeclient = codeclient;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projet)) {
            return false;
        }
        Projet other = (Projet) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mind.ak47.begin.model.Projet[ code=" + code + " ]";
    }
    
}
