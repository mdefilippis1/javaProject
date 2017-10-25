package fr.insarouen.asi.prog.asiaventures.elements.structure;

import java.util.*;
import java.lang.Object;
import java.io.*;
import fr.insarouen.asi.prog.asiaventures.elements.objets.Objet;
import java.lang.Object;
import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventures.Monde;
import fr.insarouen.asi.prog.asiaventures.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventures.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventures.elements.Activable;
import fr.insarouen.asi.prog.asiaventures.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventures.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventures.elements.Etat;
import fr.insarouen.asi.prog.asiaventures.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventures.elements.objets.serrurerie.Clef;
import fr.insarouen.asi.prog.asiaventures.elements.objets.serrurerie.Serrure;

/**
* <b> La classe Porte herite de la classe ElementStructurel et implements la classe Activable. </b>
* <p>
* Une Porte est caracterisee par les information suivantes :
* <ul>
* <li> Nom; </li>
* <li> 1-ere piece liee a cette porte; </li>
* <li> 2-eme piece liee a cette porte; </li>
* <li> Etat; </li>
* <li> Serrure; </li>
* <li> Monde. </li>
* </ul>
* </p>
* <p/>
* @author Michael De Filippis
* @author Valeria Petrov
* <p/>
* @version 1.0
* <p/>
* @since 22/04/2017
*/

public class Porte extends ElementStructurel implements Activable,Serializable{

/**
* L'attribut pieceA et pieceB represente les chambres liees par cette porte.
* <p> Il est possible d'obtenir la piece qui se trouve de l'autre cote d'une certaine porte. </p>
* @see Porte#getPieceAutreCote(Piece)
*/

  private Piece pieceA,pieceB;

/**
* L'attribut etat represent l'etat d'une porte.
* <p> Il est possible d'obtenir l'etat d'une certaine porte. </p>
* @see Porte#getEtat()
*/

  private Etat etat;

/**
* L'attribut serrure.
* <p> Il est possible d'obtenir la serrure d'une certaine porte. </p>
* @see Porte#getSerrure()
*/

  private Serrure serrure;

/**
  * Constructeur Porte
  * <p>
  * Pour la construction d'une Porte, on accede aux attributs de la classe mere.
  * </p>
  *
  * @param _nom
  *            Le nom d'une Porte.
  * @param _monde
  *            Le monde d'une Porte.
  * @param _pieceA
  * @param _pieceB
  *
  * @see Etat
  */

  public Porte(String _nom, Monde _monde, Piece _pieceA, Piece _pieceB) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(_nom,_monde);
    pieceA = _pieceA;
    pieceB = _pieceB;
    this.etat = Etat.FERME;
    pieceA.addPorte(this);
    pieceB.addPorte(this);
  }

/**
  * Constructeur Porte
  * <p>
  * Pour la construction d'une Porte, on accede aux attributs de la classe mere.
  * </p>
  *
  * @param _nom
  *            Le nom d'une Porte.
  * @param _monde
  *            Le monde d'une Porte.
  * @param _pieceA
  * @param _pieceB
  * @param _serrure
  *
  * @see Etat
  */

  public Porte(String _nom, Monde _monde, Serrure _serrure, Piece _pieceA, Piece _pieceB ) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(_nom,_monde);
    pieceA = _pieceA;
    pieceB = _pieceB;
    this.etat = Etat.FERME;
    pieceA.addPorte(this);
    pieceB.addPorte(this);
    this.serrure = _serrure;
  }

  /**
   * Donne la serrure d'une porte.
   * @return La serrure.
   * @see Porte
   */


  public Serrure getSerrure(){
    return this.serrure;
  }

 /**
  * Retourne true si une Porte est Activable avec un certain Objet.
  *
  * @param obj
  * @return Un boolean, false si la porte n'est pas Activable avec l'objet et true sinon.
  * @see Activable
  */

  public boolean activableAvec(Objet obj) {
    return (obj instanceof PiedDeBiche)||(obj instanceof Clef);
  }

 /**
  * Permet d'activer une Porte.
  *
  * @see Etat
  */

  public void activer() throws ActivationImpossibleException{
    if (this.getSerrure().getEtat() == Etat.VERROUILLE){
      throw new ActivationImpossibleException(this.getNom()+ " est verrouillee");
    }
    if (this.getEtat() == Etat.OUVERT){
      this.etat = Etat.FERME;
    }
    if (this.getEtat() == Etat.FERME){
      this.etat = Etat.OUVERT;
    }

  }

 /**
  * Permet d'activer une Porte avec un objet.
  *
  * @see Etat
  */

  public void activerAvec(Objet obj) throws ActivationImpossibleAvecObjetException, ActivationImpossibleException{
    if(!(this.activableAvec(obj))){
      throw new ActivationImpossibleAvecObjetException(obj.getNom() + " ne peut pas activer la porte");

    }
    if (obj instanceof Clef){
      this.getSerrure().activerAvec(obj);

      }
    if (obj instanceof PiedDeBiche){
      this.etat = Etat.CASSE;
    }



  }

 /**
  * Donne la piece de l'autre cote de la porte.
  *
  * @param piece
  * @return La piece.
  */

  public Piece getPieceAutreCote(Piece piece){
    if (piece.equals(pieceA)){
      return pieceB;
    }
    else{
      return pieceA;
    }
  }

 /**
  * Donne l'etat de la porte.
  *
  * @return L'etat.
  * @see Etat
  */

  public Etat getEtat(){
    return this.etat;
  }

 /**
  * Retourne les information sur la Porte.
  *
  * @return Le nom d'une Porte et les piece lie par cette porte.
  * @see Objet#getNom()
  * @see Piece#getNom()
  */

  public String toString(){
    StringBuilder res = new StringBuilder();
    res.append(this.getNom());
    res.append("\n piece A : "+ pieceA.getNom());
    res.append("\n piece B : "+ pieceB.getNom());
    res.append("\n etat : "+ this.getEtat());
    return res.toString();
  }


}
