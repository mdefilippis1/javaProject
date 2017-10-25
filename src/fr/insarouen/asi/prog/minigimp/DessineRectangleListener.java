package fr.insarouen.asi.prog.minigimp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import fr.insarouen.asi.prog.minigimp.Utilitaires;

// TODO Listener qui modifie les données (dessinables) lors d'un click dans la zone de dessin
public class DessineRectangleListener extends DessinerFiguresListener {

  public DessineRectangleListener(DessinablesData dessinables) {
    super(dessinables);

  }



  public Figure creerFigures(int x,int y,int largeur, int hauteur){
    return new Rectangle(x,y,largeur,hauteur,Color.BLACK);
  }


}
