/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import jogo.perguntas.ContainerPergunta;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.Timer;
import jogo.containers.ContainerDeJanelas;
import jogo.perguntas.ContainerPergunta2;
import jogo.perguntas.ContainerPergunta3;
import jogo.perguntas.ContainerPergunta4;
import jogo.perguntas.ContainerPergunta5;
import jogo.perguntas.ContainerPergunta6;

/**
 *
 * @author caios
 */
public class Fase extends JPanel implements ActionListener{
    
    private Image fundo;
    private Indio indio;
    private Timer timer;
    private boolean avanca;
    
    
    private boolean emJogo;
    
    private List<Inimigo> inimigos;
    
        private int[][] coordenadas = { { 2380, 10 }, { 2600, 49 }, { 1380, 89 },
   { 780, 119 }, { 580, 159 }, { 880, 239 }, { 790, 269 },
   { 760, 360 }, { 790, 140 }, { 1980, 209 }, { 560, 35 }, { 510, 70 },
   { 930, 179 }, { 590, 310 }, { 530, 60 }, { 940, 59 }, { 990, 130 },
   { 920, 200 }, { 900, 259 }, { 660, 470 }, { 540, 90 }, { 810, 220 },
   { 860, 350 }, { 740, 380 }, { 820, 410 }, { 490, 435}, { 700, 460 },
   { 920, 300 }, { 856, 328 }, { 456, 320 } };
    
    
    public Fase(int nivel) {
        
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(new TecladoAdapter());
        
        if(nivel == 1) {
            ImageIcon referencia = new ImageIcon("res\\fundot4.jpg");
            this.fundo = referencia.getImage();
        }
        if(nivel == 2) {
            ImageIcon referencia = new ImageIcon("res\\fundot4.jpg");
            this.fundo = referencia.getImage();
        }
        if(nivel == 3) {
            ImageIcon referencia = new ImageIcon("res\\fundop1.jpg");
            this.fundo = referencia.getImage();
        }
        if(nivel == 4) {
            ImageIcon referencia = new ImageIcon("res\\fundop1.jpg");
            this.fundo = referencia.getImage();
        }
        if(nivel == 5) {
            ImageIcon referencia = new ImageIcon("res\\fundo.png");
            this.fundo = referencia.getImage();
        }
        if(nivel == 6) {
            ImageIcon referencia = new ImageIcon("res\\fundo.png");
            this.fundo = referencia.getImage();
        }
                
        indio = new Indio();
        inimigos = new ArrayList<>();
        
        emJogo = true;
        avanca = false;
        inicializaInimigos();
        
        timer = new Timer(5, this);
        timer.start();
    }
    
    public void inicializaInimigos() {
        for(int i = 0; i < coordenadas.length; i++) {
            inimigos.add(new Inimigo(coordenadas[i][0], coordenadas[i][1]));
        }
    }
    
    public void removeInimigos() {
        inimigos.removeAll(inimigos);
    }
    
    public void paint(Graphics g) {
        
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);
        
        if(emJogo) {
            
            graficos.drawImage(indio.getImagem(), indio.getX(), indio.getY(), this);

            List<Flecha> flechas = indio.getFlechas();
            for(int i = 0; i < flechas.size(); i++) {
                Flecha f = (Flecha) flechas.get(i);
                graficos.drawImage(f.getImagem(), f.getX(), f.getY(), this);
            }

            for(int i = 0; i < inimigos.size(); i++) {
                Inimigo in = (Inimigo) inimigos.get(i);
                graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
            }
        graficos.setColor(Color.red);
        graficos.drawString("INIMIGOS: " + inimigos.size(), 384, 15);
        
         } else {
            ImageIcon fimJogo = new ImageIcon("res//game_over.jpg");
            
            
            graficos.drawImage(fimJogo.getImage(), 0, 0, null);
        }
        
        if(avanca) {
            this.avanca = false;
            if(ContainerDeJanelas.nivel == 1) {
                ContainerPergunta pergunta = new ContainerPergunta(this);
            }
            if(ContainerDeJanelas.nivel == 2) {
                ContainerPergunta2 pergunta2 = new ContainerPergunta2(this);
            }
            if(ContainerDeJanelas.nivel == 3) {
                ContainerPergunta3 pergunta3 = new ContainerPergunta3(this);
            }
            if(ContainerDeJanelas.nivel == 4) {
                ContainerPergunta4 pergunta4 = new ContainerPergunta4(this);
            }
            if(ContainerDeJanelas.nivel == 5) {
                ContainerPergunta5 pergunta5 = new ContainerPergunta5(this);
            }
            if(ContainerDeJanelas.nivel == 6) {
                ContainerPergunta6 pergunta6 = new ContainerPergunta6(this);
            }
            
            
        }
        
        g.dispose();
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(inimigos.size() == 0) {     //verifica se todos os inimigos morreram, pra testar se ganhou o jogo, entao da pra mudar esse depois, se for mudar aquilo de que so vem 30 inimigos
           avanca = true;
           Inimigo e = new Inimigo(915, 910);
           inimigos.add(e);
            
        }
        
        List<Flecha> flechas = indio.getFlechas();
        for(int i = 0; i < flechas.size(); i++) {
            Flecha f = (Flecha) flechas.get(i);
            if(f.isVisible()) {
                f.mexer();
            } else {
                flechas.remove(i);
            }
        }
        
         for(int i = 0; i < inimigos.size(); i++) {
            Inimigo in = (Inimigo) inimigos.get(i);
            if(in.isVisible()) {
                in.mexer();
            } else {
                inimigos.remove(i);
            }
        }
        
        indio.mexer();
        checarColisoes();   
        repaint();
    }
    
    public void checarColisoes() {
        
        Rectangle formaIndio = indio.getBounds();
        Rectangle formaInimigo;
        Rectangle formaFlecha;
        
        for(int i = 0; i < inimigos.size(); i++) {
            Inimigo tempInimigo = inimigos.get(i);
            formaInimigo = tempInimigo.getBounds();
            if(formaIndio.intersects(formaInimigo)){
                indio.setIsVisivel(false);
                tempInimigo.setIsVisible(false);
                emJogo = false;
            }
        }
        
        List<Flecha> flechas = indio.getFlechas();
        
        for(int i = 0; i < flechas.size(); i++) {
            Flecha tempFlecha = flechas.get(i);
            formaFlecha = tempFlecha.getBounds();
            
            for(int j = 0; j < inimigos.size(); j++) {
                Inimigo tempInimigo = inimigos.get(j);
                formaInimigo = tempInimigo.getBounds();
                
                if(formaFlecha.intersects(formaInimigo)) {
                    tempInimigo.setIsVisible(false);
                    tempFlecha.setIsVisible(false);
                }
            }
        }
        
    }

    public void fimJogo() {
        this.emJogo = false;
   
    }
    
    public void gameMaster() {      //remover antes de entregar!!!
        this.removeInimigos();
    }
    
    private class TecladoAdapter extends KeyAdapter{
        
        
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                emJogo = true;
                indio = new Indio();
                removeInimigos();
                inicializaInimigos();              
                
            }
            
            if(e.getKeyCode() == KeyEvent.VK_END) { //so pra testeee, remover depois
                gameMaster();
            }
            
            indio.keyPressed(e);
        }
        
        public void keyReleased(KeyEvent e) {
            indio.keyReleased(e);
        }
    }
    
}
