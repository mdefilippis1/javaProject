/*
 * AffichageFeu.java
 *
 * Created on 20 juin 2006, 17:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package fr.insarouen.asi.prog.feux;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;
import fr.insarouen.asi.prog.feux.Feu;
import fr.insarouen.asi.prog.feux.Feu.Etat;

/**
 *
 * @author nicolas
 */
public class AffichageFeu extends JPanel implements Observer{


  private Feu feu;

    /** Creates a new instance of AffichageFeu */
    public AffichageFeu(Feu _feu) {
      super();
      feu = _feu;
      feu.addObserver(this);
    }

    public void eteindre() {
      
    }

    private Color etatEnCouleur(Etat e){
      switch(e){
        case PASSE : return Color.GREEN;
        case ARRET : return Color.RED;
        case ATTENTION : return Color.ORANGE;
        default : return Color.BLACK;
      }
    }

    private int etatEnInt(Etat e){
      switch(e){
        case PASSE : return 3;
        case ARRET : return 1;
        case ATTENTION : return 2;
        default : return 0;
      }
    }



    @Override
    public void paintComponent(Graphics g){
      int intervalle = 10;
      int diametre = 20;
      super.paintComponent(g);
      for (int position = 1;position<4 ;position++ ) {
        g.setColor(Color.BLACK);
        g.fillOval(1,position*diametre+intervalle,diametre,diametre);
      }
      g.setColor(this.etatEnCouleur(feu.getEtat()));
      g.fillOval(1,this.etatEnInt(feu.getEtat())*diametre+intervalle,diametre,diametre);
    }

    public void update(Observable o, Object obj){
      this.repaint();
    }








































}
