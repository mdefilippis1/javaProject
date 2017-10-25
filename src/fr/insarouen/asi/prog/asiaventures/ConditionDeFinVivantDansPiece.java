package fr.insarouen.asi.prog.asiaventures;

import java.util.*;
import java.io.*;
import fr.insarouen.asi.prog.asiaventures.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventures.ConditionDeFin;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventures.elements.structure.Piece;

/**
* <b> La classe ConditionDeFinVivantDansPiece herite de la classe ConditionDeFin. </b>
* <p>
* Une ConditionDeFinVivantDansPiece est caracterisee par l'information suivante :
* <ul>
* <li> Vivant </li>
* <li> piece </li>
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

public class ConditionDeFinVivantDansPiece extends ConditionDeFin{

/**
* L'attribut vivant represente le vivant auquel s'adresse la condition.
* @see Vivant
*/

  private Vivant vivant;

/**
* L'attribut piece represente la piece auquelle s'adresse la condition.
* @see Piece
*/

  private Piece piece;

/**
  * Constructeur ConditionDeFinVivantDansPiece
  * <p>
  * Pour la construction d'une ConditionDeFinVivantDansPiece, on accede aux attributs de la classe mere.
  * </p>
  *
  * @param etatConditionVerifiee
  *            L'etat du jeu.
  * @param _vivant
  * @param _piece
  *
  * @see Piece
  * @see Vivant
  */

  public ConditionDeFinVivantDansPiece(EtatDuJeu etatConditionVerifiee, Vivant _vivant, Piece _piece){
    super(etatConditionVerifiee);
    this.vivant = _vivant;
    this.piece = _piece;
  }

 /**
  * Retourne l'etat du jeu.
  *
  * @return l'etat actuel du jeu.
  */

  public EtatDuJeu verifierCondition(){
    if(this.piece.contientVivant(this.vivant)){
      return this.getEtatConditionVerifiee();
    }
    else{
      return EtatDuJeu.ENCOURS;
    }
  }
}
