/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import jogo.containers.ContainerDeJanelas;

/**
 *
 * @author caios
 */
public class Inimigo {
    
    private Image imagem;
    private int x, y;
    private boolean isVisible;
    private int altura, largura;
    private static final int LARGURA_TELA = 900;
    private static int VELOCIDADE;
    
    public Inimigo(int x, int y) {
        this.x = x;
        this.y = y;
        
        if(ContainerDeJanelas.nivel == 1) {
            ImageIcon referencia = new ImageIcon("res\\teste.gif");
            imagem = referencia.getImage();
            this.VELOCIDADE = 2;
        }
        
        if(ContainerDeJanelas.nivel == 2) {
            ImageIcon referencia = new ImageIcon("res\\teste.gif");
            imagem = referencia.getImage();
            this.VELOCIDADE = 2;
        }
        if(ContainerDeJanelas.nivel == 3) {
            ImageIcon referencia = new ImageIcon("res\\inimigo1.png");
            imagem = referencia.getImage();
            this.VELOCIDADE = 3;
        }
        if(ContainerDeJanelas.nivel == 4) {
            ImageIcon referencia = new ImageIcon("res\\inimigo1.png");
            imagem = referencia.getImage();
            this.VELOCIDADE = 3;
        }
        if(ContainerDeJanelas.nivel == 5) {
            ImageIcon referencia = new ImageIcon("res\\cavaleiro.png");
            imagem = referencia.getImage();
            this.VELOCIDADE = 4;
        }
        if(ContainerDeJanelas.nivel == 6) {
            ImageIcon referencia = new ImageIcon("res\\cavaleiro.png");
            imagem = referencia.getImage();
            this.VELOCIDADE = 4;
        }
        
        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
        
        isVisible = true;
        
    }
    
    public void mexer() {
        
       if(this.x < -18) {
           this.x = LARGURA_TELA;
       } else {
           this.x -= VELOCIDADE;
       }
        
    }

    public Image getImagem() {
        return imagem;
    }

  //  public void setImagem(Image imagem) {
   //     this.imagem = imagem;
  //  }

    public int getX() {
        return x;
    }

  //  public void setX(int x) {
   //     this.x = x;
   // }

    public int getY() {
        return y;
    }

   // public void setY(int y) {
   //     this.y = y;
   // }

    public boolean isVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, largura, altura);
    }
    
    
    
    
}
