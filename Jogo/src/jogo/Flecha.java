/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author caios
 */
public class Flecha {
    
    private Image imagem;
    private int x, y;
    private int largura, altura;
    private boolean isVisible;
    
    private static final int LARGURA_TELA = 900;
    private static final int VELOCIDADE = 6;
    
    public Flecha(int x, int y) {
        this.x = x;
        this.y = y;
        
        ImageIcon referencia = new ImageIcon("res\\flecha.png");
        imagem = referencia.getImage();
        
        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
        
        isVisible = true;
        
    }
    
    public void mexer() {
        
        this.x += VELOCIDADE;
        if(this.x > LARGURA_TELA) {
            isVisible = false;
        }
    }

    public Image getImagem() {
        return imagem;
    }

  //  public void setImagem(Image imagem) {
    //    this.imagem = imagem;
   // }

    public int getX() {
        return x;
    }

  //  public void setX(int x) {
  //      this.x = x;
  //  }

    public int getY() {
        return y;
    }

  //  public void setY(int y) {
    //    this.y = y;
  //  }

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
