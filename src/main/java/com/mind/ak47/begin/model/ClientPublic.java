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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ak47@minduos
 */
@Entity
@Table(name = "client_public")
public class ClientPublic implements Serializable {

    
    @Id
    @Column(name = "code")
    private Integer code;
    
    @NotEmpty
    @Column(name = "nom")
    private String nom;
    
    @OneToOne(optional = false,fetch = FetchType.LAZY)
    @JoinTable(name = "client", 
             joinColumns = { @JoinColumn(name = "code",nullable=false) })
    private Client client;

    public ClientPublic() {
    }

    public ClientPublic(Integer code) {
        this.code = code;
    }

    public ClientPublic(Integer code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientPublic)) {
            return false;
        }
        ClientPublic other = (ClientPublic) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mind.ak47.begin.model.ClientPublic[ code=" + code + " ]";
    }
    
}
