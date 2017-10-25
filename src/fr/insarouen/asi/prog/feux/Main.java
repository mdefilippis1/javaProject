/*
 * Main.java
 *
 * Created on 20 juin 2006, 17:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package fr.insarouen.asi.prog.feux;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.util.Observer;
import java.util.Observable;

/**
 *
 * @author nicolas
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Feu feu = new Feu(Feu.Etat.ARRET);

        AffichageFeu affichageFeu = new AffichageFeu(feu);

        JFrame frameAfficheFeu= new JFrame("Feux");
        Container contentPane = frameAfficheFeu.getContentPane();
        frameAfficheFeu.setMinimumSize(new Dimension(40,120));
        frameAfficheFeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAfficheFeu.setContentPane(affichageFeu);
        frameAfficheFeu.pack();
        frameAfficheFeu.setVisible(true);
        affichageFeu.repaint();


        AffichageFeu affichageFeu2 = new AffichageFeu(feu);
        JFrame frameAfficheFeu2= new JFrame("Feux");

        frameAfficheFeu2.setMinimumSize(new Dimension(40,120));
        frameAfficheFeu2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAfficheFeu2.setContentPane(affichageFeu2);
        frameAfficheFeu2.pack();
        frameAfficheFeu2.setVisible(true);
        affichageFeu2.repaint();



        JFrame controleurFeu = new JFrame("ControleurFeu");

        controleurFeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controleurFeu.setContentPane(new ControleurFeuGraphique(feu));
        controleurFeu.pack();
        controleurFeu.setVisible(true);


        


    }
}
