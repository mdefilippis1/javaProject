package fr.insarouen.asi.prog.minigimp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Controle extends JPanel {

  private Dessin dessin;
  private DessinablesData dessinables;
  private GestionOutil cercleBouton;
  private GestionOutil rectangleBouton;
  public Controle(Dessin _dessin, DessinablesData _dessinables) {
    dessin = _dessin;
    dessinables = _dessinables;

    // TODO associe les données (dessinables) avec le dessin
    dessin.setModel(dessinables);

    cercleBouton = new GestionOutil(new DessineCercleListener(dessinables));
    rectangleBouton = new GestionOutil(new DessineRectangleListener(dessinables));

    // assignation du layout manager
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    // creation du groupe d'exclusivite des boutons cercle et rect
    ButtonGroup bg = new ButtonGroup();

    // JRadioButton cercle, ajout au panneau, et assignation d'un listener
    JRadioButton dess_cercle = new JRadioButton("Cercle", false);
    dess_cercle.setAlignmentY(JComponent.LEFT_ALIGNMENT);
    bg.add(dess_cercle);
    add(dess_cercle);


    // TODO ajouter le listener lié à la sélection du radio cercle
    dess_cercle.addItemListener(cercleBouton);

    // JRadioButton rectangle, ajout au panneau, et assignation d'un listener
    JRadioButton dess_rect = new JRadioButton("Rectangle", false);
    dess_rect.setAlignmentY(JComponent.LEFT_ALIGNMENT);
    bg.add(dess_rect);
    add(dess_rect);

    // TODO ajouter le listener lié à la sélection du radio rectangle
    dess_rect.addItemListener(rectangleBouton);
    // zone de glue
    add(Box.createGlue());

    // bouton d'effacement
    JButton efface = new JButton("Effacer");
    efface.setAlignmentY(JComponent.CENTER_ALIGNMENT);
    add(efface);

    // TODO ajouter le listener lié à l'effacement par le bouton efface
    efface.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        dessinables.vider();
      }
    });



    // bouton pour quitter
    JButton quitter = new JButton("Quitter");
    quitter.setAlignmentY(JComponent.CENTER_ALIGNMENT);
    add(quitter);

    quitter.addActionListener( new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	  System.exit(0);
	}
      });

  }

  // TODO créer la classe GestionOutil qui en fonction de la sélection
  // du bouton radio permet d'associer le bon listener.
  // gestion des outils activation/desactivation
  private class GestionOutil implements ItemListener {

    private MouseAdapter m;
    public GestionOutil(MouseAdapter _listener) {
      m=_listener;


    }

    public void itemStateChanged(ItemEvent e){
      if (!((JRadioButton)(e.getSource())).isSelected()) {
        dessin.removeMouseListener(m);
        dessin.removeMouseMotionListener(m);
      }
      else{
        dessin.addMouseListener(m);
        dessin.addMouseMotionListener(m);
      }
    }


  }





}
