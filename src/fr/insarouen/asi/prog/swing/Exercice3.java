package fr.insarouen.asi.prog.swing;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.lang.Integer;


public class Exercice3{

  public static void main(String[] args){

    JFrame frame = new JFrame("Exercice3");


    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.Y_AXIS));
    MouseAdapter a = new MouseAdapter(){
      @Override
      public void mouseClicked(MouseEvent e){
        ((JTextField) e.getSource()).setText("");
      }
    };
    Integer nombre = Integer.valueOf(args[0]);
    for (Integer i=1;i<=nombre ;i++ ) {
      JTextField jtf = new JTextField("Texte initial "+" - "+i,25);
      jtf.addMouseListener(a);
      contentPane.add(jtf);


    }

    frame.pack();
    frame.setVisible(true);





  }
}
