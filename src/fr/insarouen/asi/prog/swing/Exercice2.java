package fr.insarouen.asi.prog.swing;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;


public class Exercice2{

  public static void main(String[] args){

    JFrame frame = new JFrame("Exercice2");

    Container contentPane = frame.getContentPane();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ZoneTexte t = new ZoneTexte("Texte initial",50);

    contentPane.add(BorderLayout.CENTER,t);
    frame.pack();
    frame.setVisible(true);

  }
}

class ZoneTexte extends JTextField{


    ZoneTexte(String nom, int colonnes){
      super(nom,colonnes);

      addMouseListener(new Adapter(this));

    }
  }




class Adapter extends MouseAdapter{
  private ZoneTexte z;
  Adapter(ZoneTexte _z){
    super();
    this.z = _z;

  }
  @Override
  public void mouseClicked(MouseEvent e){
    this.z.setText("");
  }
}
