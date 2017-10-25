package fr.insarouen.asi.prog.swing;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;


public class Exercice22{

  public static void main(String[] args){

    JFrame frame = new JFrame("Exercice2.2");
    Container contentPane = frame.getContentPane();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JTextField t = new JTextField("Texte initial",50);
    t.addMouseListener(new MouseAdapter(){
      @Override
      public void mouseClicked(MouseEvent e){
        t.setText("");
      }


    });

    contentPane.add(BorderLayout.CENTER,t);
    frame.pack();
    frame.setVisible(true);

  }
}
