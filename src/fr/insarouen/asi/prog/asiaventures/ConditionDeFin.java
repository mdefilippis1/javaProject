package fr.insarouen.asi.prog.asiaventures;

import java.util.*;
import java.io.*;
import fr.insarouen.asi.prog.asiaventures.EtatDuJeu;

/**
* <b> La classe abstracte ConditionDeFin herite de la classe Objet et implement la classe Serializable. </b>
* <p>
* Une ConditionDeFin est caracterisee par l'information suivante :
* <ul>
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

public abstract class ConditionDeFin extends Object implements Serializable{

/**
* L'attribut etatConditionVerifiee represente l'etat actuel du jeu.
* <p> Il est possible d'obtenir l'etat du jeu. </p>
* @see ConditionDeFin#getEtatConditionVerifiee()
* @see ConditionDeFin#verifierCondition()
*/

  private EtatDuJeu etatConditionVerifiee;

/**
  * Constructeur ConditionDeFin
  *
  * @param etatDuJeu
  *            L'etat du jeu.
  *
  * @see EtatDuJeu
  */

  public ConditionDeFin(EtatDuJeu etatDuJeu){
    this.etatConditionVerifiee = etatDuJeu;
  }

 /**
  * Retourne l'etat du jeu.
  *
  * @return l'etat actuel du jeu.
  */

  public EtatDuJeu getEtatConditionVerifiee(){
    return this.etatConditionVerifiee;
  }

 /**
  * Methode abstracte, modifie en fonction des classes qui l'utilisent.
  *
  */

  public abstract EtatDuJeu verifierCondition();
}
