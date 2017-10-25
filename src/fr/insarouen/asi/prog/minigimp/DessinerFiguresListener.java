package fr.insarouen.asi.prog.minigimp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import fr.insarouen.asi.prog.minigimp.Utilitaires;
import static java.lang.Math.abs;
import static java.lang.Math.min;


public abstract class DessinerFiguresListener extends MouseAdapter{

  DessinablesData d;
  int x0,y0,xc,yc;
  Graphics g;
  public DessinerFiguresListener(DessinablesData dessinables){
    super();
    d = dessinables;
  }

  //public void mouseClicked(MouseEvent e){
    //int x = e.getX();
    //int y = e.getY();
    //d.addDessinable(creerFigures(x,y));
  //}

  public void mousePressed(MouseEvent e){
    g =((Dessin) (e.getSource())).getGraphics();
    x0 = e.getX();
    y0 = e.getY();
    xc=x0;
    yc=y0;
    g.setXORMode(Color.WHITE);
    creerFigures(x0,y0,abs(xc-x0),abs(yc-y0)).dessine(g);


  }
  public void mouseDragged(MouseEvent e){
    creerFigures(min(x0,xc),min(y0,yc),abs(xc-x0),abs(yc-y0)).dessine(g);
    xc = e.getX();
    yc = e.getY();
    creerFigures(min(x0,xc),min(y0,yc),abs(xc-x0),abs(yc-y0)).dessine(g);




  }

  public void mouseReleased(MouseEvent e){
    Figure f = creerFigures(min(x0,xc),min(y0,yc),abs(xc-x0),abs(yc-y0));
    f.dessine(g);
    xc = e.getX();
    yc = e.getY();
    g.setPaintMode();
    d.addDessinable(f);
  }

  public abstract Figure creerFigures(int x,int y,int largeur,int hauteur);
}
