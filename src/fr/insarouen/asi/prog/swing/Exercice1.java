package fr.insarouen.asi.prog.swing;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;


public class Exercice1{

  public static void main(String[] args){

    JFrame frame = new JFrame("Exercice1");

    Container contentPane = frame.getContentPane();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ZoneTexte t = new ZoneTexte("Texte initial",50);
    contentPane.add(BorderLayout.CENTER,t);
    frame.pack();
    frame.setVisible(true);

  }





}

class ZoneTexte extends JTextField implements MouseListener{
  ZoneTexte(String nom, int colonnes){
    super(nom,colonnes);
    addMouseListener(this);
  }

  public void mouseClicked(MouseEvent e){
    this.setText("");
  }

  public void mouseEntered(MouseEvent e){

  }
  public void mouseExited(MouseEvent e){

  }

  public void mousePressed(MouseEvent e){

  }
  public void mouseReleased(MouseEvent e){

  }


}
