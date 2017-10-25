package fr.insarouen.asi.prog.asiaventures.elements.vivants;

import java.util.*;
import fr.insarouen.asi.prog.asiaventures.elements.objets.Objet;
import java.lang.Object;
import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventures.Monde;
import fr.insarouen.asi.prog.asiaventures.elements.Entite;
import fr.insarouen.asi.prog.asiaventures.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventures.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventures.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventures.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventures.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.ObjetNonPossedeParLeVivantException;
import fr.insarouen.asi.prog.asiaventures.elements.Activable;
import fr.insarouen.asi.prog.asiaventures.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventures.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventures.elements.structure.PorteInexistanteDansLaPieceException;
import fr.insarouen.asi.prog.asiaventures.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventures.elements.Etat;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventures.elements.Executable;

/**
* <b> La classe Monstre herite de la classe Vivant et implements la classe Executable. </b>
* <p>
* Un Monstre est caractérisé par les information suivantes:
* <ul>
* <li> Nom; </li>
* <li> Liste d'objets qu'il contient; </li>
* <li> Points de vie; </li>
* <li> Points de Force; </li>
* <li> Piece où il se trouvé; </li>
* <li> Monde. </li>
* </ul>
* </p>
* <p/>
* @author Michael De Filippis
* @author Valeria Petrov
* <p/>
* @version 1.1
* <p/>
* @since 22/04/2017
*/

public class Monstre extends Vivant implements Executable{

/**
  * Constructeur Monstre
  * <p>
  * Pour la construction d'un Monstre, on accède aux attributs de la classe mère.
  * </p>
  *
  * @param _nom
  *            Le nom du Monstre.
  * @param _monde
  *            Le monde du Monstre.
  * @param _pointVie
  *            Les points de Vie du Monstre.
  * @param _pointForce
  *            Le points de force du Monstre.
  * @param _objets
  *            La liste des objets du Monstre.
  *
  * @see ElementStructurel
  */


  public Monstre(String _nom, Monde _monde, int _pointVie, int _pointForce,Piece _piece, Objet... _objets) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(_nom,_monde,_pointVie,_pointForce,_piece,_objets);
  }

/**
  * Retourne la porte selectione par le Monstre.
  *
  * @return La porte si elle est ouverte sinon retourne null.
  * @see Porte
  * @see Piece
  */

  public Porte selectionnerPorte() {
    Collection<Porte> portesDeLaPiece = this.getPiece().getPortes();
    for(Porte p : portesDeLaPiece){
      if (p.getEtat()==Etat.OUVERT){
        return p;
      }

    }
    return null;

  }

/**
  * Permet au Monstre de ramasser les Objets de la piece ou il se trouve.
  *
  * @see Objet
  * @see Piece
  */

  private void ramasserObjetsDeLaPiece() throws ObjetNonDeplacableException,ObjetAbsentDeLaPieceException{
    Collection<Objet> objetsDeLaPiece = this.getPiece().getObjets();
    for(Objet o : objetsDeLaPiece){

      this.prendre(o);

    }
  }

/**
  * Permet au Monstre de deposer ses anciens objets.
  *
  * @param anciensObjets
  * @see Objet
  * @see Vivant
  */

  private void deposerAnciensObjets(Collection<Objet> anciensObjets) throws ObjetNonPossedeParLeVivantException{
    for(Objet o : anciensObjets){
      this.deposer(o);
    }
  }

/**
  * Permet au Monstre d'executer une suite des actions.
  *
  * @see Porte
  * @see Vivant
  * @see Objet
  */

  public void executer() throws ObjetNonPossedeParLeVivantException,PorteInexistanteDansLaPieceException,PorteFermeException,ObjetAbsentDeLaPieceException,ObjetNonDeplacableException{

    Porte porteChoisie = this.selectionnerPorte();
    this.franchir(porteChoisie);
    this.setPointDeVie(this.getPointVie()-1);
    Collection<Objet> anciensObjets = this.getObjets();
    this.ramasserObjetsDeLaPiece();
    this.deposerAnciensObjets(anciensObjets);

  }



}
