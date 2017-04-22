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
@Table(name = "projetpublic")
public class Projetpublic extends Projet {

    
    @Basic(optional = false)
    @Column(name = "ch_existe")
    private short chExiste;
    @Basic(optional = false)
    @Column(name = "av_existe")
    private short avExiste;
    

    public Projetpublic() {
    }

    

    public short getChExiste() {
        return chExiste;
    }

    public void setChExiste(short chExiste) {
        this.chExiste = chExiste;
    }

    public short getAvExiste() {
        return avExiste;
    }

    public void setAvExiste(short avExiste) {
        this.avExiste = avExiste;
    }



 
    
}
