/*
 * ControleurFeuGraphique.java
 *
 * Created on 20 juin 2006, 23:29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package fr.insarouen.asi.prog.feux;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import fr.insarouen.asi.prog.feux.Feu;
import fr.insarouen.asi.prog.feux.Feu.Etat;
import java.awt.*;
import java.awt.event.*;
import fr.insarouen.asi.prog.feux.ControleurFeuAuto;

/**
 *
 * @author nicolas
 */
public class ControleurFeuGraphique extends JPanel{

    private Feu feu;


    /** Creates a new instance of ControleurFeuGraphique */
    public ControleurFeuGraphique(Feu _feu) {
      super();
      feu = _feu;
      Bouton go,attention,stop;
      go = new Bouton("Go",Etat.PASSE,feu);
      attention = new Bouton("Attention",Etat.ATTENTION,feu);
      stop = new Bouton("Stop",Etat.ARRET,feu);
      CheckBox cb = new CheckBox(feu,"auto",false,go,attention,stop);
      this.add(go);
      this.add(attention);
      this.add(stop);
      this.add(cb);


    }

    }

class Bouton extends JButton implements ActionListener{
  private Etat etat;
  private Feu feu;
  public Bouton(String nom,Etat _etat,Feu f){
    super(nom);
    etat = _etat;
    feu = f;
    this.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e){
    feu.setEtat(etat);
  }
}

class CheckBox extends JCheckBox implements ActionListener{
  ControleurFeuAuto controleurFeuAuto;
  private Feu feu;
  Bouton[] boutons;
  public CheckBox(Feu _feu,String name,boolean etat,Bouton... _boutons){
    super(name,etat);
    boutons=_boutons;
    this.addActionListener(this);
    feu = _feu;
    controleurFeuAuto = new ControleurFeuAuto(feu,1500,1500,1500);


  }

  public void actionPerformed(ActionEvent e){


    if(!(this.isSelected())){
      for(Bouton b : boutons){
        b.setEnabled(true);
      }
      controleurFeuAuto.stop();

    }
    else{
      for(Bouton b : boutons){
        b.setEnabled(false);
      }
      Thread thread = new Thread(controleurFeuAuto);
      thread.start();
    }
  }

}
