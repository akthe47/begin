/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ak47@minduos
 */
@Entity
@Table(name = "document")
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocumentPK documentPK;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    
    @JoinColumn(name = "code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Projet projet;
    

    public Document() {
    }

    public Document(DocumentPK documentPK) {
        this.documentPK = documentPK;
    }

    public Document(DocumentPK documentPK, String description) {
        this.documentPK = documentPK;
        this.description = description;
    }

    public Document(short annee, int code, int numordre) {
        this.documentPK = new DocumentPK(annee, code, numordre);
    }

    public DocumentPK getDocumentPK() {
        return documentPK;
    }

    public void setDocumentPK(DocumentPK documentPK) {
        this.documentPK = documentPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentPK != null ? documentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.documentPK == null && other.documentPK != null) || (this.documentPK != null && !this.documentPK.equals(other.documentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mind.ak47.begin.model.Document[ documentPK=" + documentPK + " ]";
    }
    
}
