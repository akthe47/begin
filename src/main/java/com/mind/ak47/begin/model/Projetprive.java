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
@Table(name = "projetprive")

public class Projetprive extends Projet {

    
    @Basic(optional = false)
    @Column(name = "bc_existe")
    private short bcExiste;
    

    public Projetprive() {
    }

   

    public short getBcExiste() {
        return bcExiste;
    }

    public void setBcExiste(short bcExiste) {
        this.bcExiste = bcExiste;
    }

    
}
