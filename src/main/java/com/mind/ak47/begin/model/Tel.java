/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ak47@minduos
 */
@Entity
@Table(name = "tel")
public class Tel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numtel")
    private Integer numtel;
    @Basic(optional = false)
    @Column(name = "indication")
    private String indication;
    @JoinColumn(name = "codeclient", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Client codeclient;

    public Tel() {
    }

    public Tel(Integer numtel) {
        this.numtel = numtel;
    }

    public Tel(Integer numtel, String indication) {
        this.numtel = numtel;
        this.indication = indication;
    }

    public Integer getNumtel() {
        return numtel;
    }

    public void setNumtel(Integer numtel) {
        this.numtel = numtel;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
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
        hash += (numtel != null ? numtel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tel)) {
            return false;
        }
        Tel other = (Tel) object;
        if ((this.numtel == null && other.numtel != null) || (this.numtel != null && !this.numtel.equals(other.numtel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mind.ak47.begin.model.Tel[ numtel=" + numtel + " ]";
    }
    
}
