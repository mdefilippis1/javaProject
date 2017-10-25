package fr.insarouen.asi.prog.asiaventures;

import java.util.*;
import java.io.*;
import fr.insarouen.asi.prog.asiaventures.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventures.ConditionDeFin;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventures.elements.objets.Objet;

/**
* <b> La classe ConditionDeFinVivantPossedeObjet herite de la classe ConditionDeFin. </b>
* <p>
* Une ConditionDeFinVivantPossedeObjet est caracterisee par l'information suivante :
* <ul>
* <li> Vivant </li>
* <li> objets </li>
* <li> etatConditionVerifiee </li>
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

public class ConditionDeFinVivantPossedeObjet extends ConditionDeFin{

/**
* L'attribut vivant represente le vivant auquel s'adresse la condition.
* @see Vivant
*/

  Vivant vivant;

/**
* L'attribut objets represente les objets auquels s'adresse la condition.
* @see Objet
*/

  Objet[] objets;

/**
  * Constructeur ConditionDeFinVivantPossedeObjet
  * <p>
  * Pour la construction d'une ConditionDeFinVivantPossedeObjet, on accede aux attributs de la classe mere.
  * </p>
  *
  * @param etatConditionVerifiee
  *            L'etat du jeu.
  * @param _vivant
  * @param _objets
  *
  * @see Vivant
  * @see Objet
  */

  public ConditionDeFinVivantPossedeObjet(EtatDuJeu etatConditionVerifiee, Vivant _vivant, Objet[] _objets){
    super(etatConditionVerifiee);
    this.vivant = _vivant;
    this.objets =  _objets;
  }

 /**
  * Retourne true si un certain vivant possede tous les objets enumeres dans la condition.
  *
  * @param vivant
  * @param objets
  * @return Un boolean, false si le vivant ne possede au moins un objet de la liste, true sinon.
  */

  private boolean possedeTousLesObjets(Vivant vivant, Objet[] objets){

    int i;
    for (i=0;i<objets.length ;i++ ) {
      if (!(vivant.possede(objets[i]))){
        return false;
      }
    }
    return true;

  }

 /**
  * Retourne l'etat du jeu.
  *
  * @return l'etat actuel du jeu.
  */


  public EtatDuJeu verifierCondition(){
    if (possedeTousLesObjets(this.vivant,this.objets)){
      return this.getEtatConditionVerifiee();
    }
    else{
      return EtatDuJeu.ENCOURS;
    }
  }


}
