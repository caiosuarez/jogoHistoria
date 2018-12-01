    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.containers;

import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author caios
 */
public class ContainerTexto extends JFrame {
    
    private Image texto;
    
    
    public ContainerTexto(int nivel) {
        
        
        
         JButton botao = new JButton("avançar");
        setLayout(null);
        botao.setBounds(730, 527, 100, 60);
        getContentPane().add(botao);        
        
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new ContainerDeJanelas();
            }
        });
        if(nivel == 1) {
            ImageIcon referencia = new ImageIcon("res\\texto1F.jpg");
            texto = referencia.getImage();
        }
        if(nivel == 2) {
            ImageIcon referencia = new ImageIcon("res\\texto2.jpg");
            texto = referencia.getImage();
        }
        if(nivel == 3) {
            ImageIcon referencia = new ImageIcon("res\\texto3.jpg");
            texto = referencia.getImage();
        }
        if(nivel == 4) {
            ImageIcon referencia = new ImageIcon("res\\texto4.jpg");
            texto = referencia.getImage();
        }
        if(nivel == 5) {
            ImageIcon referencia = new ImageIcon("res\\texto5.jpg");
            texto = referencia.getImage();
        }
        if(nivel == 6) {
            ImageIcon referencia = new ImageIcon("res\\texto6.jpg");
            texto = referencia.getImage();
        }
        if(nivel == 7) {
            ImageIcon referencia = new ImageIcon("res\\textoDesfecho.jpg");
            texto = referencia.getImage();
            botao.setVisible(false);
            JButton sair = new JButton("sair");
            setLayout(null);
            sair.setBounds(730, 527, 100, 60);
            getContentPane().add(sair);        
        
            sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                System.exit(0);
            }
        });
            
            
            
        }
        
        setTitle("jogao");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 650);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
  
    }
    
        public void paint(Graphics g) {
        
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(texto, 0, 0, null);
                
        g.dispose();
        
    }
        
    


    
}
