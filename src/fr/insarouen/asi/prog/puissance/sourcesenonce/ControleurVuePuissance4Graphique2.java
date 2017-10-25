package fr.insarouen.asi.prog.puissance.sourcesenonce;

import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.util.Observer;
import java.util.Observable;
import fr.insarouen.asi.prog.puissance.sourcesenonce.Puissance4;

public class ControleurVuePuissance4Graphique extends JPanel implements Observer{
  private Puissance4 p;
  public ControleurVuePuissance4Graphique2(Puissance4 _p) {

    super();
    p = _p;
    p.addObserver(this);
    this.addMouseListener(new MouseAdapter(){
      @Override
      public void mouseClicked(MouseEvent e){
        int diametre = p.getLargeur()*10;
        int x = e.getX();
        System.out.println(x);
        System.out.println(diametre);
        try{
          p.joueColonne(x/diametre);

        }
        catch(Puissance4ColonneException er){
          System.out.println(er.getMessage());
        }
      }


    });
  }

  private Color jetonEnCouleur(TypeJeton jeton){
    switch(jeton){
      case VIDE : return Color.GRAY;
      case ROUGE : return Color.RED;
      case JAUNE : return Color.YELLOW;
      default : return Color.WHITE;
    }
  }

  @Override
  public void paintComponent(Graphics g){
    int diametre = p.getLargeur()*10;
    super.paintComponent(g);

    //for (int x = 3;x<(diametre*p.getLargeur()+p.getLargeur()*3) ; x+=(diametre+3)) {
      //for (int y = 3;y<(diametre*p.getHauteur()+p.getHauteur()*3) ;y+=(diametre+3)) {
    for (int ligne=p.getHauteur()-1;ligne>=0 ;ligne-- ) {
      for (int colonne=0;colonne<p.getLargeur() ;colonne++ ) {
        g.setColor(this.jetonEnCouleur(p.getJeton(colonne,ligne)));
        g.fillOval(colonne*diametre+3,(p.getHauteur()-ligne-1)*diametre+3,diametre,diametre);
      }
    }



  }

  public void update(Observable o, Object obj){
    this.repaint();
  }






}
