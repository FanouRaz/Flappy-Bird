package com.fanou.jeu;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main extends JFrame {
    public static Background background;
    public Main(){
        background = new Background();
        this.setIconImage(new ImageIcon(getClass().getResource("/assets/images/oiseau2.png")).getImage());
        this.setTitle("Flappy bird");
        this.setSize(300,425);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(background);
        this.setVisible(true);
    }
    public static void main(String[] args){
        new Main();
    }
}