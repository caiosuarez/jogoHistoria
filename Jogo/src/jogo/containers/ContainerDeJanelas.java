/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.containers;

import jogo.containers.ContainerInicial;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import jogo.Fase;

/**
 *
 * @author caios
 */
public class ContainerDeJanelas extends JFrame {
    
    public static int nivel = 1;
    
   
    
    public ContainerDeJanelas() {
        
        JMenuBar barraMenu = new JMenuBar();
        
        JMenu menu = new JMenu("Menu");
        
        JMenuItem sobre = new JMenuItem("Sobre");
        sobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                JOptionPane.showMessageDialog(null, "Aplicação criada por Arthur, Caio e Gabriel. Projetada para aprender sobre a história do nosso País de uma forma descontraida", "Informações", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        JMenuItem sair = new JMenuItem("Sair");
        sair.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });   
        
        menu.add(sobre);
        menu.add(new JSeparator());
        menu.add(sair);
        
        barraMenu.add(menu);
        
        setJMenuBar(barraMenu);
        
     
        add(new Fase(nivel));
        setTitle("jogao");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(900, 670);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
    }
    

    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ContainerInicial inicial = new ContainerInicial();
        
        
        
        
        
        
       // new ContainerDeJanelas();
       
       
    }
    
}
