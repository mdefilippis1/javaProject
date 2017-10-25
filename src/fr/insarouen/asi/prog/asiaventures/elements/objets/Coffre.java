package fr.insarouen.asi.prog.asiaventures.elements.objets;

import java.util.*;
import fr.insarouen.asi.prog.asiaventures.elements.objets.Objet;
import java.lang.Object;
import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventures.Monde;
import fr.insarouen.asi.prog.asiaventures.elements.Entite;
import fr.insarouen.asi.prog.asiaventures.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventures.elements.objets.serrurerie.Clef;
import fr.insarouen.asi.prog.asiaventures.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventures.elements.Etat;
import fr.insarouen.asi.prog.asiaventures.elements.Activable;
import fr.insarouen.asi.prog.asiaventures.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventures.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventures.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventures.elements.objets.PiedDeBiche;

/**
* <b> La classe Coffre herite de la classe Objet et implements la classe Activable. </b>
* <p>
* Un coffre est caracterisee par les information suivantes :
* <ul>
* <li> Nom; </li>
* <li> Etat; </li>
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
* @since 22/04/2017
*/

public class Coffre extends Objet implements Activable{

/**
* L'attribut etat represent l'etat d'un coffre.
* <p> Il est possible d'obtenir l'etat d'un coffre. </p>
* @see Coffre#getEtat()
*/

  private Etat etat;

/**
* L'attribut objets represente la liste des objets contenus dans le coffre.
*/

  private Map<String,Objet> objets;

/**
  * Constructeur Porte
  * <p>
  * Pour la construction d'un coffre, on accede aux attributs de la classe mere.
  * </p>
  *
  * @param _nom
  *            Le nom d'un coffre.
  * @param _monde
  *            Le monde d'un coffre.
  *
  * @see Etat
  */

  public Coffre(String _nom, Monde _monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(_nom,_monde);
    this.etat = Etat.FERME;
    objets = new TreeMap<String,Objet>();
  }

  /**
   * Retourne true si le coffre est deplacable.
   *
   * @param vivant
   * @return Un boolean, false si le coffre n'est pas deplacable et true sinon. Par default, return false.
   */

  public boolean estDeplacable(){
    return false;
  }

 /**
  * Retourne true si un coffre est Activable avec un certain Objet.
  *
  * @param obj
  * @return Un boolean, false si le coffre n'est pas Activable avec l'objet et true sinon.
  * @see Activable
  */

  public boolean activableAvec(Objet obj){
    return (obj instanceof PiedDeBiche);
  }

 /**
  * Permet d'activer une Porte.
  *
  * @see Etat
  */

  public void activer() throws ActivationException{
    if (this.getEtat()==Etat.FERME){
      this.etat = Etat.OUVERT;
    }
    if (this.getEtat()==Etat.OUVERT){
      this.etat = Etat.FERME;
    }
  }

 /**
  * Permet d'activer une Porte avec un objet.
  *
  * @param obj
  * @see Etat
  */

  public void activerAvec(Objet obj) throws ActivationException{
    if (!activableAvec(obj)){
      throw new ActivationException("mauvais objet d'activation");
    }
    if (this.getEtat()==Etat.FERME){
      this.etat = Etat.OUVERT;
    }
    if (this.getEtat()==Etat.OUVERT){
      throw new ActivationException(this.getNom()+" ne peut pas etre ouvert avec "+obj.getNom());
    }
  }

 /**
  * Donne l'etat du coffre.
  *
  * @return La etat.
  * @see Etat
  */


  public Etat getEtat(){
    return this.etat;
  }

 /**
  * Retourne les information sur le coffre.
  *
  * @return Le nom d'un coffre et les objets qu'il contient.
  * @see Objet
  */

  public String toString(){
    StringBuilder res = new StringBuilder();
    res.append("\n");
    res.append("nom : ");
    res.append(this.getNom());
    res.append("\n objets : ");
    if (objets.isEmpty()) {
      res.append("pas d'objets dans le coffre");
    }
    else{
      for(String s : objets.keySet()){
        res.append("\n"+s);
      }

    }

return res.toString();

  }

}
