/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ak47@minduos
 */
@Entity
@Table(name = "facture")

public class Facture implements Serializable {

     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code")
    private Integer code;
    @Basic(optional = false)
    @Column(name = "numfacture")
    private int numfacture;
    @Basic(optional = false)
    @Column(name = "datedesignation")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
     @NotNull
    private Date datedesignation;
    @Basic(optional = false)
    @Column(name = "mthtva")
    @NotNull
    private double mthtva;
    @Basic(optional = false)
    @Column(name = "ptva")
    @Range(min=0, max=60)
    @NotNull
    private double ptva;
    @Basic(optional = false)
    @Column(name = "mttva")
    private double mttva;
    @Basic(optional = false)
    @Lob
    @Column(name = "observation")
    private String observation;
    @Basic(optional = false)
    @Column(name = "liendoc")
    private String liendoc;
    @Basic(optional = false)
    @Column(name = "mtttc")
    @NotNull
    private double mtttc;
    @JoinColumn(name = "codeprojet", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Projetprive codeprojet;

    public Facture() {
    }

    public Facture(Integer code) {
        this.code = code;
    }

    public Facture(Integer code, int numfacture, Date datedesignation, double mthtva, double ptva, double mttva, String observation, String liendoc, double mttc) {
        this.code = code;
        this.numfacture = numfacture;
        this.datedesignation = datedesignation;
        this.mthtva = mthtva;
        this.ptva = ptva;
        this.mttva = mttva;
        this.observation = observation;
        this.liendoc = liendoc;
        this.mtttc = mttc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public int getNumfacture() {
        return numfacture;
    }

    public void setNumfacture(int numfacture) {
        this.numfacture = numfacture;
    }

    public Date getDatedesignation() {
        return datedesignation;
    }

    public void setDatedesignation(Date datedesignation) {
        this.datedesignation = datedesignation;
    }

    public double getMthtva() {
        return mthtva;
    }

    public void setMthtva(double mthtva) {
        this.mthtva = mthtva;
    }

    public double getPtva() {
        return ptva;
    }

    public void setPtva(double ptva) {
        this.ptva = ptva;
    }

    public double getMttva() {
        return mttva;
    }

    public void setMttva(double mttva) {
        this.mttva = mttva;
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

    public double getMtttc() {
        return mtttc;
    }

    public void setMtttc(double mttc) {
        this.mtttc = mttc;
    }


    public Projetprive getCodeprojet() {
        Projetprive vehiculeImpl;
        if (codeprojet instanceof HibernateProxy) {
         // Véhicule proxifié
            HibernateProxy vehiculeProxy=(HibernateProxy) codeprojet;
            vehiculeImpl=(Projetprive) vehiculeProxy.getHibernateLazyInitializer().getImplementation();
        } else {
            // Véhicule véritable
            vehiculeImpl=codeprojet;
    }
            return vehiculeImpl;
    }

    public void setCodeprojet(Projetprive codeprojet) {
        this.codeprojet = codeprojet;
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
        if (!(object instanceof Facture)) {
            return false;
        }
        Facture other = (Facture) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mind.ak47.begin.model.Facture[ code=" + code + " ]";
    }
    
}
