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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

/**
 *
 * @author ak47@minduos
 */
@Embeddable
public class DocumentPK implements Serializable {

    /*@Basic(optional = false)
    @Column(name = "annee")
    private short annee;
    @Basic(optional = false)
    @Column(name = "code")
    private int code;
    @Basic(optional = false)
    @Column(name = "numordre")
    private int numordre;*/
    ProjetPK p;
    @Basic(optional = false)
    @Column(name = "numordre")
     private int numordre;
    
    
    public DocumentPK() {
    }

    public DocumentPK(ProjetPK p, int numordre) {
        this.p=p;
        this.numordre = numordre;
    }


    public int getNumordre() {
        return numordre;
    }

    public void setNumordre(int numordre) {
        this.numordre = numordre;
    }

/*

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentPK)) {
            return false;
        }
        DocumentPK other = (DocumentPK) object;
        if (this.annee != other.annee) {
            return false;
        }
        if (this.code != other.code) {
            return false;
        }
        if (this.numordre != other.numordre) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mind.ak47.begin.model.DocumentPK[ annee=" + annee + ", code=" + code + ", numordre=" + numordre + " ]";
    }
    */
}
