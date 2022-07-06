package com.fanou.jeu;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.fanou.objets.Tuyau;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

public class Background extends JPanel{ 
    private ImageIcon icoFond;
    private Image fond;
    private int posFond;
    private Tuyau tuyauHaut1;
    private Tuyau tuyauBas1;
    private Tuyau tuyauHaut2;
    private Tuyau tuyauBas2;
    private Tuyau tuyauHaut3;
    private Tuyau tuyauBas3;
    private int xTuyau;
    private int dxTuyau;

    private final int DISTANCE_TUYAUX = 250;
    private final int ECART_TUYAUX = 120;
    private Random rand;
    public Background(){
        super();
        icoFond = new ImageIcon(getClass().getResource("/assets/images/bandeFondEcran.png"));
        fond = icoFond.getImage();
        this.posFond = 0;
        this.xTuyau = 100;
        this.dxTuyau = 0;
        rand = new Random();
        tuyauHaut1 = new Tuyau(this.xTuyau, -150, "/assets/images/tuyauHaut.png");
        tuyauBas1 = new Tuyau(this.xTuyau,250,"/assets/images/tuyauBas.png");
        tuyauHaut2 = new Tuyau(this.xTuyau + this.DISTANCE_TUYAUX, -150, "/assets/images/tuyauHaut.png");
        tuyauBas2 = new Tuyau(this.xTuyau  + this.DISTANCE_TUYAUX,250,"/assets/images/tuyauBas.png");
        tuyauHaut3 = new Tuyau(this.xTuyau + this.DISTANCE_TUYAUX *2, -150, "/assets/images/tuyauHaut.png");
        tuyauBas3 = new Tuyau(this.xTuyau + this.DISTANCE_TUYAUX*2,250,"/assets/images/tuyauBas.png");
    
        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();
    }
    
    public int getPosFond(){
        return this.posFond;
    }

    public void setPosFond(int posFond){
        this.posFond = posFond;
    }

    public void deplacementFond(Graphics g){
        if(this.posFond == -140){
            this.posFond = 0;
        }
        g.drawImage(this.fond, this.posFond,0, null);
        g.drawImage(this.fond, this.posFond + 140,0,null);
        g.drawImage(this.fond, this.posFond  + 140 *2,0,null);
        g.drawImage(this.fond, this.posFond  + 140 *3,0,null);
    }

    public void deplacementTuyau(Graphics g){
        //Tuyau 1
        this.tuyauHaut1.setX(this.tuyauHaut1.getX() - 1);
        this.tuyauBas1.setX(this.tuyauBas1.getX());
        if(this.tuyauHaut1.getX() == -100){
            this.tuyauHaut1.setX(this.tuyauHaut3.getX() + this.DISTANCE_TUYAUX);
            this.tuyauHaut1.setY(-100 - 10 * this.rand.nextInt(18));
            this.tuyauBas1.setY(this.tuyauHaut1.getY() + this.tuyauHaut1.getHauteur() + this.ECART_TUYAUX);
        }
        g.drawImage(this.tuyauHaut1.getImgTuyau(),this.tuyauHaut1.getX(), this.tuyauHaut1.getY(), null);
        g.drawImage(this.tuyauBas1.getImgTuyau(),this.tuyauBas1.getX(), this.tuyauBas1.getY(), null);

        //Tuyau 2
        this.tuyauHaut2.setX(this.tuyauHaut2.getX() - 1);
        this.tuyauBas2.setX(this.tuyauBas2.getX());
        if(this.tuyauHaut2.getX() == -100){
            this.tuyauHaut2.setX(this.tuyauHaut2.getX() + this.DISTANCE_TUYAUX);
            this.tuyauHaut2.setY(-100 - 10 * this.rand.nextInt(18));
            this.tuyauBas2.setY(this.tuyauHaut2.getY() + this.tuyauHaut2.getHauteur() + this.ECART_TUYAUX);
        }
        g.drawImage(this.tuyauHaut2.getImgTuyau(),this.tuyauHaut2.getX(), this.tuyauHaut2.getY(), null);
        g.drawImage(this.tuyauBas2.getImgTuyau(),this.tuyauBas2.getX(), this.tuyauBas2.getY(), null);
        
        //Tuyau 3
        this.tuyauHaut3.setX(this.tuyauHaut3.getX() - 1);
        this.tuyauBas3.setX(this.tuyauBas3.getX());
        if(this.tuyauHaut3.getX() == -100){
            this.tuyauHaut3.setX(this.tuyauHaut3.getX() + this.DISTANCE_TUYAUX);
            this.tuyauHaut3.setY(-100 - 10 * this.rand.nextInt(18));
            this.tuyauBas3.setY(this.tuyauHaut3.getY() + this.tuyauHaut3.getHauteur() + this.ECART_TUYAUX);
        }
        g.drawImage(this.tuyauHaut3.getImgTuyau(),this.tuyauHaut3.getX(), this.tuyauHaut3.getY(), null);
        g.drawImage(this.tuyauBas3.getImgTuyau(),this.tuyauBas3.getX(), this.tuyauBas3.getY(), null);
        
    }

    @Override
    public void paintComponent(Graphics g){
        this.deplacementFond(g);
        this.deplacementTuyau(g);
    }
}
