package com.fanou.objets;

import java.awt.Image;

import javax.swing.ImageIcon;
public class Tuyau {
    private int largeur;
    private int hauteur;
    private int x;
    private int y;
    private String srcImg;
    private Image imgTuyau;
    public Tuyau(int x, int y,String srcImg){
        this.largeur = 50;
        this.hauteur = 300;
        this.x = x;
        this.y = y;
        this.srcImg = srcImg;
        this.imgTuyau = new ImageIcon(getClass().getResource(srcImg)).getImage();
    }


    public int getLargeur(){
        return this.largeur;
    }
    public void setLargeur(int largeur){
        this.largeur = largeur;
    }
    public int getHauteur(){
        return this.hauteur;
    }
    public void setHauteur(int hauteur){
        this.hauteur = hauteur;
    }
    public int getX(){
        return this.x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return this.y;
    }
    public void setY(int y){
        this.y = y;
    }
    public Image getImgTuyau(){
        return this.imgTuyau;
    }
}
