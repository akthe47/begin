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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ak47@minduos
 */
@Entity
@Table(name = "memoire")
public class Memoire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code")
    private Integer code;
    @Basic(optional = false)
    @Column(name = "nummemoire")
    private int nummemoire;
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
    @Column(name = "liendoc")
    private String liendoc;
    @Basic(optional = false)
    @Lob
    @Column(name = "observation")
    private String observation;
    @Basic(optional = false)
    @Column(name = "mtttc")
    @NotNull
    private double mtttc;
    @JoinColumn(name = "codeprojet", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Projetpublic codeprojet;

    public Memoire() {
    }

    public Memoire(Integer code) {
        this.code = code;
    }

    public Memoire(Integer code, int nummemoire, Date datedesignation, double mthtv, double ptva, double mttva, String liendoc, String observation, double mtttc) {
        this.code = code;
        this.nummemoire = nummemoire;
        this.datedesignation = datedesignation;
        this.mthtva = mthtv;
        this.ptva = ptva;
        this.mttva = mttva;
        this.liendoc = liendoc;
        this.observation = observation;
        this.mtttc = mtttc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public int getNummemoire() {
        return nummemoire;
    }

    public void setNummemoire(int nummemoire) {
        this.nummemoire = nummemoire;
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

    public void setMthtva(double mthtv) {
        this.mthtva = mthtv;
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

    public String getLiendoc() {
        return liendoc;
    }

    public void setLiendoc(String liendoc) {
        this.liendoc = liendoc;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public double getMtttc() {
        return mtttc;
    }

    public void setMtttc(double mtttc) {
        this.mtttc = mtttc;
    }

    

    public Projetpublic getCodeprojet() {
        Projetpublic vehiculeImpl;
        if (codeprojet instanceof HibernateProxy) {
         // Véhicule proxifié
            HibernateProxy vehiculeProxy=(HibernateProxy) codeprojet;
            vehiculeImpl=(Projetpublic) vehiculeProxy.getHibernateLazyInitializer().getImplementation();
        } else {
            // Véhicule véritable
            vehiculeImpl=codeprojet;
    }
            return vehiculeImpl;
    }

    public void setCodeprojet(Projetpublic codeprojet) {
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
        if (!(object instanceof Memoire)) {
            return false;
        }
        Memoire other = (Memoire) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mind.ak47.begin.model.Memoire[ code=" + code + " ]";
    }
    
}
