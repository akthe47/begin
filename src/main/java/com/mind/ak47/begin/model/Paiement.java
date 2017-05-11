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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ak47@minduos
 */
@Entity
@Table(name = "paiement")

public class Paiement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "datereception")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    @NotNull
    @Past
    private Date datereception;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numpaiement")
    private Integer numpaiement;
    @NotNull
    @Basic(optional = false)
    @Column(name = "mttc")
    private double mttc;
    @Basic(optional = false)
    @Lob
    @Column(name = "observation")
    private String observation;
    @Basic(optional = false)
    @Column(name = "liendoc")
    private String liendoc;
    @JoinColumn(name = "codemem", referencedColumnName = "code")
    @ManyToOne
    private Memoire codemem;
    @JoinColumn(name = "codefact", referencedColumnName = "code")
    @ManyToOne
    private Facture codefact;
    @JoinColumn(name = "mode", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Modepaiement mode;

    public Paiement() {
    }

    public Paiement(Integer numpaiement) {
        this.numpaiement = numpaiement;
    }

    public Paiement(Integer numpaiement, int code, double mttc, String observation, String liendoc) {
        this.numpaiement = numpaiement;
        //this.code = code;
        this.mttc = mttc;
        this.observation = observation;
        this.liendoc = liendoc;
    }

    public Date getDatereception() {
        return datereception;
    }

    public void setDatereception(Date datereception) {
        this.datereception = datereception;
    }

    public Integer getNumpaiement() {
        return numpaiement;
    }

    public void setNumpaiement(Integer numpaiement) {
        this.numpaiement = numpaiement;
    }

    public double getMttc() {
        return mttc;
    }

    public void setMttc(double mttc) {
        this.mttc = mttc;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getLiendoc() {
        return liendoc;
    }

    public void setLiendoc(String liendoc) {
        this.liendoc = liendoc;
    }

    public Memoire getCodemem() {
        return codemem;
    }

    public void setCodemem(Memoire codemem) {
        this.codemem = codemem;
    }

    public Facture getCodefact() {
        return codefact;
    }

    public void setCodefact(Facture codefact) {
        this.codefact = codefact;
    }

    public Modepaiement getMode() {
        return mode;
    }

    public void setMode(Modepaiement mode) {
        this.mode = mode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numpaiement != null ? numpaiement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paiement)) {
            return false;
        }
        Paiement other = (Paiement) object;
        if ((this.numpaiement == null && other.numpaiement != null) || (this.numpaiement != null && !this.numpaiement.equals(other.numpaiement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mind.ak47.begin.model.Paiement[ numpaiement=" + numpaiement + " ]";
    }
    
}
