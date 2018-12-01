/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author caios
 */
public class Indio {
    
    private int x, y; //coordenadas
    private int dx, dy;
    private int altura, largura;
    private boolean isVisivel;
    private Image imagem;
    private List<Flecha> flechas;
    
    public Indio() {
        ImageIcon referencia = new ImageIcon("res\\indioM.gif");
        imagem = referencia.getImage();
        
        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
        
        flechas = new ArrayList<Flecha>();   
        
        this.x = 100;
        this.y = 100;
    }
     
    public void mexer() {
        
        x += dx;
        y += dy;
        
        if(this.x < -18) {
            x = -18;
        }
        if(this.x > 770) {
            x = 770;
        }
        if(this.y < -16) {
            y = -16;
        }
        if(this.y > 478) {
            y = 478;
        }
        
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagem() {
        return imagem;
    }

    public List<Flecha> getFlechas() {
        return flechas;
    }

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setIsVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }
    
    
    
    public void atira() {
        this.flechas.add(new Flecha(x + largura, y + altura/2));
    }
    
      public Rectangle getBounds() {
        return new Rectangle(x, y, largura, altura);
    }
    
    public void keyPressed(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        
        if(codigo == KeyEvent.VK_SPACE) {
            this.atira();
        }
        
        if(codigo == KeyEvent.VK_UP) {
            dy = -5;
        }
        
        if(codigo == KeyEvent.VK_DOWN) {
            dy = 5;
        }
        if(codigo == KeyEvent.VK_LEFT) {
            dx = -5;
        }
        
        if(codigo == KeyEvent.VK_RIGHT) {
            dx = 5;
        }
        
    }
    
    public void keyReleased(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        
        if(codigo == KeyEvent.VK_UP) {
            dy = 0;
        }
        
        if(codigo == KeyEvent.VK_DOWN) {
            dy = 0;
        }
        if(codigo == KeyEvent.VK_LEFT) {
            dx = 0;
        }
        
        if(codigo == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
    
    
}
