package fr.insarouen.asi.prog.asiaventures.elements.objets.serrurerie;

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

/**
* <b> La classe Serrure herite de la classe Objet et implements la classe Activable. </b>
* <p>
* Une Serrure est caracterisee par les information suivantes :
* <ul>
* <li> Nom; </li>
* <li> Clef; </li>
* <li> Nombre generations; </li>
* <li> Etat; </li>
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

public class Serrure extends Objet implements Activable,Serializable{

/**
* L'attribut Clef.
* <p> Il est possible de creer la Clef. </p>
* @see Serrure#creerClef()
*/

  private Clef clef;

/**
* L'attribut nomGenere represent combien de fois est genere la clef. Par defaul la clef peut etre genere une seule fois.
*/

  private static int nomGenere = 0;

/**
* L'attribut etat represent l'etat d'une serrure.
* <p> Il est possible d'obtenir l'etat d'une serrure. </p>
* @see Serrure#getEtat()
*/

  private Etat etat;

/**
  * Retourne le nobre des generations de la clef (si c'est 0 alors la clef est genere).
  *
  * @param m
  * @return Nombre generations.
  */

  private static int genererNom(Monde m){

    if ((m.nomDejaDansLeMonde("serrure"+nomGenere))||(m.nomDejaDansLeMonde("clef"+nomGenere))){
      nomGenere = nomGenere+1;
      return genererNom(m);

    }
    else{
      return nomGenere;
    }
  }


/**
  * Constructeur Serrure
  * <p>
  * Pour la construction d'une Serrure, on accede aux attributs de la classe mere.
  * </p>
  *
  * @param _nom
  *            Le nom d'une Serrure.
  * @param _monde
  *            Le monde d'une Serure.
  *
  * @see Etat
  */

  public Serrure(String _nom, Monde _monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(_nom,_monde);
    this.clef = null;
    this.etat = Etat.VERROUILLE;

  }

/**
  * Constructeur Serrure
  * <p>
  * Pour la construction d'une Serrure, on a besoin d'un monde.
  * </p>
  *
  * @param _monde
  *            Le monde d'une Serure.
  *
  * @see Etat
  */

  public Serrure(Monde _monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    this("serrure"+genererNom(_monde),_monde);
  }


/**
  * Permet d'obtenir la Clef pour la serrure.
  *
  * @return La Clef.
  */



  public Clef creerClef() throws NomDEntiteDejaUtiliseDansLeMondeException{
    if (this.clef == null){
      this.clef = new Clef("clef"+genererNom(this.getMonde()),this.getMonde());

    }
    return this.clef;

  }

 /**
  * Donne l'etat d'une serrure.
  *
  * @return L' etat.
  * @see Etat
  */

  public Etat getEtat(){
    return this.etat;
  }


  /**
   * Retourne true si la serrure est deplacable.
   *
   * @param vivant
   * @return Un boolean, false si la serrure n'est pas deplacable et true sinon. Par default, return false.
   */

  public boolean estDeplacable(){
    return false;
  }

 /**
  * Retourne true si une serrure est Activable avec un certain Objet.
  *
  * @param obj
  * @return Un boolean, false si la serrure n'est pas Activable avec l'objet et true sinon.
  * @see Activable
  */

  public boolean activableAvec(Objet obj){
    if (obj == this.clef){
      return true;
    }
    else{
      return false;
    }
  }

 /**
  * Permet d'activer une serrure avec un objet.
  *
  * @see Etat
  */

  public void activerAvec(Objet obj) throws ActivationImpossibleAvecObjetException {
    if (!(this.activableAvec(obj))){
      throw new ActivationImpossibleAvecObjetException("l'objet "+obj.getNom()+" ne peut pas activer la serrure");

    }
    if (this.getEtat()==Etat.VERROUILLE){
      this.etat = Etat.DEVERROUILLE;
    }
    else{
      this.etat = Etat.VERROUILLE;
    }


  }

 /**
  * Permet d'activer une serrure.
  *
  * @see Etat
  */

  public void activer() throws ActivationImpossibleException{
 // a completer
  }



}
