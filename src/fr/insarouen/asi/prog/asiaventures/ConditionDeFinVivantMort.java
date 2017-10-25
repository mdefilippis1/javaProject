package fr.insarouen.asi.prog.asiaventures;

import java.util.*;
import java.io.*;
import fr.insarouen.asi.prog.asiaventures.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventures.ConditionDeFin;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.Vivant;

/**
* <b> La classe ConditionDeFinVivantMort herite de la classe ConditionDeFin. </b>
* <p>
* Une ConditionDeFinVivantMort est caracterisee par l'information suivante :
* <ul>
* <li> Vivant </li>
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

public class ConditionDeFinVivantMort extends ConditionDeFin{

/**
* L'attribut vivant represente le vivant auquel s'adresse la condition.
* @see Vivant
*/

  private Vivant vivant;

/**
  * Constructeur ConditionDeFinVivantMort
  * <p>
  * Pour la construction d'une ConditionDeFinVivantMort, on accede aux attributs de la classe mere.
  * </p>
  *
  * @param etatConditionVerifiee
  *            L'etat du jeu.
  * @param _vivant
  *
  * @see Vivant
  */

  public ConditionDeFinVivantMort(EtatDuJeu etatConditionVerifiee, Vivant _vivant){
    super(etatConditionVerifiee);
    this.vivant = _vivant;
  }

 /**
  * Retourne l'etat du jeu.
  *
  * @return l'etat actuel du jeu.
  */

  public EtatDuJeu verifierCondition(){
    if (this.vivant.getPointVie() == 0){
      return this.getEtatConditionVerifiee();
    }
    else{
      return EtatDuJeu.ENCOURS;
    }
  }
}
