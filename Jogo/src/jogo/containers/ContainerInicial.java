    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.containers;

import jogo.containers.ContainerTexto;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author caios
 */
public class ContainerInicial extends JFrame {
    
    private Image telaInicial;
    
    public ContainerInicial() {
        
        
     /*   
        JButton botao2 = new JButton("instrucoes");
        setLayout(null);
        botao2.setBounds(370, 170, 100, 60);
        getContentPane().add(botao2);        
        
        botao2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "Use as SETAS para movimentar o personagem e ESPAÇO para atirar.\n Elimine os inimigos e acerte as perguntas para passar de nível,\n cuidado para os inimigos não encostarem em você.", "Informações", JOptionPane.INFORMATION_MESSAGE);
                
            }
        });
    */    
        JButton botao = new JButton("iniciar");
        setLayout(null);
        botao.setBounds(370, 274, 100, 60);
        getContentPane().add(botao);        
        
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new ContainerTexto(ContainerDeJanelas.nivel);
            }
        });
        

        ImageIcon referencia = new ImageIcon("res\\inicial.png");
        telaInicial = referencia.getImage();
        setTitle("jogao");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
     public void paint(Graphics g) {
        
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(telaInicial, 0, 0, null);
                
        g.dispose();  
    }
     
   
    
    
    
}
