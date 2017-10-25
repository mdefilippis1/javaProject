package fr.insarouen.asi.prog.swing;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import fr.insarouen.asi.prog.swing.GestionListe;

public class GestionListeAvancee{

  public static void main(String[] args){
    JFrame frame = new JFrame("Exercice1");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = frame.getContentPane();
    GestionListe gest1 = new GestionListe();
    GestionListe gest2 = new GestionListe();
    JButton t1 = new JButton("<");
    JButton t2 = new JButton(">");
    JPanel panneauBoutonTransfert = new JPanel();
    t1.addActionListener(new TransfertListener(gest2,gest1));
    t2.addActionListener(new TransfertListener(gest1,gest2));

    contentPane.add(BorderLayout.WEST,gest1);
    contentPane.add(BorderLayout.CENTER,panneauBoutonTransfert);
    contentPane.add(BorderLayout.EAST,gest2);
    panneauBoutonTransfert.add(t1);
    panneauBoutonTransfert.add(t2);

    frame.pack();
    frame.setVisible(true);
  }
}

class TransfertListener implements ActionListener {
  private GestionListe source;
  private GestionListe destination;
  public TransfertListener(GestionListe _source, GestionListe _destination){
    source = _source;
    destination=_destination;
  }
  public void actionPerformed(ActionEvent e) {
    // retrait de l'element selectionne


      String element = this.source.removeSelection();
      if(element!=""){
        this.destination.addElement(element);
      }



  }
}
