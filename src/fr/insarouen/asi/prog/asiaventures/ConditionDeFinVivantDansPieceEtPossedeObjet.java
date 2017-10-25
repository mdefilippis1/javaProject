package fr.insarouen.asi.prog.asiaventures;

import java.util.*;
import java.io.*;
import fr.insarouen.asi.prog.asiaventures.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventures.ConditionDeFin;
import fr.insarouen.asi.prog.asiaventures.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventures.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventures.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventures.ConditionDeFinConjonctionConditionDeFin;

/**
* <b> La classe ConditionDeFinVivantDansPieceEtPossedeObjet herite de la classe ConditionDeFin. </b>
* <p>
* Une ConditionDeFinVivantDansPieceEtPossedeObjet est caracterisee par l'information suivante :
* <ul>
* <li> Vivant </li>
* <li> piece </li>
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

public class ConditionDeFinVivantDansPieceEtPossedeObjet extends ConditionDeFin{

/**
* L'attribut vivant represente le vivant auquel s'adresse la condition.
* @see Vivant
*/

  private Vivant vivant;

/**
* L'attribut objets represente les objets auquels s'adresse la condition.
* @see Objet
*/

  private Objet[] objets;

/**
* L'attribut piece represente la piece auquelle s'adresse la condition.
* @see Piece
*/

  private Piece piece;

/**
  * Constructeur ConditionDeFinVivantDansPieceEtPossedeObjet
  * <p>
  * Pour la construction d'une ConditionDeFinVivantDansPieceEtPossedeObjet, on accede aux attributs de la classe mere.
  * </p>
  *
  * @param etatConditionVerifiee
  *            L'etat du jeu.
  * @param _vivant
  * @param _piece
  * @param _objets
  *
  * @see Piece
  * @see Vivant
  * @see Objet
  */


  public ConditionDeFinVivantDansPieceEtPossedeObjet(EtatDuJeu etatConditionVerifiee, Vivant _vivant,Piece _piece, Objet... _objets){
    super(etatConditionVerifiee);
    this.vivant = _vivant;
    this.piece = _piece;
    this.objets = _objets;

  }

 /**
  * Retourne l'etat du jeu.
  *
  * @return l'etat actuel du jeu.
  */

  public EtatDuJeu verifierCondition(){
    ConditionDeFinConjonctionConditionDeFin conditionConj = new ConditionDeFinConjonctionConditionDeFin(this.getEtatConditionVerifiee(),new ConditionDeFinVivantDansPiece(this.getEtatConditionVerifiee(),vivant,piece),new ConditionDeFinVivantPossedeObjet(this.getEtatConditionVerifiee(),vivant,objets));
    return conditionConj.verifierCondition();
  }
}
