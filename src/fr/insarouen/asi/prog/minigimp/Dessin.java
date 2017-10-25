package fr.insarouen.asi.prog.minigimp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

// TODO compléter la classe
public class Dessin extends JPanel implements Observer{

  private DessinablesData d;
  public Dessin() {
    super();

    setOpaque(true);
    setBackground(Color.white);
    setPreferredSize(new Dimension(300,200));
    d = new DessinablesData();

  }

  // TODO associe les données à la zone de dessin et les déclare observables par Dessin
  public void setModel(DessinablesData dessinables) {
    d = dessinables;
    d.addObserver(this);
  }


  // TODO dessine le ou les figures contenues dans les données
  // si une figure est reçu ne dessiner que celle-ci
  // sinon tout redessinner
  public void update(Observable obs, Object o) {
    if(o==null){
      this.repaint();
    }
    else{
      ((Dessinable)o).dessine(this.getGraphics());
    }

  }

  // TODO dessine les figures contenues dans les données
  public void paintComponent(Graphics gc) {
      super.paintComponent(gc);
      for(Iterator i = d.iterator();i.hasNext();){
        ((Dessinable)(i.next())).dessine(gc);
      }

  }





























}
