package fr.insarouen.asi.prog.asiaventures.elements.structure;

import java.lang.Object;
import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventures.Monde;
import fr.insarouen.asi.prog.asiaventures.elements.Entite;
import fr.insarouen.asi.prog.asiaventures.NomDEntiteDejaUtiliseDansLeMondeException;

/**
* <b> La classe abstraite ElementStructurel, qui hérite de la classe Entite. </b>
* <p>
* Un ElementStructurel est caractérisé par les information suivantes (hérités de la classe mère):
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

abstract public class ElementStructurel extends Entite{

 /**
  * Constructeur ElementStructurel
  * <p>
  * Pour la construction d'un ElementStructurel, on accède aux attributs de la classe mère.
  * </p>
  *
  * @param nom
  *            Le nom de l'Objet.
  * @param monde
  *            Le monde de l'Objet.
  *
  * @see Entite
  */

  public ElementStructurel(String nom , Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);

  }
}
