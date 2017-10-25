package fr.insarouen.asi.prog.puissance.sourcesenonce;

import java.awt.*;
import javax.swing.*;
import fr.insarouen.asi.prog.puissance.sourcesenonce.Puissance4;
import fr.insarouen.asi.prog.puissance.sourcesenonce.ControleurVuePuissance4Graphique;
import java.util.Scanner;
import fr.insarouen.asi.prog.puissance.sourcesenonce.ZoneTexte;


public class Puissance4Graphique {

    public static void main(String[] args) throws Puissance4ColonneException {
	Puissance4 p4 = new Puissance4(5,6);
  int largeur = p4.getLargeur()*55;
  int hauteur = p4.getHauteur()*55;
  JButton b = new JButton("Valider");
	JFrame frame=new JFrame("Puissance 4");
  JFrame frame2 = new JFrame();
  frame.setMinimumSize(new Dimension(largeur,hauteur));
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ControleurVuePuissance4Graphique cvp4gr = new ControleurVuePuissance4Graphique(p4);

  VuePuissance4Txt vp4txt = new VuePuissance4Txt(p4);
	ControleurPuissance4Txt cp4txt = new ControleurPuissance4Txt(p4);

  ZoneTexte t = new ZoneTexte("Colonne",10,b,p4);
  Container contentPane = frame2.getContentPane();
  contentPane.setLayout(new FlowLayout());
  contentPane.add(t);
  contentPane.add(b);



	//ControleurPuissance4Graphique cp4gr = new ControleurPuissance4Graphique(p4);

	frame.setContentPane(cvp4gr);
	frame.pack();
	frame.setVisible(true);


	frame2.pack();
	frame2.setVisible(true);

  cvp4gr.repaint();
  cp4txt.joue();


  }

}
