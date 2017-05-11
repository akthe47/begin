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

/**
 *
 * @author ak47@minduos
 */
@Entity
@Table(name = "avenant")
public class Avenant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code")
    private Integer code;
    @Basic(optional = false)
    @Column(name = "numavenant")
    private int numavenant;
    @Basic(optional = false)
    @Column(name = "datedesignation")
    @Temporal(TemporalType.DATE)
    private Date datedesignation;
    @Basic(optional = false)
    @Column(name = "mthtv")
    private double mthtv;
    @Basic(optional = false)
    @Column(name = "ptva")
    private double ptva;
    @Basic(optional = false)
    @Column(name = "mttva")
    private double mttva;
    @Basic(optional = false)
    @Column(name = "mtttc")
    private double mtttc;
    @Basic(optional = false)
    @Lob
    @Column(name = "observation")
    private String observation;
    @Basic(optional = false)
    @Column(name = "liendoc")
    private String liendoc;
    @JoinColumn(name = "codeprojet", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Projetpublic codeprojet;

    public Avenant() {
    }

    public Avenant(Integer code) {
        this.code = code;
    }

    public Avenant(Integer code, int numavenant, Date datedesignation, double mthtv, double ptva, double mttva, double mtttc, String observation, String liendoc) {
        this.code = code;
        this.numavenant = numavenant;
        this.datedesignation = datedesignation;
        this.mthtv = mthtv;
        this.ptva = ptva;
        this.mttva = mttva;
        this.mtttc = mtttc;
        this.observation = observation;
        this.liendoc = liendoc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public int getNumavenant() {
        return numavenant;
    }

    public void setNumavenant(int numavenant) {
        this.numavenant = numavenant;
    }

    public Date getDatedesignation() {
        return datedesignation;
    }

    public void setDatedesignation(Date datedesignation) {
        this.datedesignation = datedesignation;
    }

    public double getMthtv() {
        return mthtv;
    }

    public void setMthtv(double mthtv) {
        this.mthtv = mthtv;
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

    public double getMtttc() {
        return mtttc;
    }

    public void setMtttc(double mtttc) {
        this.mtttc = mtttc;
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

    public Projetpublic getCodeprojet() {
        return codeprojet;
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
        if (!(object instanceof Avenant)) {
            return false;
        }
        Avenant other = (Avenant) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mind.ak47.begin.model.Avenant[ code=" + code + " ]";
    }
    
}
