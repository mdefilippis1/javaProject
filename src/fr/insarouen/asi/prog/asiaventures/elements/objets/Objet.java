package fr.insarouen.asi.prog.asiaventures.elements.objets;

import java.lang.Object;
import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventures.Monde;
import fr.insarouen.asi.prog.asiaventures.elements.Entite;
import fr.insarouen.asi.prog.asiaventures.NomDEntiteDejaUtiliseDansLeMondeException;

/**
* <b> La classe abstracte Objet, qui hérite de la classe Entite. </b>
* <p>
* Un Objet est caractérisé par les information suivantes (hérités de la classe mère):
* <ul>
* <li> Nom; </li>
* <li> Monde. </li>
* </ul>
* </p>
* <p/>
* @author Michael De Filippis
* @author Valeria Petrov
* <p/>
* @version 1.1
* <p/>
* @since 08/02/2017
*/

abstract public class Objet extends Entite{

 /**
  * Constructeur Objet
  * <p>
  * Pour la construction d'un Objet, on accède aux attributs de la classe mère.
  * </p>
  *
  * @param nom
  *            Le nom de l'Objet.
  * @param monde
  *            Le monde de l'Objet.
  *
  * @see Entite
  */

  public Objet(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);

  }

 /**
  * Retourne true si un Objet est deplaçable (méthode abstraite).
  *
  * @return Un boolean, false si l'objet n'est pas déplaçable et true sinon (par défaut tout objet est non
déplaçable).
  */

abstract public boolean estDeplacable();


}
