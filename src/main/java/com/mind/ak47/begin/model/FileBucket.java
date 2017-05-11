/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.model;

/**
 *
 * @author ak47@minduos
 */


import org.springframework.web.multipart.MultipartFile;
 
public class FileBucket {
 
    MultipartFile file;
    public FileBucket(){};
     
    public MultipartFile getFile() {
        return file;
    }
 
    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
