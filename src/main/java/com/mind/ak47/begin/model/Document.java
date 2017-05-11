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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 *
 * @author ak47@minduos
 */
@Entity
@Table(name = "document")
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private Integer code;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Lob
    @Column(name = "path")
    private String path;
    @Basic(optional = false)
    @Column(name = "ext")
    private String ext;
    @Basic(optional = false)
    @Column(name = "num")
    private int num;
    @JoinColumn(name = "type", referencedColumnName = "code")
    @ManyToOne(fetch = FetchType.LAZY)
    private Typedoc type;
    @JoinColumn(name = "codeprojet", referencedColumnName = "code")
    @ManyToOne(fetch = FetchType.LAZY)
    private Projet codeprojet;


    public Document() {
    }

    public Document(Integer code) {
        this.code = code;
    }

    public Document(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Projet getProjet() {
        return codeprojet;
    }

    public void setProjet(Projet projet) {
        this.codeprojet = projet;
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
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mind.ak47.begin.model.Document[ code=" + code + " ]";
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Typedoc getType() {
        return type;
    }

    public void setType(Typedoc type) {
        this.type = type;
    }

    public Projet getCodeprojet() {
        return codeprojet;
    }

    public void setCodeprojet(Projet codeprojet) {
        this.codeprojet = codeprojet;
    }
    
}
