package fr.insarouen.asi.prog.asiaventures;

import java.util.*;
import java.io.*;
import fr.insarouen.asi.prog.asiaventures.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventures.ConditionDeFin;

/**
* <b> La classe ConditionDeFinConjonctionConditionDeFin herite de la classe ConditionDeFin. </b>
* <p>
* Une ConditionDeFinConjonctionConditionDeFin est caracterisee par l'information suivante :
* <ul>
* <li> Liste des conditions </li>
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

public class ConditionDeFinConjonctionConditionDeFin extends ConditionDeFin{

/**
* L'attribut conditions represente la liste des conditions pour la fin du jeu.
* <p> Il est possible de verifier si les conditions sont respecte. </p>
* @see CConditionDeFinConjonctionConditionDeFin#auMoinsUneConditionEnCours(ConditionDeFin[])
*/


  private ConditionDeFin[] conditions;

/**
  * Constructeur ConditionDeFinConjonctionConditionDeFin
  * <p>
  * Pour la construction d'une ConditionDeFinConjonctionConditionDeFin, on accede aux attributs de la classe mere.
  * </p>
  *
  * @param etatConditionVerifiee
  *            L'etat du jeu.
  * @param _conditions
  *            Conditions d'arrete du jeu.
  *
  * @see EtatDuJeu
  */

  public ConditionDeFinConjonctionConditionDeFin(EtatDuJeu etatConditionVerifiee, ConditionDeFin... _conditions){

    super(etatConditionVerifiee);
    this.conditions = _conditions;
  }

 /**
  * Retourne true si au moins une condition respecte.
  *
  * @param conditions
  * @return Un boolean, false si les conditions ne sont pas respecte et true si au moin une en est.
  */

  private boolean auMoinsUneConditionEnCours(ConditionDeFin[] conditions){
    int i;
    for (i=0;i<conditions.length ;i++ ) {
      if (conditions[i].verifierCondition()==EtatDuJeu.ENCOURS){
        return true;
      }
    }
    return false;

  }

 /**
  * Retourne l'etat du jeu.
  *
  * @return l'etat actuel du jeu.
  */

  public EtatDuJeu verifierCondition(){
    if(!(auMoinsUneConditionEnCours(this.conditions))){
      return this.getEtatConditionVerifiee();

    }
    else{
      return EtatDuJeu.ENCOURS;
    }
  }
}
