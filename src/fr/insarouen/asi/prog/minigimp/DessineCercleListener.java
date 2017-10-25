package fr.insarouen.asi.prog.minigimp;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import fr.insarouen.asi.prog.minigimp.Utilitaires;



// TODO Listener qui modifie les données (dessinables) lors d'un click dans la zone de dessin
public class DessineCercleListener extends DessinerFiguresListener {

  public DessineCercleListener(DessinablesData dessinables) {
    super(dessinables);
  }



  public Figure creerFigures(int x,int y,int largeur,int longueur){
    return new Cercle(x,y,largeur,Color.BLACK);
  }




}
