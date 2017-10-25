package fr.insarouen.asi.prog.asiaventures.elements.objets;

import java.lang.Object;
import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventures.Monde;
import fr.insarouen.asi.prog.asiaventures.elements.Entite;
import fr.insarouen.asi.prog.asiaventures.NomDEntiteDejaUtiliseDansLeMondeException;

/**
* <b> La classe PiedDeBiche hérite de la classe Objet. </b>
* <p>
* Un PiedDeBiche est caractérisé par les information  suivantes (hérités de la classe mère):
* <ul>
* <li> Nom; </li>
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

public class PiedDeBiche extends Objet{

/**
  * Constructeur PiedDeBiche
  * <p>
  * Pour la construction d'un PiedDeBiche, on accède aux attributs de la classe mère.
  * </p>
  *
  * @param nom
  *            Le nom du PiedDeBiche.
  * @param monde
  *            Le monde du PiedDeBiche.
  *
  * @see Objet
  */


  public PiedDeBiche(String nom ,Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom, monde);
  }

 /**
  * Retourne true si le PiedDeBiche est deplaçable.
  *
  * @return True (par défaut tout PiedDeBiche est
déplaçable).
  */

  public boolean estDeplacable(){
    return true;
  }

}
