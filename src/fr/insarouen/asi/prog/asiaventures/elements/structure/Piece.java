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
import fr.insarouen.asi.prog.asiaventures.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventures.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.ObjetNonPossedeParLeVivantException;
import fr.insarouen.asi.prog.asiaventures.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventures.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventures.elements.structure.VivantAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventures.elements.structure.PorteInexistanteDansLaPieceException;
/**
* <b> La classe Piece herite de la classe ElementStructurel. </b>
* <p>
* Une Piece est caracterisee par les information suivantes :
* <ul>
* <li> Nom; </li>
* <li> Liste d'objets; </li>
* <li> Monde. </li>
* </ul>
* </p>
* <p/>
* @author Michael De Filippis
* @author Valeria Petrov
* <p/>
* @version 1.0
* <p/>
* @since 08/02/2017
*/

public class Piece extends ElementStructurel implements Serializable{

/**
* L'attribut objets represente la liste des objets contenus dans la Piece.
* <p> Il est possible d'ajouter ou de retirer des objets de la Piece. </p>
* @see Piece#retirer(Objet)
* @see Piece#retirer(nomObjet)
* @see Piece#deposer(Objet)
*/

  private Map<String,Objet> objets;

  /**
  * L'attribut vivants represente la liste des vivants presents dans la Piece.
    * <p> Il est possible de faire ou sortir des vivants de la Piece. </p>
  * @see Piece#entrer(vivant)
  * @see Piece#sortir(nomVivant)
  */

  private Map<String,Vivant> vivants;

  private Map<String,Porte> portes;

/**
  * Constructeur Piece
  * <p>
  * Pour la construction d'une Piece, on accede aux attributs de la classe mere.
  * </p>
  *
  * @param nom
  *            Le nom de la Piece.
  * @param monde
  *            Le monde de la Piece.
  *
  * @see ElementStructurel
  */
  public Piece(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
      super(nom,monde);
      objets = new TreeMap<String,Objet>();
      vivants = new TreeMap<String,Vivant>();
      portes = new TreeMap<String,Porte>();
  }

 /**
  * Retourne true si un Objet est present dans la Piece.
  *
  * @param nomObj
  * @return Un boolean, false si l'objet n'est pas present dans la Piece et true sinon.
  * @see Objet#getNom()
  */

  public boolean contientObjet(String nomObj){
    return this.objets.containsKey(nomObj);
  }

 /**
  * Retourne true si un Objet est present dans la Piece.
  *
  * @param obj
  * @return Un boolean, false si l'objet n'est pas present dans la Piece et true sinon.
  * @see Piece#contientObjet(String)
  * @see Objet#getNom()
  */

  public boolean contientObjet(Objet obj){
    return contientObjet(obj.getNom());
  }

 /**
  * Depose un Objet dans la Piece.
  *
  * @param obj
  *              Le nouvel Objet depose.
  * @see Objet
  */

  public void deposer(Objet obj) {
    Objet o = objets.put(obj.getNom(),obj);
  }


 /**
  * Retourne l'Objet rétire de la Piece.
  *
  * @param objet
  * @return L'Objet retire de la Piece (s'il est present dans la Piece) et null sinon.
  * @see Piece#retirer(String)
  * @see Objet#getNom()
  */

  public Objet retirer(Objet objet) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
    return retirer(objet.getNom());
  }

 /**
  * Retourne l'Objet retire de la Piece.
  *
  * @param nomObj
  * @return L'Objet retire de la Piece (s'il est present dans la Piece) et null sinon.
  * @see Piece#contientObjet(Objet)
  * @see Objet#getNom()
  */

  public Objet retirer(String nomObj) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
    if (this.contientObjet(nomObj)){


        Objet o = objets.remove(nomObj);


        if (!(o.estDeplacable())) {
          throw new ObjetNonDeplacableException(nomObj+" - l'objet n'est pas deplacable");
        }
        return o;


    }
    else{
      throw new ObjetAbsentDeLaPieceException("objet: "+nomObj+" n'est pas present dans la piece");
    }
  }

  /**
   * Retourne true si un Vivant est present dans la Piece.
   *
   * @param nomVivant
   * @return Un boolean, false si le vivant n'est pas present dans la Piece et true sinon.
   * @see Vivant#getNom()
   */

  public boolean contientVivant(String nomVivant){
    return this.vivants.containsKey(nomVivant);
  }

  /**
   * Retourne true si un Vivant est present dans la Piece.
   *
   * @param vivant
   * @return Un boolean, false si le vivant n'est pas present dans la Piece et true sinon.
   * @see Piece#contientVivant(String)
   * @see Vivant#getNom()
   */

  public boolean contientVivant(Vivant vivant){
    return this.contientVivant(vivant.getNom());
  }


  /**
   * Fait entrer un vivant.
   *
   * @param vivant
   * @see Vivant
   */

  public void entrer(Vivant vivant){
    Vivant v = this.vivants.put(vivant.getNom(),vivant);
  }

  /**
   * Fait sortir un vivant.
   * @param nomVivant
   * @return Le vivant sorti de la piece.
   * @see Piece#contientVivant(String)
   * @see Vivant
   */

  public Vivant sortir(String nomVivant) throws VivantAbsentDeLaPieceException{
    if (!(this.contientVivant(nomVivant))){
      throw new VivantAbsentDeLaPieceException("vivant : "+nomVivant+" n'est pas present dans la piece");
    }

    return this.vivants.remove(nomVivant);
  }

  /**
   * Fait sortir un vivant.
   * @param vivant
   * @return Le vivant sorti de la piece.
   * @see Piece#sortir(String)
   */

  public Vivant sortir(Vivant vivant) throws VivantAbsentDeLaPieceException{
    return this.sortir(vivant.getNom());
  }


  /**
   * Donne la porte a partir de son nom.
   * @param nomPorte
   * @return La porte.
   * @see Porte
   */

  public Porte getPorte(String nomPorte) throws PorteInexistanteDansLaPieceException{
    if (!(this.aLaPorte(nomPorte))){
      throw new PorteInexistanteDansLaPieceException("la porte "+nomPorte+" n'est pas dans la piece");
    }
    return portes.get(nomPorte);
  }

  /**
   * Ajoute une porte a une piece.
   * @param porte
   * @see Porte
   */

  public void addPorte(Porte porte){
    Porte p = this.portes.put(porte.getNom(),porte);
  }

 /**
  * Retourne true si une Porte est present dans la Piece.
  *
  * @param nomPorte
  * @return Un boolean, false si la porte n'est pas present dans la Piece et true sinon.
  * @see Porte
  */

  public boolean aLaPorte(String nomPorte){
    return this.portes.containsKey(nomPorte);
  }

 /**
  * Retourne true si une Porte est present dans la Piece.
  *
  * @param nomPorte
  * @return Un boolean, false si la porte n'est pas present dans la Piece et true sinon.
  * @see Piece
  */

  public boolean aLaPorte(Porte porte){
    return this.aLaPorte(porte.getNom());
  }

 /**
  * Donne toutes les portes presentes dans la piece.
  *
  * @return Une liste des portes
  * @see Porte
  */

  public Collection<Porte> getPortes(){
    return this.portes.values();
  }

 /**
  * Donne toutes les objets presents dans la piece.
  *
  * @return Une liste des objets
  * @see Objet
  */

  public Collection<Objet> getObjets(){
    return this.objets.values();
  }

 /**
  * Retourne les information sur la Piece.
  *
  * @return Le nom d'une Piece et les objets qu'elle contient sous forme d'une chaine de caracteres.
  * @see Objet#getNom()
  * @see Piece#getNom()
  */

  public String toString(){



      StringBuilder res = new StringBuilder();
      res.append(this.getNom());
      res.append("\n objets presents dans la piece : ");
      for(String s : objets.keySet()){
        res.append("\n"+s);
      }
      res.append("\n vivants presents dans la piece : ");
      for(String s : vivants.keySet()){
        res.append("\n"+s);
      }
    return res.toString();
  }

  }
