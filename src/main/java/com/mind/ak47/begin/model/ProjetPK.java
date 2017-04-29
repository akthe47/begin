/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ak47@minduos
 */
@Embeddable
public class ProjetPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "annee")
     short annee;
    @Basic(optional = false)
    @Column(name = "code")
     int code;

    public ProjetPK() {
    }

    public ProjetPK(short annee, int code) {
        this.annee = annee;
        this.code = code;
    }

    public short getAnnee() {
        return annee;
    }

    public void setAnnee(short annee) {
        this.annee = annee;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) annee;
        hash += (int) code;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjetPK)) {
            return false;
        }
        ProjetPK other = (ProjetPK) object;
        if (this.annee != other.annee) {
            return false;
        }
        if (this.code != other.code) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mind.ak47.begin.model.ProjetPK[ annee=" + annee + ", code=" + code + " ]";
    }
    
}
