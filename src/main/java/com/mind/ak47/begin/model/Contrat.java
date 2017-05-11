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
@Table(name = "contrat")
public class Contrat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code")
    private Integer code;
    @Basic(optional = false)
    @Column(name = "datedesignation")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date datedesignation;
    /*@Basic(optional = false)
    @Column(name = "mttc")
    private int mttc;*/
    @Basic(optional = false)
    @Column(name = "datesignature")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date datesignature;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mthtva")
    
    private double mthtva;
    @Basic(optional = false)
    @Column(name = "ptva")
    @Range(min=0, max=60)
    @NotNull
    private int ptva;
    @Basic(optional = false)
    @Column(name = "mttva")
    private double mttva;
    @Basic(optional = false)
    @Column(name = "mtttc")
    @NotNull
    private double mtttc;
    @Basic(optional = false)
    @Column(name = "liendoc")
    private String liendoc;
    @Basic(optional = false)
    @Lob
    @Column(name = "observation")
    private String observation;
     @Basic(optional = false)
    @Column(name = "numcontrat")
    private int numcontrat;
    @JoinColumn(name = "codeprojet", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Projetpublic codeprojet;
    public void setNumcontrat(int num){
    this.numcontrat=num;
    }
    public int getNumcontrat(){
    return this.numcontrat;
    }
    public Contrat() {
    }

    public Contrat(Integer code) {
        this.code = code;
    }

    public Contrat(Integer code, Date datedesignation, int mttc) {
        this.code = code;
        this.datedesignation = datedesignation;
        /*this.mttc = mttc;*/
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Date getDatedesignation() {
        return datedesignation;
    }

    public void setDatedesignation(Date datedesignation) {
        this.datedesignation = datedesignation;
    }
public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
    /*public int getMttc() {
        return mttc;
    }

    public void setMttc(int mttc) {
        this.mttc = mttc;
    }*/



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrat)) {
            return false;
        }
        Contrat other = (Contrat) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mind.ak47.begin.model.Contrat[ code=" + code + " ]";
    }

    public Date getDatesignature() {
        return datesignature;
    }

    public void setDatesignature(Date datesignature) {
        this.datesignature = datesignature;
    }

    public double getMthtva() {
        return mthtva;
    }

    public void setMthtva(double mthtva) {
        this.mthtva = mthtva;
    }

    public int getPtva() {
        return ptva;
    }

    public void setPtva(int ptva) {
        this.ptva = ptva;
    }

    public double getMttva() {
        return mttva;
    }

    public void setMttva(double mttva) {
        this.mttva = mttva;
    }

    public double getMtttc() {
        return mtttc;
    }

    public void setMtttc(double mtttc) {
        this.mtttc = mtttc;
    }

    public String getLiendoc() {
        return liendoc;
    }

    public void setLiendoc(String liendoc) {
        this.liendoc = liendoc;
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
    
}
