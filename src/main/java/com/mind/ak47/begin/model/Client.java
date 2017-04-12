/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ak47@minduos
 */
@Entity
@Table(name = "client")
public class Client implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code",nullable=false)
    private Integer code;
    
    @NotEmpty
    @Column(name = "adresse",nullable=false)
    private String adresse;
    
    @NotEmpty
    @Column(name = "mail",nullable=false)
    private String mail;
    
     @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="codeville")
    private Ville codeville;
   

    public Client() {
    }

    public Client(Integer code) {
        this.code = code;
    }

    public Client(Integer code, String adresse, String mail) {
        this.code = code;
        this.adresse = adresse;
        this.mail = mail;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    public Ville getCodeville() {
        return codeville;
    }

    public void setCodeville(Ville codeville) {
        this.codeville = codeville;
    }



    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mind.ak47.begin.model.Client[ code=" + code + " ]";
    }
    
}
