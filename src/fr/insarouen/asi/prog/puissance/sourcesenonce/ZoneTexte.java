package fr.insarouen.asi.prog.puissance.sourcesenonce;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.lang.Integer;
import fr.insarouen.asi.prog.puissance.sourcesenonce.Puissance4ColonneException;
import fr.insarouen.asi.prog.puissance.sourcesenonce.Puissance4;


public class ZoneTexte extends JTextField implements ActionListener{
  private Puissance4 p;
  ZoneTexte(String nom, int colonnes,JButton b,Puissance4 _p){
    super(nom,colonnes);
    p=_p;
    b.addActionListener(this);
    this.addActionListener(this);
    this.addMouseListener(new MouseAdapter(){
      @Override
      public void mouseClicked(MouseEvent e){
        ((JTextField) e.getSource()).setText("");
      }


    });


  }

  public void actionPerformed(ActionEvent e){
    try{
      p.joueColonne(Integer.parseInt(this.getText()));
      this.setText("");
    }
    catch(Puissance4ColonneException er){
      System.out.println(er.getMessage());
    }
  }

}
