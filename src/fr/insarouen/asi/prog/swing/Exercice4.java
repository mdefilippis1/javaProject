package fr.insarouen.asi.prog.swing;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.lang.Integer;


public class ControleurBouton{

  public static void main(String[] args){

    JFrame frame = new JFrame("P4");


    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new FlowLayout());
    JButton b = new JButton("Valider");
    ZoneTexte t = new ZoneTexte("Colonne",30,b);




    contentPane.add(t);
    contentPane.add(b);
    frame.pack();
    frame.setVisible(true);

  }




}

class ZoneTexte extends JTextField implements ActionListener{
  private Puissance4 p;
  ZoneTexte(String nom, int colonnes,JButton b,Puissance4 _p){
    super(nom,colonnes);
    p=_p;
    b.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e){
    this.setText("");
  }

}
