package com.fanou.jeu;

public class Chrono implements Runnable {
    
    @Override
    public void run(){
        while(true){
            try{
                int x = Main.background.getPosFond();
                x--;
                Main.background.setPosFond(x);
                Main.background.repaint();
                Thread.sleep(10);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
